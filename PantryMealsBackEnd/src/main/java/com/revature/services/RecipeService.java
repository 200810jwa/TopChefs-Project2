package com.revature.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.models.Recipe;
import com.revature.repositories.IRecipeDAO;


public class RecipeService implements IRecipeService {

	@Autowired
	private IRecipeDAO dao;
	
	public Set<Recipe> findAll() {
		return dao.findAll();
	}

}
