<%@page import="java.util.Iterator"%>
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

<title>Home</title>
<style>

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

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
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
			<input type="button"  class="btn btn-success" onclick="location.href='login';" value="Log In" />
			</h4>
			<%
				} else {
			%>
			<h4 align="right">
			<input type="button"  class="btn btn-danger" onclick="location.href='logout';" value="Log Out" />
			
			</h4>
			<%
				}
			%>


			<%
				if (session.getAttribute("customer") != null) {
			%>
			<a href='<spring:url value="/profile?cid=${sessionScope.customer.customerId}"/>'><span
							class="glyphicon glyphicon-user"></span> Hello ${sessionScope.customer.name }</a>
			<%
				} else {
			%>
			<a href="login"><span
							class="glyphicon glyphicon-user"></span> Hello guest</a>
			
			<%
				}
			%>

			<h4 align="right">
			<button type="button" class="btn btn-info" onclick="location.href='showcart';">Pizza Cart (${sessionScope.cart.size()})</button>
			</h4>

			<h1 align="center">Menu</h1>
			
			<c:forEach var="type" items="${typeList}">
				<li class="type"><a href="menu?type=${type}"> ${type} </a></li>
				<c:if test="${type==param.type}">
					<c:forEach var="cat" items="${catList}">
						<li class="cat" style="list-style-type: circle"><a
							href="menu?type=${type}&cat=${cat}">${cat}</a></li>
						<c:if test="${type==param.type && cat==param.cat}">
							<c:forEach var="item" items="${pizza}">
								<ul style="list-style-type: square">
									<li class="item"><a href="pizza?id=${item.itemId}">${item.name}</a></li>
									<h5>${item.description}</h5>
								</ul>
							</c:forEach>
						</c:if>
					</c:forEach>
				</c:if>
			</c:forEach>
		</div>
</div>
</body>
</html>
