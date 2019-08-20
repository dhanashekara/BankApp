package com.hcl.bankingapp.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreditCardTransaction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long transactionId;
	private double debitAmount;
	private Long fromAccountNumber;
	private Long toAccountNumber;
	private LocalDate transactionDate;
	private String description;
	private String paymentType;

	@ManyToOne
	CreditCardDetails creditCardDetails;
}
