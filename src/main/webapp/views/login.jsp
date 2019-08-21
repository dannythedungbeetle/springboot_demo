<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE HTML>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container-fluid">
	    <div class="container-fluid" style="padding-bottom: 30px; text-align: center;">

        		<c:if test="${not empty errorMessge}">
        			<div style="color: red; font-weight: bold; margin: 30px 0px;">${errorMessge}</div>
        		</c:if>

        		<form name='login' action="/login" method='POST' class="form-inline justify-content-center">
        			<table>
        				<tr>
        					<td>UserName:</td>
        					<td><input type='text' name='username' class="form-control"
        						value=''></td>
        				</tr>
        				<tr>
        					<td>Password:</td>
        					<td><input type='password' class="form-control"
        						name='password' /></td>
        				</tr>
        				<tr>
        					<td colspan='2'><input name="submit" type="submit"
        						class="btn btn-primary" value="Login" /></td>
        				</tr>
        			</table>
        			<input type="hidden" name="${_csrf.parameterName}"
        				value="${_csrf.token}" />
        		</form>
        	</div>
	</div>
</body>
</html>