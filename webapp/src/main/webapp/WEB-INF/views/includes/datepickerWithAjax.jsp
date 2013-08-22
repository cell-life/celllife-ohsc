<script>

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

    $(function () {
        $('#date1').datetimepicker({
            dateFormat: 'dd/mm/yy',
            timeFormat: 'hh:mm TT'
        });
        $('#date1').datetimepicker();

        if ($('#date1').datetimepicker('getDate') == null) {
            var date = new Date(), y = date.getFullYear(), m = date.getMonth();
            $('#date1').datetimepicker("setDate", new Date(y, m, 1));
        }
        var time = getTime($('#date1').datetimepicker('getDate'));
        $('#date1').datetimepicker("option", "maxDate", new Date());
        $('#date1').datetimepicker("setTime", time); // there is a bug where setting maxDate removes the time

    });

    function getTime(date) {
        if (date == null) {
            return "12:00 pm";
        } else {
            var HH = date.getHours();
            var mm = date.getMinutes();
            var aa = HH >= 12 ? 'pm' : 'am';
            var hh = HH % 12;
            hh = hh ? hh : 12; // the hour '0' should be '12'
            mm = mm < 10 ? '0' + mm : mm;
            hh = hh < 10 ? '0' + hh : hh;

            var time = hh + ':' + mm + ' ' + aa;
            return time;
        }
    }

    $(function () {
        $('#date2').datetimepicker({
            minDate: $('#date1').datetimepicker('getDate'),
            dateFormat: 'dd/mm/yy',
            timeFormat: 'hh:mm TT'
        });
        $('#date2').datetimepicker();
        if ($('#date2').datetimepicker('getDate') == null) {
            $('#date2').datetimepicker("setDate", new Date());
        }
        var time = getTime($('#date2').datetimepicker('getDate'));
        $('#date2').datetimepicker("option", "maxDate", new Date());
        $('#date2').datetimepicker("setTime", time); // there is a bug where setting maxDate removes the time
    });

    function fromDateSelected() {
        var time = getTime($('#date2').datetimepicker('getDate'));
        $('#date2').datetimepicker("option", "minDate", $('#date1').datetimepicker('getDate'));
        $('#date2').datetimepicker("setTime", time); // there is a bug where setting minDate removes the time
    }
    
    function filterButtonClicked() {
        if (($("#date1").val().length != 19) || ($("#date2").val().length != 19)) {
            $("#dateTooShortError").show();
            return false;
        } else if ($("#date1").datepicker('getDate') > $("#date2").datepicker('getDate')) {
            $("#dateError").show();
            return false;
        } else {
	        $("#dateTooShortError").hide();
	        $("#dateError").hide();
        	window.location = "<%= request.getParameter("windowLocation") %>" + "&startDate=" + $('#date1').val() + "&endDate=" + $('#date2').val();
        }
    }

</script>

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