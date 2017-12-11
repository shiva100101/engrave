/*package com.niit.test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.CartDAO;
import com.niit.model.Cart;
import com.niit.model.Product;

public class CartDAOTest 
{
	static CartDAO cartDAO;
	@BeforeClass
	public static void initialize() 
	{
		AnnotationConfigApplicationContext configApplnContext=new AnnotationConfigApplicationContext();
		configApplnContext.scan("com.niit.*");
		configApplnContext.refresh();
		configApplnContext.close();
		
		//SessionFactory sessionFactory=(SessionFactory)configApplnContext.getBean("DBConfig.class");
		
		cartDAO=(CartDAO)configApplnContext.getBean("cartDAO");
	}
	
	@Test
	public void addCartTest() 
	{
		Cart cart = new Cart();
		cart.setCartId(1002);
		cart.setCartPrice(499);
		cart.setCartQuantity(5);
		cart.setOrderStatus(0);

		assertTrue("Problem in Insertion", cartDAO.insertCart(cart));
	}
}
*/