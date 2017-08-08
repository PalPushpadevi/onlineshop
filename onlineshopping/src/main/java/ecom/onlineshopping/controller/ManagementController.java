package ecom.onlineshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ecom.onlineshop_back.dao.CategoryDAO;
import ecom.onlineshop_back.dao.ProductDAO;
import ecom.onlineshop_back.dto.Category;
import ecom.onlineshop_back.dto.Product;

@Controller
@RequestMapping("/manage")

public class ManagementController 
{
	
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	
	//private static final Logger logger=LoggerFactory.getLogger(ManagementController.class);
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
		}
		return mv;
	}
	
	
	//handling Product Submission
	
	@RequestMapping(value="/products",method=RequestMethod.POST)
	public String handleProductSubmission(@ModelAttribute("product") Product mproduct)
	{
		
		//create new Product
				productDAO.add(mproduct);
		return "redirect:/manage/products?operation=product";
		
		
	}
	
	
	
	
	
	@ModelAttribute("categories")
	public List<Category> getCategories()
	{
		return categoryDAO.list();
	}

}
