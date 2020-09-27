package com.revature.repositories;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.lang.UsesSunHttpServer;
import org.springframework.stereotype.Repository;

import com.revature.models.User;
import com.revature.util.HibernateUtil;

@Repository
public class UserDAO implements IUserDAO {

	@Override
	public boolean save(User u) {
		Session sess = HibernateUtil.getSession();
		Transaction tx = sess.beginTransaction();
		int id = (Integer) sess.save(u);
		if (id != 0) {
			tx.commit();
			return true;
		}
		tx.rollback();
		return true;

	}

	@Override
	public boolean update(User u) {
		Session sess = HibernateUtil.getSession();
		Transaction tx = sess.beginTransaction();
		sess.saveOrUpdate(u);
		tx.commit();
		return true;
	}

	@Override
	public boolean delete(User u) {
		Session sess = HibernateUtil.getSession();
		Transaction tx = sess.beginTransaction();
		
		Criteria cr = sess.createCriteria(User.class);
		cr.add(Restrictions.eq("id", u.getId()));
		User user = (User) cr.list().get(0);
		sess.delete(user);
		if (sess.contains(u) == false) {
			tx.commit();
			
			return true;
		} else {
			tx.rollback();
			
			return false;
		}
	}

	@Override
	public User findById(int id) {
		Session sess = HibernateUtil.getSession();

		Criteria cr = sess.createCriteria(User.class);
		cr.add(Restrictions.eq("id", id));
		if (cr.list().isEmpty()) {
			
			return null;
		}
		User u = (User) cr.list().get(0);
		
		return u;
	}

	@Override
	public User findByUsername(String username) {
		Session sess = HibernateUtil.getSession();

		Criteria cr = sess.createCriteria(User.class);
		cr.add(Restrictions.eq("username", username));
		if (cr.list().isEmpty()) {
			return null;
		}
		User u = (User) cr.list().get(0);
		return u;
	}

	@Override
	public Set<User> findAll() {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();

		Set<User> result = s.createQuery("FROM User u", User.class).getResultStream().collect(Collectors.toSet());

		tx.commit();

		return result;
	}

}
