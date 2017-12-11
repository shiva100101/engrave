package com.niit.dao;

import java.util.List;

import com.niit.model.User;

public interface UserDAO 
{
	public void insertUser(User user);

	public List<User> retrieveUser();

	public List<User> findByUsername(String loggedUsername);

	public User getUser(String useremail);
	
}
