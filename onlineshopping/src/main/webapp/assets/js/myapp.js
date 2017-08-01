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
	//create a dataset
	var products=[
	             ['1','xyz'],
	             ['2','abc'],
	             ['3','pqr'],
	             ['4','mno'],
	             ['5','rst']
	           
	             ];
	var $table= $('#productListTable');
	
	//
	
	if($table.length)
		{
		//console.log('inside the table');
		
		$table.DataTable({
			
			lengthMenu:[[3,5,-1], ['3 Records','5 Records','All']],
			pageLength:3,
			data:products
		
		
		});
		
		
		
		
		}
	
	
	
	
});