package com.cts.exceptions;

public class InvalidCollegeIdException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidCollegeIdException(){
		super("College Id is invalid");
	}
}
