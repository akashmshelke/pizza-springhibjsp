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
<link href="<spring:url value='/assets/css/container.css'/>"
	rel="stylesheet" type="text/css" />
<script src="assets/js/login.js"></script>
<script type="text/javascript" src="assets/js/jquery.js"></script>
<script type="text/javascript" src="assets/js/jquery.validate.js"></script>

<title>Login</title>
<style type="text/css">
.error {
	color: red;
}

.valid {
	color: green;
}
</style>
</head>
<body background="assets/images/pizza_background.jpg">
	<!-- <div class="jumbotron"> -->
		<center>
			<img class="img-responsive" src="assets/images/Pizza.png" alt="pizza"
				width="75" height="50">
			<h2>Login form</h2>
		</center>

		<div class="container" style="width: 300px">

			<h4 style="color: green">${requestScope.welmessage}</h4>

			<p style="color: red">${requestScope.message}</p>

			<form method="post" modelAttribute="customer" name="login">

				<div class="row">
					<div class="form-group col-xs-10">
						<label for="email">Email:</label> <input type="email"
							class="form-control" id="email" placeholder="Enter email"
							name="email">

					</div>
				</div>
				<div class="row">
					<div class="form-group col-xs-10">
						<label for="pwd">Password:</label> <input type="password"
							class="form-control" id="password" placeholder="Enter password"
							name="password">
					</div>
				</div>

				<button type="submit" class="btn btn-success" id="logbutton">Submit</button>
				<input type="button" class="btn btn-info"
					onclick="location.href='register'" value="Click here to register">


			</form>

		</div>
	<!-- </div> -->
</body>
</html>