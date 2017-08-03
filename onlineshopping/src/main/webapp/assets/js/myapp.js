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
	
	//code for jquery datatable
	
	var $table= $('#productListTable');
	
	//
	
	if($table.length)
		{
		
		var jsonurl=  '';
		if(window.categoryId==  '')
		{
			jsonurl =window.contextRoot + '/json/data/all/products';
		}
		else
			{
			jsonurl=window.contextRoot + '/json/data/category/'+window.categoryId+ '/products';
			}
		
		//console.log('inside the table');
		
		$table.DataTable({
			
			lengthMenu:[[3,5,-1], ['3 Records','5 Records','All']],
			pageLength:3,
			ajax: 
			{
				url:jsonUrl,
				datSrc: ''
			},
			columns:[
			       {data:'name'} ,
			       {data:'brand'}  ,
			       {data:'unitPrice'}  
			        
			         ]
		
		
		});
		
		
		
		
		}
	
	
	
	
});