package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.models.User;
import com.revature.services.UserService;
import com.revature.templates.LoginTemplate;

@Controller
//@RequestMapping("/login")
public class LoginController {

	@Autowired
	private UserService service;
	
	@PostMapping(path = "login", produces = "application/json")
	@ResponseBody
	public User loginController(@RequestBody LoginTemplate lf) {
		return service.login(lf);
	}
	
}
