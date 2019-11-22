package com.cts.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cts.dao.HESDao;
import com.cts.exceptions.InvalidCollegeIdException;
import com.cts.exceptions.InvalidJobLevelException;
import com.cts.exceptions.InvalidModeOfStudyException;
import com.cts.exceptions.NoRecordsException;


@Component("hesBo")
public class HESBO {


	HESDao hesDao;

	public HESDao getHesDao() {
		return hesDao;
	}

	@Autowired
	public void setHesDao(HESDao hesDao) {
		this.hesDao = hesDao;
	}


	public Integer registerCourse(RegistrationVO registrationTO) throws InvalidCollegeIdException,InvalidJobLevelException,InvalidModeOfStudyException
	{

		if(registrationTO.getJobLevel()<0 || registrationTO.getJobLevel()<3 || registrationTO.getJobLevel()>7)
		{
			throw new InvalidJobLevelException();
		}
		if(hesDao.getCollegeDetails(registrationTO.getCollegeId())==null)
		{
			throw new InvalidCollegeIdException();
		}
		if(!(registrationTO.getModeOfStudy().charAt(0)=='P' || registrationTO.getModeOfStudy().charAt(0)=='D'))
		{
			throw new InvalidModeOfStudyException();
		}
		return hesDao.registerCourse(registrationTO);

	}


	public List<DetailsVO> viewRegisteredDetails(int collegeId, String modeOfStudy) {

		return  hesDao.viewRegisteredDetails(collegeId,modeOfStudy);

	}

}
