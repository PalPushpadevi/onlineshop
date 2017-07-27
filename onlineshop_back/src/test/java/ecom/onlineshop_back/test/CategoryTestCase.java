package ecom.onlineshop_back.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ecom.onlineshop_back.dao.CategoryDAO;
import ecom.onlineshop_back.dto.Category;

public class CategoryTestCase
{
	private static AnnotationConfigApplicationContext context;
	
	private  static CategoryDAO categoryDAO;
	
	private Category category;
	
	@BeforeClass
	public static void init()
	{
		context =new AnnotationConfigApplicationContext();
		context.scan("ecom.onlineshop_back");
		context.refresh();
		categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
	}
	
	/*@Test
	public void testAddCategory()
	{
		category=new Category();
		category.setName("trendy");
		category.setDescription("have a some trendy look");
		category.setImageurl("imageurl");
		assertEquals("sucessfully added category", true, categoryDAO.add(category));
	}*/
/*
@Test
public void testGetCategory()
{
	category=categoryDAO.get(1);
	assertEquals("sucessfully added category", "trendy", category.getName());
	
	
}*/
	
	
	@Test
	public void testupdateCategory()
	{
		category=categoryDAO.get(1);
	category.setName("Trendy");
		
		assertEquals("sucessfully updated category", true, categoryDAO.update(category));
		
		
	}
	
}
