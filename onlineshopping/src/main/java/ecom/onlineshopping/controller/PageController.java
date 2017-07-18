package ecom.onlineshopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController 
{
@RequestMapping(value = {"/","home" , "index"} )
public ModelAndView index()
{
	ModelAndView mv=new ModelAndView("page");
	mv.addObject("title" , "home");
	mv.addObject("userClickHome" , true);
	return mv;
}


@RequestMapping(value ="About")
public ModelAndView about()
{
	ModelAndView mv=new ModelAndView("page");
	mv.addObject("title" , "about");
	mv.addObject("userClickAbout" , true);
	return mv;
}

@RequestMapping(value ="login")
public ModelAndView login()
{
	ModelAndView mv=new ModelAndView("page");
	mv.addObject("title" , "Login");
	mv.addObject("userClicklogin" , true);
	return mv;
}
@RequestMapping(value ="Registration")
public ModelAndView Registration()
{
	ModelAndView mv=new ModelAndView("page");
	mv.addObject("title" , "Registration");
	mv.addObject("userClickRegistration" , true);
	return mv;
}
}

