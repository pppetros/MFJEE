<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>PPP Airlines</title>
<link rel="stylesheet" href="resources/css/bootstrap-reboot.css" />
<link rel="stylesheet" href="resources/css/bootstrap.css" />
</head>
<body>
	<h2>Welcome Aboard with PPP Airlines!</h2>
	<h3>Καλώς ορίσατε!</h3>

	<div class="container">
		<h3 class="title">Πρόσθεσε Επιβάτη</h3>
		
		<%
			if (request.getAttribute("errors") != null) {	
		 %>
			 <fieldset class="alert-danger" style="border:1px;">
				 <legend>Errors</legend>
				 <ul>
				 	<% if (request.getAttribute("firstname_error") != null) { %>
				 		<li class="error">First name error</li>
				 	<% } %>
				 	<% if (request.getAttribute("lastname_error") != null) { %>
				 		<li class="error">Last name error</li>
				 	<% } %>
				 	<% if (request.getAttribute("date_format_error") != null) { %>
				 		<li class="error">Date of birth invalid</li>
				 	<% } %>
				 </ul>
			 </fieldset>
		 <%
		 	}
		  %>

		<form action="AddPassenger" method="post">
			<fieldset>
				<div class="form-group">
					<label for="first-name" class="inputLabel">Όνομα: </label> <input
						name="first-name" type="text" value="<%=request.getAttribute("first-name") %>"></input>
				</div>
				<div class="form-group">
					<label for="last-name" class="inputLabel">Επώνυμο: </label> <input
						name="last-name" type="text"  value="<%=request.getAttribute("last-name") %>"></input>
				</div>
				<div class="form-group">
					<label for="dob" class="inputLabel">Ημερομηνία Γέννησης: </label> <input
						name="dob" type="text" value="<%=request.getAttribute("dob") %>"></input>
				</div>
				<div class="form-group">
					<label for="gender" class="form-control">Φύλλο: </label> <select
						name="gender">
						<option value="Male" <%= (request.getAttribute("gender").equals("Male"))?"selected=\"selected\"":"" %> >Άνδρας</option>
						<option value="Female" <%= (request.getAttribute("gender").equals("Female"))?"selected=\"selected\"":"" %> >Γυναίκα</option>
					</select>
				</div>
			</fieldset>
			<div class="form-group" id="submitField">
				<input id="submitBtn" class="btn btn-primary" type="submit" value="Προσθήκη νέου επιβάτη"></input>
			</div>
		</form>

	</div>
</body>
</html>