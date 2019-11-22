package com.cts.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cts.bo.DetailsVO;
import com.cts.bo.RegistrationVO;

@Repository("csrDao")
public class CSRDaoImpl extends JdbcDaoSupport implements CSRDao{
	
	@Transactional
	public CSRUnit getUnitDetails(Integer unitCode) 
	{
		
		String getUnitQuery="SELECT * FROM CSRUNIT WHERE UNITCODE=?";
		CSRUnit csrUnit=null;
		csrUnit=(CSRUnit) getJdbcTemplate().queryForObject(getUnitQuery, new Object[]{unitCode}, new CSRUnitRowMapper());
		return csrUnit;


	}
	@Transactional
	public Integer donateAmount(RegistrationVO registrationVO)   {

		
		CSRUnit csrUnit=getUnitDetails(registrationVO.getUnitCode());
		if(csrUnit!=null)
		{
			String updateSql="UPDATE CSRUNIT SET LASTUPDATEDDATE=? , TOTALAMOUNT=? WHERE UNITCODE=?";
			int totalAmount =registrationVO.getAmount() + csrUnit.getTotalAmount();
			getJdbcTemplate().update(updateSql,new Object[]{new Date(),totalAmount,csrUnit.getUnitCode()});
		}
		
		String insertQuery="INSERT INTO REGISTRATION (EMPNAME,EMPEMAIL,PHONENO,UNITCODE,AMOUNT) VALUES (:empName,:empEmail,:phoneNo,:unitCode,:amount)";
		KeyHolder holder=new GeneratedKeyHolder();
		MapSqlParameterSource param=new MapSqlParameterSource();
		param.addValue("empName", registrationVO.getEmpName());
		param.addValue("empEmail", registrationVO.getEmpEmail());
		param.addValue("phoneNo", registrationVO.getPhoneNo());
		param.addValue("unitCode", registrationVO.getUnitCode());
		param.addValue("amount", registrationVO.getAmount());
		NamedParameterJdbcTemplate template=new NamedParameterJdbcTemplate(getDataSource());
		template.update(insertQuery, param,holder,new String[]{"registrationId"});
		Integer registrationId= holder.getKey().intValue();
		return registrationId;

	}
	@Transactional
	public List<DetailsVO> viewDonatedDetails(Integer unitCode)	 {
		
		String sql="SELECT * FROM REGISTRATION WHERE UNITCODE=?";
		return null;

}

}
