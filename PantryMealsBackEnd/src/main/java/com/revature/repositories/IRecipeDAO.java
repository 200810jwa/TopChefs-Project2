package com.revature.repositories;

import java.util.Set;

import com.revature.models.Recipe;

public interface IRecipeDAO {
	
	public Recipe findbyId(int id);
	
	public boolean saveOrUpdate(Recipe r);
	
	public Set<Recipe> findAll();
	
//	public boolean update(Recipe r);
	
	public boolean delete(Recipe r);
	
	
	

}
