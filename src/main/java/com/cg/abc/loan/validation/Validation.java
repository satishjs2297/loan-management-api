package com.cg.abc.loan.validation;

public interface Validation {
	boolean validholder(String holder);

	boolean validMobNo(String mobileNo);

	boolean aadhNo(String aadharN0);
	
	boolean actNo(String actNo);
	
	boolean sal(double sal);
}
