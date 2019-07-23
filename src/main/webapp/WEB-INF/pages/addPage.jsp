<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>Add</title>
</head>

<body>
<form action="/add" method="POST">
	<label for="name">Name</label>
	<input type="text" name="name" id="name" value="${user.name}"><br/>
	<label for="login">Login</label>
	<input type="text" name="login" id="login" value="${user.login}"><br/>
	<label for="password">Password</label>
	<input type="text" name="password" id="password" value="${user.password}"><br/>

	<select name="role" multiple>
		<c:forEach var="roles" items="${roleList}">
<%--			<option value="${roles.role}">${roles.role}</option>--%>
			<option value="${roles.role}">${roles.role}</option>
		</c:forEach>
	</select>
	<br/><br/>
	<input type="submit" value="Add new user">
</form>
</body>
</html>
