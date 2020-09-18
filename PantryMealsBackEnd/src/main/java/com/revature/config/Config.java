package com.revature.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.revature.models.Recipe;
import com.revature.models.User;

@Configuration
@ComponentScan("com.revature")
public class Config {
	
	@Bean(name ="user")
	public User getUser() {
		return new User();
	}
	
	@Bean(name= "recipe")
	public Recipe getRecipe() {
		return new Recipe();
	}

}
