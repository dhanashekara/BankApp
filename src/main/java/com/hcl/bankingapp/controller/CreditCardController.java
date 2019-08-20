package com.hcl.bankingapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.bankingapp.dto.AccountDetailsDTO;

@RestController
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
public class CreditCardController {
	
	@Autowired

	@GetMapping("/user/{userId}")
	public ResponseEntity<AccountDetailsDTO> getAccountDetails(@PathVariable Long userId){
		
		
		return null;
	}
	
}
