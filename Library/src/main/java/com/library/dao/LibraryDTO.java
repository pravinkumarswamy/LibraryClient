package com.library.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.library.entities.Library;
//@Component
public class LibraryDTO {
//	@Autowired
	private List<Library> library;

	public List<Library> getLibrary() {
		return library;
	}

	public void setLibrary(List<Library> library) {
		this.library = library;
	}

}
