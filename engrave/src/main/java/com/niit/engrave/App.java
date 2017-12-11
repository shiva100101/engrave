package com.niit.engrave;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.config.DBConfig;

public class App {
	public static void main(String[] args) {
	ApplicationContext configApplnContext=new AnnotationConfigApplicationContext(DBConfig.class);
	System.out.println("Hello");
	}
}
