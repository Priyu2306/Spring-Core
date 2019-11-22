package com.cts.exceptions;

public class InvalidJobLevelException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidJobLevelException(){
		super("JobLevel id Invalid");
	}

}
