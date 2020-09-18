package com.revature.repositories;

import java.util.List;
import java.util.Set;

import com.revature.models.User;

public interface IUserDAO {
	
	public User findById(int id);

	public User findByUsername(String username);

	public Set<User> findAll();
	
	public boolean save(User u);
	
	public boolean update(User u);
	
	public boolean delete(User u);

}
