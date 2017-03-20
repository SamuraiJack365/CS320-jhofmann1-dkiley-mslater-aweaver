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
			<div class="col-sm-4"></div>
			<div class="col-sm-4"><h1>Student Home Page</h1></div>
			<div class="col-sm-4"></div>
		</div>
			
		<div class="row">	
			<div class="container">
			  <h2>Commencement Info</h2>
		
		  <form class="form-horizontal">
	      <div class="form-group">
	      <label class="control-label col-sm-2" for="firstName">First Name:</label>
	      <div class="col-sm-10">
	        <input type="string" class="form-control" id="firstName" placeholder="First Name">
	      </div>
	    </div>
	    
	    <div class="form-group">
	   	 <label class="control-label col-sm-2" for="lastName">Last Name:</label>
	   	    <div class="col-sm-10">          
	        	<input type="string" class="form-control" id="lastName" placeholder="Last Name">
    	 	</div>
   		 </div>
	    
	    <div class="form-group">
	   	 <label class="control-label col-sm-2" for="maj">Major(s):</label>
	   	    <div class="col-sm-10">          
	        	<input type="string" class="form-control" id="maj" placeholder="Major(s)">
    	 	</div>
   		 </div>
   		 
   		 <div class="form-group">
	   	 <label class="control-label col-sm-2" for="min">Minor(s):</label>
	   	    <div class="col-sm-10">          
	        	<input type="string" class="form-control" id="min" placeholder="Minor(s)">
    	 	</div>
   		 </div>
   		 
   		 <div class="form-group">
	   	 <label class="control-label col-sm-2" for="honors">Honors:</label>
	   	    <div class="col-sm-10">          
	        	<input type="string" class="form-control" id="honors" placeholder="Honors (100 character max)">
    	 	</div>
   		 </div>
	    
	    <div class="form-group">
	   	 <label class="control-label col-sm-2" for="gpa">GPA:</label>
	   	    <div class="col-sm-10">          
	        	<input type="string" class="form-control" id="gpa" placeholder="GPA">
    	 	</div>
   		 </div>
   		 
   		 <div class="form-group">
	   	 <label class="control-label col-sm-2" for="sports">Sports:</label>
	   	    <div class="col-sm-10">          
	        	<input type="string" class="form-control" id="sports" placeholder="Sports (if applicable)">
    	 	</div>
   		 </div>
   		 
   		 <div class="form-group">
	   	 <label class="control-label col-sm-2" for="clubs">Clubs:</label>
	   	    <div class="col-sm-10">          
	        	<input type="string" class="form-control" id="clubs" placeholder="Clubs (if applicable)">
    	 	</div>
   		 </div>  
   		 
	    <div class="form-group">        
	      		<div class="col-sm-offset-2 col-sm-10">
	        		<button type="submit" class="btn btn-default">Submit</button>
	      		</div>
	    	</div>
	  		</form>
		</div>
   		</div>
   		
   		<div class="row">
   		<form class="form-vertical">
   		<div class="form-group">
   			<div class="col-sm-offset-2 col-sm-10">
   				<h2>Commencement Media</h2>
   			</div>
	    </div>
	    </div>
	  
	  	<div class="row">
	    <div class="form-group">
	    	<div class="col-sm-offset-3 col-sm-10">
	    		<button type="button" class="btn btn-primary btn-lg">Upload Pictures</button>
	    	</div>
    	</div>
		<div class="form-group">
			<div class="col-sm-offset-3 col-sm-10">
   				<button type="button" class="btn btn-primary btn-lg">Upload Video Clip</button>
   			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-3 col-sm-10">
    			<button type="button" class="btn btn-primary btn-lg">Upload Audio Clip</button>
    		</div>
		</div>
		</div>
		</form>
		</form>
	</body>
</html>