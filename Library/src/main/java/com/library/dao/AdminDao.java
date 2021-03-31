package com.library.dao;

import org.springframework.stereotype.Component;

import com.library.entities.Admin;
//@Component
public interface AdminDao {
	public Admin find(String username);
}
