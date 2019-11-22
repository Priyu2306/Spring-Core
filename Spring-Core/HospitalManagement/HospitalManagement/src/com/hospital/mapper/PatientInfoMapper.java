package com.hospital.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hospital.bean.PatientInfoVO;

public class PatientInfoMapper implements RowMapper{

	@Override
	public PatientInfoVO mapRow(ResultSet resultSet, int rownum) throws SQLException {
		
		PatientInfoVO patientInfoVO = new PatientInfoVO();
		patientInfoVO.setPatientId(resultSet.getInt("patient_id"));
		patientInfoVO.setPatientName(resultSet.getString("patient_name"));
		patientInfoVO.setPatientAddr(resultSet.getString("patient_address"));
		patientInfoVO.setAge(resultSet.getInt("patient_age"));
		patientInfoVO.setGender(resultSet.getString("patient_gender"));
		patientInfoVO.setAdmissionDate(resultSet.getDate("admission_date"));
		patientInfoVO.setDischargeDate(resultSet.getDate("discharge_date"));
		patientInfoVO.setRegistrationFee(resultSet.getFloat("registration_fee"));
		 
		return patientInfoVO;
	}

}
