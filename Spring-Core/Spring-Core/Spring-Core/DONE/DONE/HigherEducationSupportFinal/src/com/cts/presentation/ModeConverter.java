package com.cts.presentation;

public class ModeConverter {
	
	public String getMode(String val){
		
		if(val.charAt(0)=='P'){
			return "Part-Time";
		}
		else{
			return "Distance Education";
		}
		
	}

}
