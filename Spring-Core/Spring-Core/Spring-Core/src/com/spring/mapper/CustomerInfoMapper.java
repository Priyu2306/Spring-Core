package com.spring.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bean.CustomerVO;

public class CustomerInfoMapper implements RowMapper{

	@Override
	public CustomerVO mapRow(ResultSet resultSet, int rownum) throws SQLException {
		CustomerVO customerVO = new CustomerVO();
		customerVO.setCustomerName(resultSet.getString("customer_name"));
		customerVO.setCustomerId(resultSet.getInt("customer_id"));
		customerVO.setAddress(resultSet.getString("address"));
		customerVO.setContctno(resultSet.getString("contactno"));
		
		return customerVO;
	}

}
