package com.javatechnology.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javatechnology.dao.LoginDao;
import com.javatechnology.model.Login;
@Service
@Transactional(readOnly=true)
public class LoginServiceImpl implements LoginService{
	@Autowired
	private LoginDao dao;
	@Override
	@Transactional
	public void addLogin(Login login) {
		dao.addLogin(login);
		
	}

	@Override
	public List<Login> getAllLogins() {
		return dao.getAllLogins();
	}

	@Override
	@Transactional
	public Login deleteLogin(long id) {
		return dao.deleteLogin(id);
		
	}

	@Override
	@Transactional
	public Login updateLogin(Login login) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Login getLogin(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
