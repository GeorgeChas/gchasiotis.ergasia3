<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.List,my_package.productv2" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Batabase Products</title>
<link rel="stylesheet" href="styles/style.css">
<style>
	.info{
		 border-collapse: collapse;
		  width: 100%;
		  margin-left: 10px;
	}
	.info th{
  		padding: 12px 0;
  		text-align: center;
  		background-color: black;
  		color: white;
	}
	.info td, .info th{
		 border: 1px solid #ddd;
 		 padding: 8px;
	}
</style>
</head>
<body>
	<div class="container">
			Καταχωρημένα Προϊόντα
	</div>
	
	<%
		List<productv2> products = (List<productv2>)request.getAttribute("batabase_products");
	%>
	
	<div class="container1">
		<h3>Ο αριθμός των προϊόντων στη βάση είναι:<h3 style="color: red;"><%= products.size() %></h3></h3>
	</div>
	
	<table class="info">
		<tr>
			<th> Όνομα </th> <th> Barcode </th> <th> Χρώμα </th> <th> Περιγραφή </th>
		</tr>
		<%
			for(int i=0;i<products.size();i++) {
				productv2 stored_product = products.get(i); 
		%>
		<tr>
			<td><%= stored_product.getSname() %></td>
			<td><%= stored_product.getBarcode() %></td>
			<td><%= stored_product.getColor() %></td>
			<td><%= stored_product.getPdescription() %></td>
		</tr>
		<%     
			}
		%>
	</table>
	
	<form action="back">
		<div class="submit">
			<input type="submit" value="New Product">
		</div>
	</form>
</body>
</html>