package com.revature.models;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.revature.templates.RecipeTemp;

@Component
@Entity
@Table(name = "recipes")
public class Recipe implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name ="recipe_id")
	@SequenceGenerator(name="recipe",sequenceName="recipe_seq", allocationSize=1)
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="recipe")
	private int id;
	private String title;
	private String href;
	private String ingredients;
	private String thumbnail;
	private int[] rating;
	
	
	public Recipe() {
		super();
	}


	public Recipe(int id, String title, String href, String ingredients, String thumbnail, int[] rating) {
		super();
		this.id = id;
		this.title = title;
		this.href = href;
		this.ingredients = ingredients;
		this.thumbnail = thumbnail;
		this.rating = rating;
	}
	
	
	public Recipe(int id, String title, String href, String ingredients) {
		super();
		this.id = id;
		this.title = title;
		this.href = href;
		this.ingredients = ingredients;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setIdNull(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getIngredients() {
		return ingredients;
	}
	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}
	public int[] getRating() {
		return rating;
	}
	public void setRating(int[] rating) {
		this.rating = rating;
	}
	
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Recipe [id=" + id + ", title=" + title + ", href=" + href + ", ingredients=" + ingredients
				+ ", thumbnail=" + thumbnail + ", rating=" + rating + "]";
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((href == null) ? 0 : href.hashCode());
		result = prime * result + id;
		result = prime * result + ((ingredients == null) ? 0 : ingredients.hashCode());
		result = prime * result + Arrays.hashCode(rating);
		result = prime * result + ((thumbnail == null) ? 0 : thumbnail.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Recipe other = (Recipe) obj;
		if (href == null) {
			if (other.href != null)
				return false;
		} else if (!href.equals(other.href))
			return false;
		if (id != other.id)
			return false;
		if (ingredients == null) {
			if (other.ingredients != null)
				return false;
		} else if (!ingredients.equals(other.ingredients))
			return false;
		if (!Arrays.equals(rating, other.rating))
			return false;
		if (thumbnail == null) {
			if (other.thumbnail != null)
				return false;
		} else if (!thumbnail.equals(other.thumbnail))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}


	public Recipe(RecipeTemp rt) {
		super();
		this.title = rt.getRec().getTitle();
		this.href = rt.getRec().getHref();
		this.ingredients = rt.getRec().getIngredients();
		this.thumbnail = rt.getRec().getThumbnail();
		this.rating = rt.getRec().getRating();
	}

	
	
	
	
	
}

