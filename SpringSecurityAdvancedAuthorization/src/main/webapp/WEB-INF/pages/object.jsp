<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">
    <link href="<c:url value="/resources/theme/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/theme/css/starter-template.css" />" rel="stylesheet">
    <title>${profileUser.username}</title>
</head>
<body>

<jsp:include page="top.jsp" />

<div class="container">
    <div class="col-lg-4">


        <h1>Object Page</h1>

        <p>Admin can view, create, edit and delete the object</p>
        <p>User can view and edit the object</p>

        <c:out value='${message}' /><br />

        <h3>Object List</h3>

        <sec:authorize access="hasAuthority('VIEW_OBJECT')">

            <table class="table table-bordered table-striped">

                <c:forEach items="${objects}" var="object">

                    <tr>
                        <td>
                                ${object.name}
                        </td>
                        <td>
                                ${object.value}
                        </td>

                    </tr>

                </c:forEach>

            </table>

        </sec:authorize>


        <sec:authorize access="hasAuthority('CREATE_OBJECT')">

            <form:form  action ="create-object" method='POST' commandName="objectForm">

                <h2>Create object</h2>

                <div class="form-group">
                    <label for="nameInput">Object Name</label>
                    <form:input id="nameInput" path="name" placeholder="Object Name" size="30" cssClass="form-control" />
                </div>

                <div class="form-group">
                    <label for="valueInput">Value</label>
                    <form:input id="valueInput" path="value" placeholder="Value" size="30" cssClass="form-control" />
                </div>

                <button class="btn btn-default" type="submit">Create Object</button>


            </form:form>

        </sec:authorize>

    </div>



</div>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="<c:url value='/resources/theme/js/bootstrap.min.js' />"></script>
</body>
</html>