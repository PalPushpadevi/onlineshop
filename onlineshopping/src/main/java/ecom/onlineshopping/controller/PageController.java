package ecom.onlineshopping.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ecom.onlineshop_back.dao.CategoryDAO;
import ecom.onlineshop_back.dao.ProductDAO;
import ecom.onlineshop_back.dao.UserDAO;
import ecom.onlineshop_back.dto.Category;
import ecom.onlineshop_back.dto.Product;
import ecom.onlineshop_back.dto.User;
import ecom.onlineshopping.exception.ProductNotFoundException;

@Controller
public class PageController 
{
	@Autowired
	private CategoryDAO  categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private UserDAO userDAO;
	
	
	
	
@RequestMapping(value = {"/","home" , "index"} )
public ModelAndView index()
{
	ModelAndView mv=new ModelAndView("page");
	mv.addObject("title" , "home");
	/* passing the list of categories*/
	mv.addObject("categories",categoryDAO.list());
	
	mv.addObject("userClickHome" , true);
	
	return mv;
}


@RequestMapping(value ="About")
public ModelAndView about()
{
	ModelAndView mv=new ModelAndView("page");
	mv.addObject("title" , "about");
	mv.addObject("userClickAbout" , true);
	return mv;
}

@RequestMapping(value ="login")
public ModelAndView login(@RequestParam(name="error" , required=false) String error)
{
	ModelAndView mv=new ModelAndView("page");

	if(error!=null)
	{
		mv.addObject("message","invalid username and password");
	}
	mv.addObject("title" , "Login");
	mv.addObject("userClicklogin" , true);
	return mv;
}


@RequestMapping(value ="Registration")
public ModelAndView Registration()
{
	ModelAndView mv=new ModelAndView("page");
	mv.addObject("title" , "Registration");
	mv.addObject("userClickRegistration" , true);
	return mv;
}
//userdetail

@RequestMapping(value="/saveregister",method=RequestMethod.POST)
public ModelAndView saveRegister(@ModelAttribute("user") User user, BindingResult res )
{
	ModelAndView mv=new ModelAndView("page");
	
	if(res.hasErrors())
	{
		mv.setViewName("Registration");
		return mv;
	}
	else
	{
		userDAO.addUser(user);
		mv.setViewName("redirect:/login");
		return mv;
		
	}
	
}





@RequestMapping(value ="contact")
public ModelAndView contact()
{
	ModelAndView mv=new ModelAndView("page");
	mv.addObject("title" , "contact");
	mv.addObject("userClickcontact" , true);
	return mv;
}

/*methods to load all the products based on categories
 * 
 * 
 */

@RequestMapping(value ="/show/all/products")
public ModelAndView showAllProducts()
{
	ModelAndView mv=new ModelAndView("page");
	mv.addObject("title" , "All Products");
	/* passing the list of categories*/
	mv.addObject("categories",categoryDAO.list());
	
	mv.addObject("userClickAllProducts" , true);
	
	return mv;
}

@RequestMapping(value ="/show/category/{id}/products")
public ModelAndView showCategoryProducts(@PathVariable("id") int id)
{
	ModelAndView mv=new ModelAndView("page");
	
	//CategoryDAO to fetch single category
	Category category=null;
	category=categoryDAO.get(id);
	mv.addObject("title" , category.getName());
	/* passing the list of categories*/
	mv.addObject("categories",categoryDAO.list());
	// passing the single category object
	mv.addObject("category",category);
	mv.addObject("userClickCategoryProducts" , true);
	
	return mv;
}

/*  viewing a single product*/
@RequestMapping(value="/show/{id}/product")
public ModelAndView showSingleProduct(@PathVariable int id) throws ProductNotFoundException
{
	ModelAndView mv=new ModelAndView("page");
	Product product= productDAO.get(id);
	if(product==null) throw new ProductNotFoundException();
	
	//update the view count
product.setProView(product.getProView() + 1);
	productDAO.update(product);
	
	
	mv.addObject("title",product.getName());
	mv.addObject("product",product);
	mv.addObject("userClickShowProduct",true);
	
	
	return mv;
}

@RequestMapping(value ="access-denied")
public ModelAndView accessDenied()
{
	ModelAndView mv=new ModelAndView("error");
	mv.addObject("title" , "403 Acess-denied");
	mv.addObject("errorTitle" , "Sory");
	mv.addObject("errorDescription" , "Your not authorized to view this page");

	return mv;
}

@RequestMapping(value="/perform-logout")
public String logout(HttpServletRequest request,HttpServletResponse response)
{
	
	Authentication auth=SecurityContextHolder.getContext().getAuthentication();
	if(auth!=null)
	{
		new SecurityContextLogoutHandler().logout(request, response, auth);
	}
	return "redirect:/login?logout";
}
 
}

