package com.revature.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;


import com.revature.models.Recipe;
import com.revature.models.User;
import com.revature.services.RecipeService;
import com.revature.services.UserService;
import com.revature.templates.LoginTemplate;
import com.revature.templates.RecipeRequestTemplate;
import com.revature.templates.RecipeTemp;


@Controller
@CrossOrigin(origins = "http://localhost:4200")
public class RecipeController {
	
	@Autowired
	private RecipeService rservice;
	
	@Autowired
	private UserService service;
	
//	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("allRecipes")
	@ResponseBody
	public ResponseEntity<Set<Recipe>> FindAll() {
		Set<Recipe> list = rservice.findAll();
		return ResponseEntity.ok(list);
		
	}
	
//	@CrossOrigin(origins = "http://localhost:4200")
	@PatchMapping("rate")
	@ResponseBody
	public ResponseEntity rateRecipe(@RequestBody Recipe r) {
		if(rservice.update(r) == true) {
			return ResponseEntity.accepted().build();
		}else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
//	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(path = "recipes", produces = "application/json")
	@ResponseBody
	public ResponseEntity<Set<Recipe>> findRecipes(@RequestBody RecipeRequestTemplate rt) {
		Set<Recipe> results;
		results = rservice.getRecipes(rt.list,rt.looseFilter);
		//rservice.assignRatings(results);
		if(results != null) {
			return ResponseEntity.ok(results);
		}else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
				
	}
	
	
}
