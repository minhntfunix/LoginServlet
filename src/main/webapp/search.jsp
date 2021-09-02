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
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp" />
<table class="images">
	<c:set var="tablewidth" value="3"/>
	<c:forEach var="p" items="${products}" varStatus="row">
		
		<c:if test="${row.index % tablewidth ==0 }"	>
			<tr>
		</c:if>
		<td>
		<div class="card bg-white" style="width: 18rem;">	
			<img class="card-img-top" src="${pageContext.request.contextPath}/Images/${fn:replace(fn:trim(p.name),' ','')}.jpg" /> 
			<div class="card-body">
				<h6 class="card-title"> 
					<a href="info?id=${p.id}"> ${p.name}  </a> 
				</h6>
				
				<p class="card-price">$${p.price} </p>
			
				
			</div>	
		</div>
		</td>
		<c:if test="${row.index+1 % tablewidth == 0 }">
			</tr>
		</c:if>
		
	</c:forEach>
	
	
	

</table>



	<div class="paging">
		<c:forEach begin="1" end= "${end}" var="i">
			<a href="SearchController2?index=${i}"> ${i}</a>
		</c:forEach>
	</div>
	
<jsp:include page="footer.jsp" />
</body>
</html>