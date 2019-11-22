package com.cts.exceptions;

public class NoRecordsException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public NoRecordsException(){
		super("List is empty");
	}

}
