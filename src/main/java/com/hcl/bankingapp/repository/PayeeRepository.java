package com.hcl.bankingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.bankingapp.entity.PayeeDetails;

@Repository
public interface PayeeRepository extends JpaRepository<PayeeDetails, Long>{
	
}
