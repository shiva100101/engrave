package com.niit.dao;

import java.util.List;

import com.niit.model.Orders;

public interface OrderDAO 
{
	public boolean createOrder(Orders orders);
	public List<Orders> retrieveOrders(String userEmail);
}
