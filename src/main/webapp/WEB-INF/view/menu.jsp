<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="app?action=" var="linkApp" />
<c:url value="/" var="linkHome" />
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
				<span>Hello, ${signedInUser.name}</span>
			</c:when>
			<c:otherwise>
				<a href="${linkApp}SignInForm">Sign in</a>
				<a href="${linkApp}SignUpForm">Sign up</a>
			</c:otherwise>
		</c:choose>

		<a href="${linkApp}SignOut">Sign out</a>
	</div>

	<div>
		<a href="${linkHome}">Home</a>
		<a href="${linkApp}UserPage">User's page</a>

		<c:if test="${isSignedIn}">
			<a href="">Update account</a>
			<a href="">Remove account</a>
		</c:if>
	</div>

</body>
</html>