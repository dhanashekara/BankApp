package com.hcl.bankingapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.bankingapp.dto.AccountDetailsDTO;
import com.hcl.bankingapp.dto.CreditCardTransactionDTO;
import com.hcl.bankingapp.entity.Account;
import com.hcl.bankingapp.entity.CreditCardDetails;
import com.hcl.bankingapp.entity.CreditCardTransaction;
import com.hcl.bankingapp.entity.UserDetails;
import com.hcl.bankingapp.exception.NoTransactions;
import com.hcl.bankingapp.exception.UserNotFound;
import com.hcl.bankingapp.repository.AccountRepository;
import com.hcl.bankingapp.repository.CreditCardRepository;
import com.hcl.bankingapp.repository.CreditCardTransactionRepository;
import com.hcl.bankingapp.repository.UserDetailsRepository;

@Service
public class CreditCardServiceImpl implements CreditCardService {

	@Autowired
	CreditCardRepository credRepo;

	@Autowired
	AccountRepository accRepo;
	
	@Autowired
	UserDetailsRepository userRepo;
	
	@Autowired
	CreditCardTransactionRepository credTransactionRepo;

	public AccountDetailsDTO getAccountDetails(Long userId) {

		if (null != userId) {

			AccountDetailsDTO accountDTO = new AccountDetailsDTO();
			UserDetails userDetails = new UserDetails();
			userDetails.setUserId(userId);
		//	Account acc = new Account();
		//	acc.setUserDetails(userDetails);
			Account acc = accRepo.findByUserId(userId);
			userDetails = userRepo.findById(userId).get();
			if (null != acc && userDetails!= null) {
				CreditCardDetails crdDetails = credRepo.findByUserDetails(userDetails);
				if(null != crdDetails) {
					accountDTO.setAccountbalance(acc.getBalance());
					accountDTO.setAccountMail(userDetails.getEmail());
					accountDTO.setAccountNo(acc.getAccountNo());
					accountDTO.setUserName(userDetails.getUserName());
					accountDTO.setCreditBalance(crdDetails.getCreditBalance());
					return accountDTO;
				}else {
					throw new UserNotFound("Credit Card details Not found");
				}
			}else {
				throw new UserNotFound("Account Not Found");
			}
		}else {
			throw new UserNotFound("User Not Found");
		}
	}

	public List<CreditCardTransactionDTO> getStatement(Long userId) {

		if(null != userId) {
			List<CreditCardTransaction> trList = credTransactionRepo.getTransactionDetails(userId);
			
			
			if(null != trList && !trList.isEmpty()) {
				
				CreditCardTransactionDTO credDTO = new CreditCardTransactionDTO();
				List<CreditCardTransactionDTO> trDTOList = new ArrayList<>();
				
				trList.forEach(tr -> {
					
					credDTO.setAccountNumber(tr.getToAccountNumber());
					credDTO.setPaymentType(tr.getPaymentType());
					credDTO.setReceiverName(tr.getReceiverName());
					credDTO.setDebitAmount(tr.getDebitAmount());
					credDTO.setDescription(tr.getDescription());
					credDTO.setTransactionDate(tr.getTransactionDate());
					trDTOList.add(credDTO);
				});
				return trDTOList;
			}else {
				throw new NoTransactions("No transaction Present");
			}
		}else {
			throw new UserNotFound("User Not Found");
		}
	}
}
