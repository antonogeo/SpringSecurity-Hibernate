<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">SuperApp</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li <c:if test="${fn:endsWith(pageContext.request.requestURI, '/dashboard.jsp')}" >class="active"</c:if> ><a href="dashboard">Dashboard</a></li>
                <li <c:if test="${fn:endsWith(pageContext.request.requestURI, '/admin.jsp')}" >class="active"</c:if> ><a href="admin">Admin Page</a></li>
                <li <c:if test="${fn:endsWith(pageContext.request.requestURI, '/object.jsp')}" >class="active"</c:if> ><a href="object">Objects</a></li>
            </ul>
        </div>
    </div>
</nav>
