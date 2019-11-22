package com.cts.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cts.bo.CSRBO;
import com.cts.bo.DetailsVO;
import com.cts.bo.RegistrationVO;
import com.cts.exceptions.InvalidEmailException;
import com.cts.exceptions.InvalidEmpNameException;
import com.cts.exceptions.InvalidPhoneNoException;
import com.cts.exceptions.InvalidUnitCodeException;
import com.cts.exceptions.NoRecordsException;

@Component("csrFacade")
public class CSRFacade {

	private CSRBO csrBO;

	public CSRFacade() {

	}

	@Autowired
	public CSRFacade(CSRBO csrBO) {
		this.csrBO = csrBO;
	}

	public Integer donateAmount(RegistrationVO registrationVO) throws InvalidEmailException, InvalidEmpNameException,InvalidPhoneNoException, InvalidUnitCodeException
	{
		return csrBO.donateAmount(registrationVO);
	}

	public List<DetailsVO> viewDonatedDetails(Integer unitCode) 
			throws NoRecordsException {
		return csrBO.viewDonatedDetails(unitCode);

	}

}
