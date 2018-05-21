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
		<div class="title">Πρόσθεσε Επιβάτη</div>

		<form action="AddPassenger" method="post">
			<fieldset>
				<div class="form-group">
					<label for="first-name" class="inputLabel">Όνομα: </label> <input
						name="first-name" type="text"></input>
				</div>
				<div class="form-group">
					<label for="last-name" class="inputLabel">Επώνυμο: </label> <input
						name="last-name" type="text"></input>
				</div>
				<div class="form-group">
					<label for="dob" class="inputLabel">Ημερομηνία Γέννησης: </label> <input
						name="dob" type="text"></input>
				</div>
				<div class="form-group">
					<label for="gender" class="form-control">Φύλλο: </label> <select
						name="gender">
						<option value="Male">Άνδρας</option>
						<option value="Female">Γυναίκα</option>
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