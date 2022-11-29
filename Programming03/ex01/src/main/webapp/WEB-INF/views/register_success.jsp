<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Success</title>
<style type="text/css">
	span {
		display: inline-block;
		width: 200px;
		text-align: left;
	}
</style>
</head>
<body>
	<div align="center">
		<h2>Registration Succeeded!</h2>

		<span>E-mail:</span><span>${user.email}</span><br/>
		<span>Password:</span><span>${user.password}</span><br/>
        <span>First name:</span><span>${user.firstname}</span><br/>
        <span>Last name:</span><span>${user.lastname}</span><br/>
		<span>Phone number:</span><span>${user.phonenumber}</span><br/>
		<span>Address:</span><span>${user.address}</span><br/>
		<span>Town:</span><span>${user.town}</span><br/>
		<span>Region:</span><span>${user.region}</span><br/>
		<span>Post/zip:</span><span>${user.zip}</span><br/>
		<span>Country:</span><span>${user.country}</span><br/>
	</div>
</body>
</html>