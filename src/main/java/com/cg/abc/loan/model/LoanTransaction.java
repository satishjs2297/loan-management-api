package com.cg.abc.loan.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LoanTransaction {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long txnId;
	
	private String accountNumber;
	
	private double emiAmount;
	
	private Integer numberOfInstallments;
	
	public LoanTransaction() {
		// TODO Auto-generated constructor stub
	}
	
	public LoanTransaction(String accountNumber, double emiAmount, Integer numberOfInstallments) {
		this.accountNumber = accountNumber;
		this.emiAmount = emiAmount;
		this.numberOfInstallments = numberOfInstallments;
	}

	public Long getTxnId() {
		return txnId;
	}

	public void setTxnId(Long txnId) {
		this.txnId = txnId;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getEmiAmount() {
		return emiAmount;
	}

	public void setEmiAmount(double emiAmount) {
		this.emiAmount = emiAmount;
	}

	public Integer getNumberOfInstallments() {
		return numberOfInstallments;
	}

	public void setNumberOfInstallments(Integer numberOfInstallments) {
		this.numberOfInstallments = numberOfInstallments;
	}

	
	
	
	

}
