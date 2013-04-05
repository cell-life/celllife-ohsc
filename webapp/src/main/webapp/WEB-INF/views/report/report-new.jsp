<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>OHSC</title>

<link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	rel="stylesheet" media="screen">
<link
	href="${pageContext.request.contextPath}/css/bootstrap-responsive.css"
	rel="stylesheet">

<style type="text/css">
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
		<div class="masthead" style="position: relative">
			<h2>
				<img
					src="http://upload.wikimedia.org/wikipedia/commons/thumb/2/21/Coat_of_arms_of_South_Africa.svg/250px-Coat_of_arms_of_South_Africa.svg.png"
					style="height: 100px"></img> OHSC
			</h2>
			<div class="btn-toolbar"
				style="position: absolute; top: 25px; right: 0px;">
				<a class="btn btn-link disabled" style="background: #fff;">Welcome
					Dr Radebe</a> <a class="btn btn-primary"> Log Out </a>
			</div>
		</div>

		<p></p>

		<div class="row-fluid ">
			<ul class="breadcrumb">
				<div>South Africa | Eastern Cape</div>
			</ul>

			<p>Below are the ratings of the [Unit of Evaluation]s in each of
				the 6 core standards for quality care.</p>

			<table class="table table-striped table-bordered">
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
                    <c:forEach items="${averages}" var="average">
                        <tr>
                            <td>${average.provinceShortName}</td>
                            <%--<td>${average.staffAttitudeAverage}</td>--%>
                            <%--<td>${average.cleanlinessAverag}</td>--%>
                            <%--<td>${average.waitingTimesAverage}</td>--%>
                            <%--<td>${average.drugAvailabilityAverage}</td>--%>
                            <%--<td>${average.infectionControlAverage}</td>--%>
                            <%--<td>${average.safeAndSecureCareAverage}</td>--%>
                            <td>blank</td>
                            <td>blank</td>
                            <td>blank</td>
                            <td>blank</td>
                            <td>blank</td>
                            <td>blank</td>
                            <td>blank</td>
                            <td>blank</td>
                        </tr>
                    </c:forEach>
				</tbody>
			</table>

			<div class="pagination pull-right">
				<ul>
					<li><a href="#">Prev</a></li>
					<li><a href="#">1</a></li>
					<li><a href="#">2</a></li>
					<li><a href="#">Next</a></li>
				</ul>
			</div>
		</div>

		<p>Disclaimer: These ratings are compiled only from responses to
			the mobile phone survey by patients who reported on their personal
			experience at their specific health care facility.</p>

		<hr>

		<div class="row-fluid">
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
</body>
</html>