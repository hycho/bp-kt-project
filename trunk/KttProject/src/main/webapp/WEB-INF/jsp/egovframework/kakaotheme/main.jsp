<%@ include file="common/initPage.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Theme</title>
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/kakaotheme/main.css'/>"/>
<script src="<c:url value='/script/egovframework/kakaotheme/main/jquery-1.8.2.js'/>"></script>
<script src="<c:url value='/script/egovframework/kakaotheme/main/cufon-yui.js'/>"></script>
<script src="<c:url value='/script/egovframework/kakaotheme/main/jquery.fancybox-1.3.2.pack.js'/>"></script>
<script src="<c:url value='/script/egovframework/kakaotheme/main/jquery.tools.js'/>"></script>
<script src="<c:url value='/script/egovframework/kakaotheme/main/pitch.js'/>"></script>
<script src="<c:url value='/script/egovframework/kakaotheme/main/Titillium.font.js'/>"></script>
<script type="text/javascript">
Cufon.replace('h1,h2,h3,#menu li a');
Counter(new Date("Oct 20 2012 12:00:00 UTC"));
var done_message = "It's here!";
$(document).ready(function() {
	anim(); 
	$(".scrollable").scrollable({ });
	$(".items a").fancybox({
		'titlePosition'		: 'inside',
		'overlayColor'		: '#000',
		'overlayOpacity'	: 0.9
	});
});
</script>
</head>
<body>
	<div id="content">
	
		<!-- top -->
		<div id="top">
			<h1 id="logo"><a href="#">Fine<span>Product</span></a></h1>
			<ul id="menu">
				<li><a class="current" href="#">Home</a></li>
				<li><a href="#">About</a></li>
				<li><a href="#">Press Releases</a></li>
				<li><a href="#">Contact</a></li>
			</ul>
		</div>
		<!-- /top -->
		
		<!-- pitch -->
		<div id="pitch">
			<h2 id="hello">Revolutionizing the way you communicate online.</h2>
			<p id="countdown"></p>
		</div>
		<!-- /pitch -->
		
		<!-- screenshots -->		
		<div id="screenshots">		
			<a href="javascript:;" class="arrows prev">Previous</a>
		
			<div class="scrollable">
				<div class="items">
					
					<!-- group 1 -->
					<ul>
						<li><a href="/images/egovframework/kakaotheme/main/screenshots/big1.jpg" title="Image Caption"><img src="/images/egovframework/kakaotheme/main/screenshots/thumb1.jpg" alt="Image" /></a></li>
						<li><a href="/images/egovframework/kakaotheme/main/screenshots/big1.jpg" title="Image Caption"><img src="/images/egovframework/kakaotheme/main/screenshots/thumb1.jpg" alt="Image" /></a></li>
						<li><a href="/images/egovframework/kakaotheme/main/screenshots/big1jpg" title="Image Caption"><img src="/images/egovframework/kakaotheme/main/screenshots/thumb1.jpg" alt="Image" /></a></li>
						<li><a href="/images/egovframework/kakaotheme/main/screenshots/big1.jpg" title="Image Caption"><img src="/images/egovframework/kakaotheme/main/screenshots/thumb1.jpg" alt="Image" /></a></li>
					</ul>
					<!-- /group 1 -->	
				
					<!-- group 2 -->
					<ul>
						<li><a href="/images/egovframework/kakaotheme/main/screenshots/big1.jpg" title="Image Caption"><img src="/images/egovframework/kakaotheme/main/screenshots/thumb1.jpg" alt="Image" /></a></li>
						<li><a href="/images/egovframework/kakaotheme/main/screenshots/big1.jpg" title="Image Caption"><img src="/images/egovframework/kakaotheme/main/screenshots/thumb1.jpg" alt="Image" /></a></li>
						<li><a href="/images/egovframework/kakaotheme/main/screenshots/big1.jpg" title="Image Caption"><img src="/images/egovframework/kakaotheme/main/screenshots/thumb1.jpg" alt="Image" /></a></li>
						<li><a href="/images/egovframework/kakaotheme/main/screenshots/big1.jpg" title="Image Caption"><img src="/images/egovframework/kakaotheme/main/screenshots/thumb1.jpg" alt="Image" /></a></li>
					</ul>
					<!-- /group 2 -->
					
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
				<script type="text/javascript" src="http://widgets.twimg.com/j/2/widget.js"></script>
				<script type="text/javascript">new TWTR.Widget({version:2,type:'profile',rpp:11,interval:4000,width:'auto',height:135,theme:{shell:{background:'none',color:'#A7A6AE'},tweets:{background:'none',color:'#A7A6AE',links:'#DCDCDE'}},features:{scrollbar:false,loop:false,live:true,hashtags:true,timestamp:false,avatars:false,behavior:'default'}}).render().setUser('solucija').start();</script>
				<!-- /twitter widget -->
				
			</div>
			<div class="boxbottom"></div>
			
		</div>
		<!-- /side -->
		
		<!-- footer -->
		<div id="footer">
			<p>&copy; 2012 <a href="#">FineProduct</a> &middot; All Rights Reserved &middot; <a title="Awesome Web Templates" href="http://www.solucija.com/">Solucija</a></p>
		</div>
		<!-- /footer -->
	</div>
</body>
</html>
