package com.cts.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CSRUnitRowMapper implements RowMapper<CSRUnit>{

	public CSRUnit mapRow(ResultSet rs, int rowNum) throws SQLException {
		CSRUnit csrUnit = new CSRUnit();
		csrUnit.setUnitCode(rs.getInt("UNITCODE"));
		csrUnit.setUnitName(rs.getString("UNITNAME"));
		csrUnit.setTotalAmount(rs.getInt("TOTALAMOUNT"));
		csrUnit.setLastUpdatedDate(rs.getDate("LASTUPDATEDDATE"));
		return csrUnit;
	}


}
