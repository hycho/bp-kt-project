<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
  <title>사용자 리스트 페이지</title>
  <link rel="stylesheet" href="<c:url value='/resources/css/style.css'/>" type="text/css" />
  <link rel="stylesheet" href="<c:url value='/resources/css/pagination.css'/>" type="text/css" />
	<script type="text/javascript" src="<c:url value='/resources/js/jquery.min.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/jquery.easing.1.3.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/jquery-ui-1.8.16.custom.min.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/all-in-one-min.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/setup.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/jquery.paginate.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/moment.min.js'/>"></script>
	
	<script type="text/javascript">
	var RECORDCOUNTPERPAGE = 10;
	
	$(function(){
		function UserListModel() {
			var self = this;
			//data
			self.userListData = ko.observable();
			self.searchType = ko.observable();
			self.searchValue = ko.observable();
			//comp
			
			//operation
			self.search = function() {
				searchFunc(1);
			};
			
			searchFunc = function(count){
				$.ajax("/rest/manager/user/selectUserList", {
	      	data: {
	      		searchType : self.searchType(),
	      		searchValue : self.searchValue(),
	      		recordCountPerPage : RECORDCOUNTPERPAGE,
	      		pageIndex : (count-1) * RECORDCOUNTPERPAGE
	      			},
	        type: "post",
	        dataType: "json",
	        success: function(data){
	        	self.userListData(data);
	        	setPaginate("pagenation" ,data.totalCount/RECORDCOUNTPERPAGE, count, RECORDCOUNTPERPAGE, function(page){
	        		searchFunc(page);
	        			});
	        		}
		        });
			};
			
			self.keySearch= function (data, event) {
				if (event.which == 13) {
					self.search();
			     }
				return true;
			};
			
			
			
			function setPaginate(pageElemId ,pCount, pStart, pDisplay, func){
				$("#"+pageElemId).paginate({
					count: Math.ceil(pCount),
					start: pStart,
					display: pDisplay,
					border: false,
					text_color: '#79B5E3',
					background_color: 'none',	
					text_hover_color: '#2573AF',
					background_hover_color: 'none', 
					images: false,
					mouse: 'press',
					onChange: func
				});	
				
				var pagenationWidth = 0;
				$("#"+pageElemId).find("div").each(function(idx, obj){
					pagenationWidth += Number($(obj).css("width").substring(0,$(obj).css("width").length-2));
				});
				$("#"+pageElemId).css("width", pagenationWidth);
			}
		}
		
		var userListModel = new UserListModel();
		ko.applyBindings(userListModel);
		userListModel.search();
	});
	</script>
</head>
<body>
<section class="container clearfix">
<header class="container page_info clearfix">
	<h1 class="regular brown bottom_line">사용자 리스트</h1>
	<div class="clear"></div>
</header>
<!-- /Page Title -->
<div class="">
	<div data-bind="with: userListData" id="code_origin" class="code_tmpl">
		<p>
			<select data-bind="value: $root.searchType">
			  <option value="ID">아이디</option>
	    </select>
			<input data-bind="value: $root.searchValue, valueUpdate: 'afterkeydown',event:{keypress: $root.keySearch}" class="inputText" type="text" id="name" name="name" />
			<a data-bind="click: $root.search" href="#" style="margin-bottom:0px" class="button white">검색</a>
		</p>	
		
		<table cellspacing="0" border="1" summary="사용자 리스트" class="tbl_type">
			<caption>사용자 리스트</caption>
			<colgroup>
			<col width="10%">
			<col width="30%">
			<col width="10%">
			<col width="10%">
			<col width="10%">
			<col width="30%">
			</colgroup>
			<thead>
			<tr>
				<th scope="col"><input type="checkbox" /></th>
				<th scope="col">아이디</th>
				<th scope="col">이름</th>
				<th scope="col">이메일</th>
				<th scope="col">성별</th>
				<th scope="col">가입일</th>
			</tr>
			</thead>
			<tbody data-bind="foreach: data">
			<tr>
				<td><input type="checkbox" /></td>
				<td data-bind="text: ID"></td>
				<td data-bind="text: FIRSTNAME+LASTNAME"></td>
				<td data-bind='text: EMAILFIRST+"@"+EMAILLAST'></td>
				<td data-bind="text: SEX == 0?'남' : '여'"></td>
				<td data-bind="text: moment(CREATEDATE).format('MMMM Do YYYY, h:mm:ss a')"></td>
			</tr>
			</tbody>
		</table>
	</div>
	<div style="width:100%; align:center">
		<div style="margin:0 auto" id="pagenation"></div>
	</div>
	<div style="text-align:right">
		<a href="<c:url value='/manager/user/userInsertView'/>" class="button white">등록</a>
		<a href="#" class="button white">삭제</a>
		<a href="#" class="button white">이전페이지</a>
	</div>
</div>
</section>
<!-- END CONTENT -->
</body>
</html>
