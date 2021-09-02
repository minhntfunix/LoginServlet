<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.*, java.util.*"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="stylesheet"
	href="	https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	type=text/css>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="CSS/Header.css" type=text/css>
<title>Insert title here</title>
</head>
<body>

	<header class="section-header">
		<section class="header-main border-bottom">
			<div class="container-fluid">
				<div class="row align-items-center">
					<div class="col-lg-3 col-sm-4 col-md-4 col-5">
						<a href="index.jsp" class="brand-wrap" data-abc="true"><span
							class="logo">Mobile World</span> </a>

					</div>
					<div class="col-lg-4 col-xl-5 col-sm-8 col-md-4 d-none d-md-block">
						<form action="SearchController2" class="search-wrap" >
							<div class="input-group w-100">
								
								<input type="text" name="s" class="form-control search-form"
									style="width: 55%;" placeholder="Search">
									
								<div class="input-group-append">
									<input class="btn btn-primary search-button" type="submit" value="Search">
									
										<i class="fa fa-search"></i>
									
								</div>
							</div>
						</form>
					</div>






				</div>
			</div>
			
		</section>
		<nav class="navbar navbar-expand-md navbar-main border-bottom">
			<div class="container-fluid">
				<form class="d-md-none my-2">
					<div class="input-group">
						<input type="search" name="search" class="form-control"
							placeholder="Search" required="">
						<div class="input-group-append">
							<button type="submit" class="btn btn-secondary">
								<i class="fa fa-search"></i>
							</button>
						</div>
					</div>
				</form>
				<button class="navbar-toggler collapsed" type="button"
					data-toggle="collapse" data-target="#dropdown6"
					aria-expanded="false">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="navbar-collapse collapse" id="dropdown6" style="">
					<ul class="navbar-nav mr-auto">

						<li class="nav-item"><a class="nav-link" href="index.jsp"
							data-abc="true">Home</a></li>
						<li class="nav-item"><a class="nav-link" href="index.jsp"
							data-abc="true">Products</a></li>
						<li class="nav-item"><a class="nav-link" href=""
							data-abc="true">About us</a></li>
						<li class="nav-item"><a class="nav-link" href="Cart.jsp"
							data-abc="true">Cart</a></li>
						<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/UserLogin.jsp"
							data-abc="true">Login</a></li>
						<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/Register.jsp"
							data-abc="true">Register</a></li>
						
					</ul>
				</div>
			</div>
		</nav>
	</header>






	<!-- <div class="header">
		<h1>Mobile World</h1>
		<img src="Images/Logo.jpg">

	</div>


	<div class="topnav">
		<a class="active" href="#home">Home</a> <a href="#product">Product</a>
		<a href="#about us">About us</a> 
		<input type="text" placeholder="Search here.....">
	</div>
 -->

<!-- <form action="SearchController2" class="search-wrap">
							<div class="input-group w-100">
								
								<input type="text" name="s" class="form-control search-form"
									style="width: 55%;" placeholder="Search">
									
								<div class="input-group-append">
									<input type="submit" class="btn btn-primary search-button" >
										<i class="fa fa-search"></i>
									
								</div>
							</div>
</form> -->




</body>
</html>