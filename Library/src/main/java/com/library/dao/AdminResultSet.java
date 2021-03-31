package com.library.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.library.entities.Admin;

public class AdminResultSet implements ResultSetExtractor<Admin>{

	@Override
	public Admin extractData(ResultSet rs) throws SQLException, DataAccessException {
		// TODO Auto-generated method stub
		Admin admin=null;
		if(rs.next()) {
		admin=new Admin();
		
		admin.setUsername(rs.getString(1));
		admin.setPassword(rs.getString(2));
		}
		return admin;
	}

}
