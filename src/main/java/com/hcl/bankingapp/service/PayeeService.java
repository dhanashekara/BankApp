package com.hcl.bankingapp.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.bankingapp.dto.PayeeReqDto;
import com.hcl.bankingapp.entity.Authentication;
import com.hcl.bankingapp.entity.PayeeDetails;
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
	
	public Long generateOTP(String email,Long payeeAccountNumber) {
		
		Authentication auth = new Authentication();
		
		if(null != email && !email.isEmpty()) {
			Integer otp = otpService.generateOTPandSendMail(email,payeeAccountNumber);
			if(otp != null) {
				auth.setOtp(otp);
				authRepo.save(auth);
			}
		}
		return auth.getOtpGen();
	}
}
