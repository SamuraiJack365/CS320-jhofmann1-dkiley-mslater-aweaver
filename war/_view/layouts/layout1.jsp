<!DOCTYPE html>
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
    <c:set var="page" scope="session" value="${'student'}" />
    <%@include file="../../includes/nav.jspf"%>
        <div class="container-fluid jumbotron">
            <div class="row">
                <div class="col-sm-4">
                    <table class="table table-striped text-center">
                        <thead>
                            <tr>
                                <th class="text-center">Major(s)</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>${major1}</td>
                            </tr>
                            <c:if test="${major2 neq null}">
                                <tr>
                                    <td>${major2}</td>
                                </tr>
                            </c:if>
                        </tbody>
                    </table>
                </div>
                <div class="col-sm-4"><img src="${studentpic}" class="img-rounded img-responsive center-block" alt="Student Picture"></div>
                <div class="col-sm-4">
                    <c:if test="${minor1 neq null}">
                        <table class="table table-striped text-center">
                            <thead>
                                <tr>
                                    <th class="text-center">Minor(s)</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>${minor1}</td>
                                </tr>
                                <c:if test="${minor2 neq null}">
                                    <tr>
                                        <td>${minor2}</td>
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
                    <h1 class="text-center">${firstname} ${lastname}</h1>
                </div>
                <div class="col-sm-4"></div>
            </div>
            <div class="row">
                <div class="col-sm-4"></div>
                <div class="col-sm-4 text-center">
                    <c:if test="${club neq null}">
                        <h3>${club}
                            <c:if test="${office neq null}"><small>${office}</small></c:if>
                        </h3>
                    </c:if>
                </div>
                <div class="col-sm-4"></div>
            </div>
            <%@include file="../../includes/nav2.jspf"%>
        </div>
</body>

</html>
