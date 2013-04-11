<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>OHSC</title>

    <link href="resources/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <style type="text/css">
        body {
            padding-top: 20px;
            padding-bottom: 40px;
        }
    </style>
    <link href="resources/css/bootstrap-responsive.css" rel="stylesheet">
    
    <script type="text/javascript" src="https://www.google.com/jsapi"></script>
    <script type="text/javascript">
      google.load("visualization", "1", {packages:["corechart"]});
      google.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['Clinic', 'Rating'],
          ['Clinic ${bestClinics[0].clinic_code}',  ${bestClinics[0].overall}],
          ['Clinic ${bestClinics[0].clinic_code}',  ${bestClinics[0].overall}],
          ['Clinic ${bestClinics[0].clinic_code}',  ${bestClinics[0].overall}],
          ['Clinic ${bestClinics[0].clinic_code}',  ${bestClinics[0].overall}],
          ['Clinic ${bestClinics[0].clinic_code}',  ${bestClinics[0].overall}]
        ]);

        var options = {
          title: 'Top Performing Clinics',
          titleTextStyle: {fontSize: 20},
          hAxis :  {minValue: 0,  maxValue: 5},
          backgroundColor: '#efefef'
        };

        var chart = new google.visualization.BarChart(document.getElementById('chart_div'));
        chart.draw(data, options);
      }
    </script>
    
    <script type="text/javascript">
      google.load("visualization", "1", {packages:["corechart"]});
      google.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['Clinic', 'Rating'],
          ['Clinic ${worstClinics[0].clinic_code}',  ${worstClinics[0].overall}],
          ['Clinic ${worstClinics[1].clinic_code}',  ${worstClinics[1].overall}],
          ['Clinic ${worstClinics[2].clinic_code}',  ${worstClinics[2].overall}],
          ['Clinic ${worstClinics[3].clinic_code}',  ${worstClinics[3].overall}],
          ['Clinic ${worstClinics[4].clinic_code}',  ${worstClinics[4].overall}]
        ]);

        var options = {
          title: 'Bottom Performing Clinics',
          titleTextStyle: {fontSize: 20},
          hAxis :  {minValue: 0,  maxValue: 5},
          colors: ['red'],
          backgroundColor: '#efefef'
        };

        var chart = new google.visualization.BarChart(document.getElementById('chart_2_div'));
        chart.draw(data, options);
      }
    </script>
    
</head>
<body>


<div class="container">

    <div class="masthead">
        <ul class="nav nav-pills pull-right">
            <li class="active"><a href="resources/report/nationalRatingPerDomain">Home</a></li>
            <li><a href="#">About</a></li>
            <li><a href="#">Contact</a></li>
        </ul>
        <h3 class="muted">OHSC</h3>
    </div>

    <hr>

	<h1>Reports</h1>
	<ul>
	  <li><a href="resources/report/nationalRatingPerDomain">Aggregated national ratings report</a></li>
	</ul>
	
	<p><div id="chart_div" style="width: 500px; height: 300px; margin-bottom:30px"></div></p>
	
	<p><div id="chart_2_div" style="width: 500px; height: 300px;"></div></p>
	
	<hr>
	
	<div class="footer">
        <p>&copy; Cell-Life (NPO) - 2013</p>
    </div>
	
</div>

</body>
</html>