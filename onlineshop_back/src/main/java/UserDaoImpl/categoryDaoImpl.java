package UserDaoImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import UserDao.categoryDAO;
import UserModel.category;

@Repository("categoryDAO")
public class categoryDaoImpl implements categoryDAO
{
public static List<category> categories = new ArrayList<>();

	static 
	{
		category cat=new category();
		cat.setId(1);
		cat.setName("trendy");
		cat.setDescription("have a some trendy look");
		cat.setImageurl("imageurl");
		cat.setActive(true);
		categories.add(cat);
		
				/* adding second category*/
		
		cat.setId(2);
		cat.setName("traditional");
		cat.setDescription("have a some traditional look");
		cat.setImageurl("imageurl");
		cat.setActive(true);
		categories.add(cat);
		
	

	}
	
	
	
@Override
	public List<category> list() {
		// TODO Auto-generated method stub
		return categories;
	}

}
