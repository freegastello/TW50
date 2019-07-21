<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<c:if test="${empty user.name}">
		<title>Add</title>
	</c:if>
	<c:if test="${!empty user.name}">
		<title>Edit</title>
	</c:if>
</head>
<body>
<c:if test="${empty user.name}">
	<c:url value="/add" var="var"/>
</c:if>
<c:if test="${!empty user.name}">
	<c:url value="/edit" var="var"/>
</c:if>
<form commandName="user" action="${var}" method="POST">
	<c:if test="${!empty user.name}">
		<input type="hidden" name="id" value="${user.id}">
	</c:if>
	<label for="name">Name</label>
		<input type="text" name="name" id="name" value="${user.name}"><br/>
	<label for="login">Login</label>
		<input type="text" name="login" id="login" value="${user.login}"><br/>
	<label for="password">Password</label>
		<input type="text" name="password" id="password" value="${user.password}"><br/>

<%--	<label for="role">role</label>--%>
<%--		<input type="text" name="role" id="role" value="${roleList.get(0).role}"><br/>--%>

	<c:if test="${empty user.name}">
		<label for="role_id">Role</label>
		<select size="2" multiple>
			<c:forEach var="roles" items="${roleList}">
				<option name="role" id="role_id" value="${roles.role}">${roles.role}</option>
			</c:forEach>
		</select>
		<br/><br/>
		<input type="submit" value="Add new user">
	</c:if>
	<c:if test="${!empty user.name}">
		<label for="role">Role</label>
		<input type="text" name="role" id="role" value="${user.role.get(0).role}"><br/>
		<input type="submit" value="Edit user">
	</c:if>
</form>
</body>
</html>
