package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO
{
	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	//@Override
	public boolean addCategory(Category category) 
	{
		try 
		{
			sessionFactory.getCurrentSession().save(category);
			return true;
		}
		catch(Exception e)
		{	
			return false;
		}
	}

	//@Override
	public List<Category> retrieveCategory() 
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Category");
		List<Category> listCategory=query.list();
		session.close();
		return listCategory;
	}

	
	//@Override
	@Transactional
	public Category getCategory(int catId) 
	{
		Session session=sessionFactory.openSession();
		Category category=(Category)session.get(Category.class,catId);
		session.close();
		return category;
	}

	//@Override
	@Transactional
	public boolean updateCategory(Category category) 
	{
		try 
		{
			sessionFactory.getCurrentSession().saveOrUpdate(category);
			return true;
		}
		catch(Exception e)
		{	
			System.out.println("Execption Arised:"+e);
			return false;
		}
	}
	
	//@Override
		@Transactional
		public boolean deleteCategory(Category category) 
		{
			try
			{
				sessionFactory.getCurrentSession().delete(category);
				return true;
			}
			catch(Exception e)
			{
				return false;
			}
		}

}
