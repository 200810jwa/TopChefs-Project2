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
	private String link;
	private String ingredients;
	private String thumbnailBase64;
	private byte[] thumbnailByteArray;
	private float rating;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getIngredients() {
		return ingredients;
	}
	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}
	public String getThumbnailBase64() {
		return thumbnailBase64;
	}
	public void setThumbnailBase64(String thumbnailBase64) {
		this.thumbnailBase64 = thumbnailBase64;
	}
	public byte[] getThumbnailByteArray() {
		return thumbnailByteArray;
	}
	public void setThumbnailByteArray(byte[] thumbnailByteArray) {
		this.thumbnailByteArray = thumbnailByteArray;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(thumbnailByteArray);
		result = prime * result + Objects.hash(id, ingredients, link, rating, thumbnailBase64, title);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Recipe)) {
			return false;
		}
		Recipe other = (Recipe) obj;
		return id == other.id && Objects.equals(ingredients, other.ingredients) && Objects.equals(link, other.link)
				&& Float.floatToIntBits(rating) == Float.floatToIntBits(other.rating)
				&& Objects.equals(thumbnailBase64, other.thumbnailBase64)
				&& Arrays.equals(thumbnailByteArray, other.thumbnailByteArray) && Objects.equals(title, other.title);
	}
	@Override
	public String toString() {
		return "Recipe [id=" + id + ", title=" + title + ", link=" + link + ", ingredients=" + ingredients
				+ ", thumbnailBase64=" + thumbnailBase64 + ", thumbnailByteArray=" + Arrays.toString(thumbnailByteArray)
				+ ", rating=" + rating + "]";
	}
	
	
}

