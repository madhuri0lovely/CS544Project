<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Session</title>
</head>
<body>
	<h1>edit session</h1>
	<h2>Information of Session Id : ${sessionForUpdated.id}</h2>


	<form:form modelAttribute="sessionForUpdated" method="POST"
		enctype="multipart/form-data"
		action="/session_edit/${sessionForUpdated.id}">
		<div>
			<p>
				<label for="capacity">capacity</label>
				<form:input path="capacity" id="capacity" />
			</p>

			<p>
				<label for="conselor">conselor</label>
				<form:select path="conselor" id="conselor">
					<form:option value="${sessionForUpdated.conselor.id}"
						label="${sessionForUpdated.conselor.firstName}" />
					<form:options path="conselor" items="${conselors}" />
				</form:select>
			</p>

			<p>
				<label for="date">Date</label>
				<form:input path="date" id="date" />
			</p>

			<p>
				<label for="time">Start Time</label>
				<form:input path="time" id="time" />
			</p>

			<p>
				<label for="location">Location</label>
				<form:select path="location" id="location" itemValue="location"
					itemLabel="location">
					<form:option value="${sessionForUpdated.location.id}"
						label="${sessionForUpdated.location.name}" />
					<form:options path="location" items="${locations}" />
				</form:select>
			</p>

			<p>
				<label for="duration">Duration</label>
				<form:input path="duration" id="duration" />
			</p>

			<p id="buttons">
				<input type="submit" name="submit" type="submit" value="Save">
			</p>

		</div>
	</form:form>


</body>
</html>