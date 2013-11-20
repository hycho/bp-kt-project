<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
<script src="/Framework/resources/apps/highchart/highcharts.js"></script>
<script src="/Framework/resources/apps/highchart/modules/exporting.js"></script>
<script type="text/javascript">
$(function () {
    var highchart1 = new Highcharts.Chart({
        chart: {
        	renderTo: 'container',
            type: 'column',
            margin: [ 50, 50, 100, 80]
        },
        title: {
            text: 'World\'s largest cities per 2008'
        },
        xAxis: {
            categories: [
                'GET',
                'POST'
            ],
            labels: {
                rotation: 0,
                align: 'right',
                style: {
                    fontSize: '13px',
                    fontFamily: 'Verdana, sans-serif'
                }
            }
        },
        yAxis: {
            min: 0,
            title: {
                text: 'Population (millions)'
            }
        },
        legend: {
            enabled: false
        },
        tooltip: {
            pointFormat: 'Population in 2008: <b>{point.y:.1f} millions</b>',
        },
        series: [{
            name: 'Population',
            data: [34.4, 21.8],
            dataLabels: {
                enabled: true,
                rotation: -90,
                color: '#FFFFFF',
                align: 'right',
                x: 4,
                y: 10,
                style: {
                    fontSize: '13px',
                    fontFamily: 'Verdana, sans-serif',
                    textShadow: '0 0 3px black'
                }
            }
        }]
    });
    
    /*$.ajax({
    	url: "http://localhost:8080/Framework/tutorial/getTypeCount",
    	dataType: "json",
		success: function(data) {
			alert(data);
			//highchart1.series[0].setData([data.get, data.post]);
		},
		error: function(xhr) { 
			MvcUtil.showErrorResponse(xhr.responseText, link);
		}
	});*/
	
	$.ajax({
    	url: "http://localhost:8080/Framework/tutorial/bigWait",
		success: function(data) {
			alert(data);
			//highchart1.series[0].setData([data.get, data.post]);
		},
		error: function(xhr) { 
			alert("error = "+xhr);
		}
	});
    
    $("#runBig").click(function(){
    	$.ajax({
        	url: "http://localhost:8080/Framework/tutorial/bigRun",
    		success: function(data) {
    			//alert(data);
    			//highchart1.series[0].setData([data.get, data.post]);
    		},
    		error: function(xhr) { 
    			alert("error = "+xhr);
    		}
    	});
    });
    
});

</script>
<head>
	<title>Home</title>
</head>
<body>
<div id="container" style="min-width: 500px; height: 400px; margin: 0 auto"></div>
<button id="runBig">run</button>
</body>
</html>
