package com.hcl.bankingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.bankingapp.entity.CreditCardDetails;

public interface CreditCardRepository extends JpaRepository<CreditCardDetails, Long>{

}
