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
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" >
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js" ></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" ></script>

<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.bundle.min.js"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"></script>

<link rel="stylesheet" href="CSS/Cart.css" type=text/css>
<title>Shopping cart</title>
</head>
<body>
	

	
<%-- 	<% 
	Cart cart= (Cart) session.getAttribute("cart");
	
	if (cart ==null){
		response.getWriter().println("The cart is empty");		
	}
	%> --%>
	
	
	
	<jsp:include page="header.jsp"></jsp:include>

	<c:if test = "${empty cart}">
         <h4> The cart is empty </h4>
      </c:if>
	<%
	String message= (String) session.getAttribute("message");
	if (message !=null){
	out.println(message);
	}	
%>
      
	<div class="container">
    <div class="row">
        <aside class="col-lg-9">
            <div class="card">
                <div class="table-responsive">
                    <table class="table table-borderless table-shopping-cart">
                        <thead class="text-muted">
                            <tr class="small text-uppercase">
                                <th scope="col">Product</th>
                                <th scope="col" width="20">Quantity</th>
                                <th scope="col" width="120">Update</th>
                                <th scope="col" width="120">Price</th>
                                 
                                 <th scope="col" width="120">Total</th>
                                <th scope="col" class="text-right d-none d-md-block" width="100"></th>
                            </tr>
                        </thead>
                        <tbody>
                         <c:forEach var="p" items="${cart.getitems()}" >
                        	<form name="item" action="AddtoCart">
                            	<tr>
                           
                                <td>
                                    <figure class="itemside align-items-center">
                                        <div class="aside"><img src="${pageContext.request.contextPath}/Images/${fn:replace(fn:trim(p.name),' ','')}.jpg" class="img-sm"></div>
                                        <figcaption class="info"> <a href="#" class="title text-dark" data-abc="true">${p.name}</a>
                                            
                                        </figcaption>
                                    </figure>
                                </td>
                                
                                <td> 
									<div class="quantity">
									<input type="number" style="width: 3em" name="quantity" min=0  value='${p.number}'>
									</div>                                
                               
                                </td>
                                
                                <td>
                                <input type="submit" name="action" value="update"> 
                                <input type="hidden" name="id" value="${p.id}">
                                </td>
                                
                                 <td>
                                    <div class="price-wrap"> <var class="price">${p.price}</var> </div>
                                </td>
                                
                                
                                
                            
                                
                                <td>
                                    <div class="price-wrap"> <var class="price">
                                    
                                    <c:set var = "balance" value = "${p.price}" />
						
									<fmt:formatNumber type = "number" 
        						 	maxFractionDigits="0" value = "${Math.floor(balance*100)*10000*p.number}"/>
                                    
                                    </var> </div>
                                </td>
                                
                               
                                
                                <td class="text-right d-none d-md-block">
                                <a href="AddtoCart?action=delete&id=${p.id}" class="btn btn-light" data-abc="true"> Remove</a> 
                                
                                </td>
                                
                            </tr>
                            
                            </form>
                            </c:forEach>
                            
                            
                        
                            
                        </tbody>
                    </table>
                </div>
            </div>
        </aside>
        <aside class="col-lg-3">
            <div class="card mb-3">
                <div class="card-body">
                    <form>
                        <div class="form-group"> <label>Have coupon?</label>
                            <div class="input-group"> <input type="text" class="form-control coupon" name="" placeholder="Coupon code"> <span class="input-group-append"> <button class="btn btn-primary btn-apply coupon">Apply</button> </span> </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="card">
                <div class="card-body">
                    <dl class="dlist-align">
                        <dt>Total price:</dt>
                        <dd class="text-right ml-3">
                        
                        <c:set var = "balance" value = "${cart.getAmount()}" />
						
						<fmt:formatNumber type = "number" 
         maxFractionDigits="0" value = "${Math.floor(balance*100)*10000}"/>
                        
                        
                      </dd>
                    </dl>
                    <dl class="dlist-align">
                        <dt>Discount:</dt>
                        <dd class="text-right text-danger ml-3"></dd>
                    </dl>
                    <dl class="dlist-align">
                        <dt>Total:</dt>
                        <dd class="text-right text-dark b ml-3">
                        <strong>
                         <c:set var = "balance" value = "${cart.getAmount()}" />
						
						<fmt:formatNumber type = "number" 
         maxFractionDigits="0" value = "${Math.floor(balance*100)*10000}"/>
                        
                        
                        
                        </strong></dd>
                    </dl>
                    <hr> 
                    <a href="Checkout" class="btn btn-out btn-primary btn-square btn-main" data-abc="true"> Checkout </a> 
                    <a href="index.jsp" class="btn btn-out btn-success btn-square btn-main mt-2" data-abc="true">Continue Shopping</a>
                </div>
            </div>
        </aside>
    </div>
</div>
<jsp:include page="footer.jsp" />
</body>
</html>