<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ include file="logout.jsp" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body>
	<h4>Welcome <%=session.getAttribute("uname")%></h4>
	<h1>Welcome To Amazon Shopping Site </h1>
	<form action="shop.do">
		<input type="hidden" name="formid" value="shop">
		<input type="hidden" name="shopid" value="s1">
		<input type="submit" value="Start Shopping">
	</form>
</body>
</html>