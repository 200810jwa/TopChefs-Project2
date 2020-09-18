package com.revature.services;

import java.util.Set;

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
		System.out.println(userDao.findAll());
		User u = userDao.findByUsername(lf.getUsername());
		if(u == null) {
			System.out.println("couldn't find username");
			return null;
		}
		
		if(u.getPassword().equals(lf.getPassword())) {
			return u;
		}
		
		return null;
	}

	public boolean save(User u){
		return userDao.save(u);
	}
	
	public boolean update(User u) {
		return userDao.update(u);
	}
	
	public boolean delete(User u) {
		return userDao.delete(u);
	}

	public Set<User> findAll() {
		return userDao.findAll();
	}
}
