<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Appointment</title>
</head>
<body>
	<h1>Sessions</h1>
	<a href="/login">Login</a>


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
				<td>${session.location.building}</td>
				<td>${session.counselor.firstName}</td>
				<td>${session.capacity}</td>
				<td><a href="save?sessionID=${session.id}">signup</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>