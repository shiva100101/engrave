package com.niit.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.ProductDAO;
import com.niit.model.Category;
import com.niit.model.Product;

public class ProductDAOTest {
	static ProductDAO productDAO;

	@BeforeClass
	public static void initialize() {
		AnnotationConfigApplicationContext configApplnContext = new AnnotationConfigApplicationContext();
		configApplnContext.scan("com.niit.*");
		configApplnContext.refresh();

		// SessionFactory
		// sessionFactory=(SessionFactory)configApplnContext.getBean("DBConfig.class");

		productDAO = (ProductDAO) configApplnContext.getBean("productDAO");
	}

	@Ignore
	@Test
	public void addProductTest() {
		Product product = new Product();
		product.setProductId(1002);
		product.setProductName("Lenovo");
		product.setProductDesc("Mobile with NFC");
		product.setStock(10);
		product.setPrice(8000);
		product.setCatId(1002);
		product.setSupplierId(1002);

		assertTrue("Problem in Insertion", productDAO.addProduct(product));
	}

	@Ignore
	@Test
	public void updateProductTest() {
		Product product = new Product();
		product.setProductId(1002);
		product.setProductName("Lenovo");
		product.setProductDesc("Mobile with NFC and 4g");
		product.setStock(10);
		product.setSupplierId(1002);

		assertTrue(productDAO.updateProduct(product));
	}

	@Ignore
	@Test
	public void deleteProductTest() {
		Product product = new Product();
		product.setProductId(1002);

		assertTrue(productDAO.deleteProduct(product));

	}

	@Ignore
	@Test
	public void retrieveProductTest() {
		List<Product> listProduct = productDAO.retrieveProduct();
		assertNotNull("Problem in Retriving", listProduct);
		this.show(listProduct);
	}

	public void show(List<Product> listProduct) {
		for (Product product : listProduct) {
			System.out.println("Product ID:" + product.getProductId());
			System.out.println("Product Name:" + product.getProductName());
			System.out.println("Product Desc:"+product.getProductDesc());
		}

	}
	
	@Ignore
	@Test
	public void getProductTest()
	{
		Product product=productDAO.getProduct(1002);
		assertNotNull("Problem getting in Product:",product);
		System.out.println("Product ID:"+product.getProductId());
		System.out.println("Product Name:"+product.getProductName());
	}
}
