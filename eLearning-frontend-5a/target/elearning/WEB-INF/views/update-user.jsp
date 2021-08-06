<%@ include file="header.jsp"%>
<h2>Update User</h2>
<hr>
<c:url var="updateUrl" value="/update-user"></c:url>
<form:form action="${updateUrl }" method="post" modelAttribute="user"
	enctype="multipart/form-data">
	<pre>
        Id        : <form:input path="id" disabled="true" />	<br>
        Username  : <form:input path="username" />
		<br>
        Password  : <form:input path="password" />
		<br>
        Email     : <form:input path="email" />
		<br>
        Address   : <form:input path="address" />
		<br>
		Image     : <input name="image" type="file" /><br>	
                    <input type="submit" value="Update User" /> <input
			type="reset" value="Reset" />
        </pre>
</form:form>
</body>
</html>