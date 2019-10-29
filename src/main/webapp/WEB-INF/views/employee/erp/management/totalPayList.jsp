<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../../includes/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>급여 목록</title>
<link rel="stylesheet"
	href="https://uicdn.toast.com/tui-grid/latest/tui-grid.css" />
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://uicdn.toast.com/tui-grid/latest/tui-grid.js"></script>
</head>
<body>

	<div class="wrapper">
		<div class="row">
			<div class="col-md-12">
				<h1 class="page-header">급여 목록</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-md-1">
				<div class="form-group">
					<select class="form-control" id="sal_year">
						<option value="" disabled selected>년</option>
					</select>
				</div>
			</div>
			<div class="col-md-1">
				<div class="form-group">
					<select class="form-control" id="sal_month">
						<option value="" disabled selected>월</option>
						<option value="01">01</option>
						<option value="02">02</option>
						<option value="03">03</option>
						<option value="04">04</option>
						<option value="05">05</option>
						<option value="06">06</option>
						<option value="07">07</option>
						<option value="08">08</option>
						<option value="09">09</option>
						<option value="10">10</option>
						<option value="11">11</option>
						<option value="12">12</option>
					</select>
				</div>
			</div>
			<div class="col-md-1">
				<div class="form-group">
					<input type="button" value="검색" id="search"
						class="btn btn-primary btn-block">
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-10">
				<div class="form-group">
					<div id="grid"></div>
				</div>
			</div>
		</div>
	</div>
</body>
<script>
	$(function(){
		var date = new Date();
		var year = date.getFullYear();
		//var month = new String(date.getMonth()+1);
		for (var i = year-2; i <= year; i++) {
			$("#sal_year").append('<option value="'+i+'">'+i+'</option>');
		}
	});
 	
	$("#search").click(function() {
		var date = new Object();
		date.sal_year = $("#sal_year").val();
		date.sal_month = $("#sal_month").val();
		$.ajax({
			type : "POST",
			contentType : 'application/json;charset=UTF-8',
			dataType : 'json',
			url : "totalpaylist.do",
			data : JSON.stringify(date),
			success : function(result) {
				grid.resetData(result);
			}
		});

	});

	const grid = new tui.Grid({
		el : document.getElementById('grid'),
		data : null,
		scrollX : false,
		scrollY : false,
		rowHeaders: ['checkbox'],
		columns : [ {
			header : '사원번호',
			name : 'emp_no',
	        sortable: true
			
		}, {
			header : '기본급',
			name : 'sal_basic_pay'
		}, {
			header : '식대',
			name : 'sal_food_pay'
		}, {
			header : '보너스',
			name : 'sal_bonus'
		}, {
			header : '급여계',
			name : 'sal_total'
		}, {
			header : '공제합계',
			name : 'sal_deducted',
		}, {
			header : '차감수령액',
			name : 'sal_real',
		} ]
	});
</script>
</html>
<%@include file="../../includes/footer.jsp"%>