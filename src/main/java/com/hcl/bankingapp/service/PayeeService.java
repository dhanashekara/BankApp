package com.hcl.bankingapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hcl.bankingapp.dto.PayeeResDto;
import com.hcl.bankingapp.entity.Authentication;
import com.hcl.bankingapp.exception.EnterValidCredentials;
import com.hcl.bankingapp.repository.AuthenticationRepository;
import com.hcl.bankingapp.repository.PayeeRepository;

@Service
public class PayeeService {

	@Autowired
	PayeeRepository payeeRepository;

	@Autowired
	OTPService otpService;

	@Autowired
	AuthenticationRepository authRepo;

	/*
	 * public String deletePayeeDetails(PayeeReqDto payeeDto) {
	 * 
	 * PayeeDetails payee = new PayeeDetails(); Authentication auth = new
	 * Authentication(); if(payeeDto != null) { Integer otp =
	 * otpService.generateOTPandSendMail(payeeDto.getEmail());
	 * 
	 * if(otp != null) { auth.setOtp(otp); authRepo.save(auth); }
	 * 
	 * 
	 * 
	 * 
	 * //BeanUtils.copyProperties(payeeDto, payee); payeeRepository.delete(payee);
	 * return "deleted successfully"; }else { return ""; } }
	 */

	public Integer generateOTP(String email, Long payeeAccountNumber) {

		Authentication auth = new Authentication();

		if (null != email && !email.isEmpty()) {
			Integer otp = otpService.generateOTPandSendMail(email, payeeAccountNumber);
			if (otp != null) {
				auth.setOtp(otp);
				authRepo.save(auth);
			}
		}
		return auth.getOtpGen();
	}

	public String authenticate(Integer otpGenId, Integer otp, Long payeeId) {

		if (null != otpGenId && null != otp) {
			Authentication auth = authRepo.findByOtpGenAndOtp(otpGenId, otp);

			if (null != auth) {

				/*
				 * HttpHeaders headers = new HttpHeaders();
				 * headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
				 * HttpEntity<String> entity = new HttpEntity<>(headers);
				 */

				RestTemplate restTemplate = new RestTemplate();
				restTemplate.delete("http://192.168.43.207:8087/bank/user/"+payeeId);
				return "success";
			}else {
				throw new EnterValidCredentials("");
			}
		}else {
			throw new EnterValidCredentials("");
		}
	}
	

	public PayeeResDto deletePayee(long payeeId) {
		// TODO Auto-generated method stub
		 payeeRepository.deleteById(payeeId);
		PayeeResDto payeeResDto = new PayeeResDto();
		payeeResDto.setPayeeId(payeeId);
		payeeResDto.setMessage("Success");
		return payeeResDto;
		
	}
}
