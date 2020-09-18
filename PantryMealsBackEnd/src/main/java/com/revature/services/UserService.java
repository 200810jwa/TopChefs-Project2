package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.User;
import com.revature.repositories.IUserDAO;
import com.revature.templates.LoginTemplate;

@Service
public class UserService {

	@Autowired
	private IUserDAO userDao;
	
	public User login(LoginTemplate lf) {
		// TODO Auto-generated method stub
		System.out.println("login called");
		return null;
	}

	public void save(User u){
		userDao.save(u);
	}
	
	public void update(User u) {
		userDao.update(u);
	}
}
