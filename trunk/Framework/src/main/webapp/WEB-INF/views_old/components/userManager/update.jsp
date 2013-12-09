<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
	<title><spring:message code="author.regist.title" /></title>
	<script type="text/javascript" src="<c:url value='/resources/js/knockout/knockout-3.0.0.js'/>"></script>
	<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/style.css'/>">
	<script type="text/javascript">
	$(function(){});
	</script>
</head>
<body>
<div id="code_origin" class="code_tmpl">
<!-- UI Object -->
<form action="" method="post">
	<fieldset>
		<legend>Legend</legend>
		<div class="form_table">
		<table border="1" cellspacing="0" summary="표의 요약을 반드시 넣어 주세요">
		<tbody>
		<tr>
		<th scope="row">인풋: 설명 숨기고 줄 바꿈 없는</th>
		<td>
			<div class="item">
				<input type="text" name="" title="레이블 텍스트" class="i_text">
				<button type="button" class="i_help"><span>?</span></button>
				<span class="i_dsc hide">숨겨둔 설명 입니다. 줄 바꿈 없습니다.</span>
			</div>
		</td>
		</tr>
		<tr>
		<th scope="row">인풋: 설명 숨기고 줄 바꿈</th>
		<td>
			<div class="item">
				<input type="text" name="" title="레이블 텍스트" class="i_text">
				<button type="button" class="i_help"><span>?</span></button>
				<p class="i_dsc hide">숨겨둔 설명 입니다. 줄 바꿈 했습니다.</p>
			</div>
		</td>
		</tr>
		<tr>
		<th scope="row">인풋: 설명 보이고 줄 바꿈 없는</th>
		<td>
			<div class="item">
				<input type="text" name="" title="레이블 텍스트" class="i_text"> 숨겨두지 않은 설명 입니다. 줄 바꿈 없습니다.
			</div>
		</td>
		</tr>
		<tr>
		<th scope="row">인풋: 설명 보이고 줄 바꿈</th>
		<td>
			<div class="item">
				<input type="text" name="" title="레이블 텍스트" class="i_text">
				<p class="i_dsc">숨겨두지 않은 설명 입니다. 줄 바꿈 했습니다.</p>
			</div>
		</td>
		</tr>
		<tr>
		<th scope="row">인풋: 줄 바꿈 없는 인풋</th>
		<td>
			<div class="item">
				<input type="text" name="" title="레이블 텍스트" class="i_text"> - <input type="text" name="" title="레이블 텍스트" class="i_text">
			</div>
		</td>
		</tr>
		<tr>
		<th scope="row">인풋: 줄 바꿈</th>
		<td>
			<div class="item">
				<input type="text" name="" title="레이블 텍스트" class="i_text"><br>
				<input type="text" name="" title="레이블 텍스트" class="i_text">
			</div>
		</td>
		</tr>
		<tr>
		<th scope="row">인풋: 레이블 클리어</th>
		<td>
			<div class="item">
				<label for="temp_input" class="i_label">레이블 텍스트를 인풋과 오버레이</label>
				<input type="text" name="" id="temp_input" class="i_text" style="width:300px">
			</div>
		</td>
		</tr>
		<tr>
		<th scope="row">멀티라인 인풋</th>
		<td>
			<div class="item">
				<textarea name="" cols="50" rows="5" title="레이블 텍스트" class="i_text"></textarea>
			</div>
		</td>
		</tr>
		<tr>
		<th scope="row">멀티라인 인풋: 레이블 클리어</th>
		<td>
			<div class="item">
				<label for="temp_textarea" class="i_label">레이블 텍스트를 멀티라인 인풋과 오버레이</label>
				<textarea name="" cols="50" rows="5" id="temp_textarea" class="i_text"></textarea>
			</div>
		</td>
		</tr>
		<tr>
		<th scope="row">셀렉트: 단일 선택</th>
		<td>
			<div class="item">
				<select name="">
					<option>옵션 하나</option>
					<option>옵션 둘</option>
					<option>옵션 셋</option>
				</select>
			</div>
		</td>
		</tr>
		<tr>
		<th scope="row">셀렉트: 복수 선택</th>
		<td>
			<div class="item">
				<select name="" multiple="multiple">
					<option>옵션 하나</option>
					<option>옵션 둘</option>
					<option>옵션 셋</option>
				</select>
			</div>
		</td>
		</tr>
		<tr>
		<th scope="row">체크박스 인풋: 줄 바꿈 없는</th>
		<td>
			<div class="item">
				<input name="" type="checkbox" value="" id="a1" class="i_check"><label for="a1">레이블</label> <input name="" type="checkbox" value="" id="a2" class="i_check"><label for="a2">레이블</label>
			</div>
		</td>
		</tr>
		<tr>
		<th scope="row">체크박스 인풋: 줄 바꿈 있는</th>
		<td>
			<div class="item">
				<input name="" type="checkbox" value="" id="b1" class="i_check"><label for="b1">레이블</label><br>
				<input name="" type="checkbox" value="" id="b2" class="i_check"><label for="b2">레이블</label>
			</div>
		</td>
		</tr>
		<tr>
		<th scope="row">라디오 인풋: 줄 바꿈 없는</th>
		<td>
			<div class="item">
				<input name="" type="radio" value="" id="c1" class="i_radio"><label for="c1">레이블</label> <input name="" type="radio" value="" id="c2" class="i_radio"><label for="c2">레이블</label>
			</div>
		</td>
		</tr>
		<tr>
		<th scope="row">라디오 인풋: 줄 바꿈 있는</th>
		<td>
			<div class="item">
				<input name="" type="radio" value="" id="d1" class="i_radio"><label for="d1">레이블</label><br>
				<input name="" type="radio" value="" id="d2" class="i_radio"><label for="d2">레이블</label>
			</div>
		</td>
		</tr>
		<tr>
		<th scope="row">파일</th>
		<td>
			<div class="item">
				<input name="" type="file" title="레이블 텍스트">
			</div>
		</td>
		</tr>
		</tbody>
		</table>
	</div>
	</fieldset>
</form>
<!-- //UI Object -->
</div>
</body>
</html>
