package com.cts.dao;

import java.util.List;

import com.cts.bo.DetailsVO;
import com.cts.bo.RegistrationVO;

public interface CSRDao {

	public CSRUnit getUnitDetails(Integer unitCode); 

	public Integer donateAmount(RegistrationVO registrationVO) ; 
	
	public List<DetailsVO> viewDonatedDetails(Integer unitCode);	
}
