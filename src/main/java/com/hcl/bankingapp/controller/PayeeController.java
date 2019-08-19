package com.hcl.bankingapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.hcl.bankingapp.service.PayeeService;

@RestController
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
	public ResponseEntity<Long> generateOTP(@PathVariable String email,@PathVariable Long payeeAccountNumber){
		return new ResponseEntity<Long>(payeeService.generateOTP(email,payeeAccountNumber),HttpStatus.OK);
	}
	
	
}
