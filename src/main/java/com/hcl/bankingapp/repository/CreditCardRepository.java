package com.hcl.bankingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.bankingapp.entity.CreditCardDetails;
import com.hcl.bankingapp.entity.UserDetails;

public interface CreditCardRepository extends JpaRepository<CreditCardDetails, Long>{

	public CreditCardDetails findByUserDetails(UserDetails userDetails);
}
