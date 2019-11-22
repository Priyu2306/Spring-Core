package com.hospital.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hospital.bean.PatientHealthRecordVO;
import com.hospital.bean.PatientInfoVO;
import com.hospital.mapper.PatientHealthRecordMapper;
import com.hospital.mapper.PatientInfoMapper;

@Repository
public class PatientInfoDao {
	
	
	DataSource dataSource;
	JdbcTemplate jdbcTemplate;

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
	
	public int insertPatientInfo(PatientInfoVO patientInfoVO){
		int insertSatus = 0;
		String sql ="insert into patient_info" +
				"(patient_id, patient_name, patient_address, patient_age, patient_gender, admission_date" +
				", discharge_date, registration_fee) values(?,?,?,?,?,?,?,?)" ;
		insertSatus = jdbcTemplate.update(sql, new Object[]{patientInfoVO.getPatientId(),patientInfoVO.getPatientName(),
				patientInfoVO.getPatientAddr(),patientInfoVO.getAge(),patientInfoVO.getGender(),patientInfoVO.getAdmissionDate(),
				patientInfoVO.getDischargeDate(),patientInfoVO.getRegistrationFee()});
		if(insertSatus!=0){
			insertSatus = patientInfoVO.getPatientId();
		}
		return insertSatus;
	}
	
	public boolean validatePatientId(int patientId){
		boolean result=false;
		int patient_Id=0;
		String sql ="select patient_id from patient_info where patient_id=?";
		patient_Id = (Integer)jdbcTemplate.queryForInt(sql,new Object[]{patientId});
		if(patient_Id!=0){
			result=true;
		}
		return result;
	}
	
	public int insertPatientHealthRecord(PatientHealthRecordVO patientHealthRecordVO){
		String sql = "insert into patient_health_record(patient_id,test_name,test_cost,test_date) values(?,?,?,?)";
		int status=0;
		status = jdbcTemplate.update(sql,new Object[]{patientHealthRecordVO.getPatientId(),patientHealthRecordVO.getTestName(),
				patientHealthRecordVO.getTestCost(),patientHealthRecordVO.getTestDate()});
		return status;
	}
	
	public PatientInfoVO getPatientInfo(int patientId){
		PatientInfoVO patientInfoVO = null;
		String sql = "select * from patient_info where patient_id=?";
		patientInfoVO = (PatientInfoVO) jdbcTemplate.queryForObject(sql, new Object[]{patientId}, new PatientInfoMapper());
		return patientInfoVO;
	}
	
	public PatientHealthRecordVO getPatientHealthInfo(int patientId){
		PatientHealthRecordVO patientHealthRecordVO = null;
		String sql = "select * from patient_health_record where patient_id=?";
		patientHealthRecordVO = (PatientHealthRecordVO) jdbcTemplate.queryForObject(sql, new Object[]{patientId}, new PatientHealthRecordMapper());
		return patientHealthRecordVO;
	}
	
	public int updatePatientBill(PatientInfoVO patientInfoVO){
		int status = 0;
		String sql ="update patient_info set final_amount=? where patient_id=?";
		status = jdbcTemplate.update(sql,new Object[]{patientInfoVO.getTotalCost(),patientInfoVO.getPatientId()});
		return status;
	}
	
}
