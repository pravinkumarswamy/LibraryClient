package com.library.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.library.entities.Library;
@Component
public class LibraryDaoImpl implements LibraryDao{
	@Autowired
	private JdbcTemplate jdbctemplate;
	
	@Override
	public List<Library> findAll() {
		// TODO Auto-generated method stub
		
		return jdbctemplate.query("select * from library", new LibrayRowMapper());
	}

	@Override
	public boolean delete(int student_id) {
		// TODO Auto-generated method stub
		int res=jdbctemplate.update("delete from library where student_id="+student_id);
		System.out.println(res);
		if(res>=1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean insert(Library library) {
		// TODO Auto-generated method stub
		int res=jdbctemplate.update("insert into library values(?,?,?,?,?)",
				library.getName_of_the_student(),
				library.getBook_issued(),library.getEmail_id(),library.getPhone_number(), library.getStudent_id());
		if(res>=1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean update(Library library) {
		// TODO Auto-generated method stub
		int res=jdbctemplate.update("update library set name_of_the_student=?,book_issued=?,email_id=?,phone_number=? where student_id=?",library.getName_of_the_student(),library.getBook_issued(),library.getEmail_id(),library.getPhone_number(),library.getStudent_id());
		if(res>=1) {
			return true;
		}
		return false;
	}

}
