package ecom.onlineshop_back.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ecom.onlineshop_back.dao.ProductDAO;
import ecom.onlineshop_back.dto.Product;
@Repository("productDAO")
@Transactional(rollbackFor=Exception.class)


public class ProductDaoImpl implements ProductDAO
{
	 @Autowired
		private SessionFactory sessionFactory;
	
	 @Override
	public Product get(int productId)
	 {
		try
		{
			return  sessionFactory.getCurrentSession().get(Product.class, Integer.valueOf(productId));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			
		}
		return null;
		
	 }
		
	

	@Override
	public List<Product> list() 
	{

		return sessionFactory.getCurrentSession().createQuery("From Product" ,Product.class).getResultList();
	}

	@Override
	public boolean add(Product product)
	{
		try
		{
			sessionFactory.getCurrentSession().merge(product);
			
			return true;
		}
		
		catch(Exception ex)
		{
			ex.printStackTrace();
			
			return false;
			}
	
	}

	@Override
	public boolean update(Product product) {
		try
		{
			sessionFactory.getCurrentSession().update(product);
			
			return true;
		}
		
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
			
		}
	}

	@Override
	public boolean delete(Product product) {
		product.setActive(false);
		try
		{
			return this.update(product);
			
		
		}
		
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
			
		}
		
	}
	

	@Override
	public List<Product> listActiveProducts()
	{
		
			String selectActiveProducts = "From Product Where active = :active";
			return sessionFactory.getCurrentSession().
					createQuery(selectActiveProducts,Product.class)
					.setParameter("active", true).getResultList();
			}
	

	@Override
	public List<Product> listActiveProductsByCategory(int categoryId)
	{
		
			String selectActiveProductsByCategory = "From Product Where active = :active  and categoryId = :categoryId";
			return sessionFactory.getCurrentSession().
					createQuery(selectActiveProductsByCategory ,Product.class)
					.setParameter("active", true)
					.setParameter("categoryId",categoryId).getResultList();
			}
	

	@Override
	public List<Product> getLatestActiveProducts(int count) 
		{
			
			return sessionFactory.getCurrentSession().
					createQuery("From Product Where active = :active  and categoryId=:categoryId",Product.class)
					.setParameter("active", true).setFirstResult(0).setMaxResults(count)
					.getResultList();
			}
	

}
