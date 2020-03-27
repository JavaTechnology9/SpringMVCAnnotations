<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%-- <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> --%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<body>
	<%-- <form action="/SpringMVC/registerProcess">
FirstName:<input type="text" name="firstname"><br/>
LastName: <input type="text" name ="lastname"><br/>
Email:<input type="text" name="email"><br/>
PhoneNumber: <input type="text" name ="phonenumber"><br/>
<input type="submit" value="submit">
</form> --%>
	<form:form modelAttribute="registration"
		action="registerProcess" method="post">
		<table align="center">
			<tr>
				<td><form:label path="firstname">FirstName</form:label></td>
				<td><form:input path="firstname" name="firstname" id="firstname"/></td>
				<td><form:errors path="firstname"></form:errors>
			</tr>
			<tr>
				<td><form:label path="lastname">LastName</form:label></td>
				<td><form:input path="lastname"/></td>
				<td><form:errors path="lastname"></form:errors>
			</tr>
			<tr>
				<td><form:label path="email">Email</form:label></td>
				<td><form:input path="email"/></td>
				<td><form:errors path="email"></form:errors>
			</tr>
			<tr>
				<td><form:label path="phonenumber">PhoneNumber</form:label></td>
				<td><form:input path="phonenumber"/></td>
			</tr>
			
			<tr>
			<td><form:button name="register"> Register</form:button></td>
			</tr>

		</table>
	</form:form>
</body>
</html>