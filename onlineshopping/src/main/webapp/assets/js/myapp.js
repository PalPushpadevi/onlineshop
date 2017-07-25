$(function(){
	switch(menu)
	{
	
	case 'about':
		$('#about').addClass('active');
		break;
	
	case 'Login':
		$('#login').addClass('active');
		break;
	case 'Registration':
		$('#reg').addClass('active');
		break;
	case 'contact':
		$('#contact').addClass('active');
		break;
	case 'All Products' :
		$('#listProducts').addClass('active');
		break;
	default:
		$('#listProducts').addClass('active');
		$('#a_'+menu).addClass('active');
		break;
	
		
	
	}
	
});