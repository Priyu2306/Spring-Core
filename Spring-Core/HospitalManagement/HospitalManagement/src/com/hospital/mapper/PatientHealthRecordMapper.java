package com.hospital.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hospital.bean.PatientHealthRecordVO;

public class PatientHealthRecordMapper implements RowMapper{

	@Override
	public PatientHealthRecordVO mapRow(ResultSet resultSet, int rownum) throws SQLException {
		
		PatientHealthRecordVO patientHealthRecordVO = new PatientHealthRecordVO();
		patientHealthRecordVO.setPatientId(resultSet.getInt("patient_id"));
		patientHealthRecordVO.setTestName(resultSet.getString("test_name"));
		patientHealthRecordVO.setTestCost(resultSet.getFloat("test_cost"));
		patientHealthRecordVO.setTestDate(resultSet.getDate("test_date"));
		
		return patientHealthRecordVO;
	}
	
	

}
