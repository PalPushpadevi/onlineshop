package ecom.onlineshop_back.dao;

import java.util.List;

import ecom.onlineshop_back.dto.Category;

public interface CategoryDAO
{
	List<Category> list();
	Category get(int id);
	boolean add(Category category);
}
