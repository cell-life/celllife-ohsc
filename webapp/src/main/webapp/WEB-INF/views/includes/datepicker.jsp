<script>
    /* Table initialisation */
    $(document).ready(function () {
        $('#myTable').dataTable({
            "sDom": 'lfr<"toolbar">tip'
        });
        $("div.toolbar").html('<form class="form-inline"><fieldset><label>From:</label>'
        		+'<input id="date1" name="date1" value="${param.startDate}" onchange="fromDateSelected()" type="text"/>'
        		+'<label>To:</label><input id="date2" name="date2" value="${param.endDate}" type="text"/>'
        		+'<button id="filter" type="button" class="btn" onclick="filterButtonClicked(\'<%= request.getParameter("windowLocation") %>\')">Apply</button>'
        		+'</fieldset></form>');
    });
</script>
<script type="text/javascript" src="resources/js/datepicker.js"></script>
<jsp:include page="../includes/datepickerErrors.jsp"/>