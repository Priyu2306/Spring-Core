package com.spring.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.spring.dao.TriangleDao;

@Component

public class TriangleBo {
	
	@Autowired
	private TriangleDao triangleDao;
	
	public TriangleDao getTriangleDao() {
		return triangleDao;
	}

	public void setTriangleDao(TriangleDao triangleDao) {
		this.triangleDao = triangleDao;
	}
	
	public void drawTriangle(String message){
		System.out.println(message+" "+"In Bo");
		triangleDao.drawMessage(message);
	}

	
	
	public void getCount(){
		System.out.println(triangleDao.getCount());
	}

}
