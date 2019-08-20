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
public class CreditCardDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Long creditCardNumber;
	private LocalDate expDate;
	private double creditAmount;
	private String creditCardName;
	private int cvv;
	
	@ManyToOne
	UserDetails userDetails;
	
}
