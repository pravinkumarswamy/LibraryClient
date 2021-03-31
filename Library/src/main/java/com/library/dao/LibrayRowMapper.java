package com.library.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.library.entities.Library;

public class LibrayRowMapper implements RowMapper<Library>{

	@Override
	public Library mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Library library=new Library();
		library.setName_of_the_student(rs.getString(1));
		library.setBook_issued(rs.getString(2));
		library.setEmail_id(rs.getString(3));
		library.setPhone_number(rs.getInt(4));
		library.setStudent_id(rs.getInt(5));
		return library;
	}
	

}
