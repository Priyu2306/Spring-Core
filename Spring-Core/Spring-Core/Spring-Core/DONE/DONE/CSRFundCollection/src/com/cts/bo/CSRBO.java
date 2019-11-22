package com.cts.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cts.dao.CSRDao;
import com.cts.dao.CSRUnit;
import com.cts.exceptions.InvalidEmailException;
import com.cts.exceptions.InvalidEmpNameException;
import com.cts.exceptions.InvalidPhoneNoException;
import com.cts.exceptions.InvalidUnitCodeException;
import com.cts.exceptions.NoRecordsException;

@Component("csrBO")
public class CSRBO {

	private CSRDao csrDao;

	public CSRDao getCsrDao() {
		return csrDao;
	}

	@Autowired
	public void setCsrDao(CSRDao csrDao) {
		this.csrDao = csrDao;
	}

	public CSRBO() {

	}

	public Integer donateAmount(RegistrationVO registrationVO) throws InvalidEmailException, InvalidEmpNameException,InvalidPhoneNoException, InvalidUnitCodeException
	{
		
		String namePattern="[a-zA-Z ]+";
		String emailPattern="[_a-zA-Z0-9-\\+]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9]+)*(\\.[a-zA-Z]{2,})";
		String phoneNoPattern="[0-9]{10}";
		if(!registrationVO.getEmpName().matches(namePattern))
		{
			throw new InvalidEmpNameException();
		}
		if(!registrationVO.getEmpEmail().matches(emailPattern))
		{
			throw new InvalidEmailException();
		}
		if(csrDao.getUnitDetails(registrationVO.getUnitCode())==null)
		{
			throw new InvalidUnitCodeException();
		}
		if(!registrationVO.getPhoneNo().matches(phoneNoPattern))
		{
			throw new InvalidPhoneNoException();
		}
		return csrDao.donateAmount(registrationVO);
	}

	public List<DetailsVO> viewDonatedDetails(Integer unitCode) throws NoRecordsException {

		return csrDao.viewDonatedDetails(unitCode);
	}



}
