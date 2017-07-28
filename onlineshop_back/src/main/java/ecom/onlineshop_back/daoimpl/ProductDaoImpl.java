package ecom.onlineshop_back.daoimpl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ecom.onlineshop_back.dao.ProductDAO;
import ecom.onlineshop_back.dto.Product;
@Repository("productDAO")
@Transactional 

public class ProductDaoImpl implements ProductDAO {

	@Override
	public Product get(int productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Product> listActiveProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> listActiveProductsByCategory(int categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getLatestActiveProducts(int count) {
		// TODO Auto-generated method stub
		return null;
	}

}
