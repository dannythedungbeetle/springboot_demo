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
<title>Displaying Employee Details</title>
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
	    <div class="row">
	        <div class="col-lg-6 col-sm-6">
	            <br />
	            <div class="card">
	            <div class="card-header bg-success">Search</div> <br />
                	<div class="card-body">
	                <form:form class="form-inline" method="get" name="searchForm" action="findByLastName">
	                <div class="form-group">
                        <label for="lastName">Last Name </label>
                        <input type="text" name="lastName" class="form-control" placeholder="Enter last name">
                        <button type="submit" class="btn btn-primary">Submit</button>
                      </div>
	                </form:form>
	                </div>
	            </div>
	        </div>
	    </div>
	    <br />
		<div class="row">
			<div class="col-lg-8 col-sm-6">
				<div class="card">
					<div class="card-header bg-primary">Employee Details</div> <br />
					<div class="card-body">
						<table class="table table-bordered">
							<thead>
								<tr>
									<th>EmployeeID</th>
									<th>First Name</th>
									<th>Last Name</th>
									<th>Dept.</th>
									<th>Salary</th>
									<th>Edit/Delete</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${employeeDetails}" var="emp">
									<tr>
										<td>${emp.empId}</td>
										<td>${emp.firstName}</td>
										<td>${emp.lastName}</td>
										<td>${emp.deptLongDesc}</td>
										<td>${emp.salary}</td>
										<td>
                                             <a href="editEmployee/${emp.empId}" class="btn btn-primary">Edit</a>
                                             <a href="deleteEmployee?empId=${emp.empId}" class="btn btn-danger">Delete</a>

                                         </td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-8 col-sm-8 ">
				<div class="card">
					<div class="card-header bg-primary">Enter New Employee Details</div> <br />
					<div class="card-body">
						<form:form method="post" name="formOne" modelAttribute="employee"
							action="/addEmployee">
							<div class="form-group">
							<!-- a path attribute – this must correspond to a getter/setter of the model attribute -->
								<form:input type="text" path="firstName" class="form-control"
									placeholder="First name" />
									<form:errors path="firstName" cssClass="error" />
							</div>
							<div class="form-group">
								<form:input type="text" path="lastName" class="form-control"
									placeholder="Last name" />
									<form:errors path="lastName" cssClass="error" />
							</div>
							<div class="form-group">
								<form:select items="${depts}" class="form-control" path="deptId" />
								<form:errors path="deptId" cssClass="error" />
							</div>
							<div class="form-group">
								<form:input type="number" path="salary" class="form-control"
									placeholder="Salary" />
								<form:errors path="salary" cssClass="error" />
							</div>
							<div class="form-group">
                                <form:input type="email" path="email" class="form-control"
                                    placeholder="Email" />
                                <form:errors path="email" cssClass="error" />
                            </div>
							<input type="submit" class="btn btn-success" value="Submit" />
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>