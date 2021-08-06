<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="header.jsp"%>
<h2>Admin Registration</h2>
<hr>
<form:form action="register-admin" method="POST" modelAttribute="admin">
	<pre>
        Id        : <form:input path="id" />
		<br>
        Name  : <form:input path="name" />
		<br>
        Password  : <form:password path="password" />
		<br>
        Email     : <form:input path="email" />
		<br>
                    <input type="submit" value="Register" /> <input
			type="reset" value="Reset" />
        </pre>
</form:form>
</body>
</html>