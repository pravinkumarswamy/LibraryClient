package com.library.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.dao.LibraryDTO;
import com.library.dao.LibraryDao;
import com.library.entities.Library;

@Service
public class LibraryServices {
	
	@Autowired
	private LibraryDao librarydao;
	
	public List<Library> getAllLibrary() {
		return librarydao.findAll();
	}
	
	public boolean deleteRecord(int student_id) {
		boolean isDeleted=false;
		if(librarydao.delete(student_id)==true) {
			isDeleted=true;
		}
		else {
			isDeleted=false;
		}
		System.out.println(isDeleted);
		return isDeleted;
	}
	
	public boolean insertRecord(Library library) {
		boolean isInserted=false;
		if(librarydao.insert(library)==true) {
			isInserted=true;
		}
		else {
			isInserted=false;
		}
		System.out.println(isInserted);
		return isInserted;
	}
	
	public boolean updateRecord(Library library) {
		boolean isUpdated=false;
		if(librarydao.update(library)==true) {
			isUpdated=true;
		}
		else {
			isUpdated=false;
		}
		System.out.println(isUpdated);
		return isUpdated;
	}
}
