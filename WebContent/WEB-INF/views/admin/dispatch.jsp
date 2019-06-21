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
	
<title>Dispatch Order</title>
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
			<input type="button"  class="btn btn-danger" onclick="location.href='logout';" value="Log Out" />
			
			</h4>

		<p>Order Dispatched...</p>

		<h4 align="right">
			<a href="orders"> Click here for All Orders</a>
		</h4>
	</div>
	</div>
</body>
</html>