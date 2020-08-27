<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div style="float: right">
	
		<c:choose>
			<c:when test="${isSignedIn}">
				<span>User's name</span>
			</c:when>
			<c:otherwise>
				<a href="">Sign in</a>
				<a href="">Sign up</a>
			</c:otherwise>
		</c:choose>
		
		<a href="">Sign out</a>
	</div>
	
	<h1>HOME PAGE</h1>
	
	<div>
		<a href="">User's area</a>
		
		<c:if test="${isSignedIn}">
			<a href="">Update account</a>
			<a href="">Remove account</a>
		</c:if>
	</div>
	
</body>
</html>