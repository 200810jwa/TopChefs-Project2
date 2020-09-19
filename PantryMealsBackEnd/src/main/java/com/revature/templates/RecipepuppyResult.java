package com.revature.templates;

import java.util.Set;

import com.revature.models.Recipe;

public class RecipepuppyResult {
	private String title;
	private float version;
	private String href;
	private Set<Recipe> results;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public float getVersion() {
		return version;
	}
	public void setVersion(float version) {
		this.version = version;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public Set<Recipe> getResults() {
		return results;
	}
	public void setResults(Set<Recipe> results) {
		this.results = results;
	}
	
	
}
