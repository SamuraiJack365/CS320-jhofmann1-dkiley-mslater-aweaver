<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <html>

    <head>
        <title>${firstname} ${lastname}</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>

    <body>
        <c:set var="page" scope="session" value="${'layout'}" />
        <%@include file="../../includes/nav.jspf"%>
            <div class="container-fluid jumbotron">
                <div class="container-fluid jumbotron">
                    <div class="row">
                        <div class="col-sm-6">
                            <c:if test="${not empty sports[0]}">
                                <table class="table table-striped text-center">
                                    <thead>
                                        <tr>
                                            <th class="text-center">Sport<c:if test="${not empty sports[1]}">s</c:if></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td>${sports[0]}</td>
                                        </tr>
                                        <c:if test="${not empty sports[1]}">
                                        <tr>
                                            <td>${sports[1]}</td>
                                        </tr>
                                        </c:if>
                                    </tbody>
                                </table>
                            </c:if>
                            <c:if test="${not empty clubs[0]}">
                                <table class="table table-striped text-center">
                                    <thead>
                                        <tr>
                                            <th class="text-center">Club<c:if test="${not empty clubs[1]}">s</c:if></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td>${clubs[0]}</td>
                                        </tr>
                                        <c:if test="${not empty clubs[1]}">
                                        <tr>
                                            <td>${clubs[1]}</td>
                                        </tr>
                                        </c:if>
                                    </tbody>
                                </table>
                            </c:if>
                        </div>
                        <div class="col-sm-6"><img src="${studentpic}" class="img-rounded img-responsive center-block" alt="Student Picture"></div>
                    </div>
                    <div class="row">
                        <div class="col-sm-4"></div>
                        <div class="col-sm-4">
                            <h1 class="text-center">${firstname} ${lastname} <c:if test="${isGPA}"><small>GPA: <small>${GPA}</small></small></c:if></h1>
                        </div>
                        <div class="col-sm-4"></div>
                    </div>
                    <div class="row">
                        <div class="col-sm-4"></div>
                        <div class="col-sm-4 text-center">
                            <h3>${majors[0]} <small><c:out value="${ not empty minors[0] ? minors[0] : null }"></c:out></small></h3>
                        </div>
                        <div class="col-sm-4"></div>
                    </div>
                </div>
            </div>
                <%@include file="../../includes/nav2.jspf"%>
    </body>

    </html>
