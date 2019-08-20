package com.hcl.bankingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.bankingapp.entity.CreditCardTransaction;

@Repository
public interface CreditCardTransactionRepository extends JpaRepository<CreditCardTransaction, Long>{

}
