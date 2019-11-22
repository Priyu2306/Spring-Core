package com.bean;

import java.util.Map;

import org.springframework.stereotype.Component;
@Component
public class Collection {
	
	private Map<String,String> map;

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}
	
	

}
