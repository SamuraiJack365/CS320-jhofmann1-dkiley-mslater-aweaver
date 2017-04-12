<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
	<head>
		
		<title>Student Home</title>
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
		<c:set var="page" scope="session" value="${'student'}"/>
		<%@include file="../../includes/nav.jspf"%>
		
		<c:if test="${! empty errorMessage}">
			<div class="error">${errorMessage}</div>
		</c:if>
	
	  	<div class="row">
	    <div class="form-group">
	    	<div class="col-sm-10">
	    		<button type="button" class="btn btn-primary btn-lg">Upload Commencement Media</button>
	    	</div>
    	</div>
    	
    	<div class="row">
	    <div class="form-group">
	    	<div class="col-sm-10">
	    		<button type="button" class="btn btn-primary btn-lg">Upload Commencement Media</button>
	    	</div>
    	</div>
    	
    	<div class="row">
	    <div class="form-group">
	    	<div class="col-sm-10">
	    		<button type="button" class="btn btn-primary btn-lg">Upload Commencement Media</button>
	    	</div>
    	</div>
    	
		</div>
		</form>
		</form>
	</body>
</html>