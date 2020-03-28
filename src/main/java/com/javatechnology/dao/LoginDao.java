package com.javatechnology.dao;

import java.util.List;

import com.javatechnology.model.Login;

public interface LoginDao {
	public void addLogin(Login login);
	public List<Login> getAllLogins();
	public Login deleteLogin(long id);
	public Login updateLogin(Login login);
	public Login getLogin(long id);
}
