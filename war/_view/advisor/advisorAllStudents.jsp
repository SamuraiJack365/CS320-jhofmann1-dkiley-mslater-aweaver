<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

        <html>

        <head>
            <title>All Students</title>
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        </head>

        <body>
            <c:set var="page" scope="session" value="${'advisorAllStudents'}" />
            <%@include file="../../includes/nav.jspf"%>
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-sm-4"></div>
                        <div class="col-sm-4">
                            <h1>All Students</h1>
                        </div>
                        <div class="col-sm-4"></div>
                    </div>
                    <div class="row">
                        <div class="col-sm-4">
                            <h2>Assigned Student(s)</h2>
                        </div>
                        <div class="col-sm-4"></div>
                        <div class="col-sm-4"></div>
                    </div>
                    <table class="table">
                        <thead>
                            <tr>
                                <th>First Name</th>
                                <th>Last Name</th>
                                <th>Student ID</th>
                                <th>Email</th>
                                <th>Preview</th>
                                <th>Approve</th>
                                <th>Reject</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${students}" var="student">
                                <tr>
                                    <td>${student.firstName}</td>
                                    <td>${student.lastName}</td>
                                    <td>${student.studentIDNum}</td>
                                    <td>${student.username}@ycp.edu</td>
                                    <td>
                                        <form action="${pageContext.servletContext.contextPath}/advisorAllStudents" method="post">
                                            <input type="hidden" name="studentOption" value="preview" />
                                            <input type="hidden" name="studentSelect" value="${student.username}" />
                                            <button type="submit" id="btn1" class="btn btn-default">Preview</button>
                                        </form>
                                    </td>
                                    <td>
                                        <form action="${pageContext.servletContext.contextPath}/advisorAllStudents" method="post">
                                            <input type="hidden" name="studentOption" value="approve" />
                                            <input type="hidden" name="studentSelect" value="${student.username}" />
                                            <button type="submit" class="btn btn-success" name="approve">Approve</button>
                                        </form>
                                    </td>
                                    <td>
                                        <form action="${pageContext.servletContext.contextPath}/advisorAllStudents" method="post">
                                            <input type="hidden" name="studentOption" value="reject" />
                                            <input type="hidden" name="studentSelect" value="${student.username}" />
                                            <button type="submit" class="btn btn-danger">Reject</button>
                                        </form>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
        </body>

        </html>
