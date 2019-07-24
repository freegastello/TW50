<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>Title</title>
</head>
<body>
<h2>Стартовая страница</h2>
<%--<c:url value="/login" var="loginUrl"/>--%>
<form action="/login" method="post">
	<c:if test="${param.error != null}">
		<p>
			Invalid username and password.
		</p>
	</c:if>
	<c:if test="${param.logout != null}">
		<p>
			You have been logged out.
		</p>
	</c:if>
	<p>
		<label for="login">Username</label>
		<input type="text" id="login" name="login"/>
	</p>
	<p>
		<label for="password">Password</label>
		<input type="password" id="password" name="password"/>
	</p>
	<input type="hidden"
		   name="${_csrf.parameterName}"
		   value="${_csrf.token}"/>
	<button type="submit" class="btn">Log in</button>
</form>
</body>
</html>
