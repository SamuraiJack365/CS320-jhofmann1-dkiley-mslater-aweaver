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
	        <input type="string" class="form-control" id="firstName" placeholder=${firstName}>
	      </div>
	    </div>
	    
	    <div class="form-group">
	   	 <label class="control-label col-sm-2" for="lastName">Last Name:</label>
	   	    <div class="col-sm-10">          
	        	<input type="string" class="form-control" id="lastName" placeholder=${lastName}>
    	 	</div>
   		 </div>
	    
	    <div class="form-group">
	   	 <label class="control-label col-sm-2" for="maj">Major(s):</label>
	   	    <div class="col-sm-10">          
	        	<select name="major1" class="form-control" id="major1">
	        		<option value=${major1}>${major1title}</option>
	        		<c:forEach var="major" items="${major}"> 
	        			<option value="${major.key}">${major.value}</option>
	        		</c:forEach>
        		</select>
        		
        		<select name="major2" class="form-control" id="major2">
        			<option value=${major2}>${major2title}</option>
	        		<c:forEach var="major" items="${major}"> 
	        			<option value="${major.key}">${major.value}</option>
	        		</c:forEach>
        		</select>
    	 	</div>
   		 </div>
   		 
   		<div class="form-group">
	   	 <label class="control-label col-sm-2" for="min">Minor(s):</label>
	   	    <div class="col-sm-10">          
	        	<select name="minor1" class="form-control" id="minor1">
	        		<option value=${minor1}>${minor1title}</option>
	        		<c:forEach var="minor" items="${minor}"> 
	        			<option value="${minor.key}">${minor.value}</option>
	        		</c:forEach>
        		</select>
        		
        		<select name="minor2" class="form-control" id="minor2">
        			<option value=${minor2}>${minor2title}</option>
	        		<c:forEach var="minor" items="${minor}"> 
	        			<option value="${minor.key}">${minor.value}</option>
	        		</c:forEach>
        		</select>
    	 	</div>
   		 </div>

   		 
   		 <div class="form-group">
	   	 <label class="control-label col-sm-2" for="honors">Honors:</label>
	   	    <div class="col-sm-10">          
	        	<input type="string" class="form-control" id="honors" placeholder=${honors}>
    	 	</div>
   		 </div>
	    
	    <div class="form-group">
	   	 <label class="control-label col-sm-2" for="gpa">GPA:</label>
	   	    <div class="col-sm-10">          
	        	<input type="string" class="form-control" id="gpa" placeholder=${gpa}>
    	 	</div>
   		 </div>
   		 
   		 <div class="form-group">
	   	 <label class="control-label col-sm-2" for="min">Sport(s):</label>
	   	    <div class="col-sm-10">          
	        	<select name="sport1" class="form-control" id="sport1">
	        		<option value=${sport1}>${sport1title}</option>
	        		<c:forEach var="sport" items="${sport}"> 
	        			<option value="${sport.key}">${sport.value}</option>
	        		</c:forEach>
        		</select>
        		
        		<select name="sport2" class="form-control" id="sport2">
        			<option value=${sport2}>${sport2title}</option>
	        		<c:forEach var="sport" items="${sport}"> 
	        			<option value="${sport.key}">${sport.value}</option>
	        		</c:forEach>
        		</select>
    	 	</div>
   		 </div>
   		 
   		 <div class="form-group">
	   	 <label class="control-label col-sm-2" for="min">Club(s):</label>
	   	    <div class="col-sm-10">          
	        	<select name="club1" class="form-control" id="club1">
	        		<option value=${club1}>${club1title}</option>
	        		<c:forEach var="club" items="${club}"> 
	        			<option value="${club.key}">${club.value}</option>
	        		</c:forEach>
        		</select>
        		
        		<select name="club2" class="form-control" id="club2">
        			<option value=${club2}>${club2title}</option>
	        		<c:forEach var="club" items="${club}"> 
	        			<option value="${club.key}">${club.value}</option>
	        		</c:forEach>
        		</select>

			<select name="club3" class="form-control" id="club3">
        			<option value=${club3}>${club3title}</option>
	        		<c:forEach var="club" items="${club}"> 
	        			<option value="${club.key}">${club.value}</option>
	        		</c:forEach>
        		</select>
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
	  	
	  	<div class="btn-group col-sm-offset-2" data-toggle="buttons">
  			<label class="btn btn-primary active">
    			<input type="radio" name="layout" id="layout1" autocomplete="off"> Layout 1
  			</label>
 			<label class="btn btn-primary">
   				<input type="radio" name="layout" id="layout2" autocomplete="off"> Layout 2
 			</label>
  			<label class="btn btn-primary">
    			<input type="radio" name="layout" id="layout3" autocomplete="off"> Layout 3
  			</label>
		</div>
	  	
	  	<div class="row">
	    <div class="form-group">
	    	<div class="col-sm-offset-5 col-sm-10">
	    		<button type="button" class="btn btn-primary btn-lg">Upload Commencment Media</button>
	    	</div>
    	</div>
    	
		</div>
		</form>
		</form>
	</body>
</html>