package ecom.onlineshop_back.dao;

import java.util.List;

import ecom.onlineshop_back.dto.Category;

public interface CategoryDAO
{	
	Category get(int id);
	List<Category> list();
	
	boolean add(Category category);
	boolean update(Category category);
	boolean delete(Category category);
}
