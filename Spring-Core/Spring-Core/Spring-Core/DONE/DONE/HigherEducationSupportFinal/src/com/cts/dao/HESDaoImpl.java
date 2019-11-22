package com.cts.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cts.bo.DetailsVO;
import com.cts.bo.RegistrationVO;

@Repository("HESDao")
public class HESDaoImpl extends JdbcDaoSupport implements HESDao {

	public HESDaoImpl() {

	}

	@Transactional
	public College getCollegeDetails(Integer collegeId) 
	{

		String collegeQuery="SELECT * FROM COLLEGE WHERE COLLEGEID=?";
		College college=getJdbcTemplate().queryForObject(collegeQuery, new Object[]{collegeId}, new CollegeRowMapper());
		
		return college;
	}

	@Transactional
	public Integer registerCourse(RegistrationVO registrationVO) 
	{

		String insertQuery="INSERT INTO REGISTRATION (EMPNO,EMPNAME,JOBLEVEL,COLLEGEID,MODEOFSTUDY,REGISTRATIONDATE) VALUES (:empNo,:empName,:jobLevel,:collegeId,:modeOfStudy,:regDate)";
		KeyHolder holder=new GeneratedKeyHolder();
		MapSqlParameterSource params=new MapSqlParameterSource();
		params.addValue("empNo", registrationVO.getEmpNo());
		params.addValue("empName", registrationVO.getEmpName());
		params.addValue("jobLevel", registrationVO.getJobLevel());
		params.addValue("collegeId", registrationVO.getCollegeId());
		params.addValue("modeOfStudy", registrationVO.getModeOfStudy());
		params.addValue("regDate", registrationVO.getRegistrationDate());
		
		NamedParameterJdbcTemplate template=new NamedParameterJdbcTemplate(getDataSource());
		template.update(insertQuery, params,holder,new String[]{"registrationId"});
		return holder.getKey().intValue();
	}

	public List<DetailsVO> viewRegisteredDetails(int collegeId,String modeOfStudy) 
	{
		String selectQuery="SELECT * FROM REGISTRATION WHERE COLLEGEID=? AND MODEOFSTUDY=?";
		List<Registration> detailsList= getJdbcTemplate().query(selectQuery, new Object[]{collegeId,modeOfStudy}, new RegistrationRowMapper());
		List<DetailsVO> detailList=new ArrayList<DetailsVO>();
		College college=getCollegeDetails(collegeId); 
		for (Registration registration : detailsList) 
		{
			DetailsVO detailsVO=new DetailsVO();
			BeanUtils.copyProperties(registration, detailsVO);
			BeanUtils.copyProperties(college, detailsVO);
			detailList.add(detailsVO);
		}
		
		
		return  detailList;
	}
}
