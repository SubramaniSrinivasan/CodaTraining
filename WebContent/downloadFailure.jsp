<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ include file="logout.jsp" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Download failure </title>
</head>
<body>
 <h3> There was Some Problem in Download </h3>
 	<form action="logout.do" method="post">
		<input type="hidden" name="formid" value="payment">
		<input type="submit" value="Go back">
	</form>
</body>
</html>