<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:url value="app" var="linkApp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:import url="menu.jsp" />

	<h1>Sign up</h1>

	<form action="${linkApp}" method="post" >
		Name: <input type="text" name="name"/>
		<br />
		<br />
		Last name: <input type="text" name="lastName" />
		<br />
		<br />
		Date of birth: <input type="text" name="dateBirth" />
		<br />
		<br />
		E-mail: <input type="text" name="email" />
		<br />
		<br />
		Password: <input type="password" name="password" />
		<br />
		<br />
		<input type="submit" value="Send" />
		<input type="hidden" name="action" value="SignUp"/>
	</form>

</body>
</html>