package com.library.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.library.entities.Admin;
@Component
public class AdminDaoImpl implements AdminDao{
	
	@Autowired
	private JdbcTemplate jdbctemplate;

	public Admin find(String username) {

		PreparedStatementSetter setter = new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, username);
//				ps.setString(2, password);
			}
		};

		return jdbctemplate.query("select * from admin where username=?", setter,
				new ResultSetExtractor<Admin>() {

					@Override
					public Admin extractData(ResultSet rs) throws SQLException, DataAccessException {

						Admin adm = null;
						if (rs.next()) {
							adm = new Admin();
							adm.setUsername(rs.getString(1));
							adm.setPassword(rs.getString(2));
							
						}
						return adm;
					}
				});
	}

	
	
	

}
