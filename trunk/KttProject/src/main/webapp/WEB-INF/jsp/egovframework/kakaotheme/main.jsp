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
	getRecommendThemeListAjax();
});

function getRecommendThemeListAjax(){
	$.ajax({
		type:"POST",
		url:"/theme/recommendThemeListAjax.do",
		data:{
			cnt : 8
		},
		success:function(data){
			var jsonData = $.parseJSON(data);
			var themeItemHtml = '<ul>';
			
			$.each(jsonData.data, function(index, map){
				themeItemHtml += '<li>'+
								 '<a class="recommendTheme" key="'+map.THEME_SEQ+'" href="#" title="'+map.THEME_NAME+'">'+
								 '<img width="171px" height="100px" src="${WEB_PATH}/'+map.THEME_SEQ+'/thumbnail.jpg" alt="Image" />'+
								 '</a>'+
								 '</li>';
			});
			
			themeItemHtml += '</ul>';
			$("#recommendItems").append(themeItemHtml);
			
			$(".recommendTheme").click(function(){
				console.log("themeView seq = " + $(this).attr("key"));
				$("#viewThemeForm").find("#themeSeq").val($(this).attr("key"));
				$("#viewThemeForm").submit();
			});
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
	<form id="viewThemeForm" name="viewThemeForm" action="/theme/viewTheme.do" method="post">
		<input type="hidden" id="themeSeq" name="themeSeq" value=""/>
	</form>
	<div id="content">
		<!-- top -->
		<div id="top">
			<h1 id="logo"><a href="#">KTA<span>Project</span></a></h1>
			<ul id="menu">
				<li><a class="current" href="/page/main.do">Home</a></li>
				<li><a href="/page/theme.do">Theme</a></li>
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
		
		<!-- screenshots -->		
		<div id="screenshots">		
			<a href="javascript:;" class="arrows prev">Previous</a>
		
			<div class="scrollable">
				<div id="recommendItems" class="items">
				</div>
			</div>
		
			<a href="javascript:;" class="arrows next">Next</a>
			
			<div class="clear"></div>
		</div>
		<!-- /screenshots -->
		
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
		
		<!-- main (left side) -->		
		<div id="main">
			<h3>Main Features</h3>
			<p><strong>Lorem ipsum dolor sit amet, consectetur adipiscing elit quisque vel lorem eu libero Aenean placerat, ligula quis placerat iaculis, mi magna luctus nibh, adipiscing pretium.</strong></p>
			<p>Quisque consectetur odio ut sem semper commodo. Maecenas iaculis leo a ligula euismod condimentum. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Ut enim risus, rhoncus sit amet ultricies vel, aliquet ut dolor. Duis iaculis urna vel massa ultricies suscipit. Phasellus diam sapien, fermentum a eleifend non, luctus non augue. Quisque scelerisque purus quis eros sollicitudin gravida. Aliquam erat volutpat. Donec a sem consequat tortor posuere dignissim sit amet at ipsum. </p>
			<p><a class="more" href="#">Read More</a></p>
		</div>
		<!-- /main (left side) -->
		
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
					}).render().setUser('kofwhgh').start();
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
