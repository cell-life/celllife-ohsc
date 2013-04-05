var radius = 74, padding = 10;

var color = d3.scale.ordinal().range([ "#aeb490", "#d7dfcf" ]);

var arc = d3.svg.arc().outerRadius(radius).innerRadius(radius - 30);

var pie = d3.layout.pie().sort(null).value(function(d) {
	return d.progress;
});

/* TODO: replace csv file with real data */
d3.csv("js/data.csv", function(error, data) {

	color.domain(d3.keys(data[0]).filter(function(key) {
		return key !== "Province";
	}));

	data.forEach(function(d) {
		d.clinics = color.domain().map(function(name) {
			return {
				name : name,
				progress : +d[name]
			};
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
				return d.Province;
			});

	svg.append("text").attr("dy", "1.5em").style("text-anchor", "middle").text(
			function(d) {
				var total = +[ d.Incomplete ] + +[ d.Complete ];
				return d.Complete + "/" + (total);
			});

});
