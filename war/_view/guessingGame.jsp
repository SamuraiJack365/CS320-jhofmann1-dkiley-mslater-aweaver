<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
	<head>
		<title>Guessing Game</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
	  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	</head>

	<body>
		<c:set var="page" scope="session" value="${'advisor'}"/>
        	<%@include file="../nav.jspf"%>
            <div class="container-fluid">
           		<div class="row">
			   		<div class="col-sm-4"></div>
			        <div class="col-sm-4"><h1>Advisor Homepage</h1></div>
			        <div class="col-sm-4"></div>
		        </div>
		        <div class="row">
		        	<div class="col-sm-4"><h2>Assigned Students</h2></div>
		        	<div class="col-sm-4"></div>
		        	<div class="col-sm-4"></div>
		        </div>
           	</div>
		</form>
	</body>
</html>