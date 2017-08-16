package ecom.onlineshop_back.daoimpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ecom.onlineshop_back.dao.user_detailDAO;
import ecom.onlineshop_back.dto.user_detail;
@Repository("user_detailDAO")
@Transactional

public class user_detailDaoImpl implements user_detailDAO 
{

	
	 @Autowired
		private SessionFactory sessionFactory;
	 
	

	@Override
	public boolean addUser(user_detail user) {
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

	}
	 
	 
	

	

	

	

