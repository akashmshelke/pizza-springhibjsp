<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="assets/bootstrap/bootstrap.min.css">
<script src="assets/bootstrap/jquery.min.js"></script>
<script src="assets/bootstrap/bootstrap.min.js"></script>
<link href="<spring:url value='/assets/css/container.css'/>" rel="stylesheet" type="text/css" />

<title>Size</title>


</head>
<body>
<div class="jumbotron">
	<center>
			<img class="img-responsive" src="assets/images/Pizza.png" alt="pizza"
				width="75" height="50">
		</center>

	<div class="container">
		<h2>Select Sizes</h2>
		<form action="addtocart">

			<table class="table" style="width: 70%">
				<thead>
					<tr>
						<th>Name</th>
						<th>Type</th>
						<th>Category</th>
						<th>Description</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><strong>${requestScope.item.name}</strong></td>
						<td>${requestScope.item.type}</td>
						<td>${requestScope.item.category}</td>
						<td>${requestScope.item.description}</td>

					</tr>
				</tbody>
			</table>
			<br>
			<c:forEach var="itemprice" items="${item.priceList}">
				<input type="checkbox" name="priceid" value="${itemprice.pricingId}"> ${itemprice.sizes} | &#8377 ${itemprice.price} </br>

			</c:forEach>
			<br> <input type="submit" value="Add To cart">
			<br>
			<h4><a href="menu">Click here for Menu</a></h4>
			
		</form>
	</div>
	</div>
</body>
</html>