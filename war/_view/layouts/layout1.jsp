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
                <div class="row">
                    <div class="col-sm-4">
                        <table class="table table-striped text-center">
                            <thead>
                                <tr>
                                    <th class="text-center">Major<c:if test="${not empty majors[1]}">s</c:if></th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>${majors[0]}</td>
                                </tr>
                                <c:if test="${not empty majors[1] && majors[1] != 0}">
                                    <tr>
                                        <td>${majors[1]}</td>
                                    </tr>
                                </c:if>
                                <c:if test="${not empty majors[2]  && majors[2] != 0}">
                                    <tr>
                                        <td>${majors[2]}</td>
                                    </tr>
                                </c:if>
                            </tbody>
                        </table>
                    </div>
                    <div class="col-sm-4"><img src="${studentpic}" class="img-rounded img-responsive center-block" alt="Student Picture"></div>
                    <div class="col-sm-4">
                        <c:if test="${not empty minors[0]}">
                            <table class="table table-striped text-center">
                                <thead>
                                    <tr>
                                        <th class="text-center">Minor<c:if test="${not empty minors[1]}">s</c:if></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>${minors[0]}</td>
                                    </tr>
                                    <c:if test="${not empty minors[1] && minors[1] != 0}">
                                        <tr>
                                            <td>${minors[1]}</td>
                                        </tr>
                                    </c:if>
                                    <c:if test="${not empty minors[2]  && minors[2] != 0}">
                                        <tr>
                                            <td>${minors[2]}</td>
                                        </tr>
                                    </c:if>
                                </tbody>
                            </table>
                        </c:if>
                    </div>
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
                        <c:if test="${not empty clubs[0]}">
                            <h3>${clubs[0]}
                                <c:if test="${not empty offices[0] && offices[0] != 0 && offices[0] != member}"><small>${offices[0]}</small></c:if>
                            </h3>
                        </c:if>
                    </div>
                    <div class="col-sm-4"></div>
                </div>
            </div>
                <%@include file="../../includes/nav2.jspf"%>
    </body>

    </html>
