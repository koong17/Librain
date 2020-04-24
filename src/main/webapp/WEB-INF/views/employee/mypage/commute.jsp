<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../includes/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>근태관리</title>
<link rel="stylesheet"
	href="https://uicdn.toast.com/tui-grid/latest/tui-grid.css" />
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://uicdn.toast.com/tui-grid/latest/tui-grid.js"></script>
</head>
<body>
	<div class="wrapper">
		<div class="row">
			<div class="col-md-12">
				<h1 class="page-header">근태 관리</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-md-2 pt-3">
				<div class="form-group">
					<input type="button" class="btn btn-primary btn-block" id="work"
						value="출근">
				</div>
			</div>
			<div class="col-md-2 pt-3">
				<div class="form-group">
					<input type="button" class="btn btn-primary btn-block" id="leave"
						value="퇴근">
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-8">
				<div class="form-group">
					<div id="gridTop"></div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-8">
				<div class="form-group">
					<div id="grid"></div>
				</div>
			</div>
		</div>
	</div>
</body>
<script>

	$("#work").click(function(){
	   $.ajax({											
			type: "POST",
			contentType : 'application/x-www-form-urlencoded;charset=UTF-8',
			dataType : 'json',	// dataType 은 호출되는 서버쪽의 함수의 리턴타입
			url: "commute.do",
			data: {cmt_status:"on"},
			success :function(result) {
				console.log(result);
				update(result);
		    }
		});
	});
	$("#leave").click(function(){
	   $.ajax({											
			type: "POST",
			contentType : 'application/x-www-form-urlencoded;charset=UTF-8',
			dataType : 'json',
			url: "commute.do",
			data: {cmt_status:"off"},
			success :function(result) {
				console.log(result);
				update(result);
		    }
		});
	});
	
	function update(result) {
		grid.resetData(result[0]);
		gridTop.resetData(result[1]);
	}

	var Grid = tui.Grid;
	Grid.setLanguage('ko');
	
	const gridTop = new tui.Grid({
		el: document.getElementById('grid'),
		data: ${gridTopData},
		scrollX: false,
		scrollY: false,
		pagination: {
			perPage: 5
		},
		columns: [
			{
				header: '사원번호',
				name: 'emp_no',
			},
			{
				header: '상태',
				name: 'cmt_status'
			},
			{
				header: '상태2',
				name: 'cmt_status_kr'
			},
			{
				header: '시',
				name: 'cmt_hour',
		        sortingType: 'asc',
		        sortable: true
				
			},
			{
				header: '분',
				name: 'cmt_minute',
		        sortingType: 'asc',
		        sortable: true
			}
		]
	});
	const grid = new tui.Grid({
		el: document.getElementById('grid'),
		data: ${gridData},
		scrollX: false,
		scrollY: false,
		rowHeaders: ['checkbox'],
		columns: [
			{
				header: '사원번호',
				name: 'emp_no',
			},
			{
				header: '상태',
				name: 'cmt_status'
			},
			{
				header: '시',
				name: 'cmt_hour',
		        sortingType: 'asc',
		        sortable: true
				
			},
			{
				header: '분',
				name: 'cmt_minute',
		        sortingType: 'asc',
		        sortable: true
			}
		]
	});
	$(function(){
		grid.sort('cmt_hour',true,true);
		grid.sort('cmt_minute',true,true);
	});
</script>
</html>
<%@include file="../includes/footer.jsp"%>