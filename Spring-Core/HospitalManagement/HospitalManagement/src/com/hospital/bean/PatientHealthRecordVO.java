package com.hospital.bean;

import java.util.Date;

public class PatientHealthRecordVO {
	
	private int patientId;
	private String testName;
	private float testCost;
	private Date testDate;
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
	public float getTestCost() {
		return testCost;
	}
	public void setTestCost(float testCost) {
		this.testCost = testCost;
	}
	public Date getTestDate() {
		return testDate;
	}
	public void setTestDate(Date testDate) {
		this.testDate = testDate;
	}
	
	

}
