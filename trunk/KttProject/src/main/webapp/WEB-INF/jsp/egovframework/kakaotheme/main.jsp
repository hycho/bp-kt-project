<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="common/initPage.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Theme</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/css/egovframework/kakaotheme/main.css'/>"/>
<link rel="stylesheet" type="text/css" href="<c:url value='/css/egovframework/kakaotheme/look.css'/>"/>
<link rel="stylesheet" type="text/css" href="<c:url value='/css/egovframework/kakaotheme/loading1.css'/>"/>
<link rel="stylesheet" type="text/css" href="<c:url value='/css/egovframework/kakaotheme/layer1.css'/>"/>

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

var done_message = "Now Try This!";

$(document).ready(function() {
	anim(); 
	$(".scrollable").scrollable({ });
	getRecommendThemeListAjax();
	
	evt_clickImportTheme();
});

function evt_clickImportTheme(){
	$("#btnImportTheme").click(function(){
		$("#importTheme").trigger("click");
	});
}

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
			var jsonDataLength = jsonData.data.length;
			
			$.each(jsonData.data, function(index, map){
				themeItemHtml += '<li>'+
								 '<a class="recommendTheme" key="'+map.THEME_SEQ+'" href="#" title="'+map.THEME_NAME+'">'+
								 '<img width="171px" height="100px" src="${WEB_PATH}/'+map.THEME_SEQ+'/thumbnail.jpg" alt="Image" />'+
								 '</a>'+
								 '</li>';
								 
				if((index+1)%4 == 0){								 
					themeItemHtml += '</ul>';
					if((index+1) != jsonDataLength){
						themeItemHtml += '<ul>';
					}
				}
				
				if((index+1) == jsonDataLength){								 
					themeItemHtml += '</ul>';
				}
			});
			
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

function importThemeFile(object){
	console.log("### Start main.jsp importThemeFile function ###");
	var files = object.files;
	
	var themeFormData = new FormData();
	themeFormData.append("importFile",files[0]);
		
	$.ajax({
		type:"POST",
		url:"/theme/importThemeAjax.do",
		data: themeFormData,
		success:function(data){
			console.log("Import theme file success Data : " + data);
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
	<!-- File Import -->
	<input type="file" id="importTheme" name="importTheme" style="display:none" onChange="importThemeFile(this)" />
	
	<form id="viewThemeForm" name="viewThemeForm" action="/theme/viewTheme.do" method="post">
		<input type="hidden" id="themeSeq" name="themeSeq" value=""/>
	</form>
	<div id="content">
		<!-- top -->
		<div id="top">
			<h1 id="logo"><a href="#">Theme Authoring<span> Project</span></a></h1>
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
				<h3>Sharing & Store</h3>
				<p>Mobile/PC상에서 직접 저작하신 테마를 세계의 모든 사람들과 공유할 수 있습니다. 또한 무료로 배포하거나 사고 팔 수 있습니다.</p>
				<p><a class="more" href="#">Read More</a></p>
			</div>
			<!-- /left column -->
			
			<!-- middle column -->
			<div class="col">
				<h3>Simple to Use</h3>
				<p>쉽게 저작할 수 있고 남녀노소 누구나 자신만의 테마를 저작/설치/공유를 최대한 쉽도록 만들었습니다.</p>
				<p><a class="more" href="#">Read More</a></p>
			</div>
			<!-- /middle column -->
			
			<!-- right column -->
			<div class="col last">
				<h3>Beautiful & Fantastic</h3>
				<p>아름답고 판타스틱한 자신만의 테마를 만들어 보세요. 만드신 테마는 카카오톡에서 멋지게 동작을 합니다.</p>
				<p><a class="more" href="#">Read More</a></p>
			</div>
			<!-- /right column -->
			
			<div class="clear"></div>
		</div>
		<!-- /columns -->		
		
		<!-- main (left side) -->		
		<div id="main">
			<h3>Try new things!</h3>
			<p><strong>시도 해 보세요. 자기만의 새로운 것을 만드는 것은 인간의 본성입니다. 자신이 원하는 것을 만들어 보세요. 대박을 터트릴지 모릅니다.</strong></p>
			<p>
				저희는 도전적이고, 활력 넘치는 삶을 살려고 합니다. 제가 말씀드렸듯이, 도전이란 위대합니다. 저는 어떠한 일도 도전이라고 생각합니다. 하는 일이 어렵지만 아주 도전적이에요.
				실패 하더라도 도전 해 볼만하다. 그것은 도전이고 난 도전하는것을 사랑한다. 순간을 사랑하세요, 그러면 그 순간의 에너지가 퍼져나갈 겁니다.
				결국 삶이란 여러분이 되고자 했던 완벽한 인격체로 거듭나는 것입니다. 낙관주의는 성공으로 인도하는 믿음이다. 희망과 자신감이 없으면 아무것도 이루어질 수 없다.
			</p>
			<p><a class="more" id="btnImportTheme">Import</a></p>
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

	<div id="loading_layer" class="mw_layer open" style="display:none">
		<div class="bg"></div>
		<div class="mw_layer_body">
			<a href="#" title="로그인 레이어 닫기" class="close">X</a>
			<fieldset>
			    <div class="ly_cont pb_margin30 pl_margin90">
			        <div class="ly_body">
			            <p class="dsc_loading">파일 Import 중...</p>
			            <img src="http://static.naver.com/common/loading/load_b01_01.gif" width="150" height="13" alt="로딩중">
			        </div>
			    </div>
				<ul class="help">
					<li class="first"><a href="#">취소</a></li>
				</ul>
			</fieldset>
		</div>
	</div>
</body>
</html>
