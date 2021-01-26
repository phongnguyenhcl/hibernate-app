<%@page import="app.hibernate.model.Product"%>
<%@page import="app.hibernate.dao.ProductDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Home</title>
</head>
<body>
	<form action="addProduct" method="get">
		Enter the product's name: <input type="text" name="product_name"><br>
		Enter the product's size: <input type="number" name="product_size"><br>
		<input type="submit" value="Submit">
	</form>
	
	<hr>
	List of Product <br>
	<hr>
	<% 
		ProductDAO productDao = new ProductDAO();
		for (Product p : productDao.getAllProduct()) {
			out.println(p + "<br>") ;
		}
	%>
	
	
</body>
</html>