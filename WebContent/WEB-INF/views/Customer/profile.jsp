<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="assets/bootstrap/bootstrap.min.css">
<script src="assets/bootstrap/jquery.min.js"></script>
<script src="assets/bootstrap/bootstrap.min.js"></script>
<link href="<spring:url value='/assets/css/container.css'/>"
	rel="stylesheet" type="text/css" />

<title>Profile</title>

<style>
table {
	border-collapse: collapse;
	width: 50%;
	margin-left: 250px;
}

th, td {
	padding: 8px;
	text-align: left;
	border-bottom: 1px solid #ddd;
}

.type {
	background-color: #33cccc;
}

.cat {
	background-color: #ffe6ff;
}

.item {
	background-color: #ffffb3;
}
</style>


<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="jumbotron">
		<center>
			<img class="img-responsive" src="assets/images/Pizza.png" alt="pizza"
				width="75" height="50">
		</center>
		<div class="container">

			<%
				if (session.getAttribute("customer") == null) {
			%>
			<h4 align="right">
				<input type="button" class="btn btn-success"
					onclick="location.href='login';" value="Log In" />
			</h4>
			<%
				} else {
			%>
			<h4 align="right">
				<input type="button" class="btn btn-danger" onclick="logout" value="Log Out" />
					<!-- onclick="location.href='/logout';" value="Log Out" /> -->
					

			</h4>
			<%
				}
			%>



			<%
				if (session.getAttribute("customer") != null) {
			%>
			<a
				href='<spring:url value="/profile?cid=${sessionScope.customer.customerId}"/>'><span
				class="glyphicon glyphicon-user"></span> Hello
				${sessionScope.customer.name }</a>
			<%
				} else {
			%>
			<a href="login"><span class="glyphicon glyphicon-user"></span>
				Hello guest</a>

			<%
				}
			%>



			<table>

				<tr>
					<td style="font: bold;">ID</td>
					<td>${requestScope.customer.customerId}</td>
				</tr>
				<tr>
					<td>Name</td>
					<td>${requestScope.customer.name}</td>
				</tr>
				<tr>
					<td>Email</td>
					<td>${requestScope.customer.email}</td>
				</tr>
				<tr>
					<td>Mobile</td>
					<td>${requestScope.customer.mobile}</td>
				</tr>
				<tr>
					<td>Address</td>
					<td>${requestScope.customer.address}</td>
				</tr>
			</table>
			<button class="btn btn-success" onclick="window.location.href='menu'">Start
				your Order</button>


			<a
				href='<spring:url value="/cust/update?cid=${requestScope.customer.customerId}"/>'>Update
				Profile</a>

		</div>
	</div>



</body>
</html>