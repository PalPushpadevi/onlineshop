package ecom.onlineshop_back.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ecom.onlineshop_back.dao.CategoryDAO;
import ecom.onlineshop_back.dto.Category;



@Repository("categoryDAO")
@Transactional
public class CategoryDaoImpl implements CategoryDAO
{

@Autowired(required=true)
private SessionFactory sessionFactory;


	
	
	
@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return null;
	}



@Override
public Category get(int id) 
{
	
	//getting category id
	return  sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
}



@Override

public boolean add(Category category) 
{
	try
	{
		//adding category data into db;
		sessionFactory.getCurrentSession().persist(category);
		
		return true;
	}
	
	catch(Exception ex)
	{
		ex.printStackTrace();
		return false;
	}
	
}



@Override
public boolean update(Category category) 
{
	
	try
	{
		//adding category data into db;
		sessionFactory.getCurrentSession().update(category);
		
		return true;
	}
	
	catch(Exception ex)
	{
		ex.printStackTrace();
		return false;
	}
}



@Override
public boolean delete(Category category) {
	// TODO Auto-generated method stub
	return false;
}







}
