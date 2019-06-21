<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form:form modelAttribute="customer">
		<table>
			<tr>
				<td>ID</td>
				<td><form:input readonly="true" path="customerId" /></td>
			</tr>

			<tr>
				<td>Name</td>
				<td><form:input path="name" /></td>

			</tr>

			<tr>
				<td>E-Mail</td>
				<td><form:input path="email" /></td>

			</tr>

			<tr>
				<td>Mobile</td>
				<td><form:input path="mobile" /></td>

			</tr>

			<tr>
				<td>Password</td>
				<td><form:password showPassword="true" path="password" /></td>

			</tr>
			<tr>
				<td>Address</td>
				<td><form:input path="address" /></td>

			</tr>

			<tr>
				<td></td>
				<td>
					<button type="submit">Update</button>
				</td>

			</tr>


		</table>



	</form:form>

</body>
</html>