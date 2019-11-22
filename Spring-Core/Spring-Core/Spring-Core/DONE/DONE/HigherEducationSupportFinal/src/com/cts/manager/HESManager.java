package com.cts.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cts.bo.DetailsVO;
import com.cts.bo.RegistrationVO;
import com.cts.exceptions.InvalidCollegeIdException;
import com.cts.exceptions.InvalidJobLevelException;
import com.cts.exceptions.InvalidModeOfStudyException;
import com.cts.exceptions.NoRecordsException;
import com.cts.facade.HESFacade;

@Component("hesManager")
public class HESManager {

	HESFacade facade;

	public HESFacade getFacade() {
		return facade;
	}

	@Autowired
	public void setFacade(HESFacade facade) {
		this.facade = facade;
	}

	public Integer registerCourse(RegistrationVO registrationVO) throws InvalidCollegeIdException,InvalidJobLevelException,InvalidModeOfStudyException
	{
		return facade.registerCourse(registrationVO);
	}

	public List<DetailsVO> viewRegisteredDetails(int collegeId,String modeOfStudy)  throws NoRecordsException
	{
		
		return  facade.viewRegisteredDetails(collegeId,modeOfStudy);
	}

}
