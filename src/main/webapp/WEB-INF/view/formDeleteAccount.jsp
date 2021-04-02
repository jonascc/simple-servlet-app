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

<h1>Delete Account</h1>

	<form action="${linkApp}" method="post" onsubmit="return deleteConfirmation()">
		Click the button to delete your account.
		<br />
		<br />
		<input type="submit" value="Delete" />
		<input type="hidden" name="action" value="DeleteAccount" />
	</form>
	
	<script type="text/javascript">
		function deleteConfirmation() {
			let conf = confirm("Are you sure you want to delete your account?");
			if(conf === false) {
				return false;
			}
		}
		
	</script>

</body>
</html>