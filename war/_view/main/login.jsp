<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
	<head>
		<title>Login</title>
		<meta charset="utf-8">
	  <meta name="viewport" content="width=device-width, initial-scale=1">
	  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<style type="text/css">
		.error {
			color: red;
		}
		
		td.label {
			text-align: right;
		}
		</style>
	</head>

	<body>
    <c:set var="page" scope="session" value="${'login'}"/>
	<%@include file="../../includes/nav.jspf"%>
	<div class="container-fluid">
		<c:if test="${! empty errorMessage}">
			<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
			<div class="alert alert-danger alert-dismissable">
			${errorMessage}
			</div>
		</c:if>
		<c:if test="${! empty result}">
			<c:if test="${result eq 'false'}">
				<div class="alert alert-danger alert-dismissable text-center">
				<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
				<span class="glyphicon glyphicon-alert"></span> Username and/or password incorrect! <span class="glyphicon glyphicon-alert"></span>
				</div>
			</c:if>
		</c:if>
		<div class="row">
			<div class="col-sm-4"></div>
			<div class="col-sm-4 well">
				<h3>Login:</h3>
				<form action="${pageContext.servletContext.contextPath}/login" method="post">
					<div class="form-group">
						<label for="username">Username:</label>
						<input type="text" name="username" class="form-control" id="username"  value="${username}" required>
					</div>
					<div class="form-group">
						<label for="password">Password:</label>
						<input type="password" name="password" class="form-control" id="password" value="${password}" required>
					</div>
					<div class="checkbox">
						<label><input type="checkbox"> Remember me</label>
					</div>
					<button type="submit" class="btn btn-default">Submit</button>
				</form>
			</div>
			<div class="col-sm-4"></div>
		</div>
			<%@include file="../../includes/nav2.jspf"%>
	</div>
	</body>
</html>