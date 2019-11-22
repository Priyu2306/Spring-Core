package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.bo.TriangleBo;

@Component
public class TriangleService {
	
	@Autowired
	private TriangleBo triangleBo;
	
	public TriangleBo getTriangleBo() {
		return triangleBo;
	}

	public void setTriangleBo(TriangleBo triangleBo) {
		this.triangleBo = triangleBo;
	}
	
	public void draw(){
		String message="It is a Triangle";
		triangleBo.drawTriangle(message);
		
	}

	
	public void getDetails(){
		triangleBo.getCount();
	}
	
}
