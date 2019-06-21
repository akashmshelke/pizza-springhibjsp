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
<link href="<spring:url value='/assets/css/container.css'/>"
	rel="stylesheet" type="text/css" />

<title>Title</title>

<style>

.button {
  background-color: #4CAF50; /* Green */
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
  -webkit-transition-duration: 0.4s; /* Safari */
  transition-duration: 0.4s;
  
}

.button1 {
  box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2), 0 6px 20px 0 rgba(0,0,0,0.19);
}
</style>

</head>
<body>
	<div class="jumbotron">
		<center>
			<img class="img-responsive" src="assets/images/Pizza.png" alt="pizza"
				width="75" height="50">
		</center>
		<div class="container">

			<h3 align="center">Welcome Admin</h3>

			<h4 align="right">
			<input type="button"  class="btn btn-danger" onclick="location.href='logout';" value="Log Out" />
			
			</h4>

			<br>
			<br><br>

			<button class="button button1"
				onclick="window.location.href='additem'">Add
				Item</button>
				
			<button class="button button1"
				onclick="window.location.href='orders?status=Pending'">
				Orders</button>

		</div>
	</div>
</body>
</html>

