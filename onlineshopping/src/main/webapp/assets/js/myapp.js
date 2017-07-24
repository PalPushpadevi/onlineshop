$(function(){
	switch(menu)
	{
	
	case 'about':
		$("#about").addclass("active");
		break;
	
	case 'Login':
		$("#login").addclass("active");
		break;
	case 'Registration':
		$("#reg").addclass("active");
		break;
	case 'contact':
		$("#contact").addclass("active");
		break;
	case 'All Products' :
		$("#listProducts").addclass("active");
		break;
	default:
		$("#home").addclass("active");
		break;
	
		
	
	}
	
});