package com.revature.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Recipe;
import com.revature.models.User;
import com.revature.repositories.IRecipeDAO;
import com.revature.repositories.IUserDAO;

@Service
public class RecipeService {

	@Autowired
	private IRecipeDAO dao;
	
	@Autowired
	private IUserDAO udao;
	
	public Set<Recipe> findAll() {
		return dao.findAll();
	}
	
	public boolean save(Recipe r) {
		 return dao.save(r);
	}
	
	public boolean update(Recipe r) {
		return dao.update(r);
	}
	
	public boolean delete(Recipe r) {
		return dao.delete(r);
	}

	public boolean saveToFavorites(Recipe r, User u) {
		u.getRecipes().add(r);
		return udao.update(u);
	}

}
