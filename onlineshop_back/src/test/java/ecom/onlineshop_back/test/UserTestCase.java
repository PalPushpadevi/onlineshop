package ecom.onlineshop_back.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ecom.onlineshop_back.dao.UserDAO;
import ecom.onlineshop_back.dto.Cart;
import ecom.onlineshop_back.dto.User;


public class UserTestCase 
{
private static AnnotationConfigApplicationContext context;
	
	private  static UserDAO userDAO;
	
	private User user=null;
	private Cart cart=null;
	
	
	@BeforeClass
	public static void init()
	{
		context =new AnnotationConfigApplicationContext();
		context.scan("ecom.onlineshop_back");
		context.refresh();
		userDAO=(UserDAO)context.getBean("userDAO");
	}
	
	/*@Test
	public void testAdd()
	{
		user=new User();
		user.setFname("Pal");
		user.setLname("Pushpa");
		user.setEmail("pushpa@gmail.com");
		user.setPassword("pushpa");
		user.setRole("Admin");
		user.setAddress("chembur,Mumbai");
		user.setContact("8689858488");
	
		
		
		//add the user
		
		if(user.getRole().equals("user"))
		{
		cart=new Cart();
		cart.setUser(user);
		//attach cart
		user.setCart(cart);
		}
		assertEquals("Failed to add user",true,userDAO.addUser(user));
				
	}*/
	
	
	@Test
	public void testUpdateCart()
	{
		user=userDAO.getByEmail("krutika@gmail.com");
		cart=user.getCart();
		cart.setGrandTotal(556);
		cart.setCartLine(1);
		assertEquals("Failed to update cart",true,userDAO.updateCart(cart));
		
		
	
	}
	

	
	

}
