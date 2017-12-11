package com.niit.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.SupplierDAO;
import com.niit.model.Category;
import com.niit.model.Supplier;

public class SupplierDAOTest 
{
	static SupplierDAO supplierDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext configApplnContext=new AnnotationConfigApplicationContext();
		configApplnContext.scan("com.niit.*");
		configApplnContext.refresh();
		
		//SessionFactory sessionFactory=(SessionFactory)configApplnContext.getBean("DBConfig.class");
		
		supplierDAO=(SupplierDAO)configApplnContext.getBean("supplierDAO");
	}
	@Ignore
	@Test
	public void addSupplierTest() 
	{
		Supplier supplier=new Supplier();
		supplier.setSupplierId(02);
		supplier.setSupplierName("Ganapathi");
		supplier.setSupplierMailId("Ganapathi@gmail.com");
		
		assertTrue(supplierDAO.addSupplier(supplier));
	}
	
	@Ignore
	@Test
	public void updateSupplierTest()
	{
		Supplier supplier=new Supplier();
		supplier.setSupplierId(01);
		supplier.setSupplierName("Kaveri wood works");
		supplier.setSupplierMailId("Kaveri@gmail.com");
		
		assertTrue(supplierDAO.updateSupplier(supplier));
	}
	@Ignore
	@Test
	public void deleteSupplierTest()
	{
		Supplier supplier=new Supplier();
		supplier.setSupplierId(02);
		
		assertTrue(supplierDAO.deleteSupplier(supplier));
	}
	@Ignore
	@Test
	public void retrieveSupplierTest()
	{
		List<Supplier> listSupplier=supplierDAO.retrieveSupplier();
		assertNotNull("Problem in Retriving",listSupplier);
		this.show(listSupplier);
	}
	public void show(List<Supplier> listSupplier)
	{
		for(Supplier supplier:listSupplier)
		{
			System.out.println("Supplier ID:"+supplier.getSupplierId());
			System.out.println("Supplier Name:"+supplier.getSupplierName());
		}
	}
	@Test
	public void getSupplierTest()
	{
		Supplier supplier=supplierDAO.getSupplier(01);
		assertNotNull("Problem in getting:",supplier);
		System.out.println("Category ID:"+supplier.getSupplierId());
		System.out.println("Category Name:"+supplier.getSupplierName());
	}
}
