<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
	<a class="navbar-brand" href="/">Employee Management</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarTogglerDemo02">
		<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
			<li class="nav-item"><a class="nav-link" href="home">Home</a></li>
			<li class="nav-item"><a class="nav-link" href="depts">Department</a>
			</li>
			<li class="nav-item"><a class="nav-link" href="employees">Employee</a>
			</li>


		</ul>
		<form class="form-inline my-2 my-lg-0">
			<c:if test="${pageContext.request.userPrincipal.name != null}">
			<span style="color:white;"><b>Welcome	${pageContext.request.userPrincipal.name} </b>! </span>
			<a class="btn btn-primary"
					onclick="document.forms['logoutForm'].submit()"> Logout</a>
			</c:if>

		</form>
	</div>
</nav>
<c:if test="${pageContext.request.userPrincipal.name != null}">
	<form id="logoutForm" method="POST" action="${contextPath}/logout">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>


</c:if>
