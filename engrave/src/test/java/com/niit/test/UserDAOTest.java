/*package com.niit.test;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.UserDAO;
import com.niit.model.User;

public class UserDAOTest 
{
	static UserDAO userDAO;	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
		ac.scan("com.niit.*");
		ac.refresh();		
		//SessionFactory
		//SessionFactory sessionFactory = (SessionFactory)ac.getBean("DBConfig.class");
		userDAO = (UserDAO) ac.getBean("userDAO");
	}
	
	@Test
	public void addUserTest()
	{
		User user = new User();
		user.setEmail("shivashankar.ram@gmail.com");
		user.setName("shiva");
		user.setPhone("8940270582");
		user.setAddress("india");
		user.setPassword("shiva");
		user.setRole("ROLE_ADMIN");
		user.setEnabled(true);
		user.setCountry("india");
		
		
		//assertTrue(userDAO.addUser(user));
	}
	
	@Ignore
	@Test
	public void updateUserTest()
	{
		User user = new User();
		user.setEmail("shivashankar.ram@gmail.com");
		user.setName("Shiva");
		user.setUsername("shiva");
		user.setPassword("123456");
		user.setRole("ROLE_USER");
		user.setAddress("Karumathampatti,Coimbatore,India");
		user.setCountry("India");
		user.setEnabled(true);
		user.setPhone("8940270582");		
		assertTrue(userDAO.addUser(user));
	}
	
	@Ignore
	@Test
	public void deleteCategoryTest()
	{
		User user = new User();
		user.setUserid(2);
		assertTrue(userDAO.deleteUser(user));
	}
	
	@Ignore
	@Test
	public void retrieveUserTest()
	{
		List<User> listUser = userDAO.retrieveUser();
		assertNotNull("Problem in retriving: ",listUser);
		this.showUserTest(listUser);
	}
	
	public void showUserTest(List<User> listUser)
	{
		for(User user:listUser)
		{
			System.out.println("User Id: "+user.getUserid());
			System.out.println("User Name: "+user.getName());
			System.out.println("User Email: "+user.getEmail());
		}
	}
	@Ignore
	@Test
	public void getUserTest()
	{
		User user = userDAO.getUser(23);
		assertNotNull("Problem in getting: "+user);
		System.out.println("User Id: "+user.getUserid());
		System.out.println("User Name: "+user.getName());
		System.out.println("User Email: "+user.getEmail());
	}
}
*/