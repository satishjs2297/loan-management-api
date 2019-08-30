package com.cg.abc.loan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.abc.loan.model.Loan;
import com.cg.abc.loan.model.LoanTransaction;
import com.cg.abc.loan.service.LoanService;

@RestController
@RequestMapping("/loan")
public class LoanManagementController {

	@Autowired
	private LoanService loanService;

	@PostMapping("/applyLoan")
	public String processLoan(@RequestBody Loan loan) {
		loanService.applyLoan(loan);
		System.out.println("Loan has been successfully processed....");
		return "Loan With Account Number : "+ loan.getAccountNumber() + " has been successfully applied";
	}
	
	@GetMapping("/showBalance/{accountNumber}")
	public double showBalance(@PathVariable String accountNumber) {
		return loanService.showBalance(accountNumber);	
	}
	
	@PutMapping("/payEmi/{accountNumber}")
	public String payEmi(@PathVariable String accountNumber) {
		return loanService.payEmi(accountNumber);
	}
	
	@GetMapping("/calculate/{loanAmount}/{interestRate}/{time}")
	public double calculateEmi(@PathVariable double loanAmount, @PathVariable double interestRate, @PathVariable int time) {
		return loanService.calculateEmi(loanAmount, interestRate, time);
	}
	
	@PutMapping("/forceclose/{accountNumber}")
	public String forceClose(@PathVariable String accountNumber) {
		return loanService.foreClose(accountNumber);
	}
	
	@GetMapping("/getAllLoanTransactions")
	public List<LoanTransaction> getAllTransactions() {
		return loanService.getAllLoanTransactions();
	}

}
