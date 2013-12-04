<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
  <title>Login Page</title>
  <link rel="stylesheet" href="<c:url value='/resources/css/style.css'/>" type="text/css" />
	<script type="text/javascript" src="<c:url value='/resources/js/jquery.min.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/jquery.easing.1.3.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/jquery-ui-1.8.16.custom.min.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/all-in-one-min.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/setup.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/constants/constants.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/util/validate.js'/>"></script>
	<script type="text/javascript">
	$(function(){
		$("#btnLogin").click(function(){
			$("#loginForm").submit();
		});
		
		$("#btnRegist").click(function(){
			location.href = "/manager/user/userInsertView";
		});
	});
	</script>
</head>
<body>
<!-- START CONTENT -->
 <section class="container clearfix">
<!-- Page Title -->
<header class="container page_info clearfix">
<h1 class="regular brown bottom_line">Login Page </h1>
<div class="clear"></div>
</header>
<!-- /Page Title -->
<div class="padding20"></div>
	<div class="col_3_4">
		<img src="<c:url value='/resources/images/404.png' />" alt="404" class="error_404" />
	  <div class="padding10"></div>
	  <h3>Try following:</h3>
	  <p>
    <ul class="align_center">
    	<li>
      	<a href="index.html">Homepage</a>
      </li>
      <li>
      	<a href="index.html">Elements</a>
      </li>
      <li>
		    <a href="index.html">Blog</a>
      </li>
      <li>
      	<a href="index.html">Contact Us</a>
      </li>
    </ul>
	</div>
	<div class="col_1_4 last">
		<form method="post" action="<c:url value='/j_spring_security_check'/>" class="comments_form" id="loginForm">
			<div class="comment_wrap">
				<label for="id">Id <span>*</span></label>
				<input type="text" name="j_username" />
			</div>
			<div class="comment_wrap">
				<label for="email">Password <span>*</span></label>
				<input type="password" name="j_password" />
			</div>
			<div class="comment_wrap">
				<a id="btnLogin" href="#" class="button white" style="margin-left:0px;"><span> Login </span></a>
				<a id="btnRegist" href="#" class="button white" style="margin-left:0px;"><span> Regist </span></a>
			</div>
		</form>
	</div>
	<div class="clear padding40"></div>
</section>
<!-- END CONTENT -->
</body>
</html>