package com.revature.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.revature.models.Recipe;
import com.revature.models.User;
import com.revature.services.UserService;


@Configuration
@ComponentScan("com.revature")
public class Config {
	
	@Bean(name = "user")
	public User getUser() {
		return new User();
	}
	
	@Bean(name = "recipe")
	public Recipe getRecipe() {
		return new Recipe();
	}
	
	@Bean(name = "service")
	public UserService getUserService() {
		return new UserService();
	}
}
