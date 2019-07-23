<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>Edit</title>
</head>
<body>
	<c:url value="/edit" var="var"/>
<form action="${var}" method="POST">
	<input type="hidden" name="id" value="${user.id}">
	<label for="name">Name</label>
		<input type="text" name="name" id="name" value="${user.name}"><br/>
	<label for="login">Login</label>
		<input type="text" name="login" id="login" value="${user.login}"><br/>
	<label for="password">Password</label>
		<input type="text" name="password" id="password" value="${user.password}"><br/>

<%--	<label for="role">Role</label>--%>
<%--	<input type="text" name="role" id="role" value="${user.role.get(0).role}"><br/>--%>


	<select name="role" multiple>
		<c:forEach var="roles" items="${roleList}">
			<c:if test="${roles.role == user.role.get(0).role}">
				<option selected value="${roles.role}">${roles.role}</option>
			</c:if>
			<c:if test="${roles.role != user.role.get(0).role}">
				<option value="${roles.role}">${roles.role}</option>
			</c:if>
		</c:forEach>
	</select>
	<br><br>
		<input type="submit" value="Edit user">
</form>
</body>
</html>




<%--selected--%>


<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--	<c:if test="${empty user.name}">--%>
<%--		<title>Add</title>--%>
<%--	</c:if>--%>
<%--	<c:if test="${!empty user.name}">--%>
<%--		<title>Edit</title>--%>
<%--	</c:if>--%>
<%--</head>--%>
<%--<body>--%>
<%--<c:if test="${empty user.name}">--%>
<%--	<c:url value="/add" var="var"/>--%>
<%--</c:if>--%>
<%--<c:if test="${!empty user.name}">--%>
<%--	<c:url value="/edit" var="var"/>--%>
<%--</c:if>--%>
<%--<form action="${var}" method="POST">--%>
<%--	<c:if test="${!empty user.name}">--%>
<%--		<input type="hidden" name="id" value="${user.id}">--%>
<%--	</c:if>--%>
<%--	<label for="name">Name</label>--%>
<%--	<input type="text" name="name" id="name" value="${user.name}"><br/>--%>
<%--	<label for="login">Login</label>--%>
<%--	<input type="text" name="login" id="login" value="${user.login}"><br/>--%>
<%--	<label for="password">Password</label>--%>
<%--	<input type="text" name="password" id="password" value="${user.password}"><br/>--%>

<%--	<c:if test="${empty user.name}">--%>
<%--		<select name="role" multiple>--%>
<%--			<c:forEach var="roles" items="${roleList}">--%>
<%--				<option value="${roles.role}">${roles.role}</option>--%>
<%--			</c:forEach>--%>
<%--		</select>--%>
<%--		<br/><br/>--%>
<%--		<input type="submit" value="Add new user">--%>
<%--	</c:if>--%>

<%--	<c:if test="${!empty user.name}">--%>
<%--		<label for="role">Role</label>--%>
<%--		<input type="text" name="role" id="role" value="${user.role.get(0).role}"><br/>--%>
<%--		<input type="submit" value="Edit user">--%>
<%--	</c:if>--%>
<%--</form>--%>
<%--</body>--%>
<%--</html>--%>
