<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
  <title>User List</title>
  <link rel="stylesheet" href="<c:url value='/resources/css/style.css'/>" type="text/css" />
	<script type="text/javascript" src="<c:url value='/resources/js/jquery.min.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/jquery.easing.1.3.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/jquery-ui-1.8.16.custom.min.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/all-in-one-min.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/setup.js'/>"></script>
</head>
<body>
    <header class="header_bg clearfix">
		<div class="container clearfix">
    <!-- Social -->
   	<ul class="social-links">
    	<li ><a href="javascript:"><img src="<c:url value='/resources/images/facebook.png' />" alt="Facebook"></a></li>
      <li ><a href="javascript:"><img src="<c:url value='/resources/images/twitter.png' />" width="24" height="24" alt="Twitter"></a></li>
    </ul>
		<!-- /Social -->
		<!-- Logo -->
		<div class="logo">
			<a href="index.html"><img src="<c:url value='/resources/images/logo.png' />" alt="" /></a>
		</div>
		<!-- /Logo -->
			
		<!-- Master Nav -->
		<nav class="main-menu">
			<ul>
				<li><a href="/home">Home</a></li>
				<li>
					<a>Pages</a>
					<ul>
						<li><a href="elements.html">Elements</a></li>
						<li><a href="typography.html">Typography</a></li>
						<li><a href="blog_single.html">Blog Single Post</a></li>
						<li><a href="javascript:">Pricing</a>
							<ul>
								<li><a href="pricing_2_cols.html">Pricing 2 Cols</a></li>
                 <li><a href="pricing_3_cols.html">Pricing 3 Cols</a></li>
                 <li><a href="pricing_4_cols.html">Pricing 4 Cols</a></li>
                 <li><a href="pricing_5_cols.html">Pricing 5 Cols</a></li>
							</ul>
						</li>
             <li><a href="full_width.html">Full Width</a></li>
						<li><a href="404.html">404 Page</a></li>
					</ul>
				</li>
				<li><a>Portfolio</a>
					<ul>
						<li><a href="portfolio_2_cols.html">Portfolio 2 Cols</a></li>
						<li><a href="portfolio_3_cols.html">Portfolio 3 Cols</a></li>
						<li><a href="portfolio_4_cols.html">Portfolio 4 Cols</a></li>
						<li><a href="portfolio_details.html">Portfolio Details</a></li>
					</ul>
				</li>
				<li><a href="blog.html">Blog</a></li>
				<li><a href="contact.html">Contact</a></li>
				<li><a>관리</a>
					<ul>
						<li>
							<a href="">사용자</a>
							<ul>
								<li><a href="<c:url value='/manager/user/userListView' />">리스트</a></li>
							</ul>
						</li>
					</ul>
				</li>
			</ul>
		</nav>
		<!-- /Master Nav -->
		</div>
</header>
<!-- /Header -->
<!-- START CONTENT -->
<section class="container clearfix">
<!-- Page Title -->
<header class="container page_info clearfix">
	<h1 class="regular brown bottom_line">사용자 리스트</h1>
	<div class="clear"></div>
</header>
		<!-- /Page Title -->
		<div class="">
			<div id="code_origin" class="code_tmpl">
				<p>
					<select data-bind="value: searchType">
					  <option value="userId">아이디</option>
					  <option value="userNm">사용자이름</option>
					  <option value="status">가입상태</option>
			    </select>
					<input class="inputText" type="text" id="name" name="name" />
				</p>	
				
				<table cellspacing="0" border="1" summary="사용자 리스트" class="tbl_type">
					<caption>사용자 리스트</caption>
					<colgroup>
					<col width="12%"><col><col width="12%" span="6">
					</colgroup>
					<thead>
					<tr>
						<th scope="col"><input type="checkbox" /></th>
						<th scope="col">아이디</th>
						<th scope="col">이름</th>
						<th scope="col">이메일</th>
						<th scope="col">등록일</th>
						<th scope="col">상태</th>
					</tr>
					</thead>
					<tbody>
					<tr>
						<td><input type="checkbox" /></td>
						<td>A12334654</td>
						<td>DELL</td>
						<td>3QZG615</td>
						<td>GX620</td>
						<td>DESKTOP</td>
					</tr>
					</tbody>
				</table>
			</div>
			<div style="text-align:right">
				<a href="#" class="button white">등록</a>
				<a href="#" class="button white">삭제</a>
				<a href="#" class="button white">이전페이지</a>
			</div>
			
			
			
			<div class="success_box">
				Alert Text
			</div>
			
			<div class="attention_box">
				Alert Text
			</div>
		
			<div class="error_box">
				Alert Text
			</div>
		</div>
		
		
		<div class="clear padding20"></div>

		<div class="col_1_2">
			
				<div class="tabs">
					<ul>
						<li><a href="#tabs-0">Lorem</a></li>
						<li><a href="#tabs-1">Ipsum</a></li>
						<li><a href="#tabs-2">Dolor</a></li>
					</ul>
					<div class="clear"></div>
					<div class="bordered_box">
						<div id="tabs-0" >
							<div class="content_text"><p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p><p>
Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p></div>
						</div>
						<div id="tabs-1">
							<div class="content_text"><p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p></div>
						</div>
						<div id="tabs-2">
							<div class="content_text"><p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p><p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p></div>
						</div>
					</div>
				</div>
		</div>
		
		
		
		<div class="col_1_2 last">
			<div class="toogle_box">
				<div class="toggle opened_toggle">
					<div class="icon"></div>
					Toggle
				</div>
				<div class="toggle_container">
					<p>
						Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. 
                      </p> <p> 
                        Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. 
					</p>
				</div>
			</div>
			
			
			
		</div>
		
		<div class="clear padding30"></div>

		
		
		<h1>Buttons</h1>
		
		
		<div class="clear padding20"></div>
		
		<div >
			<a href="#" class="button white">Button</a>
			<a href="#" class="button grey">Button</a>
      <a href="#" class="button red">Button</a>
      <a href="#" class="button orange">Button</a>
      <a href="#" class="button green">Button</a>
      <a href="#" class="button teal">Button</a>
      <a href="#" class="button blue">Button</a>
			<a href="#" class="button navy">Button</a>


		</div>
		
		
		<div class="clear padding30"></div>

	
	</section>
    <!-- END CONTENT -->
    <!-- footer -->
    <footer class="footer_bg_bottom clearfix">
		<div class="footer_bottom container">
			<div class="col_2_3">
				
				<div class="menu">
					<ul>
						<li><a href="index.html">Home</a></li>
            <li><a href="elements.html">Elements</a></li>
						<li><a href="portfolio_4_cols.html">Portfolio</a></li>
						<li><a href="pricing_5_cols.html">Pricing</a></li>
						<li><a href="blog.html">Blog</a></li>
						<li><a href="contact.html">Contact</a></li>
					</ul>
				</div>
				
				
				<div class="clear padding20"></div>
				
				
				<p>
					&copy; Some Rights Reserved. &nbsp; <a href="#">Legal Notices</a>  
				</p>
				
			</div>
			
			<div class="clear padding20"></div>
		</div>
	</footer>
    <!-- /footer -->
</body>
</html>
