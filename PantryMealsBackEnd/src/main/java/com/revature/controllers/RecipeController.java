package com.revature.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;


import com.revature.models.Recipe;
import com.revature.services.RecipeService;


@Controller
public class RecipeController {
	
	@Autowired
	private RecipeService rservice;
	
	@GetMapping("recipe/{id}")
	@ResponseBody
	public Recipe FindById(@PathVariable("id") int id) {
		Set<Recipe> all = rservice.findAll();
		
		for(Recipe r : all) {
			if(r.getId() == id) {
				return r;
			}
		}
		
		return null;
	}
	
	
}
