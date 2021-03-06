package ecom.onlineshopping.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ecom.onlineshop_back.dao.CategoryDAO;
import ecom.onlineshop_back.dao.ProductDAO;
import ecom.onlineshop_back.dto.Category;
import ecom.onlineshop_back.dto.Product;
import ecom.onlineshopping.util.FileUploadUtility;
import ecom.onlineshopping.validator.ProductValidator;

@Controller
@RequestMapping("/manage")

public class ManagementController 
{
	
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	
	private static final Logger logger=LoggerFactory.getLogger(ManagementController.class);
	@RequestMapping(value="/products",method=RequestMethod.GET)
	public ModelAndView showManageProducts(@RequestParam(name= "operation", required=false)String operation)
	{
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("userClickManageProducts",true);
		mv.addObject("Title","Manage Products");
		Product nProduct=new Product();
		//set few of the fields
		nProduct.setSupplierId(1);
		nProduct.setActive(true);
		mv.addObject("product",nProduct);
		
		if(operation!=null)
		{
			if(operation.equals("product"))
			{
				mv.addObject("message","Product Added Successfully");
			}
			else if(operation.equals("category"))
			{
				mv.addObject("message","Category Added Successfully");	
			}
		}
		return mv;
	}
	
	@RequestMapping(value="/{id}/products",method=RequestMethod.GET)
	
	public ModelAndView showEditProducts(@PathVariable  int id)
	{
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("userClickManageProducts",true);
		mv.addObject("Title","Manage Products");
		//fetch the product from the database
		Product nProduct=productDAO.get(id);
	//set the product fetch from the database
		mv.addObject("product",nProduct);
		
		
		return mv;
	}
	
	
	
	
	
	//handling Product Submission
	
	@RequestMapping(value="/products",method=RequestMethod.POST)
	public String handleProductSubmission(@Valid @ModelAttribute("product") Product mproduct ,BindingResult results,Model model,HttpServletRequest request)
	{
		//handle image validation
		if(mproduct.getId() == 0){
		new ProductValidator().validate(mproduct, results);
		}
		
		else
		{
			if(!mproduct.getFile().getOriginalFilename().equals(""))
			{
				new ProductValidator().validate(mproduct, results);	
			}
		}
		
		//checking if there are any errors
		
		if(results.hasErrors())
		{
			model.addAttribute("userClickManageProducts",true);
			model.addAttribute("title","Manage Products");
			model.addAttribute("message","Validate fail for product submission");
			return "page";
		}
		
		
		
		logger.info(mproduct.toString());
		//create new Product
		
		if(mproduct.getId()==0)
		{
				productDAO.add(mproduct);
				
				
		}
		else
		{
			productDAO.update(mproduct);	
		}
				if(!mproduct.getFile().getOriginalFilename().equals(""))
				{
					FileUploadUtility.uploadFile(request,mproduct.getFile(),mproduct.getCode());
				}
				
				
				
				
		return "redirect:/manage/products?operation=product";
		
		
	}
	@RequestMapping(value="/products/{id}/activation", method=RequestMethod.POST)
	@ResponseBody
	public String handleProductActivation(@PathVariable int id)
	{
		//===============
		
		Product product=productDAO.get(id);
		boolean isActive=product.active();
		product.setActive(!product.active());
		
		productDAO.update(product);
		
		return (isActive)?"you have successfully deactivated the product" + product.getId()
							:"you have successfully activated the product"+product.getId();
	}
	
	//to handle category submission
	@RequestMapping(value="category" , method=RequestMethod.POST)
	public String handleCategorySubmission(@ModelAttribute Category category)
	{
		categoryDAO.add(category);
		return "redirect:/manage/products?operation=category";
	}
	
	
	
	
	@ModelAttribute("categories")
	public List<Category> getCategories()
	{
		return categoryDAO.list();
	}
	
	
	@ModelAttribute("category")
	public Category getCategory()
	{
		return  new Category();
	}

}
