<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<script type="text/javascript" src="<c:url value='/resources/js/jquery/jquery.1.8.2.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/apps/jdMenu/jquery.dimensions.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/apps/jdMenu/jquery.positionBy.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/apps/jdMenu/jquery.bgiframe.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/apps/jdMenu/jquery.jdMenu.js'/>"></script>
<link rel="stylesheet" href="<c:url value='/resources/apps/jdMenu/jquery.jdMenu.css'/>" type="text/css" />
<script type="text/javascript">
$(function () {});
</script>
<head>
	<title><sitemesh:write property='title' /></title>
	<sitemesh:write property='head'/>
</head>
<body>
<div style="border: 1px solid blue; margin-bottom:30px;">
	<ul class="jd_menu">
		<li><a href="#" class="accessible">UserManager</a>
			<ul>
				<li><a href="<c:url value='/manager/user/userListView'/>">List</a></li>
				<li><a href="<c:url value='/manager/user/userInsertView'/>">Regist</a></li>
				<li><a href="<c:url value='/manager/user/userUpdateView'/>">Update</a></li>
				<li><a href="<c:url value='/manager/user/userPasswordUpdateView'/>">UpdatePassword</a></li>
			</ul>
		</li>
		<li><a href="#" class="accessible">MenuSample</a>
			<ul>
				<li>Search &raquo;
					<ul>
						<li><a href="http://base.google.com" target="_blank">Base</a></li>
						<li><a href="http://code.google.com" target="_blank">Code</a></li>
						<li><a href="http://images.google.com" target="_blank">Images</a></li>
					</ul>
					</li>
				<li><a href="http://www.gmail.com" target="_blank">GMail</a></li>
			</ul>
		</li>
	</ul>
</div>
<sitemesh:write property='body' />
</body>
</html>
