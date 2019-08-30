package com.cg.abc.loan.validation;

public class ValidationsImpl implements Validation {

	@Override
	public boolean validholder(String holder) {
		boolean name=holder.matches("[A-Z][a-z]*");
		if(name)
			 return true;
		else
		return false;
	}

	@Override
	public boolean validMobNo(String mobileNo) {
		boolean mob_no= mobileNo.matches("(0/91)?[7-9][0-9]{9}");
		if(mob_no)
			 return true;
		else
		return false;
	}

	@Override
	public boolean aadhNo(String aadharNo) {
		boolean aadh_no= aadharNo.matches("[1-9][0-9]{11}");
		if(aadh_no)
			return true;
		return false;
	}

	@Override
	public boolean actNo(String actNo) {
		boolean accNo= actNo.matches("[1-9][0-9]{3}");
		if(accNo)
			return true;
		else
		return false;
	}

	@Override
	public boolean sal(double sal) {
     if(sal>20000) {
    	 return true;
     }
     else
		return false;
	}

}
