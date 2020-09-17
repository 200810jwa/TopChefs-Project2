package com.revature.repositories;

import java.util.Set;

import com.revature.models.Recipe;

public interface IRecipeDAO {

	public Set<Recipe> findAll();
	

}
