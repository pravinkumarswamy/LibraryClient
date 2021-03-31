package com.library.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.library.exceptions.InvalidUsernameAndPassword;

@ControllerAdvice
public class ExceptionHandlerController {
	
	
	@ExceptionHandler(Exception.class)
	public String BaseException(Exception ex,Model model) {
		model.addAttribute("message", ex.getMessage());
		return "error";
	}
	
	@ExceptionHandler(InvalidUsernameAndPassword.class)
	public String InvalidUsernameException(InvalidUsernameAndPassword ex,Model model) {
		model.addAttribute("message", ex.getMessage());
		return "login";
	}

}
