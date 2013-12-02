<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
<title><spring:message code="userManager.insert.title" /></title>
<link rel="shortcut icon" href="<c:url value='/resources/images/favicon.ico'/>" /> 
<link rel="stylesheet" href="<c:url value='/resources/css/prettyPhoto.css'/>" type="text/css" />
<link rel="stylesheet" href="<c:url value='/resources/css/flexslider.css'/>" type="text/css" />
<link rel="stylesheet" href="<c:url value='/resources/css/style.css'/>" type="text/css" />

<script type="text/javascript" src="<c:url value='/resources/js/jquery.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/js/jquery.easing.1.3.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/js/jquery-ui-1.8.16.custom.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/js/all-in-one-min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/js/setup.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/js/main.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/js/knockout-3.0.0.js'/>"></script>

<script type="text/javascript">
$(function() {
	$(window).load(function(){
		$('#demo-side-bar').removeAttr('style');
	});
});
</script>
<style type="text/css">
.demobar{display:none;}
#demo-side-bar{top:53px!important;left:90%!important;display:block!important;}
</style>
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
									<li><a href="<c:url value='/manager/user/userListView'/>">리스트</a></li>
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
	
	<div class="clear"></div>
	
	<!-- Slider -->
    <div class="bannerbg">
        <div class="container clearfix">
                <div class="flexslider" >
                <ul class="slides">
                    <li>
                        <img src="<c:url value='/resources/images/fslide01.jpg' />" alt="" />
                        <p class="flex-caption">I am Caption!</p>
                    </li>
                    <li>
                        <a href="#"><img src="<c:url value='/resources/images/fslide02.jpg' />" alt="" /></a>
                    </li>
                    <li>
                        <img src="<c:url value='/resources/images/fslide03.jpg' />" alt="" />
                        <p class="flex-caption">I am Caption!</p>
                    </li>
                    <li>
                        <img src="<c:url value='/resources/images/fslide04.jpg' />" alt="" />
                    </li>
                    
                    <li>
                        <img src="<c:url value='/resources/images/fslide05.jpg' />" alt="" />
                    </li>
                    
                    <li>
                        <img src="<c:url value='/resources/images/fslide06.jpg' />" alt="" />
                    </li>
                </ul>
            </div>
        </div>
    </div>
	<!-- /Slider -->
	
	<div class="clear padding40"></div>

	
	<!-- Content -->
	<section class="container clearfix">
	
		<!-- START FEATURED COLUMNS -->
		<div class="col_1_3">
			<div class="features">
				<div class="title clearfix">
					<img src="<c:url value='/resources/images/code-icon.png' />" alt="" class="alignleft" />
					<h3>Beautiful, Responsive and Valid Template</h3>
				</div>
				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque id ligula in ipsum vulputate volutpat at ut nisi. Aliquam erat volutpat. Maecenas pretium dolor vitae lectus fermentum convallis bibendum in erat. Donec vitae risus non lorem volutpat fringilla in in metus. Aenean quis eros diam. Proin porta quam at neque congue iaculis. <br /> <a href="#">more info</a></p> 
			</div>
		</div>
		<div class="col_1_3">
			<div class="features">
				<div class="title clearfix">
					<img src="<c:url value='/resources/images/intuitive-icon.png' />" alt="" class="alignleft" />
					<h3>Eye Catching, Clean and Intuitive Design</h3>

				</div>
				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque id ligula in ipsum vulputate volutpat at ut nisi. Aliquam erat volutpat. Maecenas pretium dolor vitae lectus fermentum convallis bibendum in erat. Donec vitae risus non lorem volutpat fringilla in in metus. Aenean quis eros diam. Proin porta quam at neque congue iaculis. <br /> <a href="#">more info</a></p> 
			</div>
		</div>
		<div class="col_1_3 last">
			<div class="features">
				<div class="title clearfix">
					<img src="<c:url value='/resources/images/businesses-icon.png' />" alt="" class="alignleft" />
					<h3>Perfect for Businesses & Portfolios</h3>
					
				</div>
				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque id ligula in ipsum vulputate volutpat at ut nisi. Aliquam erat volutpat. Maecenas pretium dolor vitae lectus fermentum convallis bibendum in erat. Donec vitae risus non lorem volutpat fringilla in in metus. Aenean quis eros diam. Proin porta quam at neque congue iaculis. <br /> <a href="#">more info</a></p> 
			</div>
		</div>
		<!-- END FEATURED COLUMNS -->
		
		<div class="clear padding10"></div>
		
		<div class="recent_works_left">
			<h2 class="red">Featured Work</h2>
		</div>
		<div class="recent_works_arrows">
			<a href="#" class="prev_item"></a><a href="#" class="next_item"></a>
		</div>
		
		<div class="clear"></div>
		<div class="line"></div>
		<div class="clear padding30"></div>
					

			<div class="recent_works">
				<ul id="work">
					<!-- START PORTFOLIO COLUMN #1 -->
					<li id="id-1" class="app">
						<span class="recent_image">
							<a href="<c:url value='/resources/images/portfolio_large.jpg' />" data-rel="prettyPhoto" class="img-thumb"><img class="portfolio_image" src="<c:url value='/resources/images/featured_work_1.jpg' />" alt="" /></a>
						</span>
						<span class="title"><a href="portfolio_details.html">Open Source Icons</a></span>
						
						<span class="clear padding15"></span>
					</li>
					<!-- END PORTFOLIO COLUMN #1 -->
					
					<!-- START PORTFOLIO COLUMN #2 -->
					<li id="id-2" class="util">
						<span class="recent_image">
							<a href="<c:url value='/resources/images/portfolio_large.jpg' />" data-rel="prettyPhoto" title="Free Admin Template from eGrappler.com"  class="img-thumb"><img class="portfolio_image" src="<c:url value='/resources/images/featured_work_2.jpg' />" alt="" /></a>
						</span>
						<span class="title"><a href="portfolio_details.html">Free Admin Template</a></span>
						
						<span class="clear padding15"></span>
					</li>
					<!-- END PORTFOLIO COLUMN #2 -->
					
					<!-- START PORTFOLIO COLUMN #3 -->
					<li id="id-3" class="app">
						<span class="recent_image">
							<a href="<c:url value='/resources/images/portfolio_large.jpg' />" data-rel="prettyPhoto" title="Free Social Plugin" class="img-thumb"><img class="portfolio_image" src="<c:url value='/resources/images/featured_work_3.jpg' />" alt="" /></a>
						</span>
						<span class="title"><a href="portfolio_details.html">Free Social Plugin</a></span>
						
						<span class="clear padding15"></span>
					</li>
					<!-- END PORTFOLIO COLUMN #3 -->
					
					<!-- START PORTFOLIO COLUMN #3 -->
					<li id="id-4" class="app">
						<span class="recent_image">
							<a href="<c:url value='/resources/images/portfolio_large.jpg' />" data-rel="prettyPhoto" class="img-thumb"><img class="portfolio_image" src="<c:url value='/resources/images/portfolio_image_4.jpg' />" alt="" /></a>
						</span>
						<span class="title"><a href="portfolio_details.html">Desing Freebies</a></span>
						
						<span class="clear padding15"></span>
					</li>
					<!-- END PORTFOLIO COLUMN #3 -->
					
					<!-- START PORTFOLIO COLUMN #3 -->
					<li id="id-5" class="app">
						<span class="recent_image">
							<a href="<c:url value='/resources/images/portfolio_large.jpg'/>" data-rel="prettyPhoto" class="img-thumb"><img class="portfolio_image" src="<c:url value='/resources/images/portfolio_image_5.jpg'/>" alt="" /></a>
						</span>
						<span class="title"><a href="portfolio_details.html">Free WordPress Resume Theme</a></span>
						
						<span class="clear padding15"></span>
					</li>
					<!-- END PORTFOLIO COLUMN #3 -->
					
					<!-- START PORTFOLIO COLUMN #3 -->
					<li id="id-6" class="app">
						<span class="recent_image">
							<a href="<c:url value='/resources/images/portfolio_large.jpg'/>" data-rel="prettyPhoto" class="img-thumb"><img class="portfolio_image" src="<c:url value='/resources/images/portfolio_image_6.jpg'/>" alt="" /></a>
						</span>
						<span class="title"><a href="portfolio_details.html">jQuery Pagination Plugin</a></span>
						
						<span class="clear padding15"></span>
					</li>
					<!-- END PORTFOLIO COLUMN #3 -->
					
					<!-- START PORTFOLIO COLUMN #3 -->
					<li id="id-7" class="app">
						<span class="recent_image">
							<a href="<c:url value='/resources/images/portfolio_large.jpg'/>" data-rel="prettyPhoto" class="img-thumb"><img class="portfolio_image" src="<c:url value='/resources/images/portfolio_image_7.jpg'/>" alt="" /></a>
						</span>
						<span class="title"><a href="portfolio_details.html">Clean Business HTML Template</a></span>
						
						<span class="clear padding15"></span>
					</li>
					<!-- END PORTFOLIO COLUMN #3 -->
				</ul>
			</div>
		
	</section>
	<!-- /Content -->
		
	
	
	<section class="homepage_widgets_bg clearfix">
		<div class="container clearfix">
		
			<div class="padding20"></div>
			
            
            <!-- START COL 1/2 -->
			<div class="col_1_2 ">
				<h1 class="regular white bottom_line">About Us</h1>
				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus convallis urna a enim convallis a bibendum lectus scelerisque. Aenean at mauris augue, sed fringilla justo. Proin et porta ligula. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus convallis urna a enim convallis a bibendum lectus scelerisque. Aenean at mauris augue, sed fringilla justo. Proin et porta ligula.</p> 

				<p>Quisque malesuada lorem at leo volutpat tristique. Nunc sit amet felis imperdiet ante tincidunt viverra sit amet quis ipsum. Aenean metus urna, placerat ut pharetra id, pharetra eget turpis. Sed blandit nunc eget lorem vestibulum malesuada.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus convallis urna a enim convallis a bibendum lectus scelerisque. Aenean at mauris augue, sed fringilla justo. Proin et porta ligula. Quisque malesuada lorem at leo volutpat tristique. Nunc sit amet felis imperdiet ante tincidunt viverra sit amet quis ipsum. </p>
				
			</div>
			<!-- END COL 1/2 -->
            
			<!-- START COL 1/2 -->
            
           
           <div class="col_1_2 last" id="why-section">
				<h1 class="regular white bottom_line">Why Us</h1>
				<div><a href="#"><img class="alignleft MT0" id="why1" src="<c:url value='/resources/images/content-img1.png'/>" alt="img" ></a></div>
				<p>
					Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus convallis urna a enim convallis a bibendum lectus scelerisque. Aenean at mauris augue, sed fringilla justo.
				</p>
                
                <div class="clear padding10"></div>
                
                <div><a href="#"><img class="alignleft MT0" id="why2" src="<c:url value='/resources/images/content-img2.png'/>" alt="img" ></a></div>
				<p>
					Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus convallis urna a enim convallis a bibendum lectus scelerisque. Aenean at mauris augue, sed fringilla justo.
				</p>
                 <div class="clear padding10"></div>
                 
                <div><a href="#"><img class="alignleft MT0" id="why3" src="<c:url value='/resources/images/content-img3.png'/>" alt="img" ></a></div>
				<p>
					Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus convallis urna a enim convallis a bibendum lectus scelerisque. Aenean at mauris augue, sed fringilla justo. 
				</p>
                
                
			</div>
           <div class="clear padding10"></div>
			
			<!-- end col 1/2 -->
			
			
            
            <!-- start col -->
            
            	<div>
                
                <h2 class="regular white bottom_line">All-in-one Template</h2>
				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus convallis urna a enim convallis a bibendum lectus scelerisque. Aenean at mauris augue, sed fringilla justo. Proin et porta ligula. </p>
				<div class="clearfix">
					
					<a href="javascript:" class="green-button">Buy This Template</a>
				</div>
                
                </div>
            
            <!-- emd col -->
            
			<div class="clear padding80"></div>
			
		</div>
	</section>
		
	
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
  	<div id="demo-side-bar">
   </div>
    </div>
    <!--wrapper end-->
</body>
</html>
