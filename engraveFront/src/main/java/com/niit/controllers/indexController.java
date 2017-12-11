package com.niit.controllers;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.CategoryDAO;
import com.niit.dao.ProductDAO;
import com.niit.dao.SupplierDAO;
import com.niit.dao.UserDAO;
import com.niit.model.Product;
import com.niit.model.User;

@Controller
public class indexController {
	@Autowired
	UserDAO userDAO;

	@Autowired
	ProductDAO productDAO;

	@Autowired
	CategoryDAO categoryDAO;

	@Autowired
	SupplierDAO supplierDAO;

	@RequestMapping({"/"})
	public String index(Model m) 
	{
		/*List<Product> latestProductList = productDAO.retrieveProduct();
		m.addAttribute("latestProductList", latestProductList);*/
		return "home";
	}

	@RequestMapping("/register")
	public String goToRegister(Model m) 
	{
		User user = new User();
		m.addAttribute(user);
		return "register";
	}
	
	
	   @RequestMapping(value="/insertUser", method=RequestMethod.POST)
	   public ModelAndView saveUser(@ModelAttribute("user")User user)
	   {
	       ModelAndView mv=new ModelAndView();
		   user.setRole("ROLE_USER");
		   userDAO.insertUser(user);
		   System.out.println("User is registered successfully");
		   mv.setViewName("home");
		   return mv;
	   }

	/*@RequestMapping("/goToLogin")
	public String goToLogin(Model m) {
		User user = new User();
		m.addAttribute(user);
		return "login";
	}*/

	/*@RequestMapping("/userLogged")
	public String userLogged(Model m, HttpSession session) 
	{
		String roleName = null;
		boolean loggedIn = false;
		int userId=0;

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String loggedUsername = auth.getName();
		session.setAttribute("username", loggedUsername);
		Collection<GrantedAuthority> auths = (Collection<GrantedAuthority>) auth.getAuthorities();
		for (GrantedAuthority role : auths) 
		{
			if (role.getAuthority().equals("ROLE_ADMIN")) 
			{
				loggedIn = true;
				roleName = "admin";
			} 
			else 
			{
				loggedIn = true;
				roleName = "user";
			}
		}
		return loggedUsername;
	}
*/		/*List<User> userList = userDAO.findByUsername(loggedUsername);
		for(User u:userList)
		{
			userId = u.getUserid();
		}
		session.setAttribute("userId", userId);
		session.setAttribute("loggedIn", loggedIn);
		session.setAttribute("roleName", roleName);
		
		return "home";

	}*/
	
	/*@RequestMapping("/login")
	public String login(@RequestParam(value="error",required=false) String error,
			@RequestParam(value="logout",required=false) String logout,Model model)
	{
		if(error != null)
		{
			model.addAttribute("error","Username or Password Incorrect");
		}
		
		if(logout != null)
		{
			model.addAttribute("logout","Logged out Sucessful");
		}
		return "Login";
	}*/
	
	@RequestMapping(value="saveregister", method=RequestMethod.POST)
	   public ModelAndView saveUser1(@ModelAttribute("user")User user)
	   {
	       ModelAndView mv=new ModelAndView();
		   user.setRole("ROLE_USER");
		   user.setEnabled("1");
		   userDAO.insertUser(user);
		   System.out.println("User is registered successfully");
		   mv.setViewName("home");
		   return mv;
	   }
	/*@RequestMapping("/userLogged")
	public String userLogged() 
	{
		return "home";
	}
	@RequestMapping("/error")
	public String usererror() 
	{
		return "error";
	}
	@RequestMapping("/gotologin")
	public String usergotologin() 
	{
		return "Login";
	}*/
	
	@RequestMapping("/MyCart")
 	public String myCart(HttpSession session,Model m)
 	{
		return "Cart";
 	}
	
	@RequestMapping("/CheckOut")
	public String checkOut(HttpSession session, Model m)
	{
		
		return "CheckOut";
	}
 	
}	
