<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
    <link href="resources/css/ohsc.css" rel="stylesheet">

    
    <script type="text/javascript" src="resources/js/bootstrap.min.js"></script>


</head>
<body>
<div class="container-fluid">

	<jsp:include page="../includes/header.jsp"/>

    <hr>
    <h1>Error</h1>
	<p>
	<c:out value="${errorMessage}" />
	</p>

   
    <jsp:include page="../includes/footer.jsp"/>

</div>

</body>
</html>
