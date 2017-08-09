package ecom.onlineshopping.util;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtility 
{
	private static final String ABS_PATH="C:\\Users\\mruser\\git\\onlineshop\\onlineshopping\\src\\main\\webapp\\assets\\images\\";
	private static String REAL_PATH="";
	
	private static final Logger logger=LoggerFactory.getLogger(FileUploadUtility.class);
	public static void uploadFile(HttpServletRequest request,MultipartFile file, String code) 
	{
		REAL_PATH=request.getSession().getServletContext().getRealPath("assets/images/");
		
		logger.info(REAL_PATH);
	
	
	//chkng directory
	
	if(!new File(ABS_PATH).exists())
	{
		new File(ABS_PATH).mkdirs();
	}

	
	
	if(!new File(REAL_PATH).exists())
	{
		new File(REAL_PATH).mkdirs();
	}
	
	try
	{//server side
		file.transferTo(new File(REAL_PATH + code + ".jpg"));
		//project 
		file.transferTo(new File(ABS_PATH + code + ".jpg"));
	}
	catch(IOException ex)
	{
		
	}
	
	
}
}
