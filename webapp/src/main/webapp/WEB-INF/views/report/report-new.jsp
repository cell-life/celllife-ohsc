<!DOCTYPE html>
<html lang="en">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>OHSC</title>
<link href="/css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="/css/bootstrap-responsive.css" rel="stylesheet">
<link href="css/datatables_bootstrap.css" rel="stylesheet">

<style type="text/css">
.ohsc-nav-btn-toolbar {
	position: absolute;
	top: 25px;
	right: 0px;
}

.ohsc-welcome-text {
	background: #fff;
	color: #5e5247;
}

.ohsc-logo {
	height: 100px;
}

.ohsc-border {
	border: 1px solid #ddd;
	padding: 30px 20px 30px;
	margin: 20px 10px 20px;
	width: 95%;
	border-radius: 10px 10px 10px 10px;
	-moz-border-radius: 10px 10px 10px 10px;
	-webkit-border-radius: 10px 10px 10px 10px;
	-webkit-box-shadow: 0px 0px 12px 1px rgba(122, 104, 88, 1);
	-moz-box-shadow: 0px 0px 12px 1px rgba(122, 104, 88, 1);
	box-shadow: 0px 0px 12px 1px rgba(122, 104, 88, 1);
}

.masthead {
	position: relative;
}

svg {
	padding: 10px 0 0 10px;
	font: 8px sans-serif;
}

.arc {
	stroke: #fff;
}

</style>

</head>
<body>
	<div class="container-fluid">
		<div class="masthead">
			<h2>
				<img class="ohsc-logo" src="/img/coat-of-arms.png"></img> OHSC
			</h2>
			<div class="btn-toolbar ohsc-nav-btn-toolbar">
				<a class="btn btn-link ohsc-welcome-text">Welcome Dr Radebe</a> <a
					class="btn btn-primary"> Log Out </a>
			</div>
		</div>

		<p></p>
		<ul class="breadcrumb">
			<div>South Africa | Eastern Cape</div>
		</ul>

		<div class="row-fluid ohsc-border">

			<p>Below are the ratings of the [Unit of Evaluation]s in each of
				the 6 core standards for quality care.</p>

			<table class="table table-striped table-bordered" id="myTable">
				<thead>
					<tr>
						<th>[Unit of Evaluation]</th>
						<th>Staff Attitudes</th>
						<th>Cleanliness</th>
						<th>Waiting Times</th>
						<th>Safe & Secure Care</th>
						<th>Infection Control</th>
						<th>Drug Availability</th>
						<th>Average Rating</th>
						<th>Total Responses</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>blank</td>
						<td>blank</td>
						<td>blank</td>
						<td>blank</td>
						<td>blank</td>
						<td>blank</td>
						<td>blank</td>
						<td>blank</td>
						<td>blank</td>
					</tr>
					<tr>
						<td>blank</td>
						<td>blank</td>
						<td>blank</td>
						<td>blank</td>
						<td>blank</td>
						<td>blank</td>
						<td>blank</td>
						<td>blank</td>
						<td>blank</td>
					</tr>
					<tr>
						<td>blank</td>
						<td>blank</td>
						<td>blank</td>
						<td>blank</td>
						<td>blank</td>
						<td>blank</td>
						<td>blank</td>
						<td>blank</td>
						<td>blank</td>
					</tr>
				</tbody>
			</table>


			<p>Disclaimer: These ratings are compiled only from responses to
				the mobile phone survey by patients who reported on their personal
				experience at their specific health care facility.</p>
		</div>


		<div class="row-fluid ohsc-border">
			<center>
				<h3>Total Clinics Monitored</h3>
				<div class="row-fluid" id="donut"></div>
				<script src="http://d3js.org/d3.v3.min.js"></script>
				<script src="${pageContext.request.contextPath}/js/donut-graphs.js"></script>
			</center>
		</div>

		<hr>

		<div class="footer">
			<p>&copy; Cell-Life (NPO) - 2013</p>
		</div>

	</div>

	<script src="js/jquery-1.9.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script type="text/javascript" charset="utf-8" language="javascript"
		src="js/jquery.dataTables.js"></script>
	<script type="text/javascript" charset="utf-8" language="javascript"
		src="js/datatables_bootstrap.js"></script>
	<script>
		/* Table initialisation */
		$(document)
				.ready(
						function() {
							$('#myTable')
									.dataTable(
											{
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