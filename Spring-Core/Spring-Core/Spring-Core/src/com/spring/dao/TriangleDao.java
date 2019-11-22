package com.spring.dao;



import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TriangleDao {
	
	
	private DataSource dataSource;
	public DataSource getDataSource() {
		return dataSource;
	}

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private JdbcTemplate jdbcTemplate;
	
	 public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void drawMessage(String message){
		System.out.println(message+" "+"In Dao");
	}
	
	public int getCount(){
		int value=0;
		String sql = "Select count(*) from COMPANY";
		value = jdbcTemplate.queryForInt(sql);
		
		return value;
	
	}

}
