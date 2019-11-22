package com.cts.tester;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cts.bo.RegistrationVO;
import com.cts.exceptions.InvalidEmailException;
import com.cts.exceptions.InvalidEmpNameException;
import com.cts.exceptions.InvalidPhoneNoException;
import com.cts.exceptions.InvalidUnitCodeException;
import com.cts.exceptions.NoRecordsException;
import com.cts.manager.CSRManager;

public class Tester 
{
	private static ApplicationContext context;
	static CSRManager csrManager;
	static RegistrationVO registrationVO;
	
	public static ApplicationContext getContext() {
		return context;
	}

	public static void setContext(ApplicationContext context) {
		Tester.context = context;
	}

	public CSRManager getCsrManager() {
		return csrManager;
	}

	public void setCsrManager(CSRManager csrManager) {
		this.csrManager = csrManager;
	}

	public RegistrationVO getRegistrationVO() {
		return registrationVO;
	}

	public void setRegistrationVO(RegistrationVO registrationVO) {
		this.registrationVO = registrationVO;
	}
	
	public static void main(String[] args) 
	{
		context=new ClassPathXmlApplicationContext("csr_config.xml");
		csrManager=(CSRManager) context.getBean("csrManager");
		registrationVO=(RegistrationVO) context.getBean("registrationVO");
		
		try {
			Integer registrationId=csrManager.donateAmount(registrationVO);
			System.out.println("Registration Id: "+registrationId);
			
		} catch (InvalidEmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidEmpNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidPhoneNoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidUnitCodeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			csrManager.viewDonatedDetails(1);
		} catch (NoRecordsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
