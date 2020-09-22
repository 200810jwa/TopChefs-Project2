package com.revature.unitTests;


import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import com.revature.controllers.UserController;
import com.revature.services.UserService;


public class UserControllerTest {

	@Mock
	UserService userService;
	UserController userController;
	
	@Mock
	Model model;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		userController = new UserController();
	}
	
	
}

