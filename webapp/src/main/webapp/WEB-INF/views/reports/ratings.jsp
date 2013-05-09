<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

	<jsp:include page="../includes/header.jsp"/>

    <div class="row-fluid">
        <p id="breadcrumb">
            <a href="reports/provinces?country=${ratings[0].countryName}" class="active">Country<span>${ratings[0].countryShortName}</span></a>
            <a href="reports/districts?province=${ratings[0].provinceName}" class="active">Province<span>${ratings[0].provinceShortName}</span></a>
            <a href="reports/subDistricts?district=${ratings[0].districtName}" class="active">District<span>${ratings[0].districtShortName}</span></a>
            <a href="reports/clinics?subDistrict=${ratings[0].subDistrictName}" class="active">Sub-District<span>${ratings[0].subDistrictShortName}</span></a>
            <a href="reports/ratings?clinic=${ratings[0].clinicCode}" class="active">Clinic<span>${ratings[0].clinicShortName}</span></a>
        </p>
    </div>

    <div class="row-fluid ohsc-border">

        <p>Below are the ratings of the Clinics in each of the 6 core standards for quality care.</p>

        <table class="table table-striped table-bordered" id="myTable">
            <thead>
            <tr>
                <th>Msisdn</th>
                <th>Submission date</th>
                <th>Staff Attitudes</th>
                <th>Cleanliness</th>
                <th>Waiting Times</th>
                <th>Safe &amp; Secure Care</th>
                <th>Infection Control</th>
                <th>Drug Availability</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${ratings}" var="rating">
                <tr>
                    <td>${rating.msisdn}</td>
                    
					<jsp:useBean id="dateValue" class="java.util.Date" />
					<jsp:setProperty name="dateValue" property="time" value="${rating.submissionDate}" />
                    <td><fmt:formatDate value="${dateValue}" type="both" dateStyle="medium" timeStyle="medium"/></td>

                    <td><fmt:formatNumber value="${rating.staffAttitudeRating}" type="number" minFractionDigits="2"/></td>
                    <td><fmt:formatNumber value="${rating.cleanlinessRating}" type="number" minFractionDigits="2"/></td>
                    <td><fmt:formatNumber value="${rating.waitingTimesRating}" type="number" minFractionDigits="2"/></td>
                    <td><fmt:formatNumber value="${rating.drugAvailabilityRating}" type="number" minFractionDigits="2"/></td>
                    <td><fmt:formatNumber value="${rating.infectionControlRating}" type="number" minFractionDigits="2"/></td>
                    <td><fmt:formatNumber value="${rating.safeAndSecureCareRating}" type="number" minFractionDigits="2"/></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <p><small>These ratings are compiled only from responses to
            the mobile phone survey by patients who reported on their personal
            experience at their specific health care facility.</small></p>
    </div>

    <jsp:include page="../includes/totalClinics.jsp"/>

    <jsp:include page="../includes/footer.jsp"/>

</div>

<script type="text/javascript" src="resources/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
<script type="text/javascript" src="resources/js/jquery.dataTables.js"></script>
<script type="text/javascript" src="resources/js/datatables_bootstrap.js"></script>
<script>
	/* Table initialisation */
	$(document).ready(function() {
		$('#myTable').dataTable();
	});
</script>

</body>
</html>