<%@ include file="/WEB-INF/views/common/init.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>KaKao Theme</title>
<link href="resources/css/styles.css" rel="stylesheet" type="text/css" />
<link rel="icon" href="resources/images/icon.ico" />

<script src="resources/js/jquery-1.8.2.js"></script>
<script type="text/javascript">
	$(document).ready(function(){	
	  goTopMenuPage();
	});
	
	var goTopMenuPage = function(){
		$.each($("#menu").find("a"), function(){
			var action = "";
			switch($(this).attr("href")){
				case "#goAuthoring":
					action = "authoring";
					break;
				default:
					break;
			}
			
			if(action != null && action !== ""){
				$(this).click(function(){
					goPage(action);
				});
			}
		});
	};
	
	var goPage = function(action){
		$("#goPage").attr("action",action).submit();
	}
</script> 
</head>

<body>
<form id="goPage" action="authoring">
  <input type="hidden" value="Hello there" />
  <input type="hidden" value="Go" />
</form>
<div id="mainWrap">
<div id="mainPanel">
 <div id="menu">
  <ul>
   <li><a href="#goHome"><span>홈</span></a></li>
   <li><div class="blank"></div></li>
   <li><a href="#goAuthoring"><span>저작도구</span></a></li>
   <li><div class="blank"></div></li>
   <li><a href="#goSupport"><span>지원</span></a></li>
   <li><div class="blank"></div></li>
   <li><a href="#goForum"><span>포럼</span></a></li>
   <li><div class="blank"></div></li>
   <li><a href="#goStory"><span>개발자이야기</span></a></li>
   <li><div class="blank"></div></li>
   <li><a href="#goTel"><span>연락처</span></a></li>
  </ul>
 </div>
  <div id="logoWrap"><h1>카카오테마</h1></div>
 <div id="loginPanel">
  <h2>로그인</h2>
  <input name="name" type="text" value="아이디" onfocus="if(this.value=='User Name')this.value=''" onblur="if(this.value=='')this.value='User Name'"/>
   <div class="blank"></div>
  <input name="name" type="text" value="패스워드" onfocus="if(this.value=='Password')this.value=''" onblur="if(this.value=='')this.value='Password'"/>
  <p>회원이 아니십니까? <a href="#">가입요청</a></p>
  <a href="login?userid=hycho&userpassword=hycho" class="login">Login</a>
 </div>
 <div id="quots"><p>"누구나 자신만의 카카오톡 테마를 저작할 수 있도록 하고 싶었습니다."</p></div>
 <div id="leftPanel">
  <div class="about">
   <h2>저작이란?</h2>
   <h3>쉽고 빠른 카카오톡 저작도구</h3>
   <p><span>테스트</span></p>
   <div class="date">
    <div class="left">Saturday, April 26, 2008&nbsp;&nbsp;|</div>
    <div class="right"><a href="#">Read More</a></div>
   </div>
  </div>
  <div class="services">
   <h2>Our Spectrum of Services</h2>
   <div class="pic"><a href="#">Cras turpis duis at sapien eget nulla vulputate. </a></div>
   <p><span>Donec accumsan porta risus.</span> Vestibulum sollicitudinlibero ut semper commodo, purus enim sollicitudin nulla, dictum vehicula diam lacus at purus. In egestas. </p>
   <h3>Services</h3>
   <ul>
    <li><a href="#">Nam congue quam non augue ivamus porttitor</a></li>
    <li><a href="#" class="bottom">Jam aongue buam n augue famus</a></li>
   </ul>
   <p><span>Pellentesque dolor.</span> Nunc congue est in ante mattis ultrices. liquam erat volutpat. Nam congue quam non augue. </p>
  </div>
  <div class="testimonial">
   <h2>Testimonial</h2>
   <p> <span>Nullam vel justo. Mauris viverra mattis neque.</span> Phasellus feugiat pede ut mauris uis orcies tibulum eleifend. Donec est purusiaculis acauctorNullam vel justo. Mauris viverra mattis neque. Phasellus feugiat pede ut mauris. Duis orci.</p>
   <h3><span>by</span> David Jackson</h3>
    <p><span>Vel justo. Mauris viverra mattis neque  asellus feugiat pede ut mauris uis orcies tibulum</span> eleifend. Donec est purusiaculis acauctorNullam vel justo. Mauris viverra mattis neque. Phasellus feugiat pede ut mauris.</p>
   <h3><span>by</span> Tom Sam</h3>
  </div>
 </div>
 <div id="rightPanel">
  <h2>베스트 테마</h2>
  <div class="pic1"></div>
  <a href="#" class="view">view large</a>
   <div class="pic2"></div>
  <a href="#" class="view">view large</a>
   <div class="pic3"></div>
  <a href="#" class="view">view large</a>
  <div class="contacts">
   <h2>Quick Contact</h2>
   <p>Name</p><input name="name" type="text" value="- enter your name -" onfocus="if(this.value=='- enter your name -')this.value=''" onblur="if(this.value=='')this.value='- enter your name -'"/>
   <p>Email</p><input name="name" type="text" value="- enter your email -" onfocus="if(this.value=='- enter your email -')this.value=''" onblur="if(this.value=='')this.value='- enter your email -'"/>
   <div class="blank2"></div><a href="#">Need a Quote?</a><div class="blank"></div><a href="#">Submit</a>
  </div>
  <div class="project">
   <h2>Projects Link</h2>
   <ul>
    <li><a href="#">Lorem ipsum dolor sit amet eros consequat </a></li>
    <li><a href="#">Consectetuer adipiscing elit</a></li>
    <li><a href="#">Etiam quis est ut diam viverra rhoncus</a></li>
    <li><a href="#">Fusce eros consequat </a></li>
    <li><a href="#">Cras eros massa blandit </a></li>
    <li><a href="#" class="bottom">Aoreet utdiam viverra</a></li>
   </ul>
  </div>
 </div>
 <div id="footPanel">
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
  <div class="copyright">© Copyright Infirmation Goes Here. All Rights Reserved.</div>
  <p class="designInfo">Design by <a href="http://www.templateworld.com/">TemplateWorld</a> and brought to you by <a href="http://www.smashingmagazine.com/">SmashingMagazine</a></p>
  <div class="validation">
    <ul>
     <li><a href="http://validator.w3.org/check?uri=referer">xhtml</a></li>
     <li><div class="blank"></div></li>
     <li><a href="http://jigsaw.w3.org/css-validator/check/referer">css</a></li>
    </ul>  
  </div>
 </div>
</div>
</div>
</body>
</html>
