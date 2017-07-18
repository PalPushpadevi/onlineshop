<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="spring"  uri="http://www.springframework.org/tags"%>
    <spring:url var="css" value="/resources/css"/>
      <spring:url var="js" value="/resources/js"/>
        <spring:url var="images" value="/resources/images"/>
   <c:set var="contextRoot" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Seasonal Wear- ${title} </title>

    <!-- Bootstrap Core CSS -->
    <link href="${css}/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="${css}/mysyle.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

 <!-- Navigation -->
   <%@include file="./shared/nav.jsp" %>

    <!-- Page Content -->
    
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
    
    <!-- /.container -->

   <!-- footer -->
   
   <%@include file="./shared/footer.jsp" %>
    <!-- /.container -->

    <!-- jQuery -->
    <script src="${js}/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="${js}/bootstrap.min.js"></script>

</body>

</html>

