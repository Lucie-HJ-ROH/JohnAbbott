<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registration Form</title>
<style type="text/css">
	
	button {
		padding: 10px;
	}
	.error {
		color: red;
		font-style: italic;
	}
	form {
		display: table;
	}
	form div {
		display: table-row;
	}
	label, input, span, select {
		display: table-cell;
		margin: 5px;
		text-align: left;		
	}
	input[type=text], input[type=password], select, textarea {
		width: 200px;
		margin: 5px;
	}

	form div div {
		display: table-cell;
	}	
</style>
</head>
<body>
	<div align="center">
		<h2>User Registration</h2>
		<form:form action="register" method="post" modelAttribute="user">

            <div>
                <form:label path="email">E-mail:</form:label>
                <form:input path="email" />
                <form:errors path="email" cssClass="error" />
            </div>

            <div>
                <form:label path="plainPassword">Password:</form:label>
                <form:password path="plainPassword"/>
                <form:errors path="plainPassword" cssClass="error" />
            </div>

            <div>
                <form:label path="repassword">RE-Password:</form:label>
                <form:password path="repassword"/>
                <form:errors path="repassword" cssClass="error" />
                <span style="color: red">${user.passwordErrorMessage}</span>
            </div>

			<div>
			<form:label path="firstname">First name:</form:label>
			<form:input path="firstname" />
			<form:errors path="firstname" cssClass="error" />
			</div>

            <div>
                <form:label path="lastname">Last name:</form:label>
                <form:input path="lastname" />
                <form:errors path="lastname" cssClass="error" />
            </div>

            <div>
                <form:label path="phonenumber">Phone number:</form:label>
                <form:input path="phonenumber" />
                <form:errors path="phonenumber" cssClass="error"/>
            </div>


            <div>
                <form:label path="address">Address:</form:label>
                <form:input path="address" />
                <form:errors path="address" cssClass="error" />
            </div>

            <div>
                <form:label path="town">Town:</form:label>
                <form:input path="town" />
                <form:errors path="town" cssClass="error" />
            </div>

            <div>
                <form:label path="region">Region:</form:label>
                <form:input path="region" />
                <form:errors path="region" cssClass="error" />
            </div>

            <div>
                <form:label path="zip">Post/zip:</form:label>
                <form:input path="zip" />
                <form:errors path="zip" cssClass="error" />
            </div>

            <div>
                <form:label path="country">Country:</form:label>
                <form:input path="country" />
                <form:errors path="country" cssClass="error" />
            </div>

            <div>
				<div></div>
				<div>
				<form:button>Register</form:button>
				</div>
				<div></div>
			</div>
		</form:form>
	</div>
</body>
</html>