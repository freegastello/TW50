<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>User</title>
</head>
<body>

<h2>User</h2>
<table border="1" cellpadding="10">
	<tr>
		<th>id</th>
		<th>Name</th>
		<th>Login</th>
		<th>Password</th>
		<th>Role</th>
		<th>Action</th>
	</tr>
	<c:forEach var="user" items="${usersList}">
		<tr>
			<td>${user.id}</td>
			<td>${user.name}</td>
			<td>${user.login}</td>
			<td>${user.password}</td>
			<td>${user.role.get(0).role}</td>
			<td>
				<a href="/edit/${user.id}">edit</a>
				<a href="/delete/${user.id}">delete</a>
			</td>
		</tr>
	</c:forEach>
</table>

<h2>Add</h2>
<c:url value="/add" var="add"/>
<a href="${add}">Add new user</a>
</body>
</html>
