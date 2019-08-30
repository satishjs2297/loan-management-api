package com.cg.abc.loan.exception;

public class LoanException extends RuntimeException {
	private static final long serialVersionUID = 1l;
	
	public LoanException(){
		super();
	}
	public LoanException(String message){
		super(message);
	}
}
