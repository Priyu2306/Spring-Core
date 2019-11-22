package com.hospital.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hospital.service.PatientInfoService;

public class HospitalMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Bean.xml");
		PatientInfoService patientInfoService = (PatientInfoService)context.getBean("patientInfoService");
		//int result = patientInfoService.insertPatientInfo(2, "Sudip", "Kolkata", 37, "M", 500, "01-11-2016");
		//System.out.println("Result=="+result);
		//String result = patientInfoService.insertPatientHealthRecord(1, "ECG");
		//System.out.println("Result="+result);
		
		float billAmt = patientInfoService.updatePatientBill(1);
		System.out.println("billAmt=="+billAmt);
	}

}
