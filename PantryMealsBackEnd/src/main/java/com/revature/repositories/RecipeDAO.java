package com.revature.repositories;


import java.util.Set;
import java.util.stream.Collectors;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.revature.models.Recipe;
import com.revature.util.HibernateUtil;

@Repository
public class RecipeDAO implements IRecipeDAO {

	@Override
	public void save(Recipe r) {
	Session sess = HibernateUtil.getSession();
	Transaction tx = sess.beginTransaction();
	
		sess.save(r);
		tx.commit();
		
	}

	@Override
	public Set<Recipe> findAll() {
		Session sess = HibernateUtil.getSession();
		Transaction tx = sess.beginTransaction();
		
		Set<Recipe> result = sess.createQuery("FROM Recipe r", Recipe.class)
							.getResultStream()
							.collect(Collectors.toSet());
		
		tx.commit();
		return result;
	}

	@Override
	public void update(Recipe r) {
		Session sess = HibernateUtil.getSession();
		Transaction tx = sess.beginTransaction();
		
		sess.merge(r);
		tx.commit();
	}

	@Override
	public void delete(Recipe r) {
		Session sess = HibernateUtil.getSession();
		Transaction tx = sess.beginTransaction();
		
		sess.delete(r);
		tx.commit();
		
	}

	@Override
	public Recipe findbyId() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
