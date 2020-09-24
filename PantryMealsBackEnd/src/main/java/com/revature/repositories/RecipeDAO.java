package com.revature.repositories;

import java.util.Set;
import java.util.stream.Collectors;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.revature.models.Recipe;
import com.revature.models.User;
import com.revature.util.HibernateUtil;

@Repository
public class RecipeDAO implements IRecipeDAO {

	@Override
	public boolean save(Recipe r) {
		Session sess = HibernateUtil.getSession();
		Transaction tx = sess.beginTransaction();
//		int id = (Integer) sess.save(r);		
		if (sess.save(r) != null) {
			tx.commit();
			return true;
		}
		return false;
	}

	@Override
	public Set<Recipe> findAll() {
		Session sess = HibernateUtil.getSession();
		Transaction tx = sess.beginTransaction();

		Set<Recipe> result = sess.createQuery("FROM Recipe r", Recipe.class).getResultStream()
				.collect(Collectors.toSet());

		tx.commit();
		return result;
	}

	@Override
	public boolean update(Recipe r) {
		Session sess = HibernateUtil.getSession();
		Transaction tx = sess.beginTransaction();

		if (sess.merge(r) != null) {
			tx.commit();
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(Recipe r) {
		Session sess = HibernateUtil.getSession();
		Transaction tx = sess.beginTransaction();
		Criteria cr = sess.createCriteria(Recipe.class);
		cr.add(Restrictions.eq("id", r.getId()));
		Recipe delete = (Recipe) cr.list().get(0);
		sess.delete(delete);
		tx.commit();
		return true;
	}

	@Override
	public Recipe findbyId(int id) {
		Session sess = HibernateUtil.getSession();
		Transaction tx = sess.beginTransaction();

		Criteria cr = sess.createCriteria(Recipe.class);
		cr.add(Restrictions.eq("id",id));
		if (cr.list().isEmpty()) {
			tx.commit();
			return null;
		}
		Recipe r = (Recipe) cr.list().get(0);
		tx.commit();
		return r;

	}

}
