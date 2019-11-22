package com.hospital.bo;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hospital.bean.PatientHealthRecordVO;
import com.hospital.bean.PatientInfoVO;
import com.hospital.bean.TestDetailsVO;
import com.hospital.dao.PatientInfoDao;

@Component
public class PatientInfoBO {
	
	@Autowired
	private PatientInfoDao patientInfoDao;
	@Autowired
	private TestDetailsVO testCollection;
	
	public int insertPatientInfo(PatientInfoVO patientInfoVO){
		int patientId=0;
		patientId = patientInfoDao.insertPatientInfo(patientInfoVO);
		return patientId;
	}
	
	public String insertPatientHealthRecord(int patientId,String testName){
		String output="";
		float testCost=0;
		boolean isValidate=false;
		PatientHealthRecordVO patientHealthRecordVO=null;
		isValidate=patientInfoDao.validatePatientId(patientId);
		if(isValidate){
			testCost=retrieveTestCost(testName);
			patientHealthRecordVO = new PatientHealthRecordVO();
			patientHealthRecordVO.setPatientId(patientId);
			if(testCost!=0){
				patientHealthRecordVO.setTestName(testName);
				patientHealthRecordVO.setTestCost(testCost);
				Date date = new Date();
				patientHealthRecordVO.setTestDate(date);
			}
			int status = patientInfoDao.insertPatientHealthRecord(patientHealthRecordVO);
			output="Patient Health Record Added";
		}else{
			output="Not a valid Patient ID";
		}
		return output;
	}
	
	public float retrieveTestCost(String testName){
		float testCost=0;
		Map<String,String> testDetailMap = new HashMap<String,String>();
		testDetailMap=testCollection.getMap();
		for(Map.Entry<String, String> entry : testDetailMap.entrySet()){
			if(testName.equalsIgnoreCase(entry.getKey())){
				String cost=entry.getValue();
				testCost = Float.valueOf(cost);
			}
		}
		return testCost;
	}
	
	public float getPatientTotalBillAmt(int patientId){
		float totalCost=0;
		PatientInfoVO patientInfoVO = null;
		PatientHealthRecordVO patientHealthRecordVO =null;
		float roomCharge=1000;
		int no_of_days_hospital=0;
		patientInfoVO = patientInfoDao.getPatientInfo(patientId);
		patientHealthRecordVO = patientInfoDao.getPatientHealthInfo(patientId);
		no_of_days_hospital = (int) (patientInfoVO.getDischargeDate().getTime() - patientInfoVO.getAdmissionDate().getTime())/(1000*60*60*24);
		totalCost = patientInfoVO.getRegistrationFee()+(no_of_days_hospital*roomCharge)+ patientHealthRecordVO.getTestCost();
		patientInfoVO.setTotalCost(totalCost);
		int status = patientInfoDao.updatePatientBill(patientInfoVO);
		return totalCost;
	}

}
