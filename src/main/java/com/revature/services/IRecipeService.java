package com.revature.services;

import java.util.Set;

import com.revature.models.Recipe;

public interface IRecipeService {

	public Set<Recipe> findAll();
}
