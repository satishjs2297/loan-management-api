package com.cg.abc.loan.service;

import java.util.List;

import com.cg.abc.loan.model.Loan;
import com.cg.abc.loan.model.LoanTransaction;

public interface LoanService {
	
	void applyLoan(Loan loan);
     
	double calculateEmi(double loanAmount,double interestRate,int time );
	
	String payEmi(String actNo);
	
	double showBalance(String actNo);
	
	String foreClose(String actNo);
	
	List<LoanTransaction> getAllLoanTransactions();
	
}