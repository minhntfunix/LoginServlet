<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Product"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
 <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
 <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
 <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,700" rel="stylesheet">
 <link rel="stylesheet" href="CSS/details.css" type=text/css>
<title>Mobile World</title>
</head>
<body>





<c:set var="product" value='${requestScope["product"]}' />

<jsp:include page="header.jsp" />
	<div class="container">
		<div class="card">
			<div class="container-fluid">
				<div class="wrapper row">
					<div class="preview col-md-4">
						
						<div class="preview-pic tab-content">
						  <div class="tab-pane active" id="pic-1"><img src="${pageContext.request.contextPath}/Images/${fn:replace(fn:trim(product.name),' ','')}.jpg" /></div>
						  
						</div>
						
						
					</div>
					<div class="details col-md-8">
						<h3 class="product-title">${product.name}</h3>
						
						<p class="product-description">${product.description}</p>
						<h4 class="price"><span>
						
						<c:set var = "balance" value = "${product.price}" />
						
						<fmt:formatNumber type = "number" 
         maxFractionDigits="0" value = "${Math.floor(balance*100)*10000}" /> VNĐ
						
						
						</span></h4>
						
						<div class="action"> 
						 <form action="${pageContext.request.contextPath}/AddtoCart" method="POST"> 
						
						
								
								
								
								<input type="hidden" name="id" value="${product.id}">
								<input type="submit" name="action" value="add"> 
								
								
						
						
							</form>	
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	
<jsp:include page="footer.jsp" />	

</body>
</html>