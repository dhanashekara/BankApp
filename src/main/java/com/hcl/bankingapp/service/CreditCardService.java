package com.hcl.bankingapp.service;

import java.util.List;

import com.hcl.bankingapp.dto.AccountDetailsDTO;
import com.hcl.bankingapp.dto.CreditCardTransactionDTO;

public interface CreditCardService {

	AccountDetailsDTO getAccountDetails(Long userId);

	List<CreditCardTransactionDTO> getStatement(Long userId);

}
