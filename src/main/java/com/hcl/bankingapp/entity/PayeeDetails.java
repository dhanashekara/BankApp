package com.hcl.bankingapp.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class PayeeDetails  implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	@Id
	private Long payeeId;
	private String payeeName;
	public Long getPayeeId() {
		return payeeId;
	}
	public void setPayeeId(Long payeeId) {
		this.payeeId = payeeId;
	}
	public String getPayeeName() {
		return payeeName;
	}
	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}
	public Long getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(Long accountNo) {
		this.accountNo = accountNo;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public UserDetails getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
	private Long accountNo;
	private String branchName;
	private String status;
	@ManyToOne
	private UserDetails userDetails;

}
