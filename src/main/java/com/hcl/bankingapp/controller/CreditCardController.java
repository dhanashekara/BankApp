package com.hcl.bankingapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.bankingapp.dto.AccountDetailsDTO;
import com.hcl.bankingapp.dto.CreditCardTransactionDTO;
import com.hcl.bankingapp.service.CreditCardService;

@RestController
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
public class CreditCardController {

	@Autowired
	CreditCardService credSerice;

	@GetMapping("/user/{userId}")
	public ResponseEntity<AccountDetailsDTO> getAccountDetails(@PathVariable Long userId) {

		return new ResponseEntity<AccountDetailsDTO>(credSerice.getAccountDetails(userId), HttpStatus.OK);
	}

	@GetMapping("/user/{userId}/statement/")
	public ResponseEntity<List<CreditCardTransactionDTO>> getStatement(@PathVariable Long userId) {

		return new ResponseEntity<List<CreditCardTransactionDTO>>(credSerice.getStatement(userId), HttpStatus.OK);
	}

}
