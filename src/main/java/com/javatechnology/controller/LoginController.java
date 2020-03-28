package com.javatechnology.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.javatechnology.exception.LoginNotFoundException;
import com.javatechnology.model.Login;
import com.javatechnology.service.LoginService;
import com.javatechnology.service.MailService;

@RestController
public class LoginController {
	@Autowired
	private LoginService service;
	@Autowired
	private MailService mailService;
	
	@RequestMapping(value="/addLogin",method=RequestMethod.POST,consumes="application/json",produces="application/json")
	public Login addLogin(@RequestBody Login login) {
		service.addLogin(login);
		mailService.sendEmail("Welcome to spring RestService");
		return login;
		
	}
	@RequestMapping(value="/getAll",method=RequestMethod.GET,produces="application/json")
	public List<Login> getAllLogins(){
		return service.getAllLogins();
	}
	@ExceptionHandler(LoginNotFoundException.class)
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity<?> deleteLogin(@PathVariable("id") long id) {
		Login login =service.deleteLogin(id);
		if(login==null) {
			Error error= new Error("login object not found "+id);
			return new ResponseEntity<Error>(error,HttpStatus.NOT_FOUND);
		}
		//HttpStatus status=login!=null?HttpStatus.OK:HttpStatus.NOT_FOUND;
		return new ResponseEntity<Login>(login,HttpStatus.OK);
	}

}
