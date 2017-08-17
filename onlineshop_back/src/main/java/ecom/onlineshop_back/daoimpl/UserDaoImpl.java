package ecom.onlineshop_back.daoimpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ecom.onlineshop_back.dao.UserDAO;
import ecom.onlineshop_back.dto.Cart;
import ecom.onlineshop_back.dto.User;
@Repository("userDAO")
@Transactional

public class UserDaoImpl implements UserDAO 
{
@Autowired 
private SessionFactory sessionFactory;
	
	
	@Override
	public boolean addUser(User user) 
	{
		try
		{
			sessionFactory.getCurrentSession().persist(user);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean updateCart(Cart cart)
	{
		try
		{
			sessionFactory.getCurrentSession().update(cart);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public User getByEmail(String email) 
	{
		String selectQuery="From User where email= :email";
		try
		{
			return sessionFactory.getCurrentSession().createQuery(selectQuery,User.class)
					.setParameter("email", email)
					.getSingleResult();
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
	}

	
}
	
	 
	 
	

	

	

	

