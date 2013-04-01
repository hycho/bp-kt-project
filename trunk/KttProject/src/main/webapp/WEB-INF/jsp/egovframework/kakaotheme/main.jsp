<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>KaKao Theme</title>
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/kakaotheme/styles.css'/>"/>
<link rel="stylesheet" href="<c:url value='/images/egovframework/kakaotheme/icon.ico'/>"/>
<script src="<c:url value='/script/jquery-1.8.2.js'/>"></script>
<script src="<c:url value='/script/kakaotheme/menu.js'/>"></script>
<script type="text/javascript">
	$(document).ready(function() {
		eventMenu($("#menu"), $("#goPage"));
	});
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
				<p>"누구나 자신만의 카카오톡 테마를 저작할 수 있도록 하고 싶었습니다."</p>
			</div>
			<div class="leftPanel">
				<div class="about">
					<h2>저작이란?</h2>
					<h3>쉽고 빠른 카카오톡 저작도구</h3>
					<p>
						<span>테스트</span>
					</p>
					<div class="date">
						<div class="left">Saturday, April 26, 2008&nbsp;&nbsp;|</div>
						<div class="right">
							<a href="#">Read More</a>
						</div>
					</div>
				</div>
				<div class="services">
					<h2>Our Spectrum of Services</h2>
					<div class="pic">
						<a href="#">Cras turpis duis at sapien eget nulla vulputate. </a>
					</div>
					<p>
						<span>Donec accumsan porta risus.</span> Vestibulum
						sollicitudinlibero ut semper commodo, purus enim sollicitudin
						nulla, dictum vehicula diam lacus at purus. In egestas.
					</p>
					<h3>Services</h3>
					<ul>
						<li><a href="#">Nam congue quam non augue ivamus
								porttitor</a></li>
						<li><a href="#" class="bottom">Jam aongue buam n augue
								famus</a></li>
					</ul>
					<p>
						<span>Pellentesque dolor.</span> Nunc congue est in ante mattis
						ultrices. liquam erat volutpat. Nam congue quam non augue.
					</p>
				</div>
				<div class="testimonial">
					<h2>Testimonial</h2>
					<p>
						<span>Nullam vel justo. Mauris viverra mattis neque.</span>
						Phasellus feugiat pede ut mauris uis orcies tibulum eleifend.
						Donec est purusiaculis acauctorNullam vel justo. Mauris viverra
						mattis neque. Phasellus feugiat pede ut mauris. Duis orci.
					</p>
					<h3>
						<span>by</span> David Jackson
					</h3>
					<p>
						<span>Vel justo. Mauris viverra mattis neque asellus
							feugiat pede ut mauris uis orcies tibulum</span> eleifend. Donec est
						purusiaculis acauctorNullam vel justo. Mauris viverra mattis
						neque. Phasellus feugiat pede ut mauris.
					</p>
					<h3>
						<span>by</span> Tom Sam
					</h3>
				</div>
			</div>
			<div class="rightPanel">
				<h2>베스트 테마</h2>
				<div class="pic1"></div>
				<a href="#" class="view">view large</a>
				<div class="pic2"></div>
				<a href="#" class="view">view large</a>
				<div class="pic3"></div>
				<a href="#" class="view">view large</a>
				<div class="contacts">
					<h2>Quick Contact</h2>
					<p>Name</p>
					<input name="name" type="text" value="- enter your name -"
						onfocus="if(this.value=='- enter your name -')this.value=''"
						onblur="if(this.value=='')this.value='- enter your name -'" />
					<p>Email</p>
					<input name="name" type="text" value="- enter your email -"
						onfocus="if(this.value=='- enter your email -')this.value=''"
						onblur="if(this.value=='')this.value='- enter your email -'" />
					<div class="blank2"></div>
					<a href="#">Need a Quote?</a>
					<div class="blank"></div>
					<a href="#">Submit</a>
				</div>
				<div class="project">
					<h2>Projects Link</h2>
					<ul>
						<li><a href="#">Lorem ipsum dolor sit amet eros consequat
						</a></li>
						<li><a href="#">Consectetuer adipiscing elit</a></li>
						<li><a href="#">Etiam quis est ut diam viverra rhoncus</a></li>
						<li><a href="#">Fusce eros consequat </a></li>
						<li><a href="#">Cras eros massa blandit </a></li>
						<li><a href="#" class="bottom">Aoreet utdiam viverra</a></li>
					</ul>
				</div>
			</div>
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
