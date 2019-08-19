package com.hcl.bankingapp.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Authentication {

	@Id
	private Long otpGen;
	private String payeeId;
	private int otp;

	public Long getOtpGen() {
		return otpGen;
	}

	public void setOtpGen(Long otpGen) {
		this.otpGen = otpGen;
	}

	public String getPayeeId() {
		return payeeId;
	}

	public void setPayeeId(String payeeId) {
		this.payeeId = payeeId;
	}

	public int getOtp() {
		return otp;
	}

	public void setOtp(int otp) {
		this.otp = otp;
	}

}
