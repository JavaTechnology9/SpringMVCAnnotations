package com.javatechnology.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javatechnology.model.Login;
@Repository
public class LoginDaoImpl implements LoginDao{
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public void addLogin(Login login) {
		sessionFactory.getCurrentSession().save(login);
		
	}

	@Override
	public List<Login> getAllLogins() {
		Session currentSession = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Login> list = currentSession.createQuery("from Login").list();
		return !list.isEmpty()?list:null;
	}

	@Override
	public Login deleteLogin(long id) {
		Login login=(Login)sessionFactory.getCurrentSession().get(Login.class, id);
		Session currentSession = sessionFactory.getCurrentSession();
		if(login==null)
			return null;
		else
			currentSession.delete(login);
		return login;
		
		
	}

	@Override
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
