package com.library.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.library.entities.Library;

@Component
public interface LibraryDao {
	
	public List<Library> findAll();//for getting all objects fromDB
	public boolean delete(int student_id);//for deleting each record
	public boolean insert(Library library);//for inserting records
	public boolean update(Library library);//for updating records

}
