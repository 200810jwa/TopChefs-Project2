package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.models.Recipe;
import com.revature.models.User;
import com.revature.services.ListService;

@Controller
public class UserActionsController {

	@Autowired
	private ListService service;
	
	@PostMapping(path = "viewPrevious", produces = "application/json")
	@ResponseBody
	public ResponseEntity<List<Recipe>> UserActionsController(@RequestBody User u) {
		List<Recipe> list = u.getRecipes();
		if(u != null) {
			return ResponseEntity.ok(list);
		}else {
			//Return empty List? need to fix this???
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
		
//	@PostMapping(path = "viewFavorites", produces = "application/json")
//	@ResponseBody
//	public ResponseEntity<List<Recipe>> UserActionsController(@RequestBody User u) {
//		List<Recipe> list = u.getRecipes(); // change to get Favorite Recipes
//		if(u != null) {
//			return ResponseEntity.ok(list);
//		}else {
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//		}	
		
//To Do:
	//-Query database based on List<String> of ingredients?
	//-Not sure if this is how to implement this. 
		


		
	}
