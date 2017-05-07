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
            <c:set var="page" scope="session" value="${'home'}" />
            <%@include file="../../includes/nav.jspf"%>
                <div class="container-fluid">
                    <c:if test="${! empty errorMessage}">
                        <div class="alert alert-danger">
                            ${errorMessage}
                        </div>
                    </c:if>
                    <c:if test="${! empty result}">
                        <c:if test="${result eq 'true'}">
                            <div class="alert alert-success alert-dismissable">
                                <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a> Login of ${username} successful! Not that it matters because nothing is secure and everything is a lie!
                            </div>
                        </c:if>
                    </c:if>
                    <div class="row">
                        <div class="col-sm-4"></div>
                        <div class="col-sm-4">
                            <h1>My Commencement</h1>
                        </div>
                        <div class="col-sm-4"></div>
                    </div>
                    <div class="row">
                        <div class="col-sm-2"></div>
                        <div class="col-sm-8 well">
                            <p>MyCommencement is a web based application that will allow a student to personalize their graduation ceremony! 
                            A student inputs data and a page displaying it will be generated based on what they provide, which will then be displayed on a screen during the ceremony!</p>
                        </div>
                        <div class="col-sm-2 well">
                            <c:if test="${loggedin ne 'true'}">
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
                            </c:if>
                            <c:if test="${loggedin eq 'true'}">
                                <h3>Welcome:</h3>
                                <p>${user}</p>
                            </c:if>
                        </div>
                        <%@include file="../../includes/nav2.jspf"%>
                    </div>
                </div>
        </body>

        </html>
