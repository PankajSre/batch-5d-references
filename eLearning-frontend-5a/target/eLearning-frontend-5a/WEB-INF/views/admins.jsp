<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin List</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Password</th>
			<th>Email</th>
			<th>Actions</th>
		</tr>

		<c:forEach var="admin" items="${list }">
			<tr>
				<td>${admin.id }</td>
				<td>${admin.name }</td>
				<td>${admin.password }</td>
				<td>${admin.email }</td>
				
				<td><a href="<c:url value='/delete-admin/${admin.id }'/>">Delete</a>
					| <a href="<c:url value='/update-admin/${admin.id }'/>">Update</a></td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<a href="add-admin">Add New User</a>
</body>
</html>