package com.revature.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Recipe;
import com.revature.repositories.IRecipeDAO;

@Service
public class RecipeService {

	@Autowired
	private IRecipeDAO dao;
	
	public Set<Recipe> findAll() {
		return dao.findAll();
	}
	
	public void save(Recipe r) {
		 dao.save(r);
	}
	
	public void update(Recipe r) {
		dao.update(r);
	}
	
	public void delete(Recipe r) {
		dao.delete(r);
	}

}
