package com.bean;


public class HelloWorldBean {
	
	private String message;

	public void getMessage() {
		System.out.println("Message--"+message);
		//return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
	public void init(){
		System.out.println("Bean Initialization Done Here");
	}
	
	public void destroy(){
		System.out.println("Bean destroy is done here");
	}
	
	

}
