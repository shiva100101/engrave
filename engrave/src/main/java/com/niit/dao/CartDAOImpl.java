package com.niit.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Cart;

@Repository("cartDAO")
public class CartDAOImpl implements CartDAO
{
	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public boolean add(Cart cart) {
		try
		{
		sessionFactory.getCurrentSession().saveOrUpdate(cart);
		return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception arised"+e);
		return false;
		}
	}

	@Transactional
	public boolean deleteCart(Cart cart) {
		try
		{
		sessionFactory.getCurrentSession().delete(cart);
		return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception arised"+e);
		return false;
		}
	}

	public Cart getCart(int cartId) {
		Session session=sessionFactory.openSession();
		Cart cart=(Cart)session.get(Cart.class,cartId);
		session.close();
		return cart;
	}

	@Transactional
	public boolean updateCart(Cart cart) {
		try
		{
		sessionFactory.getCurrentSession().saveOrUpdate(cart);
		return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception arised"+e);
		return false;
		}
	}

	public List<Cart> retrieveCart(String userEmail) {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Cart where email=:email").setString("email",userEmail);
		List<Cart> listCart=query.list();
		session.close();
		return listCart;
	}

	public List<Cart> checkCartExist(String userEmail, int productId) {
		Session session=sessionFactory.openSession();
		List<Cart> listCart=null;
		try
		{
			session.beginTransaction();
			listCart = (List<Cart>)session.createQuery("from Cart where email=:email and productId=:productId")
					.setString("email", userEmail)
					.setInteger("productId", productId)
					.getResultList();
			session.getTransaction().commit();
		}
		catch(HibernateException e)
		{
			session.getTransaction().rollback();
			
		}
		return listCart;
	}

	public List<Cart> getCartById(String userEmail, int productId) {
		Session session = sessionFactory.openSession();
		List<Cart> listCart = null;
		try
		{
			session.beginTransaction();
			listCart=(List<Cart>)session.createQuery("from Cart where email=:email and productId=:productId")
					.setString("email", userEmail)
					.setInteger("productId", productId)
					.list();
			session.getTransaction().commit();
		}
		catch(HibernateException e)
		{
			session.getTransaction().rollback();
			
		}
		return listCart;
	}
}
	

