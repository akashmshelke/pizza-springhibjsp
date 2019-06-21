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

<title>Order Details</title>

</head>
<body>
<div class="jumbotron">
<center>
			<img class="img-responsive" src="assets/images/Pizza.png" alt="pizza"
				width="75" height="50">
		</center>
	<div class="container">
		<h4>Hello Admin</h4>

		<h4 align="right">
			<a href="logout"> logout </a>
		</h4>

		<c:set var="orderid" scope="session" value="0" />
		<c:set var="name" scope="session" value="0" />
		<c:set var="mobile" scope="session" value="0" />
		<c:set var="address" scope="session" value="0" />
		<c:set var="status" scope="session" value="0" />


		<c:forEach var="od" items="${orderdetails}">
			<c:set var="name" scope="session" value="${od.order.customer.name}" />
			<c:set var="mobile" scope="session"
				value="${od.order.customer.mobile}" />
			<c:set var="address" scope="session"
				value="${od.order.customer.address}" />
			<c:set var="orderid" scope="session" value="${od.order.orderId}" />
			<c:set var="status" scope="session" value="${od.order.status}" />

		</c:forEach>

		<h3 style="color: blue">Customer Details</h3>

		<h4>Name : ${name}</h4>
		<h4>Mobile : ${mobile}</h4>
		<h4>Address : ${address}</h4>
		<h4>order ID : ${orderid}</h4>
		<h4>Status : ${status}</h4>

		<h4 align="right">
			<a href="orders"> Click here for All Orders</a>
		</h4>


		<c:choose>
			<c:when test="${status == 'Pending'}">

				<button class="button button1"
					onclick="window.location.href='update?id=${orderid}'">Dispatch
					Order</button>

				<br />
			</c:when>

		</c:choose>
		<h3 style="color: blue">Order Details</h3>

		<table class="table">
			<thead>
				<tr>
					<th>Type</th>
					<th>Name</th>
					<th>Size</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="od" items="${orderdetails}">
					<tr>
						<td>${od.itemprice.item.type}</td>
						<td>${od.itemprice.item.name}</td>
						<td>${od.itemprice.sizes}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	</div>
</body>
</html>