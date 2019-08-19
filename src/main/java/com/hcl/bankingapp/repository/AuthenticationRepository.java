package com.hcl.bankingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.bankingapp.entity.Authentication;

public interface AuthenticationRepository extends JpaRepository<Authentication, Long> {

}
