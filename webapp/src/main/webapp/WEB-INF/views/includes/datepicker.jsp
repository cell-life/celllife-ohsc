<script>

    /* Table initialisation */
    $(document).ready(function () {
        $('#myTable').dataTable({
            "sDom": 'lfr<"toolbar">tip'
        });
        $("div.toolbar").html('<form class="form-inline"><fieldset><label>From:</label><input id="date1" name="date1" value="${param.startDate}" onchange="fromDateSelected()"/><label>To:</label><input id="date2" name="date2" value="${param.endDate}"/><button id="filter" type="button" class="btn" onclick="filterButtonClicked()">Apply</button></fieldset></form>');
    });

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

</script>