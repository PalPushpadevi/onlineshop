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
	
	
	
	//--------------
	
	
	
	//==============================================
	//admin data table
	
	

	var $adminProducttable= $('#adminProductTable');
	
	//
	
	if($adminProducttable.length)
		{
		
		var jsonUrl= window.contextRoot + '/json/data//admin/all/products';
		
		
		//console.log('inside the table');
		
		$adminProducttable.DataTable({
			
			lengthMenu:[[10,30,50,-1], ['30 Records','50 Records','All']],
			pageLength:30,
			ajax:
			{
				url:jsonUrl,
				dataSrc:'',
			
			},
			columns:[
			         {
			        data:'id'	 
			        	 
			         },
			         {
			        data: 'code',
			        mRender: function(data,type,row)
			        {
			        	
			        return '<img src="'+window.contextRoot+'/resources/images/'+data+'.jpg" class="adminDataTableimg"/>';
			       
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
			       data: 'active',
			       bSortable: false,
			       mRender: function(data,type,row)
			       {
			    	   var str = '';
			    	   str +=' <label class="switch">'
			    	   if(data){
			    		   
			    		   str +='<input type="checkbox" checked="checked"  value="'+row.id+'" />'
			    	 }
			    	   else
			    		   {
			    		   str +='<input type="checkbox" value="'+row.id+'" />'
			    		   }
			    	
			   		
			   	    str +='<div class="slider"> </div></label>'
			       return str
			     
			       }
			      
			       } ,
			       
			       {
			    	   data: 'id',
				       bSortable: false,
				       mRender: function(data,type,row)
				       {
				    	  var str='';
				    	 str +=' <a href="${contextRoot}/manage/'+data+'/product" class="btn btn-warning">'
				  		str +='<span class="glyphicon glyphicon-pencil"></span></a>'
				  		
				    	  return str 
				       }
			       }
			      
			    	
			        
			         ],
			         
			         initComplete: function(){
			        	 
			        var api = this.api();
			        api.$('.switch input[type="checkbox"]').on('change',function(){
			    		
			        	var checkbox=$(this);
			        	var checked=checkbox.prop('checked');
			        	var dMsg=(checked)?'you want to activate  the product?':
			        						'you want to deactivate the product?';
			        	
			        	var value=checkbox.prop('value');
			        	
			        	
			        	bootbox.confirm({
			        	size:'medium',
			        	title:'product activate and deactivate',
			        	message:dMsg,
			        	callback:function(confirmed){
			        		
			        		if(confirmed)
			        			{
			        			console.log(value);
			        			
			        			var activationUrl=window.contextRoot + '/manage/product/' + value + '/activation';
			        			$.post(activationUrl,function(data){
			        				
			        				bootbox.alert({
				        				
					        			size:'medium',
					        			title:'Information',
					        			message:data
					        			
					        			})	
			        				
			        				
			        			})
			        			
			        			
			        			
			        			
			        			}
			        		else
			        			{
			        			checkbox.prop('checked',!checked);
			        			
			        			}
			        	}
			        	
			        	
			        	});
			        	
			        	
			        	});
			        	
			        	 
			        	 
			        	 
			         }
		
		
		});
		
		}
	
	
	
	
	
	
	
	
});