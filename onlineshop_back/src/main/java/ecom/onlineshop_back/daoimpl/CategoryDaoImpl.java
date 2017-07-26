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
public class CategoryDaoImpl implements CategoryDAO
{

@Autowired
public SessionFactory SessionFactory;

public static List<Category> categories = new ArrayList<>();

	static 
	{
		Category cat=new Category();
		/* adding first category*/
		
		cat.setId(1);
		cat.setName("trendy");
		cat.setDescription("have a some trendy look");
		cat.setImageurl("imageurl");
		cat.setActive(true);
		categories.add(cat);
		
				/* adding second category*/
		cat=new Category();
		cat.setId(2);
		cat.setName("traditional");
		cat.setDescription("have a some traditional look");
		cat.setImageurl("imageurl");
		cat.setActive(true);
		categories.add(cat);
			

	}
	
	
	
@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}



@Override
public Category get(int id) 
{
	//enhance for loop
	for(Category category : categories)
	{
	if(category.getId() == id)	return category;
	}
	
	return null;
}



@Override
@Transactional
public boolean add(Category category) 
{
	try
	{
		//adding category data into db;
		SessionFactory.getCurrentSession().persist(category);
		
		return true;
	}
	catch(Exception ex)
	{
		ex.printStackTrace();
		return false;
	}
	
}







}
