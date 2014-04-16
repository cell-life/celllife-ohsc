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
    <script type="text/javascript" src="resources/js/jquery.dataTables.js"></script>
    <script type="text/javascript" src="resources/js/datatables_bootstrap.js"></script>

</head>
<body>
<div class="container-fluid">

	<jsp:include page="../includes/header.jsp"/>

    <div class="row ohsc-border">

        <h3>Select a Report</h3>


        <div class="col-md-4">

            <c:forEach items="${reports}" var="report">
                <a href="#${report.id}" class="active reportLink">
                    <h4>${report.label}</h4>
                </a>
            </c:forEach>

        </div>
        <div class="form"> </div>
    </div>

	<jsp:include page="../includes/footer.jsp"/>

</div>
<script>
    $(document).ready(function () {

        $(".reportLink").click(function () {

            var reportId = $(this).attr('href') + '';
            reportId = reportId.replace('#', '');
            alert('reportId = ' + reportId);

            $.get(
                    "service/getHtml",
                    {reportId: reportId},
                    function (data) {
                        $(".form").html(data);
                        alert('data = ' + data);
                        $(".form").on('submit', function (e) {
                            e.preventDefault();
                            alert('reportId = ' + reportId);
                            window.location = "service/pdfReport" + "?reportId=" + reportId + "&" + $("form").serialize();
                        });

                    }
            );
            return false;

        });

    });


</script>


</body>
</html>