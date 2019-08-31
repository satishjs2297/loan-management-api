package com.cg.abc.loan.dao;

import java.util.List;

import com.cg.abc.loan.model.Loan;

public interface LoanDao {
	
	void applyLoan(Loan loan);
	
	Loan getLoanById(String actNo);
	
	List<Loan> getAllLoans();
	
	String saveOrUpdateLoan(Loan loan);
}
	
	


