<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	<form:form commandName="user" action="login" method="POST">
		<h2>Log in</h2>
		<c:if test="${param.error != null}">
			<p>Invalid username and password.</p>
		</c:if>
        <div>
        	<form:input path="username" placeholder="Username" autofocus="true"/><form:errors path="username"/>
        	<br/>
        	<form:password path="password" placeholder="Password" /><form:errors path="password"/>
        	<br/>
        	<form:button>Log In</form:button>
        </div>	
	</form:form>
</body>
</html>