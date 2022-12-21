<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	 
	<form action="loginadmin" method="post">
		<label>USERNAME</label> <input type="text" name="username"><br>
		<br> <label>PASSWORD</label> <input type="password"
			name="password"><br> <br>
			<div style="color: #FF0000;">
 				<%
			out.println(request.getAttribute("error"));
			%>
			</div>
			 <input type="submit"
			value="Login Admin"> 
			<a href="createaccount.html"> <input
			type="button" value="Create Admin account"></a>
	</form>

</body>
</html>