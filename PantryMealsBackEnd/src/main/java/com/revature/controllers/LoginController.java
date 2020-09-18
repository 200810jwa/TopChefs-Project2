package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.models.User;
import com.revature.services.IUserService;
import com.revature.services.UserService;
import com.revature.templates.LoginTemplate;

@Controller
//@RequestMapping("/login")
public class LoginController {

	@Autowired
	private UserService service;
	
	@PostMapping(path = "login", produces = "application/json")
	@ResponseBody
	public ResponseEntity<User> loginController(@RequestBody LoginTemplate lf) {
		User u = service.login(lf);
		if(u != null) {
			return ResponseEntity.ok(u);
		}else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
				
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home() {
		return "home";
	}
	
}
