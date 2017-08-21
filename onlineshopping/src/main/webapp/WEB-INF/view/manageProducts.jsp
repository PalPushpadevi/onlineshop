<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
<div class="row">
 <c:if test="${not empty message}">
<div class="col-xs-12">
<div class="alert alert-success alert-dismissible">

<button type="button" class="close" data-dismiss="alert">&times;</button>
${message}
</div>
</div>
</c:if>


<div class="col-md-offset-2 col-md-8">

<div class="panel panel-primary">

<div class="panel-heading">
<h4> Product Management</h4>

</div>

<div class="panel-body">
<!-- Form Element -->
<sf:form class="form-horizontal" modelAttribute="product"
action="${contextRoot}/manage/products" method="POST" enctype="multipart/form-data">

<div class="form-group">

<label class="control-label col-md-4" for="name"> Product Name</label>
<div class="col-md-8">
<sf:input type="text" path="name" id="name" placeholder="productName" 
class="form-control"/>
<sf:errors path="name" cssClass="help-block" element="em" />
</div>
</div>

<div class="form-group">

<label class="control-label col-md-4" for="brandname"> Brand</label>
<div class="col-md-8">
<sf:input type="text" path="brand" id="brandname" placeholder="brandName" 
class="form-control"/>
<sf:errors path="brand" cssClass="help-block" element="em" />

</div>
</div>

<div class="form-group">

<label class="control-label col-md-4" for="description">Description</label>
<div class="col-md-8">
<sf:textarea path="description" id="description" placeholder="write a description" class="form-control"  />
<sf:errors path="description" cssClass="help-block" element="em" />

</div>
</div>

<div class="form-group">

<label class="control-label col-md-4" for="unitPrice">Price</label>
<div class="col-md-8">
<sf:input type="number" path="unitPrice" id="price" placeholder="unitPrice In &#8377" 
class="form-control" />
<sf:errors path="unitPrice" cssClass="help-block" element="em" />

</div>
</div>

<!-- file for image load -->
<div class="form-group">

<label class="control-label col-md-4" for="file">Image</label>
<div class="col-md-8">
<sf:input type="file" path="file" id="file" class="form-control" />
<sf:errors path="file" cssClass="help-block" element="em" />

</div>
</div>


<div class="form-group">

<label class="control-label col-md-4" for="category">Category</label>
<div class="col-md-8">
<sf:select class="form-control" path="categoryId" id="categoryId"
items="${categories}"
itemLabel="name"
itemValue="id"/> 
<c:if test="${product.id == 0}">
<br/>
<div class="text-right">
<button type="button"  data-toggle="modal" data-target="#myCategoryModal"class="btn btn-warning btn-xs">Add Category</button>
 </div>
</c:if>


</div>
</div>

<div class="form-group">
<div class="col-md-offset-2 col-md-8">
<input type="submit" id="submit" name="submit"  class="btn btn-primary"/>


<!-- hidden field for Product -->
<sf:hidden path="id"/>
<sf:hidden path="code"/>
<sf:hidden path="purchases"/>
<sf:hidden path="supplierId"/>
<sf:hidden path="proView"/>

</div>
</div>


</sf:form>
</div>

</div>
</div>

</div>

<div class="row">

<div class="cols-xs-12">
<h3>Available Products </h3>
<hr/>

</div>

<div class="cols-xs-12">
	<div style="overflow:auto">
<!-- Product table for Admin -->
	<table id="adminProductTable" class="table table-striped table-bordered">
		<thead>
		<tr>
			<th>Id</th>
			<th>&#160;</th>
			<th>Name</th>
			<th>Brand</th>
			<th>UnitPrice</th>
			<th>Active</th>
			<th>Edit</th>

		</tr>
		</thead>
		
		
		<!--  <tbody>
		<tr>
		<td>4</td>
		<td>
		<img class="adminDataTableimg" src="${contextRoot}/resources/images/p005.jpg" alt="Suits" />		
		</td>
		<td>Suits</td>
	    <td>&#8377; 1500.00</td>
		<td>
		=============== toggle switch======================== 
		<label class="switch">
		<input type="checkbox" checked="checked"  value="4" />
	    <div class="slider"> </div>
		</label> 
		</td>
		
		<td>
		<a href="${contextRoot}/manage/4/product" class="btn btn-warning">
		<span class="glyphicon glyphicon-pencil"></span>
		</a>
		</td>
		</tr>
		
		
		<tr>
		<td>4</td>
		<td>
		<img class="adminDataTableimg" src="${contextRoot}/resources/images/p005.jpg" alt="Suits" />		
		</td>
		<td>Suits</td>
	    <td>&#8377; 1500.00</td>
		<td>
		=======================================
		<label class="switch">
		<input type="checkbox"   value="4"/>
		<div class="slider"></div>
		</label> 
		</td>
		<td>
		<a href="${contextRoot}/manage/4/product" class="btn btn-warning">
		<span class="glyphicon glyphicon-pencil"></span>
		</a>
		
		</td>
		</tr>
		
		
		
		</tbody> -->
		
		<tfoot>
		<tr>
			<th>Id</th>
			<th>&#160;</th>
			<th>Name</th>
			<th>brand</th>
			<th>UnitPrice</th>
			<th>Active</th>
			<th>Edit</th>
			
		</tr>
		</tfoot>

</table>



</div>




</div>


</div>

<div class="modal fade" id="myCategoryModal" role="dialog" tabindex="-1">
<div class="modal-dialog" role="document">

<div class="modal-content">
<!-- modal header -->
<div class="modal-header">
<button type="button" class="close" data-dismiss="modal">

<span>&times;</span>
</button>
<h4 class="modal-title"> Add New Category</h4>
</div>


<div class="modal-body">
<!-- modal body -->
<sf:form modelAttribute="category" action="${contextRoot}/manage/category" method="POST" id="categoryForm">

<div class="form-group">
<label for="category_name" class="control-label col-md-4">Category Name</label>
<div class="col-md-8">

<sf:input type="text" path="name"  id="category_name" class="form-control"/>
</div>
</div>

<div class="form-group">
<label for="category_description" class="control-label col-md-4">Category description</label>
<div class="col-md-8">

<sf:textarea rows="5" path="description" id="category_description" class="form-control"/>
</div>

</div>
<div class="form-group">

<div class="col-md-offset-4 col-md-8">
<input type="submit" value="Add category" class="btn btn-primary"/>
</div>

</div>

</sf:form>

</div>
</div>

</div>




</div>

</div>






