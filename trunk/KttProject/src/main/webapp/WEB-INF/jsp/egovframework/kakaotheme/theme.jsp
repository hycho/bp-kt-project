<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>KaKao Theme</title>
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/kakaotheme/base.css'/>"/>
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/kakaotheme/styles.css'/>"/>
<link rel="stylesheet" href="<c:url value='/images/egovframework/kakaotheme/icon.ico'/>"/>
<script src="<c:url value='/script/jquery-1.8.2.js'/>"></script>
<script src="<c:url value='/script/kakaotheme/menu.js'/>"></script>
<script type="text/javascript">
$(document).ready(function() {
	// call to menu.js
	eventMenu($(".menu"), $("#goPage"));
	getThemeListAjax();
});
	
function getThemeListAjax(){
	$.ajax({
		type:"POST",
		url:"/theme/themeListAjax.do",
		success:function(data){
			console.log(data);
		},
		error:function(request, status, error){
			alert(request);
			alert(status);
			alert(error);
		}
	});
}
</script>
</head>

<body>
	<form id="goPage" action="authoring">
		<input type="hidden" value="Hello there" />
		<input type="hidden" value="Go" />
	</form>
	<div class="mainWrap">
		<div class="mainPanel">
			<div class="menu">
				<ul>
					<li><a href="#" page="/page/main.do"><span><spring:message code="btn.menu.home" ></spring:message></span></a></li>
					<li><div class="blank"></div></li>
					<li><a href="#" page="/page/theme.do"><span><spring:message code="btn.menu.theme" ></spring:message></span></a></li>
					<li><div class="blank"></div></li>
					<li><a href="#" page="/page/support.do"><span><spring:message code="btn.menu.support" ></spring:message></span></a></li>
					<li><div class="blank"></div></li>
					<li><a href="#" page="/page/forum.do"><span><spring:message code="btn.menu.forum" ></spring:message></span></a></li>
					<li><div class="blank"></div></li>
					<li><a href="#" page="/page/story.do"><span><spring:message code="btn.menu.story" ></spring:message></span></a></li>
					<li><div class="blank"></div></li>
					<li><a href="#" page="/page/contact.do"><span><spring:message code="btn.menu.contact" ></spring:message></span></a></li>
				</ul>
			</div>
			<div>
				<h1>카카오테마</h1>
			</div>
			<div class="loginPanel">
				<h2>로그인</h2>
				<input name="name" type="text" value="아이디"
					onfocus="if(this.value=='User Name')this.value=''"
					onblur="if(this.value=='')this.value='User Name'" />
				<div class="blank"></div>
				<input name="name" type="text" value="패스워드"
					onfocus="if(this.value=='Password')this.value=''"
					onblur="if(this.value=='')this.value='Password'" />
				<p>
					회원이 아니십니까? <a href="#">가입요청</a>
				</p>
				<a href="login?userid=hycho&userpassword=hycho" class="login">Login</a>
			</div>
			<div class="quots">
				<p>&nbsp;</p>
				<p>&nbsp;</p>
			</div>
			<div class="cb"></div>
			<article class="gallery_list_type">
   				<div class="gallery_list_type_left">
   					<a href="#" class="images_thumbnail_120_80"><img src="./images/ubion/no-image-120.gif"></a><br>
   				</div>
				<dl class="gallery_list_type_center">
					<dt><a href="#">JAVA 기본 문법 정복</a></dt>
					<dd class="dd_info ell"><span>학습내용</span>JAVA 프로그래밍의 가장 기초가 되는 기본문법에 대해 학습합니다. 뒤에 나오는 내용들은 자동 줄임.</dd>
					<dd class="star_count">평점 5&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;리뷰 <span class="review_count">121</span></dd>
					<dd class="sub_info">저작자 <span class="info_creator">홍길동</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;등록일 <span class="info_createddate">2012.12.12</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;분류 <span class="info_category">JAVA</span></dd>
				</dl>
				<div class="cb"></div>
			</article>
			<div class="footPanel">
				<div class="nav">
					<ul>
						<li><a href="#">Home</a></li>
						<li><div class="blank">|</div></li>
						<li><a href="#">About Us</a></li>
						<li><div class="blank">|</div></li>
						<li><a href="#">Suppor</a></li>
						<li><div class="blank">|</div></li>
						<li><a href="#">Forum</a></li>
						<li><div class="blank">|</div></li>
						<li><a href="#">Development</a></li>
						<li><div class="blank">|</div></li>
						<li><a href="#">Conact Us</a></li>
					</ul>
				</div>
				<div class="copyright">© Copyright Infirmation Goes Here. All
					Rights Reserved.</div>
				<p class="designInfo">
					Design by <a href="http://www.templateworld.com/">TemplateWorld</a>
					and brought to you by <a href="http://www.smashingmagazine.com/">SmashingMagazine</a>
				</p>
				<div class="validation">
					<ul>
						<li><a href="http://validator.w3.org/check?uri=referer">xhtml</a></li>
						<li><div class="blank"></div></li>
						<li><a
							href="http://jigsaw.w3.org/css-validator/check/referer">css</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
