<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Appointment Management System</title>

	<script src="https://code.jquery.com/jquery-1.9.1.min.js"></script>
    <!-- Bootstrap -->
    <link href="/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" href="/css/font-awesome.min.css">
	<link href="/css/animate.min.css" rel="stylesheet">
    <link href="/css/prettyPhoto.css" rel="stylesheet">      
	<link href="/css/main.css" rel="stylesheet">
	 <link href="/css/responsive.css" rel="stylesheet">
	 <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->       
    
  </head>
<body>
	<%@ include file="../header.jsp"%>
	<section id="sessions">
	<form action="">
	<div class="container">
	<div class="row">
        <div class="col-md-12">
       	</div>
    </div>
    <div class="row">
        <div class="col-md-12">
   		<div class="table-responsive">
		<table class="table table-bordred table-striped">
			 <thead>
				<th>Session ID</th>
				<th>Date</th>
				<th>Start Time</th>
				<th>Duration</th>
				<th>Location</th>
				<th>Counselor</th>
				<th>Available Seats</th>
				<th>Customers</th>
				<th>Action</th>
			</thead>
			<tbody>
			<c:forEach var="session" items="${sessions}">
				
			<tr>
				<td>${session.id}</td>
				<td>${session.date}</td>
				<td>${session.time}</td>
				<td>${session.duration}</td>
				<td>${session.location.building}</td>
				<td>${session.counselor.firstName}</td>
				<td>${session.capacity-session.attendees.size()}</td>
				
				<form action="/admin/apptRegisterCustomer/${session.id}" method="post">
					<td>
						<select id="person" name="person" class="form-control">
							<c:forEach var="person" items="${persons}">
								<option id="1" value="${person.username}">${person.username}</option>
							</c:forEach>
						</select>
					</td>
					<td>
						<input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
						<input type="submit" value="Make appointment" class="btn btn-primary btn-lg">
					</td>
				</form>
			</tr>
			</c:forEach>
			</tbody>
		</table>
		
		<div class="modal fade" id="myModal" role="dialog">
				<div class="modal-dialog">

					<!-- Modal content-->
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h4 class="modal-title">Notification</h4>
						</div>
						<div class="modal-body">
							<p>The customer already has appointment on this session.</p>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">Close</button>
						</div>
					</div>

				</div>
			</div>
	</div>
	</div>
	</div>
</form>
</section>

    <section id="bottom">
        <div class="container wow fadeInDown" data-wow-duration="1000ms" data-wow-delay="600ms">
            <div class="row">
                <div class="col-md-3 col-sm-6">
                    <div class="widget">
                        <h3>Company</h3>
                        <ul>
                            <li><a href="#">About us</a></li>
                            <li><a href="#">We are hiring</a></li>
                            <li><a href="#">Meet the team</a></li>
                            <li><a href="#">Copyright</a></li>                           
                        </ul>
                    </div>    
                </div><!--/.col-md-3-->

                <div class="col-md-3 col-sm-6">
                    <div class="widget">
                        <h3>Support</h3>
                        <ul>
                            <li><a href="#">Faq</a></li>
                            <li><a href="#">Blog</a></li>
                            <li><a href="#">Forum</a></li>
                            <li><a href="#">Documentation</a></li>                          
                        </ul>
                    </div>    
                </div><!--/.col-md-3-->

                <div class="col-md-3 col-sm-6">
                    <div class="widget">
                        <h3>Developers</h3>
                        <ul>
                            <li><a href="#">Web Development</a></li>
                            <li><a href="#">SEO Marketing</a></li>
                            <li><a href="#">Theme</a></li>
                            <li><a href="#">Development</a></li>
                        </ul>
                    </div>    
                </div><!--/.col-md-3-->

                <div class="col-md-3 col-sm-6">
                    <div class="widget">
                        <h3>Our Partners</h3>
                        <ul>
                            <li><a href="#">Adipisicing Elit</a></li>
                            <li><a href="#">Eiusmod</a></li>
                            <li><a href="#">Tempor</a></li>
                            <li><a href="#">Veniam</a></li>                           
                        </ul>
                    </div>    
                </div><!--/.col-md-3-->
            </div>
        </div>
    </section><!--/#bottom-->
	
	<div class="top-bar">
		<div class="container">
			<div class="row">
			    <div class="col-lg-12">
				   <div class="social">
						<ul class="social-share">
							<li><a href="#"><i class="fa fa-facebook"></i></a></li>
							<li><a href="#"><i class="fa fa-twitter"></i></a></li>
							<li><a href="#"><i class="fa fa-linkedin"></i></a></li> 
							<li><a href="#"><i class="fa fa-dribbble"></i></a></li>
							<li><a href="#"><i class="fa fa-skype"></i></a></li>
						</ul>
				   </div>
                </div>
			</div>
		</div><!--/.container-->
	</div><!--/.top-bar-->
	
	<%@ include file="../footer.jsp"%>
	
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="/js/jquery.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    <script src="/js/jquery.prettyPhoto.js"></script>
    <script src="/js/jquery.isotope.min.js"></script>   
    <script src="/js/wow.min.js"></script>
	<script src="/js/main.js"></script>
	
	<script>
		$(document).ready(function() {
			var value = "<c:out value="${errorMsg}"/>"
			// 		alert(paramOne);
			if (value == 'The customer already has appointment on this session') {
				$('#myModal').modal('toggle');
			}
		});
	</script>
  </body>
</html>