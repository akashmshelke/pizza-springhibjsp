<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

<title>Insert title here</title>

</head>
<body>
<div class="jumbotron">
	<h1 align="center" style="color:#ff0066">Online Pizza</h1>

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

	<h2>Thank you for Order...</h2>
	<p>* your order will be delivered to ${requestScope.address} .</p>
	

		<a href="menu">Pizza Menu</a></br> </br>

	</div>

</body>
</html>