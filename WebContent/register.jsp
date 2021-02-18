<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2> Register Page </h2>
	<h3> You Dont Have A Account, Do You Want To Register ? </h3>
	<form action="register.do" method="POST">
		<input type="hidden" name="formid" value="register">
		<input type="hidden" name="uname" value=<%= request.getParameter("uname") %> >
		<input type="hidden" name="upass" value=<%= request.getParameter("upass") %> >
		<input type="radio" name="option" value="yes"> YES
		<input type="radio" name="option" value="no"> NO
		<input type="submit" value="Submit">
	</form>
</body>
</html>