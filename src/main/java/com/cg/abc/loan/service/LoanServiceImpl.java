package com.cg.abc.loan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.abc.loan.dao.LoanDao;
import com.cg.abc.loan.dao.repository.LoanTransactionRepository;
import com.cg.abc.loan.exception.LoanException;
import com.cg.abc.loan.model.Loan;
import com.cg.abc.loan.model.LoanTransaction;

@Service
public class LoanServiceImpl implements LoanService {

	@Autowired
	private LoanDao dao;
	
	@Autowired
	private LoanTransactionRepository loanTransactionRepository;


	@Override
	public void applyLoan(Loan loan) {
		double total = calculateEmi(loan.getLoanAmount(), loan.getInterestRate(), loan.getTime()) * loan.getTime() * 12;
		loan.setTotalAmount(total);
		dao.applyLoan(loan);
	}

	@Override
	public double calculateEmi(double loanAmount, double interestRate, int time) {
		double emi;
		interestRate = interestRate / (12 * 100);

		time = time * 12;

		emi = (loanAmount * interestRate * Math.pow(1 + interestRate, time)) / (Math.pow(1 + interestRate, time) - 1);
		return emi;
	}

	@Override
	public String payEmi(String actNo) {

		Loan loan = dao.getLoanById(actNo);
		double loanAmount = loan.getLoanAmount();
		double interestRate = loan.getInterestRate();
		int time = dao.getLoanById(actNo).getTime();
		double emi = calculateEmi(loanAmount, interestRate, time);
		double amount = dao.getLoanById(actNo).getTotalAmount();
		loan.setTotalAmount(amount - emi);
		dao.saveOrUpdateLoan(loan);
		loanTransactionRepository.save(new LoanTransaction(actNo, emi, 1));
		return "EMI Amount:" + emi + " has been successfully paid.";
	}

	@Override
	public Loan getLoanById(String actNo) {
		return  dao.getLoanById(actNo);
	}

	@Override
	public String foreClose(String actNo)  {
		Loan loan = dao.getLoanById(actNo);
		if (loan != null) {
			loan.setLoanAmount(0);
			loan.setTotalAmount(0);
			dao.saveOrUpdateLoan(loan);
			return "Loan Foreclosed";
		} else {
			throw new LoanException("Invalid AccountNo");
		}		
	}

	@Override
	public List<LoanTransaction> getAllLoanTransactions() {
		return loanTransactionRepository.findAll();
	}

	@Override
	public List<Loan> getAllLoans() {
		return dao.getAllLoans();
	}

}
