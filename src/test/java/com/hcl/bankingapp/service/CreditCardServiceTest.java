package com.hcl.bankingapp.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.bankingapp.dto.AccountDetailsDTO;
import com.hcl.bankingapp.entity.CreditCardDetails;
import com.hcl.bankingapp.entity.UserDetails;
import com.hcl.bankingapp.repository.AccountRepository;
import com.hcl.bankingapp.repository.CreditCardRepository;
import com.hcl.bankingapp.repository.CreditCardTransactionRepository;

@RunWith(MockitoJUnitRunner.class)
public class CreditCardServiceTest {
	


	
	@InjectMocks
	CreditCardServiceImpl creditCardServiceImpl;
	
	@Mock
	CreditCardRepository credRepo;
	
	@Test
	public void getAccountDetailsTest() {
		AccountDetailsDTO dto=new AccountDetailsDTO();
		dto.setAccountbalance(34567.00);
		dto.setAccountMail("pradeep.aj28@gmail.com");
		dto.setAccountNo(234567L);
		dto.setCreditBalance(345678.00);
		dto.setUserName("pradeep");
		UserDetails userDetails = new UserDetails();
		
		userDetails.setUserId(123L);
		CreditCardDetails crdDetails=new CreditCardDetails();
		when(credRepo.findByUserDetails(userDetails)).thenReturn(crdDetails);
		AccountDetailsDTO actres = creditCardServiceImpl.getAccountDetails(123L);
		assertEquals(dto, actres);
	}
	
	
}
