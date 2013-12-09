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
	<script type="text/javascript" src="<c:url value='/resources/js/util/analysisUtil.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/util/validate.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources/apps/highchart/highcharts.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources/apps/highchart/modules/exporting.js'/>"></script>

	<script type="text/javascript">
	$(function () {
		var sexChart = new Highcharts.Chart({
			chart: {
					renderTo: 'sexChartContainer',
		     	plotBackgroundColor: null,
		      plotBorderWidth: null,
		      plotShadow: false
		    },
	    title: {
	     text: 'sexChartContainer'
	       	},
	    tooltip: {
	    	pointFormat: '{point.y}건'
	       	},
	    plotOptions: {
	    	pie: {
	      	allowPointSelect: true,
	        cursor: 'pointer',
	        dataLabels: {
	        	enabled: false,
	             	},
	      	showInLegend: true
	        	}
	       	},
	    series: [{
	    	type: 'pie',
	      name: 'Browser share'
	        }]
		});
		
		var ageChart = new Highcharts.Chart({
			chart: {
				renderTo: 'ageChartContainer',
	     	plotBackgroundColor: null,
	      plotBorderWidth: null,
	      plotShadow: false
	    	},
	    title: {
	     text: 'ageChartContainer'
	       	},
	    tooltip: {
	    	pointFormat: '{point.y}건'
	       	},
	    plotOptions: {
	    	pie: {
	      	allowPointSelect: true,
	        cursor: 'pointer',
	        dataLabels: {
	        	enabled: false,
	             	},
	      	showInLegend: true
	        	}
	       	},
	    series: [{
	    	type: 'pie',
	      name: 'Browser share'
	        }]
		});
	
		var idTop5Chart = new Highcharts.Chart({
			chart: {
				renderTo: 'idTop5ChartContainer',
	     	plotBackgroundColor: null,
	      plotBorderWidth: null,
	      plotShadow: false
		    },
	    title: {
	     text: 'idTop5ChartContainer'
	       	},
	    tooltip: {
	   		pointFormat: '{point.y}건'
	       	},
	    plotOptions: {
	    	pie: {
	      	allowPointSelect: true,
	        cursor: 'pointer',
	        dataLabels: {
	        	enabled: false,
	             	},
	      	showInLegend: true
	        	}
	       	},
	    series: [{
	    	type: 'pie',
	      name: 'Browser share'
	        }]
		});
		
		function initChart(spackage, smethod){	
			$.ajax("/rest/analysis/selectAnalysisSexForServiceList", {
		    type: "post",
	    	dataType: "json",
	    	data:{spackage: spackage, smethod: smethod},
	    	success: function(result){
		    	var sexData = [];
		    	$(result).each(function(idx, obj){
		    		console.log(obj);
		    		sexData.push([obj.SEXTYPE, obj.TOT]);
		    		});
		    	sexChart.series[0].setData(sexData);
		     	}
			});
			
			$.ajax("/rest/analysis/selectAnalysisAgeForServiceList", {
		    type: "post",
	    	dataType: "json",
	    	data:{spackage: spackage, smethod: smethod},
	    	success: function(result){
		    	var ageData = [];
		    	$(result).each(function(idx, obj){
		    		ageData.push([obj.BGT+"0대", obj.TOT]);
		    		});
		    	ageChart.series[0].setData(ageData);
		     	}
			});
			
			$.ajax("/rest/analysis/selectAnalysisTop5IdForServiceList", {
		    type: "post",
	    	dataType: "json",
	    	data:{spackage: spackage, smethod: smethod},
	    	success: function(result){
		    	var Top5Data = [];
		    	$(result).each(function(idx, obj){
		    		console.log(obj);
		    		Top5Data.push([obj.USERID, obj.TOT]);
		    		});
		    	idTop5Chart.series[0].setData(Top5Data);
		     	}
			});
		}
		
		function initEvent(){
			$("#btnAnalysis").click(function(){
				initChart($("#selPackage").val(), $("#selMethod").val());
			});
		};
			
		initChart($("#selPackage").val(), $("#selMethod").val());
		initEvent();
	});
	</script>
</head>
<body>
<section class="container clearfix">
	<header class="container page_info clearfix">
		<h1 class="regular brown bottom_line">Client Analysis1</h1>
		<div class="clear"></div>
	</header>
	<div>
		<p>
			<select id="selPackage">
			  <option value="com.cframe.framework.components.user.web.UserManagerController">com.cframe.framework.components.user.web.UserManagerController</option>
	    </select>
	    <select id="selMethod">
			  <option value="userListView">userListView</option>
	    </select>
			<a id="btnAnalysis" href="#" style="margin-bottom:0px" class="button white">분석</a>
		</p>
	</div>
	<div class="col_1_3">
		<div id="sexChartContainer" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
	</div>
	
	<div class="col_1_3">
		<div id="ageChartContainer" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
	</div>
	
	<div class="col_1_3 last">
		<div id="idTop5ChartContainer" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
	</div>
	<div class="clear"></div>
</section>
</body>
</html>