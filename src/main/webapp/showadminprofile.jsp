<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>
		Welcome<%request.getParameter("UserName");
	%>
	</h3>
	<a href="createaccount.html"> <input type="submit"
		value="Add new employee"></a>
		
		<h3>Employee Records</h3>
</body>
</html>