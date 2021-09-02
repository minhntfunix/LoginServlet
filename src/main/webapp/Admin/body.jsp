<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="CSS/login.css" type=text/css>
<title>Insert title here</title>
</head>
<body>
	<% 
		Cookie[] cookie= request.getCookies();
		String email="";
		String pass="";
		String remem="";
		if(cookie !=null){
			for (Cookie cook:cookie){
				if ( cook.getName().equals("cEmail") ) {
					 email = cook.getValue();					
				}
				if ( cook.getName().equals("cPass") ) {
					pass = cook.getValue();					
				}
				if ( cook.getName().equals("cRemem") ) {
					remem = cook.getValue();					
				}
			}		
			
			
		}
		
		
	%>

	<form action="Loginform" method="POST">

		Username </br> <input type="text" placeholder="Enter Username"
			name="username" value="<%= email %>" /></br> 
		Password </br> <input
			type="password" placeholder="Enter Password" name="pass"
			value="<%= pass %>" /></br>
			
		<button type="submit">Login</button>
		
		</br> 
		<label> <input type="checkbox" name="remember" value="1"
			<%= "1".equals(remem) ? "checked='/checked'" : ""%>>Remember
			me</input>
		</label>
	</form>

</body>
</html>