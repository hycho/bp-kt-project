<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
  <title>사용자 등록 페이지</title>
  <link rel="stylesheet" href="<c:url value='/resources/css/style.css'/>" type="text/css" />
  <link rel="stylesheet" href="<c:url value='/resources/css/pagination.css'/>" type="text/css" />
	<script type="text/javascript" src="<c:url value='/resources/js/jquery.min.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/jquery.easing.1.3.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/jquery-ui-1.8.16.custom.min.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/all-in-one-min.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/setup.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/jquery.paginate.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/moment.min.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/common.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/constants/constants.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/util/validate.js'/>"></script>
	
	<script type="text/javascript">
	$(function(){
		setBirthYearToSelect("BIRTHYEAR", "BIRTHMONTH", "BIRTHDAY");
		setBirthMonthToSelect("BIRTHYEAR", "BIRTHMONTH", "BIRTHDAY")
		updateNumberOfDays("BIRTHYEAR", "BIRTHMONTH", "BIRTHDAY");
		
		function InsertModel() {
			// Data
	    var self = this;
	    self.ID = ko.observable();
	    self.PASSWORD = ko.observable();
	    self.PASSWORDCHK = ko.observable();
	    self.FIRSTNAME = ko.observable();
	    self.LASTNAME = ko.observable();
	    self.BIRTHYEAR = ko.observable();
	    self.BIRTHMONTH = ko.observable();
	    self.BIRTHDAY = ko.observable();
	    self.SEX = ko.observable();
	    self.EMAILFIRST = ko.observable();
	    self.EMAILLAST = ko.observable();
	    self.CONTRYCODE = ko.observable();
	    
	    self.warnningID = ko.computed(function() {
	    	if(self.ID() == null || self.ID() == ""){
	    		return "Input your id.";
	    		}
				if(!Validator.isId(self.ID())){
					return "Check your id.";
				}
    		});
	    self.warnningPASSWORD = ko.computed(function() {
	    	if(self.PASSWORD() !== self.PASSWORDCHK()){
	    		return "Check your password.";	
	    		}
	    	if(self.PASSWORD() == null || self.PASSWORD() == "" || self.PASSWORDCHK() == null || self.PASSWORDCHK() == ""){
	    		return "Input your password.";	
	    		}
			});
	    self.warnningFIRSTNAME = ko.computed(function() {
	    	if(self.FIRSTNAME() == null || self.FIRSTNAME() == ""){
	    		return "Input your first name.";
	    		}
			});
	    self.warnningLASTNAME = ko.computed(function() {
	    	if(self.LASTNAME() == null || self.LASTNAME() == ""){
	    		return "Input your last name.";
	    		}
			});
	    self.warnningEMAIL = ko.computed(function() {
	    	if(self.EMAILFIRST() == null || self.EMAILFIRST() == "" || self.EMAILLAST() == null || self.EMAILLAST() == ""){
	    		return "Input your email.";
	    		}
	    	if(!Validator.isEmail(self.EMAILFIRST()+"@"+self.EMAILLAST())){
	    		return "Check your email.";
	    		}
			});
	    // comp
	    	
	    // Operations
	    self.regist = function() {
	    	if(typeof self.warnningID() != "undefined" || typeof self.warnningPASSWORD() != "undefined" || typeof self.warnningFIRSTNAME() != "undefined" || typeof self.warnningLASTNAME() != "undefined" || typeof self.warnningEMAIL() != "undefined"){
	    		alert("Check the required items.");
	    		return;
	    	}else{
	    		$.ajax("/rest/manager/user/userInsert", {
	    			data: {
	    	    	ID : self.ID,
	    	      FIRSTNAME : self.FIRSTNAME,
	    	      LASTNAME : self.LASTNAME,
   	      		PASSWORD : self.PASSWORD,
   	      		BIRTHYEAR : self.BIRTHYEAR,
   	      		BIRTHMONTH : self.BIRTHMONTH,
   	      		BIRTHDAY : self.BIRTHDAY,
   	      		SEX : self.SEX,
   	      		EMAILFIRST : self.EMAILFIRST,
   	      		EMAILLAST : self.EMAILLAST,
   	      		CONTRYCODE : self.CONTRYCODE
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
	    		}
		    };
		}

		ko.applyBindings(new InsertModel());
	});
	</script>
</head>
<body>
<!-- START CONTENT -->
<section class="container clearfix">
	<!-- START PAGE INFO -->
	<header class="container page_info clearfix">
		<h1 class="regular brown bottom_line">회원 가입 페이지</h1>
		<div class="clear"></div>
	</header>
	<!-- END PAGE INFO -->
	<div class="padding15"></div>
  <!-- START COL 1/3 -->	
	<div class="col_1_3">
		<ul class="contact-address">
    	<li class="address"><span>Seoul in korea</span></li>
      <li class="phone"><span>+81 010-7345-6059</span></li>
      <li class="email"><span><a href="mailto:kofwhgh@gmail.com">kofwhgh@gmail.com</a></span></li>
    </ul>
		<div class="clear"></div>
	</div>
	<!-- END COL 1/3 -->	
	<!-- START COL 2/3 LAST -->	
	<div class="col_2_3 last">
		<p>
			Welcome to new World!	Are you believe we make this page? We Together develop this site.
		</p>
		<div class="padding20"></div>
		<p class="required_info"><span>*</span> Required</p>
		<!-- SUCCESS MESSAGE -->
		<div class="success_box none">
			Email successfully sent. Thank you!
		</div>
		<!-- END SUCCESS MESSAGE -->
		<!-- ERROR MESSAGE -->
		<div class="error_box none">
			Please complete all required fields.
		</div>
		<!-- END ERROR MESSAGE -->
		<p>
			<label for="ID">ID <span>*</span></label>
			<input data-bind="value: ID" class="inputText" type="text" id="ID" name="ID" />
			<span data-bind="text: warnningID" class="warnning"></span>
		</p>
		<div class="clear"></div>
		<p>
			<label for="PASSWORD">Password <span>*</span></label>
			<input data-bind="value: PASSWORD" class="inputText" type="password" id="PASSWORD" name="PASSWORD" />
			<span data-bind="text: warnningPASSWORD" class="warnning">Input password.</span>
		</p>
		<div class="clear"></div>
		<p>
			<label for="PASSWORDCHK">Check Password <span>*</span></label>
			<input data-bind="value: PASSWORDCHK" class="inputText" type="password" id="PASSWORDCHK" name="PASSWORDCHK" />
			<span data-bind="text: warnningPASSWORD" class="warnning">Input password.</span>
		</p>
		<div class="clear"></div>
		<p>
			<label for="FIRSTNAME">First Name <span>*</span></label>
			<input data-bind="value: FIRSTNAME" class="inputText" type="text" id="FIRSTNAME" name="FIRSTNAME" />
			<span data-bind="text: warnningFIRSTNAME" class="warnning">Input your first name.</span>
		</p>
		<div class="clear"></div>
		<p>
			<label for="LASTNAME">Last Name <span>*</span></label>
			<input data-bind="value: LASTNAME" class="inputText" type="text" id="LASTNAME" name="LASTNAME" />
			<span data-bind="text: warnningLASTNAME" class="warnning">Input your last name.</span>
		</p>
		<div class="clear"></div>
		<p>
			<label for="BIRTHYEAR">BirthDay <span>*</span></label>
			<select data-bind="value: BIRTHYEAR" id="BIRTHYEAR">
			</select>-
			<select data-bind="value: BIRTHMONTH" id="BIRTHMONTH">
			</select>-
			<select data-bind="value: BIRTHDAY" id="BIRTHDAY">
			</select>
		</p>
		<div class="clear"></div>
		<p>
			<label for="SEX">Sex <span>*</span></label>
			<select data-bind="value: SEX" id="SEX">
				<option value="0">Man</option>
				<option value="1">Woman</option>
			</select>
		</p>
		<div class="clear"></div>
		<p>
			<label for="EMAIL">EMAIL <span>*</span></label>
			<input data-bind="value: EMAILFIRST" class="inputText" type="text" id="EMAILFIRST" name="EMAILFIRST" style="width:150px;"/> @
			<input data-bind="value: EMAILLAST" class="inputText" type="text" id="EMAILLAST" name="EMAILLAST" style="width:150px;"/>
			<span data-bind="text: warnningEMAIL" class="warnning">Input your email.</span>
		</p>
		<div class="clear"></div>
		<p>
			<label for="CONTRYCODE">Contry Code <span>*</span></label>
			<select data-bind="value: CONTRYCODE" id="CONTRYCODE">
				<option value="82">대한민국 +82</option>
			</select>
		</p>
		<div class="clear"></div>
	</div>
	<div style="text-align:right">
		<a data-bind="click: regist" href="#" class="button white">Regist</a>
		<a href="<c:url value='/manager/user/userListView'/>" class="button white">Go List</a>
	</div>
	<!-- END COL 2/3 LAST -->	
	<div class="clear padding20"></div>
</section>
<!-- END CONTENT -->
</div>
</body>
</html>