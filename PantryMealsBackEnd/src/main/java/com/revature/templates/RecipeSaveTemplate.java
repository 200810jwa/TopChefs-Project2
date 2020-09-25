package com.revature.templates;

import com.revature.models.Recipe;
import com.revature.models.User;

public class RecipeSaveTemplate {
	Recipe recipe;
	User user;
	
	public Recipe getRecipe() {
		return recipe;
	}
	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
}
