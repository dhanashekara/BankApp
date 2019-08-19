package com.hcl.bankingapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.bankingapp.dto.PayeeReqDto;
import com.hcl.bankingapp.dto.PayeeResDto;
import com.hcl.bankingapp.service.PayeeService;

@RestController
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
public class PayeeController {

	@Autowired
	PayeeService payeeService;

	/*
	 * @PutMapping("/user/payee/{payeeId}/{email}") public ResponseEntity<String>
	 * DeletePayeeDetails(@RequestBody PayeeReqDto payeeDto) {
	 * 
	 * return new ResponseEntity<String>(payeeService.deletePayeeDetails(payeeDto),
	 * HttpStatus.OK);
	 * 
	 * }
	 */

	@GetMapping("/user/{email}/{payeeAccountNumber}")
	public ResponseEntity<Integer> generateOTP(@PathVariable String email,@PathVariable Long payeeAccountNumber){
		return new ResponseEntity<Integer>(payeeService.generateOTP(email,payeeAccountNumber),HttpStatus.OK);
	}

	//authentication for deleting payee
	@PostMapping("/authentication/{otpGenId}/{otp}/{payeeId}") 
	public ResponseEntity<String> deleteAuthenticate(@PathVariable Integer otpGenId,@PathVariable Integer otp,@PathVariable Long payeeId){
		return new  ResponseEntity<String>(payeeService.authenticate(otpGenId,otp,payeeId),HttpStatus.OK);
	}
	
	/*
	 * //authentication for addPayee
	 * 
	 * @PostMapping("/authentication/{otpGenId}/{otp}/{payeeId}") public
	 * ResponseEntity<String> Authenticate(@PathVariable Integer
	 * otpGenId,@PathVariable Integer otp,@RequestBody PayeeReqDto payeeId){ return
	 * new
	 * ResponseEntity<String>(payeeService.authenticate(otpGenId,otp,payeeId,payeeId
	 * ),HttpStatus.OK); }
	 */
//	restTemplate.delete("http://192.168.43.207:8087/bank/user/"+payeeId);
	
	@DeleteMapping("/user/{payeeId}")
	public ResponseEntity<PayeeResDto> deletePayee(@PathVariable Long payeeId){
		
		System.out.println("Rest templete success");
		//return new  ResponseEntity<String>(payeeService.deletePaye(otpGenId,otp,payeeId),HttpStatus.OK);
		return new  ResponseEntity<PayeeResDto>(payeeService.deletePayee(payeeId),HttpStatus.OK);
	}
	 
}
