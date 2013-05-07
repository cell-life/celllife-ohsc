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
    <link href="resources/css/jquery-ui.css" rel="stylesheet">
    <link href="resources/css/jquery-ui-timepicker.css" rel="stylesheet">
    <link href="resources/css/ohsc.css" rel="stylesheet">

    <script type="text/javascript" src="resources/js/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="resources/js/jquery-ui.min.js"></script>
    <script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="resources/js/jquery-ui-timepicker-addon.js"></script>

</head>
<body>
<div class="container-fluid">

	<jsp:include page="../includes/header.jsp"/>

    <div class="row-fluid">
        <p id="breadcrumb">
            <a href="reports/provinces?country=${averages[0].countryName}" class="active">Country<span>${averages[0].countryShortName}</span></a>
            <a>Province</a>
            <a>District</a>
            <a>Sub-District</a>
            <a>Clinic</a>
        </p>
    </div>

    <div class="row ohsc-border">

        <p>Below are the ratings of the Provinces in each of the 6 core standards for quality care.</p>
            <div class="row-fluid">
            <form class="form-inline pull-right">
                <fieldset>
                    <label>From:</label>
                    <input id="date1" name="date1" onchange="fromDateSelected()"/>
                    <script>
                        $(function () {
                            $('#date1').datetimepicker({
                                dateFormat: 'dd/mm/yy',
                                timeFormat: 'hh:mm TT'
                            });
                        });
                    </script>
                    <label>To:</label>
                    <input id="date2" name="date2" onchange="toDateSelected()" disabled="true"/>
                    <script>
                        $(function () {
                            $('#date2').datetimepicker({
                                minDate: $('#date1').datetimepicker('getDate'),
                                dateFormat: 'dd/mm/yy',
                                timeFormat: 'hh:mm TT'
                            });
                        });
                    </script>
                    <button id="filter" type="button" class="btn" onclick="filterButtonClicked()">Filter</button>
                </fieldset>
            </form>
            </div>

        <table class="table table-striped table-bordered" id="myTable">
            <thead>
            <tr>
                <th>Province</th>
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
                    <td><a href="reports/districts?province=${average.provinceName}">${average.provinceShortName}</a></td>
                    <td><fmt:formatNumber value="${average.staffAttitudeRating}" type="number" minFractionDigits="2"/></td>
                    <td><fmt:formatNumber value="${average.cleanlinessRating}" type="number" minFractionDigits="2"/></td>
                    <td><fmt:formatNumber value="${average.waitingTimesRating}" type="number" minFractionDigits="2"/></td>
                    <td><fmt:formatNumber value="${average.drugAvailabilityRating}" type="number" minFractionDigits="2"/></td>
                    <td><fmt:formatNumber value="${average.infectionControlRating}" type="number" minFractionDigits="2"/></td>
                    <td><fmt:formatNumber value="${average.safeAndSecureCareRating}" type="number" minFractionDigits="2"/></td>
                    <td><fmt:formatNumber value="${average.averageRating}" type="number" minFractionDigits="2"/></td>
                    <td>${average.totalResponses != null ? average.totalResponses : "0"}</td>
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

<script type="text/javascript" src="resources/js/jquery.dataTables.js"></script>
<script type="text/javascript" src="resources/js/datatables_bootstrap.js"></script>

<script>
    function fromDateSelected(){
        $('#date2').prop('disabled', false);
        $('#date2').datetimepicker( "option", "minDate", $('#date1').datetimepicker('getDate') );
        console.log($('#date1').datetimepicker('getDate'));
    }
    function toDateSelected(){
        //window.location = 'reports/provinces?country=za South Africa (National Government)&startDate=' + $("#date1").val() + '&endDate=' + $("#date2").val();
    }
    function filterButtonClicked() {
        window.location = 'reports/provinces?country=za South Africa (National Government)&startDate=' + $("#date1").val() + '&endDate=' + $("#date2").val();
    }
</script>

</body>
</html>