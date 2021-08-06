<%@ include file="header.jsp"%>
<br>
<table border="1">
	<tr>
		<th>ID</th>
		<th>Username</th>
		<th>Password</th>
		<th>Email</th>
		<th>Address</th>
		<th>Image</th>
		<th>Actions</th>
	</tr>

	<c:forEach var="user" items="${list }">
		<tr>
			<td>${user.id }</td>
			<td>${user.username }</td>
			<td>${user.password }</td>
			<td>${user.email }</td>
			<td>${user.address }</td>
			<td><img
				src="<c:url value='/resources/images/${user.id }.png'/>" /></td>
			<td><a href="<c:url value='/delete-user/${user.id }'/>">Delete</a>
				| <a href="<c:url value='/update-user/${user.id }'/>">Update</a></td>
		</tr>
	</c:forEach>
</table>
<br>
<a href="addUser">Add New User</a>
</body>
</html>