<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>User</title>
</head>
<body>
<a href="/logout">logout</a>
<h2>User</h2>
<table border="1" cellpadding="10">
	<tr>
		<th>id</th>
		<th>Name</th>
		<th>Login</th>
		<th>Password</th>
		<th>Role</th>
		<th>Activity</th>
		<th>Action</th>
	</tr>
	<c:forEach var="user" items="${usersList}">
		<tr>
			<td>${user.id}</td>
			<td>${user.name}</td>
			<td>${user.login}</td>
			<td>${user.password}</td>
			<td>
				<c:forEach var="rol" items="${user.role}" varStatus="theCount">
					${user.role.get(theCount.index).role}
				</c:forEach>
			</td>
			<td>
				<c:if test="${user.enabled == true}">
					<input type="checkbox" checked>
				</c:if>
				<c:if test="${user.enabled == false}">
					<input type="checkbox">
				</c:if>
			</td>
			<td>
				<a href="/admin/edit/${user.id}">edit</a>
				<a href="/admin/delete/${user.id}">delete</a>
			</td>
		</tr>
	</c:forEach>
</table>

<h2>Add</h2>
<%--<c:url value="/admin/add" var="add"/>--%>
<a href="/admin/add">Add new user</a>
</body>
</html>
