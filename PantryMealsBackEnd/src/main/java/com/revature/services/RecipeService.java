package com.revature.services;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Recipe;
import com.revature.models.User;
import com.revature.repositories.IRecipeDAO;
import com.revature.repositories.IUserDAO;
import com.revature.templates.RecipepuppyResult;

@Service
public class RecipeService {

	@Autowired
	private IRecipeDAO dao;

	@Autowired
	private IUserDAO udao;

	private final CloseableHttpClient httpClient = HttpClients.createDefault();

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
		u.getFavoriteRecipes().add(r);
		return udao.update(u);
	}

	public boolean saveToPrevious(Recipe r, User u) {
		u.getPreviousRecipes().add(r);
		return udao.update(u);
	}

	public Set<Recipe> assignRatings(Set<Recipe> list) {
		Set<Recipe> saved = dao.findAll();
		for (Recipe r : list) {
			for (Recipe s : saved) {
				if (r.getHref().equals(s.getHref())) {
					r.setRating(s.getRating());
				}
			}
		}
		return list;
	}

	public Set<Recipe> getRecipes(String[] ingredients, boolean hardStop) {

		HttpPost request = null;
		ObjectMapper om = new ObjectMapper();
		RecipepuppyResult recipes = null;
		String list = String.join(", ", ingredients);

		try {
			URIBuilder builder = new URIBuilder();
			builder.setScheme("http").setHost("www.recipepuppy.com").setPath("/api").setParameter("i", list);
			URI uri;
			uri = builder.build();
			request = new HttpPost(uri);
		} catch (URISyntaxException e1) {
			e1.printStackTrace();
		}

		try (CloseableHttpClient httpClient = HttpClients.createDefault();
				CloseableHttpResponse response = httpClient.execute(request)) {
			recipes = om.readValue(EntityUtils.toString(response.getEntity()), RecipepuppyResult.class);
		} catch (IOException e) {
			e.printStackTrace();
		}

		Set<Recipe> results = recipes.getResults();
		if (hardStop == true) {
			return filterExtraIng(results, ingredients);			
		}
		return results;
	}
	
	public Set<Recipe> filterExtraIng(Set<Recipe> results, String[] ingredients){
		List<String> ing = Arrays.asList(ingredients);
		for (Recipe r : results) {
			String[] rpingredients = r.getIngredients().split(", ");
			for (String s : rpingredients) {
				if (ing.contains(s) == false) {
					r.setHref("delete");
				}
				
			}
		}
		results.removeIf(r -> (r.getHref().equals("delete"))); // THIS IS NOT WORKING!!!!!!
		return results;
	}
}
