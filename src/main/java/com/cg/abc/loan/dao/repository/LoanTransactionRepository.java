package com.cg.abc.loan.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.abc.loan.model.LoanTransaction;

public interface LoanTransactionRepository extends JpaRepository<LoanTransaction, Long> {

}
