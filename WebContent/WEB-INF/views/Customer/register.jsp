<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="assets/bootstrap/bootstrap.min.css">
<script type="text/javascript" src="assets/bootstrap/jquery.min.js"></script>
<script type="text/javascript" src="assets/js/register.js"></script>
<link href="<spring:url value='/assets/css/container.css'/>"
	rel="stylesheet" type="text/css" />

<script type="text/javascript" src="assets/js/jquery.js"></script>
<script type="text/javascript" src="assets/js/jquery.validate.js"></script>
<title>Registration</title>

<style type="text/css">

 body {
            background-image:url("assets/images/pizza_background.jpg");
        
            
}
.error {
	color: red;
}

.valid {
	color: green;
}

</style>
</head>
<body >
	
		<center>
			<img class="img-responsive" src="assets/images/Pizza.png" alt="pizza"
				width="75" height="50">
				<h3>Registration</h3>
		</center>
		
		<div class="container" style="width: 400px">
			
			<h4 style="color: red">${requestScope.emailexist}</h4>
			<form method="post" modelAttribute="customer" name="register">
				<div class="row">
					<div class="form-group col-xs-8">
						<label for="name">Name:</label> <input type="name"
							class="form-control" id="name" placeholder="Enter name"
							name="name">
					</div>
				</div>
				<div class="row">
					<div class="form-group col-xs-8">
						<label for="mobile">Mobile:</label> <input type="mobile"
							class="form-control" id="mobile" placeholder="Enter mobile"
							name="mobile">


					</div>
				</div>
				<div class="row">
					<div class="form-group col-xs-8">
						<label for="email">Email:</label> <input type="email"
							class="form-control" id="email" placeholder="Enter email"
							name="email">


					</div>
				</div>
				<div class="row">
					<div class="form-group col-xs-8">
						<label for="address">Address:</label> <input type="address"
							class="form-control" id="address" placeholder="Enter address"
							name="address">

					</div>
				</div>
				<div class="row">
					<div class="form-group col-xs-8">
						<label for="pwd">Password:</label> 
						<input type="password" class="form-control" id="password" placeholder="Enter password"
							name="password">
					</div>
				</div>

				<div class="form-group">
					<button type="submit" class="btn btn-success">Register</button>
					<input type="button" class="btn btn-info"
					onclick="location.href='login'" value="Click here to Login">
				</div>
				

			</form>
		</div>
	</body>
</html>