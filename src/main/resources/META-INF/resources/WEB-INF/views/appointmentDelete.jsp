<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Appointments</title>
</head>
<body>
<h1>Appointments</h1>
<a href="/appointmentManage">Manage Appointment</a><br/>
<a href="/login">Login</a>
	<table>
		<tr>
			<th>Appointment ID</th>
			<th>Date</th>
			<th>Start Time</th>
			<th>Duration</th>
			<th>Location</th>
			<th>Counselor</th>
			<th>No of Seats</th>
			<th>Customer Name</th>
			<th>Action</th>
		</tr>
		<c:forEach var="appt" items="${appointments}">
			<tr>
				<td>${appt.id}</td>
				<td>${appt.session.date}</td>
				<td>${appt.session.time}</td>
				<td>${appt.session.duration}</td>
				<td>${appt.session.location.building}</td>
				<td>${appt.session.counselor.firstName}</td>
				<td>${appt.session.capacity}</td>
				<td>${appt.person.getFullName()}</td>
				<td><a href="delete?apptID=${appt.id}">delete</a></td>
				</form>
			</tr>
		</c:forEach>
	</table>
</body>
</html>