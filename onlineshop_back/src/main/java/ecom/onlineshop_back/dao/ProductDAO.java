package ecom.onlineshop_back.dao;

import java.util.List;

import ecom.onlineshop_back.dto.Product;

public interface ProductDAO 
{
	
	Product get(int productId);
	List<Product> list();
	boolean add(Product product);
	boolean update(Product product);
	boolean delete(Product product);
	
	//bussiness method
	
	List<Product> listActiveProducts();
	List<Product> listActiveProductsByCategory(int categoryId);
	List<Product> getLatestActiveProducts(int count);
	
	
	
	
	
	

}
