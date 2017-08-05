
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

    <title>Seasonal Wear- ${title} </title>
    <script>
    window.menu = '${title}';
    window.contextRoot ='${contextRoot}';
    </script>
    <!-- Bootstrap Core CSS -->
    <link href="${css}/bootstrap.min.css" rel="stylesheet">
    <!-- datatable css -->
     <link href="${css}/dataTables.bootstrap.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="${css}/mystyle.css" rel="stylesheet">

  
      
</header>
</div>

<body>
<div class="wrapper">
 <!-- Navigation -->
  
<div class ="container">
   <div class="navbar-header">
   <a class="navbar-brand" href="${contextRoot}/home">Home</a>
   
   
   </div>
   </div>
   
   <div class="content">
   
   <div class="container">
   
   <div class="row">
   <div class="col-xs-12">
   
   <div class="jumbotron">
   
   <h1>${errorTitle}</h1>
   <hr/>
   
   <blockquote>
   
   ${errorDescription}
   
   
   </blockquote>
   
   
   </div>
   
   </div>
   
   </div>
   
   </div>
   
   </div>
   
   
    </div>
    
    
    <!-- /.container -->

   <!-- footer -->
   
   <%@include file="./shared/footer.jsp" %>
    <!-- /.container -->


</body>

</html>


