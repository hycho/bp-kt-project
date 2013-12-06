<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
  <title>Service Analysis Page</title>
  <link rel="stylesheet" href="<c:url value='/resources/css/style.css'/>" type="text/css" />
	<script type="text/javascript" src="<c:url value='/resources/js/jquery.min.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/jquery.easing.1.3.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/jquery-ui-1.8.16.custom.min.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/all-in-one-min.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/setup.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/constants/constants.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/util/validate.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources/apps/highchart/highcharts.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources/apps/highchart/modules/exporting.js'/>"></script>

	<script type="text/javascript">
	$(function () {
	   $('#container1').highcharts({
	   	chart: {
	     	plotBackgroundColor: null,
	       plotBorderWidth: null,
	       plotShadow: false
	       	},
	     title: {
	     	text: 'Browser market shares at a specific website, 2010'
	       	},
	     tooltip: {
	   		pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
	       	},
	     plotOptions: {
	       pie: {
	         allowPointSelect: true,
	         cursor: 'pointer',
	         dataLabels: {
	         	enabled: true,
	           color: '#000000',
	           connectorColor: '#000000',
	           format: '<b>{point.name}</b>: {point.percentage:.1f} %'
	             		}
	           	}
	       	},
	     series: [{
	     	type: 'pie',
	       name: 'Browser share',
	       data: [
	        	['Firefox',   45.0],
	         	['IE',       26.8],
	          			  		{
	              name: 'Chrome',
	              y: 12.8,
	              sliced: true,
	              selected: true
	          					},
	          ['Safari',    8.5],
	          ['Opera',     6.2],
	          ['Others',   0.7]
	            ]
	        }]
	    });
	
	$('#container2').highcharts({
	   	chart: {
	     	plotBackgroundColor: null,
	       plotBorderWidth: null,
	       plotShadow: false
	       	},
	     title: {
	     	text: 'Browser market shares at a specific website, 2010'
	       	},
	     tooltip: {
	   		pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
	       	},
	     plotOptions: {
	       pie: {
	         allowPointSelect: true,
	         cursor: 'pointer',
	         dataLabels: {
	         	enabled: true,
	           color: '#000000',
	           connectorColor: '#000000',
	           format: '<b>{point.name}</b>: {point.percentage:.1f} %'
	             		}
	           	}
	       	},
	     series: [{
	     	type: 'pie',
	       name: 'Browser share',
	       data: [
	        	['Firefox',   45.0],
	         	['IE',       26.8],
	          			  		{
	              name: 'Chrome',
	              y: 12.8,
	              sliced: true,
	              selected: true
	          					},
	          ['Safari',    8.5],
	          ['Opera',     6.2],
	          ['Others',   0.7]
	            ]
	        }]
	    });
	
	$('#container3').highcharts({
	   	chart: {
	     	plotBackgroundColor: null,
	       plotBorderWidth: null,
	       plotShadow: false
	       	},
	     title: {
	     	text: 'Browser market shares at a specific website, 2010'
	       	},
	     tooltip: {
	   		pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
	       	},
	     plotOptions: {
	       pie: {
	         allowPointSelect: true,
	         cursor: 'pointer',
	         dataLabels: {
	         	enabled: true,
	           color: '#000000',
	           connectorColor: '#000000',
	           format: '<b>{point.name}</b>: {point.percentage:.1f} %'
	             		}
	           	}
	       	},
	     series: [{
	     	type: 'pie',
	       name: 'Browser share',
	       data: [
	        	['Firefox',   45.0],
	         	['IE',       26.8],
	          			  		{
	              name: 'Chrome',
	              y: 12.8,
	              sliced: true,
	              selected: true
	          					},
	          ['Safari',    8.5],
	          ['Opera',     6.2],
	          ['Others',   0.7]
	            ]
	        }]
	    });
	});
	</script>
</head>
<body>
<section class="container clearfix">
	<header class="container page_info clearfix">
		<h1 class="regular brown bottom_line">Typography</h1>
		<div class="clear"></div>
	</header>
	<div class="col_1_3">
		<div id="container1" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
	</div>
	
	<div class="col_1_3">
		<div id="container2" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
	</div>
	
	<div class="col_1_3 last">
		<div id="container3" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
	</div>
	<div class="clear"></div>
</section>
</body>
</html>