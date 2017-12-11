package com.niit.controllers;

import java.security.Principal;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.dao.CartDAO;
import com.niit.dao.CategoryDAO;
import com.niit.dao.OrderDAO;
import com.niit.dao.ProductDAO;
import com.niit.dao.SupplierDAO;
import com.niit.dao.UserDAO;
import com.niit.model.Cart;
import com.niit.model.Category;
import com.niit.model.Orders;
import com.niit.model.Product;
import com.niit.model.User;

@Controller
@Scope("session")
public class CartController 
{
	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	UserDAO userDAO;

	@Autowired
	ProductDAO productDAO;

	@Autowired
	CategoryDAO categoryDAO;

	@Autowired
	SupplierDAO supplierDAO;

	@Autowired
	OrderDAO orderDAO;

	@Autowired
	CartDAO cartDAO;

	@RequestMapping(value="/MyCart", method=RequestMethod.GET)
	public String myCart(HttpServletRequest request, Model m)
	{
		Principal principal=request.getUserPrincipal();
		String email=principal.getName();
		//User user=userDAO.getUser(email);
		List<Cart> userCartList = cartDAO.retrieveCart(email);
		//m.addAttribute(user);
		m.addAttribute("userCartList", userCartList);
		return "Cart";
	}
	@RequestMapping(value ="/addToCart", method = RequestMethod.POST)
	public String addto(@RequestParam("id") int productId, HttpServletRequest request, Model m) 
	{
		Principal principal=request.getUserPrincipal();
		String userEmail=principal.getName();
		System.out.println(userEmail);
		//int productId=Integer.valueOf(request.getParameter("cartProductId"));
		int Quantity=Integer.valueOf(request.getParameter("quant"));
		Product p=productDAO.getProduct(productId);
		double price=p.getPrice();
		User u=userDAO.getUser(userEmail);
		System.out.println(u.getName());
		List<Cart> cartExist=cartDAO.checkCartExist(userEmail, productId);
		if(cartExist.isEmpty())
		{
			Cart cart=new Cart();
			cart.setCartPrice(price);
			cart.setCartQuantity(Quantity);
			cart.setProduct(p);
			cart.setUser(u);
			cartDAO.add(cart);
			System.out.println("error");
		}
		else
		{
			List<Cart> cartList=cartDAO.getCartById(userEmail, productId);
			for(Cart c:cartList)
			{
				int CartId=c.getCartId();
				Cart cart=new Cart();
				cart.setCartId(CartId);
				cart.setCartPrice(price);
				cart.setCartQuantity(Quantity);
				cart.setProduct(p);
				cart.setUser(u);
				
				cartDAO.updateCart(cart);
				
			}
		}
		List<Cart> userCartList=cartDAO.retrieveCart(userEmail);
		m.addAttribute("userCartList",userCartList);
		return "Cart";
	}
	
	/*@RequestMapping(value ="/addToCart", method = RequestMethod.POST)
	public String addtoCart(HttpServletRequest request, Model m) 
	{
		Principal principal=request.getUserPrincipal();
		String userEmail=principal.getName();
		int productId=Integer.valueOf(request.getParameter("cartProductId"));
		int Quantity=Integer.valueOf(request.getParameter("quant"));
		Product p=productDAO.getProduct(productId);
		double price=p.getPrice();
		User u=userDAO.getUser(userEmail);
		List<Cart> cartExist=cartDAO.checkCartExist(userEmail, productId);
		if(cartExist.isEmpty())
		{
			Cart cart=new Cart();
			cart.setCartPrice(price);
			cart.setCartQuantity(Quantity);
			cart.setProduct(p);
			cart.setUser(u);
			cartDAO.add(cart);
		}
		else
		{
			List<Cart> cartList=cartDAO.getCartById(userEmail, productId);
			for(Cart c:cartList)
			{
				int CartId=c.getCartId();
				Cart cart=new Cart();
				cart.setCartId(CartId);
				cart.setCartPrice(price);
				cart.setCartQuantity(Quantity);
				cart.setProduct(p);
				cart.setUser(u);
				
				cartDAO.updateCart(cart);
				
			}
		}
		List<Cart> userCartList=cartDAO.retrieveCart(userEmail);
		m.addAttribute("userCartList",userCartList);
		return "Cart";
	}
	*/
	@RequestMapping(value="/CheckOut", method=RequestMethod.GET)
	public String checkout(Model m,HttpServletRequest request)
	{
		Principal principal=request.getUserPrincipal();
		String userEmail=principal.getName();
		User user=userDAO.getUser(userEmail);
		List<Cart> userCartList=cartDAO.retrieveCart(userEmail);
		
		m.addAttribute(user);
		m.addAttribute("userCartList",userCartList);
		return "shipping";
	}
	
	/*@RequestMapping(value="/shipping", method=RequestMethod.GET)
	public String shippingDetails(Model m,HttpServletRequest request)
	{
		Principal principal=request.getUserPrincipal();
		String userEmail=principal.getName();
		User user=userDAO.getUser(userEmail);
		List<Cart> userCartList=cartDAO.retrieveCart(userEmail);
		
		m.addAttribute(user);
		m.addAttribute("userCartList",userCartList);
		return "shipping";
	}*/
	
	@RequestMapping(value="/deleteCart/{cartId}",method=RequestMethod.GET)
	public String deleteCart(@PathVariable("cartId")int cartId,HttpServletRequest request,Model m)
	{
		Cart cart = cartDAO.getCart(cartId);
		cartDAO.deleteCart(cart);
		Principal principal=request.getUserPrincipal();
		String userEmail=principal.getName();
		List<Cart> userCartList = cartDAO.retrieveCart(userEmail);
		m.addAttribute("userCartList", userCartList);
		return "Cart";
	}
	
	@RequestMapping(value="/invoice", method=RequestMethod.POST)
	public String invoiceDetails(HttpServletRequest request, HttpSession session, Model m)
	{
		Principal principal=request.getUserPrincipal();
		String userEmail=principal.getName();
		User user=userDAO.getUser(userEmail);
		//String paymentMode = String.valueOf(request.getParameter("payment"));
		//double orderAmount = Double.valueOf(request.getParameter("total"));
		Orders os = new Orders();
		os.setUser(user);
		//os.setOrderAmount(orderAmount);
		//os.setPaymentMode(paymentMode);
		os.setOrderDate(new Date());
		orderDAO.createOrder(os);
		List<Cart> userCartList = cartDAO.retrieveCart(userEmail);
		m.addAttribute(user);
		m.addAttribute("userCartList", userCartList);
		return "invoice";
	}
	
	@RequestMapping(value="/ack")
	public String ack(HttpServletRequest request)
	{
		Principal principal = request.getUserPrincipal();
		String userEmail = principal.getName();
		List<Cart> userCartlist =cartDAO.retrieveCart(userEmail);
		for(Cart c:userCartlist)
		{
			int cartId = c.getCartId();

			Cart cr=cartDAO.getCart(cartId);
			cartDAO.deleteCart(cr);
			

		}
		return "acknowledgement";
	}
	
	/*@RequestMapping(value="/toMyCart", method=RequestMethod.GET)
	public String myOders(HttpServletRequest request,Model m)
	{
		Principal principal=request.getUserPrincipal();
		String userEmail=principal.getName();
		User user=userDAO.getUser(userEmail);
		List<Orders> userOrdersList = orderDAO.retrieveOrders(userEmail);
		m.addAttribute(user);
		m.addAttribute("userOrdersList", userOrdersList);
		return "myorder";
	}*/
}
		