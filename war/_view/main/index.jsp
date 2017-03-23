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
	<%@include file="../../includes/nav.jspf"%>
	<div class="container-fluid">
		<c:if test="${! empty errorMessage}">
			<div class="alert alert-danger">
			${errorMessage}
			</div>
		</c:if>
		<div class="row">
			<div class="col-sm-4"></div>
			<div class="col-sm-4"><h1>My Commencement</h1></div>
			<div class="col-sm-4"></div>
		</div>
		<div class="row">
			<div class="col-sm-2"></div>
			<div class="col-sm-8 well">
				<p>Lorem ipsum dolor sit amet, sit ne omnis ipsum, quo ex unum inani legere. Eam perfecto expetendis instructior id. Usu ex alii fastidii. Illud semper reprehendunt his cu, ei vix possim persius. Hinc convenire eum eu.</p>
				<p>Delenit placerat ius ea, cu vis ornatus detraxit disputando. Eam commodo legimus ei, qui accusam fabellas hendrerit ei, cu pro quaeque inimicus. Nam at legimus dolores hendrerit, alia principes pri te. No eam nostro oblique. Vel nonumes nusquam ne, ius illud mollis delicatissimi eu. Primis cetero ocurreret ne his.</p>				
				<p>No vis enim perfecto appellantur, an aliquid consulatu his. His at suas iriure euismod. Ei hinc vocent duo. At vim quaeque legimus, id senserit suavitate sea, vim ei commodo vocibus referrentur. Cum nonumes facilisi ex, eam ex porro scaevola, eu eum sensibus sapientem. Sea idque delicata accommodare ea, vidit primis fabellas sea id. Et mel aeque delicata moderatius, sit meis semper adversarium eu.</p>				
				<p>Dictas dolores lobortis at vel, eam ne lucilius perpetua. Et brute facer pro. Everti rationibus sententiae ea nec. Inermis hendrerit neglegentur ea his, no quem dico quo.</p>				
				<p>Possit atomorum salutandi vix ut. Ne pri mollis probatus hendrerit, ne usu adhuc sonet. Ei qui graece invidunt intellegat. No qui maluisset aliquando. Choro exerci prodesset duo eu, agam paulo deleniti te mea. Illum veniam nam ut.</p>
			</div>
			<div class="col-sm-2 well">
				<h3>Login:</h3>
				<form action="${pageContext.servletContext.contextPath}/login" method="post">
					<div class="form-group">
						<label for="username">Username:</label>
						<input type="username" name="username" class="form-control" id="username">
					</div>
					<div class="form-group">
						<label for="pwd">Password:</label>
						<input type="password" name="password" class="form-control" id="pwd">
					</div>
					<div class="checkbox">
						<label><input type="checkbox"> Remember me</label>
					</div>
					<button type="submit" class="btn btn-default">Submit</button>
				</form>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-4"></div>
			<div class="col-sm-4">
				<div class="list-group">
					<a href="#" class="list-group-item">- Home</a>
					<a href="#" class="list-group-item">- Login</a>
					<a href="#" class="list-group-item">- About</a>
				</div>
			</div>
			<div class="col-sm-4"></div>
		</div>
	</div>
	</body>
</html>