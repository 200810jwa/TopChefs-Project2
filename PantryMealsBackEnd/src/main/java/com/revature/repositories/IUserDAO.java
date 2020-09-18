package com.revature.repositories;

import com.revature.models.User;

public interface IUserDAO {
	
	public void save(User u);
	
	public void update(User u);

}
