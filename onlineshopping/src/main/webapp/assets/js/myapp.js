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
	case 'All Products':
		$('#listProducts').addClass('active');
		break;
	case 'Manage Products':
		$('#manageProducts').addClass('active');
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
		
		var jsonUrl= '';
		if(window.categoryId == '')
		{
			jsonUrl = window.contextRoot + '/json/data/all/products';
		}
		else
			{
			jsonUrl = window.contextRoot + '/json/data/category/'+window.categoryId+'/products';
			}
		
		//console.log('inside the table');
		
		$table.DataTable({
			
			lengthMenu:[[3,5,-1], ['3 Records','5 Records','All']],
			pageLength:3,
			ajax:
			{
				url:jsonUrl,
				dataSrc:'',
			
			},
			columns:[
			         {
			        data: 'code',
			        mRender: function(data,type,row)
			        {
			        	
			        return '<img src="'+window.contextRoot+'/resources/images/'+data+'.jpg" class="dataTableImg"/>';
			       
			        }
			        	 
			         },
			       {
			    	 data: 'name'
			        } ,
			      
			    	 {
			    	data:'brand'
			    	} ,
			    	
			       {
			    		data:'unitPrice',
			    		mRender: function(data,type,row)
			    		{
			    			return '&#8377;'  + data
			    		}
			    			
			       },
			       {
			       data: 'id',
			       bSortable: false,
			       mRender: function(data,type,row)
			       {
			    	   var str = '';
			    	   str += '<a href="'+window.contextRoot+'/show/'+data+'/product" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></a> &#160;';
			    	   str += '<a href="'+window.contextRoot+'/cart/add/'+data+'/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
			       return str
			     
			       }
			      
			       } 
			    	
			        
			         ]
		
		
		});
		
		}
	
	//dissmissing the alert within a sec
	
	var $alert = $('.alert');
	if($alert.length)
		{
		setTimeout(function()
				{
			
			$alert.fadeOut('slow');
				}, 3000)
		}
	
	
	
	
	
	
});