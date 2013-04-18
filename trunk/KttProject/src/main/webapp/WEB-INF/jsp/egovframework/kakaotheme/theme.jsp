<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="common/initPage.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Theme</title>
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
});
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
		
		<!-- columns -->
		<div id="cols">
			
			<!-- left column -->
			<div class="col">
				<p><img width="220px" height="100px" src="${WEB_PATH}/1/thumbnail.jpg" alt="Image" /></p>
				<p><a class="more" href="#">다운로드</a></p>
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
		
		
		
		<!-- side -->
		<div id="side">
			<div class="boxtop"></div>
			<div class="boxmiddle">
				<!-- twitter widget -->
				<script type="text/javascript">
					new TWTR.Widget({
						version:2,
						type:'profile',
						rpp:11,
						interval:30000,
						width:'auto',
						height:135,
						theme:{
							shell:{
								background:'none',
								color:'#A7A6AE'
							},
							tweets:{
								background:'none',
								color:'#A7A6AE',
								links:'#DCDCDE'
							}
						},
						features:{
							scrollbar:false,
							loop:false,
							live:true,
							hashtags:true,
							timestamp:false,
							avatars:false,
							behavior:'default'
						}
					}).render().setUser('kofwhgh').start();</script>
				</script>
				<!-- /twitter widget -->
			</div>
			<div class="boxbottom"></div>
			
		</div>
		<!-- /side -->
		
		<!-- footer -->
		<div id="footer" class="footer_area">
			<p>&copy; 2013 <a href="#">KTA Product</a> &middot; All Rights Reserved &middot; <a title="Good Developer" href="http://babayetustudy.tistory.com//">Cho Ho Young</a></p>
		</div>
		<!-- /footer -->
	</div>
</body>
</html>
