package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.User;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO 
{
	@Autowired
	SessionFactory sessionFactory;
	
	public void insertUser(User user)	
	{
		Session session= sessionFactory.openSession();
		session.beginTransaction();
		session.persist(user);
		session.getTransaction().commit();
	}
		
	@Autowired
	public UserDAOImpl(SessionFactory sessionFactory)
	{
		super();
		sessionFactory= sessionFactory;
	}
	
	public void inserUser(User user) {
		// TODO Auto-generated method stub
		
	}

	public List<User> retrieveUser() 
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from User");
		List<User> listUser=query.list();
		session.close();
		return null;
	}

	public List<User> findByUsername(String loggedUsername) 
	{
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from User where email= :email");
		query.setParameter("email", loggedUsername);
		List<User> listUser = query.list();
		session.close();
		return listUser;
	}

	/*public User getUser(int userId) 
	{
		Session session = sessionFactory.openSession();
		User user = (User)session.get(User.class,userId);
		session.close();
		return user;
	}*/

	public User getUser(String useremail) {
		Session session = sessionFactory.openSession();
		return session.get(User.class, useremail);
	}
}
