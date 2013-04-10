<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>OHSC</title>

    <c:set var="url">${pageContext.request.requestURL}</c:set>
    <base href="${fn:substring(url, 0, fn:length(url) - fn:length(pageContext.request.requestURI))}${pageContext.request.contextPath}/" />

    <link href="resources/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="resources/css/bootstrap-responsive.css" rel="stylesheet">
    <link href="resources/css/datatables_bootstrap.css" rel="stylesheet">
    <link href="resources/css/ohsc.css" rel="stylesheet">

</head>
<body>
<div class="container-fluid">
    <div class="masthead">
        <h2>
            <img class="ohsc-logo" src="resources/img/coat-of-arms.png"> OHSC
        </h2>
        <div class="btn-toolbar ohsc-nav-btn-toolbar">
            <a class="btn btn-link ohsc-welcome-text">Welcome Dr Radebe</a>
            <a class="btn btn-primary">Log Out</a>
        </div>
    </div>

    <div class="row-fluid">
        <p id="breadcrumb">
            <a href="#" class="active">Country<span>South Africa</span></a>
            <a href="#" class="active">Province<span>Western Cape</span></a>
            <a href="#">Municipality</a>
            <a href="#">Clinic</a>
        </p>
    </div>

    <div class="row-fluid ohsc-border">

        <p>Below are the ratings of the ${averages[0].regionType.plural} in each of
            the 6 core standards for quality care.</p>

        <table class="table table-striped table-bordered" id="myTable">
            <thead>
            <tr>
                <th>${averages[0].regionType.singular}</th>
                <th>Staff Attitudes</th>
                <th>Cleanliness</th>
                <th>Waiting Times</th>
                <th>Safe &amp; Secure Care</th>
                <th>Infection Control</th>
                <th>Drug Availability</th>
                <th>Average Rating</th>
                <th>Total Responses</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${averages}" var="average">
                <tr>
                    <td>${average.name}</td>
                    <td>${average.staffAttitudeRating != null ? average.staffAttitudeRating : "N/A"}</td>
                    <td>${average.cleanlinessRating != null ? average.cleanlinessRating : "N/A"}</td>
                    <td>${average.waitingTimesRating != null ? average.waitingTimesRating : "N/A"}</td>
                    <td>${average.drugAvailabilityRating != null ? average.drugAvailabilityRating : "N/A"}</td>
                    <td>${average.infectionControlRating != null ? average.infectionControlRating : "N/A"}</td>
                    <td>${average.safeAndSecureCareRating != null ? average.safeAndSecureCareRating : "N/A"}</td>
                    <td>${average.averageRating != null ? average.averageRating : "N/A"}</td>
                    <td>${average.totalResponses != null ? average.totalResponses : "0"}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>


        <p><small>These ratings are compiled only from responses to
            the mobile phone survey by patients who reported on their personal
            experience at their specific health care facility.</small></p>
    </div>

    <div class="arrow-heading">
        <div class="arrow-box"></div>
        <div class="arrow"></div>
        <p>Total Clinics Monitored</p>
    </div>

    <div class="row-fluid ohsc-border">
        <center>
            <div class="row-fluid" id="donut"></div>
            <script src="resources/js/d3.v3.min.js"></script>
            <script src="resources/js/donut-graphs.js"></script>
        </center>
    </div>

    <hr>

    <div class="footer">
        <p>&copy; Cell-Life (NPO) - 2013</p>
    </div>

</div>

<script type="text/javascript" src="resources/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
<script type="text/javascript" src="resources/js/jquery.dataTables.js"></script>
<script type="text/javascript" src="resources/js/datatables_bootstrap.js"></script>
<script>
    /* Table initialisation */
    $(document).ready(
            function() {
                $('#myTable').dataTable( {
                    "sDom" : "<'row-fluid'<'span6'l><'span6'f>r>t<'row-fluid'<'span6'i><'span6'p>>",
                    "sPaginationType" : "bootstrap",
                    "oLanguage" : {
                        "sLengthMenu" : "_MENU_ records per page"
                    }
                });
            });
</script>

</body>
</html>