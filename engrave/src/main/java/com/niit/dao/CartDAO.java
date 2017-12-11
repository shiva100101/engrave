package com.niit.dao;

import java.util.List;

import com.niit.model.Cart;

public interface CartDAO 
{
	public boolean add(Cart cart);
	public boolean deleteCart(Cart cart);
	public Cart getCart(int cartId);
	public boolean updateCart(Cart cart);
	public List<Cart> retrieveCart(String userEmail);
	public List<Cart> checkCartExist(String userEmail,int productId);
	public List<Cart> getCartById(String userEmail,int productId);
}
