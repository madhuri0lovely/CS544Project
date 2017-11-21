<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sessions</title>
</head>
<body>
	<h1>Sessions</h1>
	<a href="/login">Login</a>
	
	<form action="">
		<table>
			<tr>
				<th>Session ID</th>
				<th>Date</th>
				<th>Start Time</th>
				<th>Duration</th>
				<th>Location</th>
				<th>Counselor</th>
				<th>No of Seats</th>
				<th>Action</th>
			</tr>
			<c:forEach var="session" items="${sessions}">
			<tr>
				<td>${session.id}</td>
				<td>${session.date}</td>
				<td>${session.time}</td>
				<td>${session.duration}</td>
				<td>${session.location.name}</td>
				<td>${session.conselor.firstName}</td>
				<td>${session.capacity}</td>
				<td>
				<a href="session_edit/${session.id}">Edit</a>
					<a href="session_delete/${session.id}">Delete</a>
				</td>
			</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>