package com.cg.abc.loan.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cg.abc.loan.dao.repository.LoanRepository;
import com.cg.abc.loan.model.Loan;

@Repository
public class LoanDaoImpl implements LoanDao {
	
	@Autowired
	private LoanRepository loanRepository;

	@Override
	public void applyLoan(Loan loan) {
		loanRepository.save(loan);
	}
	
	@Override
	public Loan getLoanDetails(String accountNumber) {
		return loanRepository.getLoanByAccountNumber(accountNumber);
	}

	@Override
	public String saveOrUpdateLoan(Loan loan) {
		loanRepository.save(loan);
		return loan.getAccountNumber();
	}

	

}
