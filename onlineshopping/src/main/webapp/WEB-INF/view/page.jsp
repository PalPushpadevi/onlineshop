<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="spring"  uri="http://www.springframework.org/tags"%>
    <spring:url var="css" value="/resources/css"/>
     <spring:url var="js" value="/resources/js"/>
     <spring:url var="images" value="/resources/images/"/>
   <c:set var="contextRoot" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<div class="container">
<header class="topbar">

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <meta name="_csrf" content="${_csrf.token}">
    <meta name="_csrf_header" content="${_csrf.headerName}">

    <title>Seasonal Wear-${title} </title>
    <script>
    window.menu = '${title}';
    window.contextRoot ='${contextRoot}';
    </script>
    <!-- Bootstrap Core CSS -->
    <link href="${css}/bootstrap.min.css" rel="stylesheet" >
    <!-- datatable css -->
     <link href="${css}/dataTables.bootstrap.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="${css}/mystyle.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
      
</header>
</div>

<body>
<div class='container'>
<div class='row'>
<div class='col-lg-12'>
<img src="${images}/kids.jpg">
</div>
</div>
</div>
<div class="wrapper">
 <!-- Navigation -->
   <%@include file="./shared/nav.jsp" %>

    <!-- Page Content -->
    <div class="content">
    <c:if test="${userClickHome == true }">
    <%@include file="home.jsp" %>
    </c:if>
    
    <!-- about -->
      <c:if test="${userClickAbout == true }">
    <%@include file="About.jsp" %>
    </c:if>
    <!-- Registration -->
    
      <c:if test="${userClickRegistration == true }">
    <%@include file="Registration.jsp" %>
    </c:if>
    <!-- login -->
      <c:if test="${userClicklogin == true }">
    <%@include file="login.jsp" %>
    </c:if>
    
    <!-- contact -->
    
     <c:if test="${userClickcontact == true }">
    <%@include file="contact.jsp" %>
    </c:if>
    
    <!-- load only when user click  -->
     <c:if test="${userClickAllProducts == true  or userClickCategoryProducts == true}">
    <%@include file="listProducts.jsp" %>
    </c:if>
        
        
        <!-- load only when user click show product  -->
      <c:if test="${userClickShowProduct == true}">
    <%@include file="SingleProduct.jsp" %>
    </c:if>
     <!-- load only when user click manage products  -->
      <c:if test="${userClickManageProducts == true}">
    <%@include file="manageProducts.jsp" %>
    </c:if>
   
   
    </div>
    
    
    <!-- /.container -->

   <!-- footer -->
   
   <%@include file="./shared/footer.jsp" %>
    <!-- /.container -->

    <!-- jQuery -->
    <script src="${js}/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="${js}/bootstrap.min.js"></script>
    
    
    <!-- datatable plugin -->
     <script src="${js}/jquery.dataTables.js"></script>
     
     <!-- datatable -->
     
      <script src="${js}/dataTables.bootstrap.js"></script>
      
      
       <!-- bootbox.js -->
     
      <script src="${js}/bootbox.min.js"></script>
     
    <script src="${js}/myapp.js"></script>
</div>
</body>

</html>


