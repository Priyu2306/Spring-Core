package com.cts.exceptions;

@SuppressWarnings("serial")
public class InvalidEmailException extends Exception {
	public InvalidEmailException() {
		super("Email can Contain Alphabets , underscore or digits");
	}
}
