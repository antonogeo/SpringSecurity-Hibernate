<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
    <div class="starter-template">

        <h1>Object Page</h1>

        <p>Admin can view, create, edit and delete the object</p>
        <p>User can view and edit the object</p>

        <c:out value='${message}' /><br />

        <form:form  action ="create-object" method='POST' commandName="objectForm" cssClass="form-signin">

            <h2 class="form-signin-heading">Create object</h2>

            <label for="inputName" class="sr-only">Name</label>
            <form:input path="name" id="inputName" placeholder="Name" size="30" cssClass="form-control" />

            <button class="btn btn-lg btn-primary btn-block" type="submit">Create Object</button>
        </form:form>


    </div>
</div>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="<c:url value='/resources/theme/js/bootstrap.min.js' />"></script>
</body>
</html>