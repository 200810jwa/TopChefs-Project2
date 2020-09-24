package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.models.Recipe;
import com.revature.models.User;
import com.revature.services.ListService;
import com.revature.services.RecipeService;
import com.revature.services.UserService;
import com.revature.templates.RecipeSaveTemplate;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
public class UserActionsController {

	@Autowired
	private RecipeService rservice;
	
	@Autowired 
	private UserService uservice;

	@PostMapping(path = "viewPrevious", produces = "application/json")
	@ResponseBody
	public ResponseEntity<List<Recipe>> viewPrevious(@RequestBody User u) {
		List<Recipe> list = u.getPreviousRecipes();
		if (list != null) {
			return ResponseEntity.ok(list);
		} else {
			// Return empty List? need to fix this???
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PostMapping(path = "viewFavorites", produces = "application/json")
	@ResponseBody
	public ResponseEntity<List<Recipe>> viewFavorites(@RequestBody User u) {
		List<Recipe> list = u.getFavoriteRecipes(); // change to get Favorite Recipes
		if (u != null) {
			return ResponseEntity.ok(list);
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PutMapping("saveToFavorites")
	@ResponseBody
	public ResponseEntity<Recipe> saveToFavorites(@RequestBody RecipeSaveTemplate rst) {
		if(rservice.saveToFavorites(rst.getRecipe(), rst.getUser()) == true) {
			System.out.println("Saved to Favorites");
			return ResponseEntity.accepted().build();
		}else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
				
	}
	
	@PutMapping("saveToPrevious")
	@ResponseBody
	public ResponseEntity<Recipe> saveToPrevious(@RequestBody RecipeSaveTemplate rst) {
		if(rservice.saveToPrevious(rst.getRecipe(), rst.getUser()) == true) {
			System.out.println("saved to previous");
			return ResponseEntity.accepted().build();
		}else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
				
	}

//To Do:
	// -Query database based on List<String> of ingredients?
	// -Not sure if this is how to implement this.

}
