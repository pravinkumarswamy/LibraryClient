package com.library.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.dao.AdminDao;
import com.library.entities.Admin;
import com.library.exceptions.InvalidUsernameAndPassword;
@Service
public class AdminServices {
	@Autowired
	private AdminDao admindao;
	
	public Admin ValidateAdmin(String username,String password) {
		Admin admin=admindao.find(username);
		if(password.equals(admin.getPassword())) {
			return admin;
		}
		else {
			throw new InvalidUsernameAndPassword("Incorrect Username and Password");
		}
//		return null;
	}

}
