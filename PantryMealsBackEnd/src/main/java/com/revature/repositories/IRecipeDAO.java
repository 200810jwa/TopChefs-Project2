package com.revature.repositories;

import java.util.Set;

import com.revature.models.Recipe;

public interface IRecipeDAO {
	
	public Recipe findbyId();
	
	public void save(Recipe r);
	
	public Set<Recipe> findAll();
	
	public void update(Recipe r);
	
	public void delete(Recipe r);
	
	
	

}
