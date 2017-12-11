package com.niit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Orders;

@Repository("orderDAO")
public class OrderDAOImpl implements OrderDAO
{

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public boolean createOrder(Orders orders) {
		try
		{
			sessionFactory.getCurrentSession().saveOrUpdate(orders);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public List<Orders> retrieveOrders(String userEmail) {
		
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("from Orders where email=:email").setString("email",userEmail);
			List<Orders> listOrders=query.list();
			session.close();
			return listOrders;
		}
	
}
	
