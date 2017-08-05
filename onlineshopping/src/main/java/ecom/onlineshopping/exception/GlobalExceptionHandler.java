package ecom.onlineshopping.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;


@ControllerAdvice

public class GlobalExceptionHandler 
{
@ExceptionHandler(NoHandlerFoundException.class)
public ModelAndView handlerNoHandlerFoundException()
{
	ModelAndView mv=new ModelAndView("error");
	mv.addObject("errorTitle","The Page is not constructed");
	mv.addObject("errorDescription","The page you are looking is not available");
	mv.addObject("title","404 Error Page");
	return mv;
	
}
	
@ExceptionHandler(ProductNotFoundException.class)
public ModelAndView handlerProductNotFoundException()
{
	ModelAndView mv=new ModelAndView("error");
	mv.addObject("errorTitle","The Product is not available");
	mv.addObject("errorDescription","The Product you are looking is not available now");
	mv.addObject("title","404 Error Page");
	return mv;
	
}
	
@ExceptionHandler(Exception.class)
public ModelAndView handlerException(Exception ex)
{
	ModelAndView mv=new ModelAndView("error");
	mv.addObject("errorTitle","Contact your Administrator");
	mv.addObject("errorDescription",ex.toString());
	mv.addObject("title"," Error");
	return mv;
	
}
	


}

