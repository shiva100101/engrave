package com.niit.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.CategoryDAO;
import com.niit.model.Category;

public class CategoryTest 
{
	static CategoryDAO categoryDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext configApplnContext=new AnnotationConfigApplicationContext();
		configApplnContext.scan("com.niit.*");
		configApplnContext.refresh();
		
		//SessionFactory sessionFactory=(SessionFactory)configApplnContext.getBean("DBConfig.class");
		
		categoryDAO=(CategoryDAO)configApplnContext.getBean("categoryDAO");
	}
	
	@Test
	public void addCategoryTest() 
	{
		Category category=new Category();
		category.setCatId(1004);
		category.setCatName("JM");
		category.setCatDesc("Shirt");
		
		assertTrue(categoryDAO.addCategory(category));
	}
	@Ignore
	@Test
	public void updateCategoryTest() 
	{
		Category category=new Category();
		category.setCatId(1004);
		category.setCatName("JM");
		category.setCatDesc("Nice Shirt");
		
		assertTrue(categoryDAO.updateCategory(category));
	}
	
	@Ignore
	@Test
	public void deleteCategoryTest()
	{
		Category category=new Category();
		category.setCatId(1003);
		
		assertTrue(categoryDAO.deleteCategory(category));
	}
	
	@Ignore
	@Test
	public void retrieveCategoryTest()
	{
		List<Category> listCategory=categoryDAO.retrieveCategory();
		assertNotNull("Problem in Retriving",listCategory);
		this.show(listCategory);
	}
	
	public void show(List<Category> listCategory)
	{
		for(Category category:listCategory)
		{
			System.out.println("Category ID:"+category.getCatId());
			System.out.println("Category Name:"+category.getCatName());
		}
	}
	@Ignore
	@Test
	public void getCategoryTest()
	{
		Category category=categoryDAO.getCategory(1002);
		assertNotNull("Problem in getting:",category);
		System.out.println("Category ID:"+category.getCatId());
		System.out.println("Category Name:"+category.getCatName());
	}

}