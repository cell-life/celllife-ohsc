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
        </ul>
        <h3 class="muted">OHSC</h3>
    </div>

    <hr>

    <h1>Reports</h1>

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
    </center>

    <iframe class="row-fluid"
            src="${pageContext.request.contextPath}/js/donut-graphs.jsp"
            marginwidth="0" marginheight="0" scrolling="no"></iframe>
    <!-- TODO: find a better place to put iframe jsp-->

    <hr>

    <div class="footer">
        <p>&copy; Cell-Life (NPO) - 2013</p>
    </div>

</div>

</body>
</html>