package com.cts.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class RegistrationRowMapper implements RowMapper<Registration>{
	
	public Registration mapRow(ResultSet rs, int rowNum) throws SQLException {
		Registration registration = new Registration();
		registration.setRegistrationId(rs.getInt("registrationId"));
		registration.setEmpNo(rs.getInt("empNo"));
		registration.setEmpName(rs.getString("empName"));
		registration.setJobLevel(rs.getInt("jobLevel"));
		registration.setModeOfStudy(rs.getString("modeOfStudy"));
		registration.setRegistrationDate(rs.getDate("registrationDate"));
		registration.setCollegeId(rs.getInt("collegeId"));
		return registration;
	}

}
