package com.javatechnology.service;

import java.util.List;

import com.javatechnology.model.Login;

public interface LoginService {
	public void addLogin(Login login);
	public List<Login> getAllLogins();
	public Login deleteLogin(long id);
	public Login updateLogin(Login login);
	public Login getLogin(long id);

}
