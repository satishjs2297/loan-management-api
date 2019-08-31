package com.cg.abc.loan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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

@CrossOrigin
@RestController
@RequestMapping("/loan")
public class LoanManagementController {

	@Autowired
	private LoanService loanService;

	@PostMapping("/applyLoan")
	public ResponseEntity<String> processLoan(@RequestBody Loan loan) {
		loanService.applyLoan(loan);
		System.out.println("Loan With Account Number : " + loan.getAccountNumber() + " has been successfully applied");
		return new ResponseEntity<String>(loan.getAccountNumber(), HttpStatus.OK);
	}

	@GetMapping("/getLoanById/{accountNumber}")
	public Loan getLoanById(@PathVariable String accountNumber) {
		return loanService.getLoanById(accountNumber);
	}

	@GetMapping("/getAllLoans")
	public List<Loan> getAllLoans() {
		return loanService.getAllLoans();
	}

	@PutMapping("/payEmi/{accountNumber}")
	public ResponseEntity<String> payEmi(@PathVariable String accountNumber) {
		return new ResponseEntity<String>(loanService.payEmi(accountNumber), HttpStatus.OK);
	}

	@GetMapping("/calculate/{loanAmount}/{interestRate}/{time}")
	public double calculateEmi(@PathVariable double loanAmount, @PathVariable double interestRate,
			@PathVariable int time) {
		return loanService.calculateEmi(loanAmount, interestRate, time);
	}

	@PutMapping("/forceclose/{accountNumber}")
	public ResponseEntity<String> forceClose(@PathVariable String accountNumber) {
		return new ResponseEntity<String>(loanService.foreClose(accountNumber), HttpStatus.OK);
	}

	@GetMapping("/getAllLoanTransactions")
	public List<LoanTransaction> getAllTransactions() {
		return loanService.getAllLoanTransactions();
	}

}
