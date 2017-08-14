 
<div class="content">

<div class="container">
<c:if test="${not empty message}">


  <div class="row">
    	<div class="col-md-4 col-md-offset-4">
<div class="alert alert-danger">
${message}

</div>

</div>
</div>
</c:if>

    <div class="row">
    	<div class="col-md-4 col-md-offset-4">
    		<div class="panel panel-default">
			  	<div class="panel-heading">
			    	<h3 class="panel-title">Login via site</h3>
			 	</div>
			  	<div class="panel-body">
			    	<form action="${contextRoot}/login" method="POSt" class="form-horizontal" id="loginform">
                 
                    <div class="form-group">
                    <label for="username" class="control-label col-md-4">Email</label>
				<div class="col-md-8">

					<input class="form-control"  placeholder="yourmail@example.com" name="username" id="username" type="text">
				</div>
					</div>	
			    	 <div class="form-group">
                    <label for="password" class="control-label col-md-4">Password</label>
			    			<div class="col-md-8">
			    			<input class="form-control"  placeholder="Password" name="password" type="password" id="password">
			    			
			    		</div>
			    		</div>
			    		<div class="checkbox">
			    	    	<label>
			    	    		<input name="remember" type="checkbox" value="Remember Me"> Remember Me
			    	    	</label>
			    	    </div>
			    		<input class="btn btn-lg btn-success btn-block" type="submit" value="Login"/>
			    		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		
			      	</form>
                     
			    </div>
			</div>
		</div>
	</div>
</div>
</div>