package ecom.onlineshopping.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import ecom.onlineshop_back.dao.UserDAO;
import ecom.onlineshop_back.dto.User;
import ecom.onlineshopping.model.UserModel;

@ControllerAdvice
public class GlobalController {

	@Autowired
	private HttpSession session;
	@Autowired
	private UserDAO userDAO;
	
	private UserModel userModel=null;

	@ModelAttribute("userModel")
	public UserModel getUserModel() {

		if (session.getAttribute("userModel") == null) {
			// add user

			Authentication authentication = SecurityContextHolder.getContext()
					.getAuthentication();

			User user = userDAO.getByEmail(authentication.getName());

			if (user!= null) {
				//create new userModel to pass the user detail
				
				userModel=new UserModel();
				userModel.setId(user.getUid());
			    userModel.setEmail(user.getEmail());
			    userModel.setRole(user.getRole());				
			    userModel.setFullName(user.getFname() +" " +user.getLname());
				
				if(userModel.getRole().equals("USER"))
				{
					//set the cart if only user is buyer
					userModel.setCart(user.getCart());
				}
				
				//set the usermodel using session
				session.setAttribute("userModel", userModel);
				return userModel;
			

			}

		}

		return (UserModel) session.getAttribute("userModel");

	}

}
