package com.revature.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.sun.istack.NotNull;

@Component
@Entity
@Table(name = "users")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(unique = true)
	private String username;

	private String password;
	private String firstName;
	private String lastName;
	private String email;

	public User(int id, String username, String password, String firstName, String lastName, String email) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	@ManyToMany
	@JoinTable(name = "User_Favorites", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {
			@JoinColumn(name = "recipe_id") })
	@JoinColumn(nullable = false)
	private List<Recipe> FavoriteRecipes;

	@ManyToMany
	@JoinTable(name = "User_Previous", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {
			@JoinColumn(name = "recipe_id") })
	private List<Recipe> previousRecipes;

	public User() {
		super();
	}

	public User(int id, String username, String password, String firstName, String lastName, String email,
			List<Recipe> savedRecipes, List<Recipe> previousRecipes) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.FavoriteRecipes = savedRecipes;
		this.previousRecipes = previousRecipes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + id;
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((previousRecipes == null) ? 0 : previousRecipes.hashCode());
		result = prime * result + ((FavoriteRecipes == null) ? 0 : FavoriteRecipes.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id != other.id)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (previousRecipes == null) {
			if (other.previousRecipes != null)
				return false;
		} else if (!previousRecipes.equals(other.previousRecipes))
			return false;
		if (FavoriteRecipes == null) {
			if (other.FavoriteRecipes != null)
				return false;
		} else if (!FavoriteRecipes.equals(other.FavoriteRecipes))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + ", savedRecipes=" + FavoriteRecipes
				+ ", previousRecipes=" + previousRecipes + "]";
	}

	public List<Recipe> getFavoriteRecipes() {
		return FavoriteRecipes;
	}

	public void setFavoriteRecipes(List<Recipe> savedRecipes) {
		this.FavoriteRecipes = savedRecipes;
	}

	public List<Recipe> getPreviousRecipes() {
		return previousRecipes;
	}

	public void setPreviousRecipes(List<Recipe> previousRecipes) {
		this.previousRecipes = previousRecipes;
	}

}
