<div class="container">

<!-- breadcrumb -->
<div class="row">

<div class="col-xs-12">

<ol class="breadcrumb">

<li><a href="${contextRoot}/home">Home</a> </li>
<li><a href="${contextRoot}/show/all/products">product</a> </li>
<li class="active">${product.name} </li>

</ol>

</div>

</div>

<div class="row">

<!-- product image -->
<div class="col-sm-4">

<div class="thumbnail">

<img src="${images}/${product.code}.jpg" class="img img-responsive"/>

</div>
</div>

<!-- product description -->
<div class="col-sm-8">

<h3>${product.name}</h3>
<hr/>
<p>${product.description}</p>
<hr/>

<h4>Price:<strong> &#8377;${product.unitPrice} /.</strong></h4>
<hr/>


<a href="${contextRoot}/cart/add/${product.id}/product" class="btn btn-success">
<span class="glyphicon glyphicon-shopping-cart"></span>Add tO cart</a>
<a href="${contextRoot}/show/all/products" class="btn btn-primary">Back</a>


</div>





</div>



















</div>