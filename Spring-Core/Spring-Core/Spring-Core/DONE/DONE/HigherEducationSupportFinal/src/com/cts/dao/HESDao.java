package com.cts.dao;

import java.util.List;

import com.cts.bo.DetailsVO;
import com.cts.bo.RegistrationVO;


public interface HESDao {

	public College getCollegeDetails(Integer collegeId);

	public Integer registerCourse(RegistrationVO registrationVO);

	public List<DetailsVO> viewRegisteredDetails(int collegeId,
			String modeOfStudy);

}
