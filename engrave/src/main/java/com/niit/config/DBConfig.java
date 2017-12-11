package com.niit.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.model.Cart;
import com.niit.model.Category;
import com.niit.model.Product;
import com.niit.model.Supplier;
import com.niit.model.User;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.niit")
public class DBConfig 
{
		//Creating a data source Bean
	@Autowired	
	@Bean(name="datasource")
		public DataSource getH2DataSource()
		{
			System.out.println("DBConfig initiated...");
			DriverManagerDataSource driverMgrDataSource=new DriverManagerDataSource();
			driverMgrDataSource.setDriverClassName("org.h2.Driver");
			driverMgrDataSource.setUrl("jdbc:h2:tcp://localhost/~/engrave");
			driverMgrDataSource.setUsername("sa");
			driverMgrDataSource.setPassword("");
			System.out.println("Connected");
			return driverMgrDataSource;
		}
		
		//Session Factory Bean Created.
	@Autowired
		@Bean(name="sessionFactory")
		public SessionFactory getSessionFactory()
		{
			Properties hibernateProperties=new Properties();
			hibernateProperties.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
			hibernateProperties.put("hibernate.hbm2ddl.auto","update");
			hibernateProperties.put("hibernate.show_sql","true");
			System.out.println("table created");
			
			
			LocalSessionFactoryBuilder localSessionFacBuilder=new LocalSessionFactoryBuilder(getH2DataSource());
			localSessionFacBuilder.addProperties(hibernateProperties);
			localSessionFacBuilder.addAnnotatedClass(Category.class);
			localSessionFacBuilder.addAnnotatedClass(Product.class);
			localSessionFacBuilder.addAnnotatedClass(Supplier.class);
			localSessionFacBuilder.addAnnotatedClass(User.class);
			localSessionFacBuilder.addAnnotatedClass(Cart.class);
			SessionFactory sessionFactory=localSessionFacBuilder.buildSessionFactory();
			System.out.println("Session Factory Object Created");
			return sessionFactory;
		}
		//Transaction Bean Object
	@Autowired
		@Bean
		public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) 
		{
			HibernateTransactionManager hibernateTranMgr=new HibernateTransactionManager(sessionFactory);
			return hibernateTranMgr;
		}
}
