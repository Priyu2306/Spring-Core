package com.hospital.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hospital.bean.PatientInfoVO;
import com.hospital.bo.PatientInfoBO;
@Component
public class PatientInfoService {
	
	@Autowired
	private PatientInfoBO patientInfoBO;
	/**
	 * @param args
	 */
	public int insertPatientInfo(int patientId,String patientName,String patientAddr,
			int age,String gender,float registrationFee,String date){
		int patientid=0;
		try{
		PatientInfoVO patientInfoVO = new PatientInfoVO();
		patientInfoVO.setPatientId(patientId);
		patientInfoVO.setPatientName(patientName);
		patientInfoVO.setPatientAddr(patientAddr);
		patientInfoVO.setAge(age);
		patientInfoVO.setGender(gender);
		patientInfoVO.setRegistrationFee(registrationFee);
		String addDate = "01-11-2016";
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date admissionDate = sdf.parse(addDate);
		patientInfoVO.setAdmissionDate(admissionDate);
		Date dischargeDate = new Date();
		patientInfoVO.setDischargeDate(dischargeDate);
		patientid = patientInfoBO.insertPatientInfo(patientInfoVO);
		}catch (Exception ex){
			System.out.println(ex.getMessage());
		}
		return patientid;
	}
	
	public String insertPatientHealthRecord(int patientId,String testName){
		String output="";
		output = patientInfoBO.insertPatientHealthRecord(patientId, testName);
		return output;
	}
	
	public float updatePatientBill(int patientId){
		float totalAmt = patientInfoBO.getPatientTotalBillAmt(patientId);
		return totalAmt;
	}

}
