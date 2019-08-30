package com.cg.abc.loan.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.abc.loan.model.Loan;

public interface LoanRepository extends JpaRepository<Loan, Long> {
	
	@Query("select l from Loan l where l.accountNumber=:accountNumber")
	public Loan getLoanByAccountNumber(@Param("accountNumber") String accountNumber);

}
