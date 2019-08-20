package com.hcl.bankingapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.bankingapp.dto.AccountDetailsDTO;

@RestController
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
public class CreditCardController {

	@GetMapping("/")
	public ResponseEntity<AccountDetailsDTO> getAccountDetails(){
		return null;
		
		
	}
	
}
