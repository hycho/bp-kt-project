<%@ include file="/WEB-INF/views/common/init.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title><spring:message code="title"/></title>
<link href="resources/css/styles.css" rel="stylesheet" type="text/css" />
<link href="resources/apps/jquery-ui-1.9.0.custom/css/smoothness/jquery-ui-1.9.0.custom.css" rel="stylesheet" type="text/css" />
<link rel="icon" href="resources/images/icon.ico" />

<script src="resources/js/jquery-1.8.2.js"></script>
<script src="resources/apps/jquery-ui-1.9.0.custom/js/jquery-ui-1.9.0.custom.js"></script>
<script type="text/javascript">
	$(document).ready(function(){	
	  aEvent();
	  $( "#tabs" ).tabs();
	  settingGridster();
	});
	
	var aEvent = function(){
		$.each($("body").find("a"), function(){
			var action = null;
			switch($(this).attr("href")){
				case "#newAuthoring":
					action = newAuthoring;
					break;
				default:
					break;
			}
			if(action != null && action !== ""){
				$(this).click(function(){
					action();
				});
			}
		});
		
		// Layer 흐릿한 백그라운드를 클릭하면 Layer를 삭제 하도록 해놓음.
		$("#layer").find(".bg").click(function(){
			$("#layer").fadeOut();
		});
	};
	
	var newAuthoring = function(){
		openLayer("layer1");
	};
	
	var openLayer = function(id){
		$(".layer").fadeIn();
		
		var temp = $("#" + id);
		if(temp.outerHeight() < $(document).height()){
			temp.css("margin-top", "-"+temp.outerHeight()/2+"px");
		}else{
			temp.css("top", "0px");
		}
		
		if(temp.outerWidth() < $(document).width()){
			temp.css("margin-left", "-"+temp.outerWidth()/2+"px");
		}else{
			temp.css("left", "0px");
		}
		
		$("#tabs div.ui-tabs-panel").css("height", parseInt(temp.css("height"))-parseInt($("#tabs ul.ui-tabs-nav").css("height"))-(parseInt($("#tabs").parent().css("padding-top")) * 3));
	};
</script> 
</head>
<body>
<div id="mainWrap">
	<div id="mainPanel">
		<div id="menu">
		  	<ul>
		   		<li><a href="#"><span>홈</span></a></li>
				<li><div class="blank"></div></li>
				<li><a href="#"><span>저작도구</span></a></li>
				<li><div class="blank"></div></li>
				<li><a href="#"><span>지원</span></a></li>
				<li><div class="blank"></div></li>
				<li><a href="#"><span>포럼</span></a></li>
				<li><div class="blank"></div></li>
				<li><a href="#"><span>개발자이야기</span></a></li>
				<li><div class="blank"></div></li>
				<li><a href="#"><span>연락처</span></a></li>
		  	</ul>
		</div>
		<div id="logoWrap"><h1>카카오테마</h1></div>
		<div id="loginPanel">
		  	<h2>조호영님 어서오세요.</h2>
		  	<p>쪽지 : <a href="#">15통</a></p>
		 	<p>
		 		<a href="#newAuthoring" class="login">새로저작</a>
		 		<span class="blank2"></span>
		 		<a href="#" class="login">테마목록</a>
		 	</p>
		</div>
	</div>
</div>
<div id="layer" class="layer">
	<div class="bg"></div>
	<div class="layer_area" id="layer1" style="width:1000px; height:600px;">
		<div id="tabs">
			<ul>
				<li><a href="#tabs-1">1단계: 기본</a></li>
				<li><a href="#tabs-2">2단계: 테마</a></li>
				<li><a href="#tabs-3">3단계: 보색</a></li>
				<li><a href="#tabs-4">4단계: 완료</a></li>
			</ul>
			<div id="tabs-1">
				 <h3>1단계 : 기본 설정</h3>
				 <p>테마 이름과 테마 어플리케이션 이름을 입력합니다.</p>
				 <p>카카오톡의 테마 설정 화면에서 보여지는 이름이며 원하시는 이름을 입력해 주시기 바랍니다. </p>
				 <p>테마 이름 : <input type="text" id="themeName" name="themeName" value=""/></p>
				 <p>어플 이름 : <input type="text" id="appName" name="appName" value=""/></p>
			</div>
			<div id="tabs-2">
				<h3>2단계 : 테마 설정</h3>
				<p>초기 테마 설정을 해주십시요</p>
				<p>테마는 차후 수정이 가능 합니다. </p>
				<p>테마 검색 : <input type="text" id="appName" name="appName" value=""/> <button>검색</button> </p>
				<div class="fieldset" style="height:150px;">Theme Sample</div>
				<p class="redlabel">※ 위는 적용할 테마입니다.</p>
				<div class="fieldset" style="height:150px;">Theme Sample</div>
				<p class="redlabel">※ 선택된 테마가 적용이 된 화면입니다.</p>
			</div>
			<div id="tabs-3">
				<h3>3단계 : 보색 설정</h3>
				<p>보색 설정을 해주십시요</p>
				<p>보색은 차후 수정이 가능 합니다. </p>
				<p>보색 검색 : <input type="text" id="appName" name="appName" value=""/> <button>검색</button> </p>
				<div class="fieldset" style="width:250px; height:380px;">Theme Sample</div>
			</div>
			<div id="tabs-4">
				<h3>4단계 : 완료 설정</h3>
				<div class="fieldset" style="height:460px;">Theme Sample</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>
