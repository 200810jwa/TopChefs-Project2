package com.revature.models;

import java.util.Arrays;

public class Recipe {
	private int id;
	private String title;
	private String link;
	private String[] ingredients;
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
	public String[] getIngredients() {
		return ingredients;
	}
	public void setIngredients(String[] ingredients) {
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
		result = prime * result + id;
		result = prime * result + Arrays.hashCode(ingredients);
		result = prime * result + ((link == null) ? 0 : link.hashCode());
		result = prime * result + Float.floatToIntBits(rating);
		result = prime * result + ((thumbnailBase64 == null) ? 0 : thumbnailBase64.hashCode());
		result = prime * result + Arrays.hashCode(thumbnailByteArray);
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
		if (id != other.id)
			return false;
		if (!Arrays.equals(ingredients, other.ingredients))
			return false;
		if (link == null) {
			if (other.link != null)
				return false;
		} else if (!link.equals(other.link))
			return false;
		if (Float.floatToIntBits(rating) != Float.floatToIntBits(other.rating))
			return false;
		if (thumbnailBase64 == null) {
			if (other.thumbnailBase64 != null)
				return false;
		} else if (!thumbnailBase64.equals(other.thumbnailBase64))
			return false;
		if (!Arrays.equals(thumbnailByteArray, other.thumbnailByteArray))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	public Recipe(int id, String title, String link, String[] ingredients) {
		super();
		this.id = id;
		this.title = title;
		this.link = link;
		this.ingredients = ingredients;
	}
	public Recipe(int id, String title, String link, String[] ingredients, String thumbnailBase64) {
		super();
		this.id = id;
		this.title = title;
		this.link = link;
		this.ingredients = ingredients;
		this.thumbnailBase64 = thumbnailBase64;
	}
	public Recipe(int id, String title, String link, String[] ingredients, byte[] thumbnailByteArray) {
		super();
		this.id = id;
		this.title = title;
		this.link = link;
		this.ingredients = ingredients;
		this.thumbnailByteArray = thumbnailByteArray;
	}
	public Recipe() {
		super();
	}
	@Override
	public String toString() {
		return "Recipe [id=" + id + ", title=" + title + ", link=" + link + ", ingredients="
				+ Arrays.toString(ingredients) + ", thumbnailBase64=" + thumbnailBase64 + ", thumbnailByteArray="
				+ Arrays.toString(thumbnailByteArray) + ", rating=" + rating + "]";
	}
	
}
