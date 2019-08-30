package com.cg.abc.loan.dao;

import com.cg.abc.loan.model.Loan;

public interface LoanDao {
	
	void applyLoan(Loan loan);
	
	Loan getLoanDetails(String actNo);
	
	String saveOrUpdateLoan(Loan loan);
}
	
	


