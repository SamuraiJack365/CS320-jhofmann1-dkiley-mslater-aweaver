<<<<<<< HEAD
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
	<head>
		<title>Index</title>
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
    <c:set var="page" scope="session" value="${'home'}"/>
	<%@include file="../nav.jspf"%>
	<%-- <jsp:include page="../nav.html" /> --%>
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-4"></div>
			<div class="col-sm-4"><h1>My Commencement</h1></div>
			<div class="col-sm-4"></div>
		</div>
		<div class="row">
			<div class="col-sm-4"></div>
				<c:if test="${! empty errorMessage}">
					<div class="alert alert-danger">
					${errorMessage}
					</div>
				</c:if>
				<div class="col-sm-4"><input type="button" class="btn btn-default" name="guessing" value="guessing" onclick="location.href='${pageContext.servletContext.contextPath}/guessingGame'"></div>
			<div class="col-sm-4"></div>
		</div>
	</div>
	</body>
=======
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
	<head>
		<title>Index</title>
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
    <c:set var="page" scope="session" value="${'home'}"/>
	<%@include file="../nav.jspf"%>
	<%-- <jsp:include page="../nav.html" /> --%>
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-4"></div>
			<div class="col-sm-4"><h1>My Commencement</h1></div>
			<div class="col-sm-4"></div>
		</div>
		<div class="row">
			<div class="col-sm-4"></div>
				<c:if test="${! empty errorMessage}">
					<div class="alert alert-danger">
					${errorMessage}
					</div>
				</c:if>
				<div class="col-sm-4"><input type="button" class="btn btn-default" name="guessing" value="guessing" onclick="location.href='${pageContext.servletContext.contextPath}/guessingGame'"></div>
			<div class="col-sm-4"></div>
		</div>
	</div>
	</body>
>>>>>>> refs/remotes/origin/master
</html>