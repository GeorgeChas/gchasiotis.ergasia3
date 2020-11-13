<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>    
<%@ page import="java.util.List,my_package.productv2" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Barcode Exist</title>
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
			Καταχώρηση Προϊόντος
	</div>
	<%
		session.getAttribute("batabase_products_");
	%>
	<div class="container1">
		<h3>Το Barcode που συμπληρώσατε υπάρχει και το προϊον είναι:</h3>
	</div>
	<table class="info">
		<tr>
			<th> Όνομα </th> <th> Barcode </th> <th> Χρώμα </th> <th> Περιγραφή </th>
		</tr>
		
		<tr>
			<td>${batabase_products_.sname}</td>
			<td>${batabase_products_.barcode}</td>
			<td>${batabase_products_.color}</td>
			<td>${batabase_products_.pdescription}</td>
		</tr>
	</table>
	
	<div class="container1">
		<h3>Συμπληρώστε ξανά τα παρακάτω στοιχεία:</h3>
	</div>
	
	<form class="my-form" action="create">
		
		<div class="row">
			<label>Όνομα:</label>
			<input type="text" name="name" placeholder="Enter Product Name">
		</div>
		<br>
		<div class="row">
			<label>Barcode<h4>*</h4>:</label>
			<input type="text" name="barcode" placeholder="Enter Barcode">
			<h7>Barcode Exist</h7>
		</div>
		<br>
		<div class="row">
			<label>Χρώμα:</label>
			<input type="text" name="color" placeholder="Enter Product Color">
		</div>
		<br>
		<div class="row">
			<label>Περιγραφή:</label>
			<textarea name="description"></textarea>
		</div>
		<br>
		<div class="submit">
			<input type="submit" value="Submit">
		</div>
	</form>
	<form action="store">
		<div class="submit">
			<input type="submit" value="Search Product">
		</div>
	</form>
	
	
</body>
</html>