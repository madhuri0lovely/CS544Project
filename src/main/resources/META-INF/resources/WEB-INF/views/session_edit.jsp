<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<script type="text/javascript">
	function validateForm() {
		var date = document.getElementById("date").value;
		var date_format = /^(19|20)\d{2}\/(0?[1-9]|1[0-2])\/(0?[1-9]|1\d|2\d|3[01])$/;

		if (!date.match(date_format)) {
			alert("Date is invalid! it should be yyyy/mm/dd");
			return false;
		}
		return true;
	}
</script>

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
				<form:errors path="capacity" cssStyle="Color:RED"></form:errors>
			</p>

			<p>
				<label for="counselor">counselor</label>
				<form:select path="counselor" id="counselor">
					<form:option value="${sessionForUpdated.counselor.id}"
						label="${sessionForUpdated.counselor.firstName}" />
					<form:options path="counselor" items="${counselors}" />
				</form:select>
				
				<form:errors path="counselor" cssStyle="Color:RED"></form:errors>
			</p>

			<p>
				<label for="date">Date</label>
				<form:input path="date" id="date" />
				<form:errors path="date" cssStyle="Color:RED"></form:errors>
			</p>

			<p>
				<label for="time">Start Time</label>
				<form:select path="time" id="time" itemValue="time" itemLabel="time">
					<form:option value="${sessionForUpdated.time}"
						label="${sessionForUpdated.time}" />
					<form:options path="time" items="${times}" />
				</form:select>
				<form:errors path="time" cssStyle="Color:RED"></form:errors>
			</p>

			<p>
				<label for="location">Location</label>
				<form:select path="location" id="location" itemValue="location"
					itemLabel="location">
					<form:option value="${sessionForUpdated.location.id}"
						label="${sessionForUpdated.location.name}" />
					<form:options path="location" items="${locations}" />
				</form:select>
				<form:errors path="location" cssStyle="Color:RED"></form:errors>
			</p>

			<p>
				<label for="duration">Duration</label>
				<form:input path="duration" id="duration" />
				<form:errors path="duration" cssStyle="Color:RED"></form:errors>
			</p>
			

			<p id="buttons">
				<td><form:button id="btnSubmit" type="submit" onclick="return validateForm();">Update</form:button></td>
			</p>

		</div>
	</form:form>


</body>
</html>