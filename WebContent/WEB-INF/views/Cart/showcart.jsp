<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="assets/bootstrap/bootstrap.min.css">
<script src="assets/bootstrap/jquery.min.js"></script>
<script src="assets/bootstrap/bootstrap.min.js"></script>

<link href="<spring:url value='/assets/css/container.css'/>" rel="stylesheet" type="text/css" />

<title>Cart</title>

</head>
<body>
<div class="jumbotron">
<center>
			<img class="img-responsive" src="assets/images/Pizza.png" alt="pizza"
				width="75" height="50">
		</center>
	<div class="container">

		<%
			if (session.getAttribute("customer") != null) {
		%>
		<h4 align="right">
			<a href="logout"> logout</a>
		</h4>
		<%
			} else {
		%>
		<h4 align="right">
			<a href="login"> Login</a>
		</h4>
		<%
			}
		%>

		<%
			if (session.getAttribute("customer") != null) {
		%>
		<p align="left">Hello ${sessionScope.customer.name }</p>
		<%
			} else {
		%>
		<p align="left">Hello Guest</p>
		<%
			}
		%>

		<h4 align="right">
			<a href="showcart"> Cart (${sessionScope.cart.size()})</a>
		</h4>

		<h2 style="color: blue">Cart</h2>
		<h4 style="color: red">${ requestScope.emptyPlaceOrder}</h4>
		<h4 style="color: red">${requestScope.cartmsg}</h4>

		<table class="table" style="width: 60%">
			<tr>
				<th>Type</th>
				<th>Pizza Name</th>
				<th>Size</th>
				<th>Price</th>
			</tr>
			<c:forEach var="ip" items="${pricelist}">
				<tr>
					<td>${ip.item.type}</td>
					<td>${ip.item.name}</td>
					<td>${ip.sizes}</td>
					<td>Rs. ${ip.price}</td>
				</tr>
			</c:forEach>
		</table>

		<h3>Net Total : RS. ${requestScope.total}</h3>

		<%
			if (session.getAttribute("customer") != null) {
		%>
		<h4 align="left">
			<a href="placeorder">Place Order</a>
		</h4>
		<%
			} else {
		%>
		<h4 align="left">
			<a href="login"> Place order</a>
		</h4>
		<%
			}
		%>


		<a href="menu">Pizza Menu</a></br> </br>

	</div>
	</div>
</body>
</html>