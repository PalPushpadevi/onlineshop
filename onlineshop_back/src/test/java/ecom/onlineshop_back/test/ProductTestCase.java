package ecom.onlineshop_back.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ecom.onlineshop_back.dao.ProductDAO;
import ecom.onlineshop_back.dto.Product;



public class ProductTestCase 
{
private static AnnotationConfigApplicationContext context;
	
	private  static ProductDAO productDAO;
	
	private Product product;
	
	@BeforeClass
	public static void init()
	{
		context =new AnnotationConfigApplicationContext();
		context.scan("ecom.onlineshop_back");
		context.refresh();
		productDAO=(ProductDAO)context.getBean("productDAO");
	}
	
	@Test
	public void testCRUDProduct()
	{
		//create operation
		product=new Product();
		product.setId(4);
		product.setCode("p005");
		product.setName("Suits");
		product.setBrand("Rumaira");
		product.setDescription("Stylish Patiala Suits");
		product.setUnitPrice(1500);
		product.setSupplierId(3 );
		product.setCategoryId(3);
		product.setActive(true);
		product.setProView(3);
		product.setPurchases(5);
		assertEquals("something will be wrong while inserting a product",true, productDAO.add(product));
		
	
	//update and delete operation
	product=new Product();
	product = productDAO.get(3);
	product.setName("seasonal");
	assertEquals("updated product", true, productDAO.update(product));
	
	assertEquals(" deleted product", true, productDAO.delete(product));
	
	assertEquals("retrive the list", 4, productDAO.list().size());

	
	}
	@Test
	public void testlistActiveProducts()
	{
		assertEquals("retrive the list", 3, productDAO.listActiveProducts().size());	
	}
	
	@Test
	public void testlistActiveProductsByCategory()
	{
		assertEquals("retrive the list", 2, productDAO.listActiveProductsByCategory(1).size());	
		assertEquals("retrive the list", 1, productDAO.listActiveProductsByCategory(3).size());
	}
	
	
	

}
