package ecom.onlineshop_back.dao;


import ecom.onlineshop_back.dto.Cart;
import ecom.onlineshop_back.dto.User;

public interface UserDAO
{
	
	boolean addUser(User user);
	User getByEmail(String email);
	
	boolean updateCart(Cart cart);
}
