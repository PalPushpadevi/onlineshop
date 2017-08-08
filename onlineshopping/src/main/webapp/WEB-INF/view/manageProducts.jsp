<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<div class="container">
<div class="row">
<c:if text="${notemptymessage}">
<div class="col-xs-12">
<div class="alert alert-success alert-dismissible">

<button type="button" class="close" data-dismiss="alert">&times;</button>

${message}

</div>



</div>












</c:if>

</div>

</div>
<div class="col-md-offset-2 col-md-8">

<div class="panel panel-primary">

<div class="panel-heading">
<h4> Product Management</h4>

</div>

<div class="panel-body">
<!-- Form Element -->
<sf:form class="form-horizontal" modelAttribute="product"
action="${contextRoot}/manage/products" method="POST">

<div class="form-group">

<label class="control-label col-md-4" for="name"> Product Name</label>
<div class="col-md-8">
<sf:input type="text" path="name" id="name" placeholder="productName" 
class="form-controller"/>
<em class="helpblock">Please Enter Product</em>
</div>
</div>

<div class="form-group">

<label class="control-label col-md-4" for="brandname"> Brand</label>
<div class="col-md-8">
<sf:input type="text" path="brand" id="brandname" placeholder="brandName" 
class="form-controller"/>
<em class="helpblock">Please Enter Brand</em>
</div>
</div>

<div class="form-group">

<label class="control-label col-md-4" for="description">Description</label>
<div class="col-md-8">
<sf:textarea path="description" id="description" placeholder="write a description"  />
<em class="helpblock">Please Enter Description of the Product</em>
</div>
</div>

<div class="form-group">

<label class="control-label col-md-4" for="unitPrice">Price</label>
<div class="col-md-8">
<sf:input type="number" path="unitPrice" id="price" placeholder="unitPrice In &#8377" 
class="form-controller" />
<em class="helpblock">Enter the Unit_Price</em>
</div>
</div>

<div class="form-group">

<label class="control-label col-md-4" for="category">Category</label>
<div class="col-md-8">
<sf:select class="form-controller" path="categoryId" id="categoryId"
items="${categories}"
itemLabel="name"
itemValue="id"/> 

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

</div>