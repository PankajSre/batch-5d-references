<%@ include file="header.jsp"%>

<h2>User Registration</h2>
<hr>
<form:form action="register" method="POST" modelAttribute="user"
	enctype="multipart/form-data">
	<pre>
        Id        : <form:input path="id" />
		<br>
        Username  : <form:input path="username" />
		<br>
        Password  : <form:password path="password" />
		<br>
        Email     : <form:input path="email" />
		<br>
        Address   : <form:input path="address" />
		<br>
        Image     : <form:input path="image" type="file" />
                    <input type="submit" value="Register" /> <input
			type="reset" value="Reset" />
        </pre>
</form:form>
</body>
</html>