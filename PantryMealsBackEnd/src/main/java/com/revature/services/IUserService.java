package com.revature.services;

import com.revature.models.User;
import com.revature.templates.LoginTemplate;

public interface IUserService {
	public User login(LoginTemplate lf);
}
