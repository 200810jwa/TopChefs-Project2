package com.revature.repositories;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.revature.models.User;
import com.revature.util.HibernateUtil;

@Repository
public class UserDAO implements IUserDAO {

	@Override
	public void save(User u) {
		Session sess = HibernateUtil.getSession();
		Transaction tx = sess.beginTransaction();
		
		int id =(Integer) sess.save(u);
		
		if(id != 0) {
			tx.commit();
		}
		tx.rollback();
	
		
		
		
	}

	@Override
	public void update(User u) {
		Session sess = HibernateUtil.getSession();
		Transaction tx = sess.beginTransaction();
		
		User user = (User) sess.merge(u);
		
		if(user.equals(u)) {
			tx.commit();
		}
		tx.rollback();
	}
	

}
