<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>OHSC</title>

    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <style type="text/css">
        body {
            padding-top: 20px;
            padding-bottom: 40px;
        }
    </style>
    <link href="${pageContext.request.contextPath}/css/bootstrap-responsive.css" rel="stylesheet">
</head>
<body>


<div class="container">

    <div class="masthead">
        <ul class="nav nav-pills pull-right">
            <li class="active"><a href="${pageContext.request.contextPath}/report/nationalRatingPerDomain">Home</a></li>
            <li><a href="#">About</a></li>
            <li><a href="#">Contact</a></li>
        </ul>
        <h3 class="muted">OHSC</h3>
    </div>

    <hr>

    <div class="row-fluid">
        <div class="span12">

            <h2> Core Standards - ${parentRegion} Ratings</h2>
            
            	<p>Below are the ratings of the ${fn:toLowerCase(type)}s in each
            	of the 6 core standards for quality care. These ratings are
            	compiled only from responses to the mobile phone survey by patients
            	who reported on their personal experience at their specific health
            	care facility.</p>
            	
            	<p>The total number of responses contributing to the ratings are
            	shown on the extreme right as are the average ratings across all 6.</p>

				<table class="table table-striped table-bordered" id="myTable">
					<thead>
						<tr>
							<th>${type}</th>
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


                    <!-- For each item -->
                    <c:forEach items="${items}" var="item">
                        <tr>
                            <c:if test="${childReportBaseUrl != null}">
                                <td><a
                                        href="${pageContext.request.contextPath}${childReportBaseUrl}${item.name}"><c:out
                                        value="${item.name}"/></a></td>

                            </c:if>
                            <c:if test="${childReportBaseUrl == null}">
                                <td><c:out value="${item.name}"/></td>
                            </c:if>
							<!-- Not sure this is the best way for number formatting, please feel free to refactor. -->
							<td><c:if test="${item.ratingDomain1 != 0}">
									<fmt:formatNumber type="number" maxFractionDigits="2"
										value="${ item.ratingDomain1}" />
								</c:if> <c:if test="${item.ratingDomain1 == 0}">
									N/A
								</c:if></td>
							<td><c:if test="${item.ratingDomain2 != 0}">
									<fmt:formatNumber type="number" maxFractionDigits="2"
										value="${ item.ratingDomain2}" />
								</c:if> <c:if test="${item.ratingDomain2 == 0}">
									N/A
								</c:if></td>
							<td><c:if test="${item.ratingDomain3 != 0}">
									<fmt:formatNumber type="number" maxFractionDigits="2"
										value="${ item.ratingDomain3}" />
								</c:if> <c:if test="${item.ratingDomain3 == 0}">
									N/A
								</c:if></td>
							<td><c:if test="${item.ratingDomain4 != 0}">
									<fmt:formatNumber type="number" maxFractionDigits="2"
										value="${ item.ratingDomain4}" />
								</c:if>
								<c:if test="${item.ratingDomain4 == 0}">
									N/A
								</c:if></td>
							<td><c:if test="${item.ratingDomain5 != 0}">
									<fmt:formatNumber type="number" maxFractionDigits="2"
										value="${ item.ratingDomain5}" />
								</c:if> <c:if test="${item.ratingDomain5 == 0}">
									N/A
								</c:if></td>
							<td><c:if test="${item.ratingDomain6 != 0}">
									<fmt:formatNumber type="number" maxFractionDigits="2"
										value="${ item.ratingDomain6}" />
								</c:if> <c:if test="${item.ratingDomain6 == 0}">
									N/A
								</c:if></td>
							<td><c:if test="${item.ratingOverall != 0}">
									<fmt:formatNumber type="number" maxFractionDigits="2"
										value="${ item.ratingOverall}" />
								</c:if> <c:if test="${item.ratingOverall == 0}">
									N/A
								</c:if></td>
							<td><c:if test="${item.count != 0}">
									<fmt:formatNumber type="number" maxFractionDigits="2"
										value="${item.count}" />
								</c:if> <c:if test="${item.count == 0}">
									N/A
								</c:if></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

            <p>

            </p>
        </div>
    </div>

    <hr>

    <div class="footer">
        <p>&copy; Cell-Life (NPO) - 2013</p>
    </div>

</div>

<script src="http://code.jquery.com/jquery.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script type="text/javascript" charset="utf-8" language="javascript" src="${pageContext.request.contextPath}/js/jquery.dataTables.js"></script>

	<script>
		$(document)
				.ready(
						function() {
							$('#myTable').dataTable( {
								"sDom" : "t",
								"bPaginate": false
							});
							$.extend($.fn.dataTableExt.oStdClasses, {
								"sWrapper" : "dataTables_wrapper form-inline"
							});
						});
	</script>
</body>
</html>