package ecom.onlineshopping.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import ecom.onlineshop_back.dto.Product;

public class ProductValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return Product.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) 
	{
		Product product=(Product) target;
		
		//checking whether images are loaded or not
		
		if(product.getFile()==null ||
	product.getFile().getOriginalFilename().equals(""))
		{
			errors.rejectValue("file", null, "Please select an images to upload");
			return;
		}
		
		if(!(product.getFile().getContentType().equals("image/jpeg")||
				product.getFile().getContentType().equals("image/png")||
				product.getFile().getContentType().equals("image/gif")))
		{
			errors.rejectValue("file", null, "Please Upload only Image File!");
			
			return;
		}
			
		
	}

}
