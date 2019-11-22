package com.spring.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.BookPackageVO;
import com.bean.CustomerVO;
import com.bean.PackageVO;
import com.spring.mapper.CustomerInfoMapper;


@Repository
public class PackageInfoDAO {
	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	
	
	public DataSource getDataSource() {
		return dataSource;
	}

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int insertPackageInfo(PackageVO packageVO){
		int insertStatus=0;
		String sql="insert into package_info(pckage_id, package_name, no_of_nights, room_type, base_tariff, no_of_adults, no_of_kids)"+
					"values(?, ?, ?, ?, ?, ?, ?)";
		insertStatus = jdbcTemplate.update(sql, new Object[]{packageVO.getPackage_id(),packageVO.getPackage_name(),packageVO.getNo_of_nights(),
						packageVO.getRoom_type(),packageVO.getBase_tariff(),packageVO.getNo_of_adults(),packageVO.getNo_of_kids()});
		return insertStatus;
	}
	
	public int getCount(){
		String sql="select count(*) from package_info";
		int count = jdbcTemplate.queryForInt(sql);
		int packageCount = 100 + count;
		return packageCount;
	}
	
	public float getPackageBaseTariff(String packageId){
		float baseTariff=0;
		String sql="select base_tariff from package_info where pckage_id=?";
		baseTariff=(Float)jdbcTemplate.queryForObject(sql, new Object[]{packageId},Float.class);
		return baseTariff;
	}
	
	public int addCustomer(CustomerVO customerVO){
		int insertStatus=0; 
		int status = 0;
		String sql= "insert into customer_info(customer_name,address,contactno) values(?,?,?)";
		String sql1 = "select * from customer_info where customer_id=(Select max(customer_id) from customer_info)";
		insertStatus = jdbcTemplate.update(sql, new Object[]{customerVO.getCustomerName(),customerVO.getAddress(),customerVO.getContctno()});
		if(insertStatus==1){
			customerVO = (CustomerVO) jdbcTemplate.queryForObject(sql1, new CustomerInfoMapper());
			status=customerVO.getCustomerId();
		}
		
		return status;
	}
	
	public int addBookingDetails(BookPackageVO bookPackageVO,String packageId){
		int status=0;
		String sql="insert into booking_info(package_id,no_of_adults,no_of_kids,checkin,checkout,season,total_tariff,customer_id) " +
				"values(?, ?, ?, ?, ?, ?, ?, ?)";
		status=jdbcTemplate.update(sql, new Object[]{packageId,bookPackageVO.getNoOfAdults(),bookPackageVO.getNoOfKids(),bookPackageVO.getCheckin(),bookPackageVO.getCheckout(),
				bookPackageVO.getSeason(),bookPackageVO.getTotalTariff(),bookPackageVO.getCustomerId()});
			
		return status;
	}

}
