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
<title>Displaying Departments Details</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<style>
.error {
    font-weight: bold;
    color: red;
}
</style>
</head>
<body>
<jsp:include page="navbar.jsp"></jsp:include>
	<div class="container-fluid">
	    <br />
	    <h3>Departments</h3> <hr />
	    <div class="row">
        			<div class="col-lg-8 col-sm-6">
        						<table class="table table-bordered">
        							<thead>
        								<tr>
        									<th>Department ID</th>
        									<th>Dept. Short Desc</th>
        									<th>Dept. Long Desc</th>
        									<th>Edit/Delete</th>
        								</tr>
        							</thead>
        							<tbody>
        								<c:forEach items="${deptDtls}" var="dept">
        									<tr>
        										<td>${dept.deptId}</td>
        										<td>${dept.deptShortDesc}</td>
        										<td>${dept.deptLongDesc}</td>
        										<td>
                                                     <a href="editDept/${dept.deptId}" class="btn btn-primary">Edit</a>
                                                     <a href="deleteDept?deptId=${dept.deptId}" class="btn btn-danger">Delete</a>
                                                 </td>
        									</tr>
        								</c:forEach>
        							</tbody>
        						</table>
        					</div>
        				</div>
        			</div>

</body>
</html>