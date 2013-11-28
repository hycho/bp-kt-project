<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
	<title><spring:message code="userManager.insert.title" /></title>
	<script type="text/javascript" src="<c:url value='/resources/js/knockout/knockout-3.0.0.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/common/common.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/common/constants.js'/>"></script>
	<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/style.css'/>">
	<script type="text/javascript">
	$(function() {
		function UserInsertModel() {
			// Data
	    var self = this;
	    self.userId = ko.observable("test1");
	    self.password = ko.observable("pw");
	    self.ckPassword = ko.observable("pw");
	    self.passwordHint = ko.observable();
	    self.passwordCnsr = ko.observable("3");
	    self.userNm = ko.observable("test");
	    self.ihidNum1 = ko.observable("840227");
	    self.ihidNum2 = ko.observable("1149810");
	    self.zip1 = ko.observable("430");
	    self.zip2 = ko.observable("060");
	    self.adress = ko.observable("주소1");
	    self.detailAdress = ko.observable("주소2");
	    self.areaNo = ko.observable("02");
	    self.middleTelNo = ko.observable("0000");
	    self.endTelNo = ko.observable("8888");
	    self.phone1 = ko.observable("010");
	    self.phone2 = ko.observable("0000");
	    self.phone3 = ko.observable("0000");
	    self.userFax1 = ko.observable("02");
	    self.userFax2 = ko.observable("1111");
	    self.userFax3 = ko.observable("1111");
	    self.email1 = ko.observable("ffff");
	    self.email2 = ko.observable("naver.com");
	    self.sex = ko.observable();
	    
	    // comp
	    self.ihidNum = ko.computed(function() {
	    	return self.ihidNum1()+self.ihidNum2();
	    	});
	    self.zip = ko.computed(function() {
	    	return self.zip1()+self.zip2();
	    	});
	    self.phone = ko.computed(function() {
	    	return self.phone1()+self.phone2()+self.phone3();
	    	});
	    self.userFax = ko.computed(function() {
	    	return self.userFax1()+self.userFax2()+self.userFax3();
	    	});
	    self.email = ko.computed(function() {
	    	return self.email1()+"@"+self.email2();
	    	});
	    self.chkuserId = ko.computed(function() {
	    	if(self.userId() == null || self.userId() == ""){
	    		return "아이디를 입력 하십시요.";	
	    		}
	    	});
	    self.chkckPassword = ko.computed(function() {
	    	if(self.password() !== self.ckPassword()){
	    		return "동일한 패스워드가 아닙니다.";	
	    		}
	    	});
	    self.chkpasswordCnsr = ko.computed(function() {
	    	if(self.passwordCnsr() == null || self.passwordCnsr() ==""){
	    		return "정답을 입력해 주십시요.";	
	    		}
	    	});
	    self.chkuserNm = ko.computed(function() {
	    	if(self.userNm() == null || self.userNm() ==""){
	    		return "성함을 입력해 주십시요.";	
	    		}
	    	});
	    self.chkihidNum = ko.computed(function() {
	    	if(!checkIhidNum(self.ihidNum1(), self.ihidNum2())){
	    		return "올바른 주민등록번호가 아닙니다.";	
	    		}
	    	});
	    	
	    // Operations
	    self.save = function() {
	    	$.ajax("/manager/user/userInsert", {
	      	data: {
	      		userId : self.userId(),
		 				password : self.password(),
		 				passwordHint : self.passwordHint(),
		 				passwordCnsr : self.passwordCnsr(),
		 				ihidNum : self.ihidNum(),
		 				userNm : self.userNm(),
		 				zip : self.zip(),
		 				adress : self.adress(),
		 				areaNo : self.areaNo(),
		 				userStatus : "1",
		 				detailAdress : self.detailAdress(),
		 				endTelNo : self.endTelNo(),
		 				phone : self.phone(),
		 				userFax : self.userFax(),
		 				email : self.email(),
		 				middleTelNo : self.middleTelNo(),
		 				sex : self.sex()
	      			},
	        type: "post",
	        dataType: "json",
	        success: function(result){
	        	if(result == SUCCESS_FLAG){
	        		alert("등록을 완료 했습니다.");
	        		location.href="/manager/user/userListView";
	        			}
	        		}
		        });
		    };
		    
		  self.prev = function() {
			  history.back();
		  	};
		  	
		  self.duplicationUserId = function(){
			  $.ajax("/manager/user/chkUserId", {
	      	data: {
	      		userId : self.userId()
	      			},
	        type: "post",
	        dataType: "json",
	        success: function(result){
	        	if(result == SUCCESS_FLAG){
	        		$("#chkuserId").text("동일한 아이디가 존재합니다.");
	        	}else{
	        		$("#chkuserId").text("사용 가능한 아이디 입니다.");
	        			}
	        		}
		        });
		  	}
		}

		ko.applyBindings(new UserInsertModel());
	});
	</script>
</head>
<body>
<div id="code_origin" class="code_tmpl">
<!-- UI Object -->
<fieldset>
	<legend><spring:message code="userManager.insert.title" /></legend>
	<div class="form_table">
	<table border="1" cellspacing="0">
	<tbody>
	<tr>
		<th scope="row"><spring:message code="userManager.insert.userId" /></th>
		<td>
			<div class="item">
				<input data-bind="value: userId" type="text" id="userId" name="userId" title="<spring:message code="userManager.insert.userId" />" class="i_text">
				<button data-bind="click: duplicationUserId" type="button"><span>중복확인</span></button>
				<span data-bind="text: chkuserId" id="chkuserId" class="i_dsc"></span>
			</div>
		</td>
	</tr>
	<tr>
		<th scope="row"><spring:message code="userManager.insert.password" /></th>
		<td>
			<div class="item">
				<input data-bind="value: password" type="password" id="password" name="password" title="<spring:message code="userManager.insert.password" />" class="i_text">
			</div>
		</td>
	</tr>
	<tr>
		<th scope="row"><spring:message code="userManager.insert.ckPassword" /></th>
		<td>
			<div class="item">
				<input data-bind="value: ckPassword" type="password" id="ckPassword" name="ckPassword" title="<spring:message code="userManager.insert.ckPassword" />" class="i_text">
				<span data-bind="text: chkckPassword" class="i_dsc"></span>
			</div>
		</td>
	</tr>
	<tr>
		<th scope="row"><spring:message code="userManager.insert.passwordHint" /></th>
		<td>
			<div class="item">
				<select data-bind="value: passwordHint" id="passwordHint" name="passwordHint">
					<option value="1">질문 1</option>
					<option value="2">질문 2</option>
					<option value="3">질문 3</option>
				</select>
			</div>
		</td>
	</tr>
	<tr>
		<th scope="row"><spring:message code="userManager.insert.passwordCnsr" /></th>
		<td>
			<div class="item">
				<input data-bind="value: passwordCnsr" type="text" id="passwordCnsr" name="passwordCnsr" title="<spring:message code="userManager.insert.passwordCnsr" />" class="i_text">
				<span data-bind="text: chkpasswordCnsr" class="i_dsc"></span>
			</div>
		</td>
	</tr>
	<tr>
		<th scope="row"><spring:message code="userManager.insert.userNm" /></th>
		<td>
			<div class="item">
				<input data-bind="value: userNm" type="text" id="userNm" name="userNm" title="<spring:message code="userManager.insert.userNm" />" class="i_text">
				<span data-bind="text: chkuserNm" class="i_dsc"></span>
			</div>
		</td>
	</tr>
	<tr>
		<th scope="row"><spring:message code="userManager.insert.ihidNum" /></th>
		<td>
			<div class="item">
				<input data-bind="value: ihidNum1" type="text" id="ihidNum1" name="ihidNum1" class="i_text"> - <input data-bind="value: ihidNum2" type="text" id="ihidNum2" name="ihidNum2" class="i_text">
				<span data-bind="text: chkihidNum" class="i_dsc"></span>
			</div>
		</td>
	</tr>
	<tr>
		<th scope="row"><spring:message code="userManager.insert.zip" /></th>
		<td>
			<div class="item">
				<input data-bind="value: zip1" type="text" id="zip1" name="zip1" class="i_text"> - <input data-bind="value: zip2" type="text" id="zip2" name="zip2" class="i_text">
			</div>
		</td>
	</tr>
	<tr>
		<th scope="row"><spring:message code="userManager.insert.adress" /></th>
		<td>
			<div class="item">
				<input data-bind="value: adress" type="text" id="adress" name="adress" title="<spring:message code="userManager.insert.adress" />" class="i_text">
			</div>
		</td>
	</tr>
	<tr>
		<th scope="row"><spring:message code="userManager.insert.detailAdress" /></th>
		<td>
			<div class="item">
				<input data-bind="value: detailAdress" type="text" id="detailAdress" name="detailAdress" title="<spring:message code="userManager.insert.detailAdress" />" class="i_text">
			</div>
		</td>
	</tr>
	<tr>
		<th scope="row"><spring:message code="userManager.insert.telno" /></th>
		<td>
			<div class="item">
				<input data-bind="value: areaNo" type="text" id="areaNo" name="areaNo" class="i_text"> - <input data-bind="value: middleTelNo" type="text" id="middleTelNo" name="middleTelNo" class="i_text"> - <input data-bind="value: endTelNo" type="text" id="endTelNo" name="endTelNo" class="i_text">
			</div>
		</td>
	</tr>
	<tr>
		<th scope="row"><spring:message code="userManager.insert.phone" /></th>
		<td>
			<div class="item">
				<input data-bind="value: phone1" type="text" id="phone1" name="phone1" class="i_text"> - <input data-bind="value: phone2" type="text" id="phone2" name="phone2" class="i_text"> - <input data-bind="value: phone3" type="text" id="phone3" name="phone3" class="i_text">
			</div>
		</td>
	</tr>
	<tr>
		<th scope="row"><spring:message code="userManager.insert.userFax" /></th>
		<td>
			<div class="item">
				<input data-bind="value: userFax1" type="text" id="userFax1" name="userFax1" class="i_text"> - <input data-bind="value: userFax2" type="text" id="userFax2" name="userFax2" class="i_text"> - <input data-bind="value: userFax3" type="text" id="userFax3" name="userFax3" class="i_text">
			</div>
		</td>
	</tr>
	<tr>
		<th scope="row"><spring:message code="userManager.insert.email" /></th>
		<td>
			<div class="item">
				<input data-bind="value: email1" type="text" id="email1" name="email1" class="i_text">@<input data-bind="value: email2" type="text" id="email2" name="email2" class="i_text">
			</div>
		</td>
	</tr>
	<tr>
		<th scope="row"><spring:message code="userManager.insert.sex" /></th>
		<td>
			<div class="item">
				<select data-bind="value: sex" id="sex" name="sex">
					<option value="0"><spring:message code="common.sex.man" /></option>
					<option value="1"><spring:message code="common.sex.woman" /></option>
				</select>
			</div>
		</td>
	</tr>
	</tbody>
	</table>
	<div style="margin-top:3px;text-align:right">
		<button data-bind="click: save">저장</button>
		<button data-bind="click: prev">이전으로</button>
	</div>
</div>
</fieldset>
<!-- //UI Object -->
</div>
</body>
</html>
