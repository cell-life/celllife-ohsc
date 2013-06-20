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

    <div class="row-fluid">
        <p id="breadcrumb">
            <a href="reports/provinces?country=${ratings.countryName}" class="active">Country<span>${ratings.countryShortName}</span></a>
            <a href="reports/districts?province=${ratings.provinceName}" class="active">Province<span>${ratings.provinceShortName}</span></a>
            <a href="reports/subDistricts?district=${ratings.districtName}" class="active">District<span>${ratings.districtShortName}</span></a>
            <a href="reports/clinics?subDistrict=${ratings.subDistrictName}" class="active">Sub-District<span>${ratings.subDistrictShortName}</span></a>
            <a href="reports/ratings?clinic=${param.clinic}" class="active">Clinic<span>${ratings.clinicShortName}</span></a>
        </p>
    </div>

    <div class="row-fluid">
        <div id="dateError" class="alert alert-block alert-error" style="display:none;margin:20px;">
            <p>Error: The "From" date must be earlier than the "To" date.</p>
        </div>
    </div>
    <div class="row-fluid">
        <div id="dateTooShortError" class="alert alert-block alert-error" style="display:none;margin:20px;">
            <p>One or both of the dates are invalid. Format must be "dd/MM/yyyy hh:mm aa".</p>
        </div>
    </div>

    <div class="row ohsc-border">

        <p>Below are the ratings of the Districts in each of the 6 core standards for quality care.</p>

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
            </tbody>
        </table>


        <p><small>These ratings are compiled only from responses to
            the mobile phone survey by patients who reported on their personal
            experience at their specific health care facility.</small></p>
    </div>

    <jsp:include page="../includes/totalClinics.jsp"/>

    <jsp:include page="../includes/footer.jsp"/>

</div>

<script>
	function convertParamDateToMMDDYYHHSSAMPM(param) {
		if (param == null || param == '') {
			return null;
		} else {
			var date = $.datepicker.parseDate("dd/mm/yy", param);
			var time = param.slice(11,19);
			var strTime = date.getMonth() + "/" + date.getDate() + "/" +  (date.getFullYear()%2000) + " " + time;
			return strTime; 
		}
	}

	/* Table initialisation */    
   	$(document).ready(function() {
   		var startDate = convertParamDateToMMDDYYHHSSAMPM('${param.startDate}');
   		if (startDate == null) {
   			startDate = "01/01/2000 12:00 AM";
   		}
   		var endDate = convertParamDateToMMDDYYHHSSAMPM('${param.endDate}');
   		if (endDate == null) {
   			var today = new Date();
   			endDate = today.getMonth() + "/" + today.getDate() + "/" +  (today.getFullYear()%2000) + " 12:00 AM";
   		}
   		$('#myTable').dataTable( {
   			"sDom": 'lfr<"toolbar">tip',
   			"bProcessing": true,
   			"bServerSide": true,
   			"sAjaxSource": "service/ratings/findIndividualRatingsByClinic",
   			"fnServerParams": function ( aoData ) {
   			      aoData.push( { "name": "clinicCode", "value": "${param.clinic}" } );
   			      aoData.push( { "name": "startDate", "value": startDate } );
   			      aoData.push( { "name": "endDate", "value": endDate } );
   			    }
   		} );
   		$("div.toolbar").html('<form class="form-inline"><fieldset><label>From:</label><input id="date1" name="date1" value="${param.startDate}" onchange="fromDateSelected()"/><label>To:</label><input id="date2" name="date2" value="${param.endDate}"disabled="true"/><button id="filter" type="button" class="btn" onclick="filterButtonClicked()">Apply</button></fieldset></form>');
   	});

    $(function () {
        $('#date1').datetimepicker({
            dateFormat: 'dd/mm/yy',
            timeFormat: 'hh:mm TT'
        });
    });

    $(function () {
        $('#date2').datetimepicker({
            minDate: $('#date1').datetimepicker('getDate'),
            dateFormat: 'dd/mm/yy',
            timeFormat: 'hh:mm TT'
        });
    });

    function fromDateSelected() {
        $('#date2').prop('disabled', false);
        $('#date2').datetimepicker("option", "minDate", $('#date1').datetimepicker('getDate'));
    }
    function filterButtonClicked() {
        if (($("#date1").val().length != 19) || ($("#date2").val().length != 19)) {
            $("#dateTooShortError").show();
        } else if ($("#date1").val() > $("#date2").val()) {
            $("#dateError").show();
            $('#date2').prop('disabled', false);
        }
        else {
        	window.location = 'reports/ratings?clinic=' +'${param.clinic}' + '&startDate=' + $("#date1").val() + '&endDate=' + $("#date2").val();
        }
    }
</script>

</body>
</html>