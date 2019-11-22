package com.cts.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cts.bo.DetailsVO;
import com.cts.bo.RegistrationVO;
import com.cts.exceptions.InvalidEmailException;
import com.cts.exceptions.InvalidEmpNameException;
import com.cts.exceptions.InvalidPhoneNoException;
import com.cts.exceptions.InvalidUnitCodeException;
import com.cts.exceptions.NoRecordsException;
import com.cts.facade.CSRFacade;

@Component("csrManager")
public class CSRManager {

	private CSRFacade csrFacade;

	public CSRFacade getCsrFacade() {
		return csrFacade;
	}

	@Autowired
	public void setCsrFacade(CSRFacade csrFacade) {
		this.csrFacade = csrFacade;
	}

	public Integer donateAmount(RegistrationVO registrationVO) throws InvalidEmailException, InvalidEmpNameException,InvalidPhoneNoException, InvalidUnitCodeException
	{
		return csrFacade.donateAmount(registrationVO);
	}

	public List<DetailsVO> viewDonatedDetails(Integer unitCode) throws NoRecordsException
	{
		return csrFacade.viewDonatedDetails(unitCode);

	}

}
