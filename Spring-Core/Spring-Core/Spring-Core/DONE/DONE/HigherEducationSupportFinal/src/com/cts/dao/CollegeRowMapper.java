package com.cts.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CollegeRowMapper implements RowMapper<College>{
	
	public College mapRow(ResultSet rs, int rowNum) throws SQLException {
		College college = new College();
		college.setCollegeId(rs.getInt("COLLEGEID"));
		college.setCollegeName(rs.getString("COLLEGENAME"));
		college.setCourseOffered(rs.getString("COURSEOFFERED"));
		college.setDescription(rs.getString("DESCRIPTION"));
		return college;
	}

}
