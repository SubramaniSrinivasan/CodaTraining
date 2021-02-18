<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Report </title>
</head>
<body>
<%@ include file="logout.jsp" %>
	<h3> Choose in what format to download file </h3>
	<form action="download.do" method="GET">
		<input type="hidden" name="formid" value="download">
		<input type="radio" name="choise" value="xls"/>EXCEL
		<input type="radio" name="choise" value="pdf"/> PDF
		<input type="SUBMIT" value="DOWNLOAD">
	</form>
</body>
</html>