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
	<a href="/appointmentDelete">Delete Appointment</a><br/>
<a href="/login">Login</a>
<span>${errorMsg}</span>
		<table>
			<tr>
				<th>Session ID</th>
				<th>Date</th>
				<th>Start Time</th>
				<th>Duration</th>
				<th>Location</th>
				<th>Counselor</th>
				<th>Available Seats</th>
				<th>Customers</th>
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
				<td>${session.capacity-session.attendees.size()}</td>
				
				<form action="apptRegisterCustomer/${session.id}/" method="post">
				<td>
				<select id="person" name="person">
				<c:forEach var="person" items="${persons}">
				<option id="1" value="${person.username}">${person.username}</option>
				</c:forEach>
				</select>
				</td>
				<td>
				<input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
				<input type="submit" value="Make appointment">
				</td>
			</tr>
				</form>
			</c:forEach>
		</table>

</body>
</html>
