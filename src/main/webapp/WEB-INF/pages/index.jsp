<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/starter-template.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/jquery-2.1.4.min.js"></script>
</head>
<body>
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
					<span class="icon-bar"></span>
	        		<span class="icon-bar"></span>
	       			 <span class="icon-bar"></span>
				</button>
				<a class="brand" href="https:www.udemy.com/u/tunatore/"><b>Udemy</b></a>
				<dir class="nav-collapse collapse">
					<ul>
						<li class="active"><a href="${pageContext.request.contextPath}">Home</a></li>
						<li class="active"><a href="${pageContext.request.contextPath}/promo.html">Promo</a></li>
					</ul>
				</dir>
			</div>
		</div>
	</div>
	
	<div class="container">
		<h1>Java Spring MVC</h1>
		<p>The sample application provided by Spring MVC JavaConfig</p>
		<a href="${pageContext.request.contextPath}/displayUsersMySQL">Display users with MySQL</a>
	</div>
	
	<footer>
		<div class="container">
			<p class="text-muted"><b>Tuna Tore 2016 Please feel free to ask me question by email</b></p>
			<a href="<%=request.getContextPath() %>?language=en">EN</a>
			<a href="<%=request.getContextPath() %>?language=vi">VI</a>
		</div>
	</footer>
</body>
</html>