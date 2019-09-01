package com.cg.abc.loan.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="LOAN")
public class Loan {

	@Id
	private String accountNumber;
	private String holder;
	private String mobileNo;
	private String city;
	private String aadharNo;
	private double salary;
	private double loanAmount;
	private int time;
	private double interestRate;
	private double totalAmount;

	public Loan() {
		// TODO Auto-generated constructor stub
	}

	public Loan(String accountNumber, String holder, String mobileNo, String city, String aadharNo, double salary,
			double loanAmount, int time, double interestRate, double totalAmount) {
		this.accountNumber = accountNumber;
		this.holder = holder;
		this.mobileNo = mobileNo;
		this.city = city;
		this.aadharNo = aadharNo;
		this.salary = salary;
		this.loanAmount = loanAmount;
		this.time = time;
		this.interestRate = interestRate;
		this.totalAmount = totalAmount;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = Math.round(salary * 100) / 100;
	}

	public double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(double loanAmount) {
		this.loanAmount = Math.round(loanAmount * 100) / 100;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = Math.round(interestRate * 100) / 100;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = Math.round(totalAmount * 100) / 100;
	}

	@Override
	public String toString() {
		return "Loan [actNo=" + accountNumber + ", holder=" + holder + ", mobileNo=" + mobileNo + ", city=" + city
				+ ", aadharNo=" + aadharNo + ", salary=" + salary + ", loanAmount=" + loanAmount + ", time=" + time
				+ ", interestRate=" + interestRate + ", totalAmount=" + totalAmount + "]";
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

}
