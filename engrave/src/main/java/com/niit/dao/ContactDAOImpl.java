/*package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Contact;

@Repository("contactDAO")
public class ContactDAOImpl implements ContactDAO 
{

	@Autowired
	SessionFactory sessionFactory;
	@Transactional
	public boolean addContact(Contact contact) 
	{
		try
		{
			sessionFactory.getCurrentSession().saveOrUpdate(contact);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Transactional
	public boolean updateContact(Contact contact) 
	{
		try
		{
			sessionFactory.getCurrentSession().saveOrUpdate(contact);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Transactional
	public boolean deleteContact(Contact contact) 
	{
		try
		{
			sessionFactory.getCurrentSession().delete(contact);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public List<Contact> retrieveContact() 
	{
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Contact");
		List<Contact> listContact = query.list();
		session.close();
		return listContact;
	}

	public Contact getContact(int contactId) 
	{
		Session session = sessionFactory.openSession();
		Contact contact = (Contact)session.get(Contact.class,contactId);
		session.close();
		return contact;
	}

}
*/