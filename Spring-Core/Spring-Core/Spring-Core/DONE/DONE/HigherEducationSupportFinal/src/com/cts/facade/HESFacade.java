package com.cts.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cts.bo.DetailsVO;
import com.cts.bo.HESBO;
import com.cts.bo.RegistrationVO;
import com.cts.exceptions.InvalidCollegeIdException;
import com.cts.exceptions.InvalidJobLevelException;
import com.cts.exceptions.InvalidModeOfStudyException;
import com.cts.exceptions.NoRecordsException;

@Component("hesFascade")
public class HESFacade {

	HESBO bo;

	public HESFacade(){

	}
	@Autowired
	public HESFacade(HESBO bo){
		this.bo=bo;
	}

	public Integer registerCourse(RegistrationVO registrationVO) throws InvalidCollegeIdException,InvalidJobLevelException,InvalidModeOfStudyException
	{

		return bo.registerCourse(registrationVO);
	}

	public List<DetailsVO> viewRegisteredDetails(int collegeId, String modeOfStudy) throws NoRecordsException {

		return  bo.viewRegisteredDetails(collegeId,modeOfStudy);

	}

}
