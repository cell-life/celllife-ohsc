<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>OHSC</title>

    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <style type="text/css">
        body {
            padding-top: 20px;
            padding-bottom: 40px;
        }

        iframe {
            border: none;
        }
    </style>
    <link href="${pageContext.request.contextPath}/css/bootstrap-responsive.css" rel="stylesheet">
</head>
<body>


<div class="container">

    <div class="masthead">
        <ul class="nav nav-pills pull-right">
            <li class="active"><a href="${pageContext.request.contextPath}/report/nationalRatingPerDomain">Home</a></li>
            <li><a href="#">About</a></li>
            <li><a href="#">Contact</a></li>
            <li><a href="j_spring_cas_security_logout">Logout</a>
        </ul>
        <h3 class="muted">OHSC</h3>
    </div>

    <hr>

    <c:forEach items="${provinces.content}" var="province">
        <p>${province.shortName}</p>

    </c:forEach>

    <h1>${result.person.name}</h1>

    <p>
    <ul>
        <li><a
                href="${pageContext.request.contextPath}/report/nationalRatingPerDomain">Aggregated
            national ratings report</a></li>
        <li>Future Report Here</li>
        <li>Future Report Here</li>
    </ul>
    </p>

    <hr>

    <center>
        <h3>Total Clinics Monitored</h3>

			<div class="row-fluid" id="donut"><jsp:include
					page="${pageContext.request.contextPath}/js/donut-graphs.jsp" /></div>

	</center>

    <hr>

    <div class="footer">
        <p>&copy; Cell-Life (NPO) - 2013</p>
    </div>

</div>

</body>
</html>