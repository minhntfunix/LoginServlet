<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>


<link rel="stylesheet" href="CSS/login.css" type=text/css>
<title>Login</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col">
				<div class="leftcolumn">
					<%
					String message= (String) session.getAttribute("error");
					if (message !=null){
					out.println(message);
					}	
					%>

					<jsp:include page="Admin/header.jsp" />
					<jsp:include page="Admin/body.jsp" />
					<jsp:include page="Admin/footer.jsp" />

				</div>
			</div>

			<div class="col">
				<div class="welcomeback">
					<h1>Welcome Back</h1>
					<p />
					To keep connected with us, please login with your personal info
				</div>
			</div>

		</div>

	</div>





</body>



</html>