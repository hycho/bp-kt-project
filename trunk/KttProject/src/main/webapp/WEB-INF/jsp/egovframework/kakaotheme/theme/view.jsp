<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="../common/initPage.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Theme view</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/css/egovframework/kakaotheme/main.css'/>"/>
<script src="<c:url value='/script/egovframework/kakaotheme/main/jquery-1.8.2.js'/>"></script>
<script src="<c:url value='/script/egovframework/kakaotheme/main/cufon-yui.js'/>"></script>
<script src="<c:url value='/script/egovframework/kakaotheme/main/jquery.fancybox-1.3.2.pack.js'/>"></script>
<script src="<c:url value='/script/egovframework/kakaotheme/main/jquery.tools.js'/>"></script>
<script src="<c:url value='/script/egovframework/kakaotheme/main/pitch.js'/>"></script>
<script src="<c:url value='/script/egovframework/kakaotheme/main/Titillium.font.js'/>"></script>

<script type="text/javascript" src="http://widgets.twimg.com/j/2/widget.js"></script>

<script type="text/javascript">
Cufon.replace('h1,h2,h3');
Counter(new Date("Oct 20 2012 12:00:00 UTC"));

var done_message = "It's here!";
$(document).ready(function() {
	anim(); 
	$(".scrollable").scrollable({ });
	
	$(".download").click(function(){
		getRecommendThemeListAjax($(this).attr("key"));
	});
});

function getRecommendThemeListAjax(themeKey){
	$.ajax({
		type:"POST",
		url:"/theme/runPackageDownAjax.do",
		data:{
			themeSeq : themeKey
		},
		success:function(data){
			window.location="${WEB_PATH}/"+themeKey+"/downLoad.apk";
		},
		error:function(request, status, error){
			console.log(request);
			console.log(status);
			console.log(error);
		}
	});
}


</script>
</head>
<body>
	<div id="content">
		<!-- top -->
		<div id="top">
			<h1 id="logo"><a href="#">KTA<span>Project</span></a></h1>
			<ul id="menu">
				<li><a href="/page/main.do">Home</a></li>
				<li><a class="current" href="/page/theme.do">Theme</a></li>
				<li><a href="/page/about.do">About</a></li>
				<li><a href="#">Contact</a></li> 
			</ul>
		</div>
		<!-- /top -->
		
		<!-- pitch -->
		<div id="pitch">
			<h2 id="hello">Revolutionizing the way you authoring theme online.</h2>
			<p id="countdown"></p>
		</div>
		<!-- /pitch -->
		
		<!-- main (left side) -->		
		<div id="main">
			<h3>${result.THEME_NAME}</h3>
			<p><strong>${result.THEME_DESC}</strong></p>
			<p>Author : ${result.CREATOR}</p>
			<p><a class="more download" href="#" key="${result.THEME_SEQ}">Down Load</a></p>
		</div>
		<!-- /main (left side) -->
		
		<!-- side -->
		<div id="side">
			<div class="boxtop"></div>
			<div class="boxmiddle">
			</div>
			<div class="boxbottom"></div>
			
		</div>
		<!-- /side -->
		
		<div id="cols"></div>
		<!-- columns -->
		<div id="cols">
			
			<!-- left column -->
			<div class="col">
				<h3>Robust and Modular</h3>
				<p>Quisque scelerisque purus quis eros sollicitudin gravida. Aliquam erat volutpat. Donec a sem consequat tortor posuere dignissim sit amet at ipsum.</p>
				<p><a class="more" href="#">Read More</a></p>
			</div>
			<!-- /left column -->
			
			<!-- middle column -->
			<div class="col">
				<h3>Simple to Use</h3>
				<p>Quisque scelerisque purus quis eros sollicitudin gravida. Aliquam erat volutpat. Donec a sem consequat tortor posuere dignissim sit amet at ipsum.</p>
				<p><a class="more" href="#">Read More</a></p>
			</div>
			<!-- /middle column -->
			
			<!-- right column -->
			<div class="col last">
				<h3>Interactive and Fun</h3>
				<p>Quisque scelerisque purus quis eros sollicitudin gravida. Aliquam erat volutpat. Donec a sem consequat tortor posuere dignissim sit amet at ipsum.</p>
				<p><a class="more" href="#">Read More</a></p>
			</div>
			<!-- /right column -->
			
			<div class="clear"></div>
		</div>
		<!-- /columns -->		
		
		<!-- footer -->
		<div id="footer" class="footer_area">
			<p>&copy; 2013 <a href="#">KTA Product</a> &middot; All Rights Reserved &middot; <a title="Good Developer" href="http://babayetustudy.tistory.com//">Cho Ho Young</a></p>
		</div>
		<!-- /footer -->
	</div>
</body>
</html>
