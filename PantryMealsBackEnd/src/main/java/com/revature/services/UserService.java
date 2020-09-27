package com.revature.services;

import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.User;
import com.revature.repositories.IUserDAO;
import com.revature.templates.LoginTemplate;
import com.revature.templates.RegisterTemplate;

@Service
public class UserService {

	@Autowired
	private IUserDAO userDao;
	
	private Logger log = Logger.getLogger(UserService.class);

	private PasswordHashingService pw;
	
	public UserService() {
		super();
	}
	
	

	public UserService(IUserDAO userDao) {
		super();
		this.userDao = userDao;
	}



	public User login(LoginTemplate lf) {
		User u = userDao.findByUsername(lf.getUsername());
		if(u == null) {
			log.info("couldn't find username");
			System.out.println("couldn't find username");
			return null;
		}
		if(u.getPassword().equals(pw.passwordHash(lf.getPassword()))){
		//if(u.getPassword().equals(lf.getPassword())) {
			log.info("Logged in a user");
			System.out.println("Logged in a user");
			return u;
		}
		log.info("Loggin attemp failed");
		System.out.println("password hashing not working");
		return null;
	}

	public boolean save(RegisterTemplate rt){
		User u = new User(0, rt.getUsername(), rt.getPassword(), rt.getFirstname(), rt.getLastname(), rt.getEmail());
		return userDao.save(u);
	}
	
	public boolean update(User u) {
		u.setPassword(pw.passwordHash(u.getPassword()));
		return userDao.update(u);
	}
	
	public boolean delete(User u) {
		return userDao.delete(u);
	}

	public Set<User> findAll() {
		return userDao.findAll();
	}

	public User findById(int id) {
		return userDao.findById(id);
	}
	
	public User findByUserName(User u) {
		return userDao.findByUsername(u.getUsername());
	}
}
