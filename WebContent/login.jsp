<!DOCTYPE html>
<%@ include file="header.jsp" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Login Page </title>
</head>
<body>
	<form action="login.do" method="POST">
		<input type="hidden" name="formid" value="login">
		Username : <input type="text" name="uname">
		Password : <input type="password" name="upass">
		<br>
		<input type="submit" value="Login">
	</form>
</body>
</html>