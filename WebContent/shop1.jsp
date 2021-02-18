<%@page import="java.util.List"%>
<%@page import="utility.ShopDTO"%>
<%@page import="utility.ItemDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Shop 1 </title>
</head>
<body>
	<hr>
	<%@ include file="logout.jsp" %>
	<h3>Welcome <%= session.getAttribute("uname") %></h3>
	<hr>
	<h1><% ShopDTO shopDTO = (ShopDTO)request.getAttribute("shopDTO");
		   List<ItemDTO> list = (List<ItemDTO>)request.getAttribute("ItemDTO");
		%>
		<%= shopDTO.getShopName() %>
	</h1>
		<form action="shopping.do" method="post">
			<input type="hidden" name="formid" value="shop">
			<input type="hidden" name="shopid" value="s2">
			<%  for(ItemDTO item : list){ %>
				<img src="<%= item.getImageURL() %>" alt="<%= item.getItemDescription() %>" width="200" height="200">
				<br>
				<input type="checkbox" name="<%= item.getItemID() %>" value="<%= item.getItemDescription() %>"><%= item.getItemDescription() %>
				<br>
			<% } %>
			<input type="submit" value="Next Shop">
		</form>
	
	</body>
</html>