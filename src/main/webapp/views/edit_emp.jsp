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
<title>Edit Employee Details</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</head>
<body>
<jsp:include page="navbar.jsp"></jsp:include>
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-8 col-sm-10 ">
				<div class="card">
					<div class="card-header bg-primary">Employee Details</div>
					<div class="card-body">
                            <form:form method="post" name="editForm" modelAttribute="empModel" action="updateEmployee">
                                <div class="form-group">
                                    <!-- a path attribute – this must correspond to a getter/setter of the model attribute -->
                                    <label for="">Firstname</label>
                                    <form:input type="text" path="firstName" class="form-control"
                                placeholder="First name" />
                                </div>
                                <div class="form-group">
                                    <label for="">Lastname</label>
                                    <form:input type="text" path="lastName" class="form-control"
                                placeholder="Last name" />
                                </div>
                                <div class="form-group">
                                    <label for="">Department</label>
                                    <form:input type="text" path="deptId" class="form-control"
                                placeholder="Dept." />
                                </div>
                                <div class="form-group">
                                    <label for="">Salary</label>
                                    <form:input type="text" path="salary" class="form-control"
                                placeholder="Salary" />
                                <div class="form-group">
                                    <label for="">Emp Id</label>
                                    <form:input type="text" path="empId" disable="disabled" class="form-control" />
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