<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="app" var="linkApp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:import url="menu.jsp" />

	<h1>Sign in</h1>

	<form action="${linkApp}" method="post" >
		E-mail: <input type="text" name="email" />
		<br />
		<br />
		Password: <input type="password" name="password" />
		<br />
		<br />
		<input type="submit" value="Send" />
		<input type="hidden" name="action" value="SignIn" />
	</form>

</body>
</html>