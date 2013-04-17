var radius = 74, padding = 10;

var color = d3.scale.ordinal().range([ "#aeb490", "#d7dfcf" ]);

var arc = d3.svg.arc().outerRadius(radius).innerRadius(radius - 30);

var pie = d3.layout.pie().sort(null).value(function(d) {
	return d.progress;
});

color.domain(["totalClinicsMonitored","totalClinics"]);

d3.json("service/totals/findClinicsMonitoredByProvince?country=za%20South%20Africa%20(National%20Government)", function(data) {

		data.forEach(function(d) {
			d.clinics = color.domain().map(function(name) {
				if (name == "totalClinics") {
					return {
						name : "incomplete",
						progress : d[name] - d.totalClinicsMonitored
					}
				} else {
					return {
						name : "complete",
						progress : d[name]
					}
				}
			});
		});
		
		var svg = d3.select("#donut").selectAll(".pie").data(data).enter().append(
				"svg").attr("class", "pie").attr("width", radius * 2).attr(
				"height", radius * 2).append("g").attr("transform",
				"translate(" + radius + "," + radius + ")");

		svg.selectAll(".arc").data(function(d) {
			return pie(d.clinics);
		}).enter().append("path").attr("class", "arc").attr("d", arc).style("fill",
				function(d) {
					return color(d.data.name);
				});

		svg.append("text").attr("dy", ".35em").style("text-anchor", "middle").text(
				function(d) {
                    return d.provinceShortName;
				});

		svg.append("text").attr("dy", "1.5em").style("text-anchor", "middle").text(
				function(d) {
					return [d.totalClinicsMonitored] + "/" + ([d.totalClinics]);
				});
});
