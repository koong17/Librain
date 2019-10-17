<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html><head><meta charset="UTF-8">
<title>급여</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://uicdn.toast.com/tui-grid/latest/tui-grid.css" />
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://uicdn.toast.com/tui-grid/latest/tui-grid.js"></script>
</head>
<body>
<%@include file="../../includes/header.jsp"%>
	<div class="col-md-6 col-xs-12">
		<div class="form-group">
			<select class="mdb-select md-form" id="sal_year">
			  <option value="" disabled selected>년</option>
			  <option value="2019">2019</option>
			  <option value="2020">2020</option>
			  <option value="2021">2021</option>
			</select>
			<select class="mdb-select md-form" id="sal_month">
			  <option value="" disabled selected>월</option>
			  <option value="9">9</option>
			  <option value="10">10</option>
			  <option value="11">11</option>
			</select>
			<input type="button" value="검색" id="search" class="btn btn-success btn-sm">
		</div>
	</div>
	<div id="grid"></div>
<%@include file="../../includes/footer.jsp"%>
</body>
<script>
	$("#search").click(function(){
	   	var date = new Object();
		date.sal_year = $("#sal_year").val();
		date.sal_month = $("#sal_month").val();
	   	$.ajax({											
			type: "POST",
			contentType : 'application/json;charset=UTF-8',
			dataType : 'json',
			url: "totalpaylist.do",
			data: JSON.stringify(date),
			success :function(result) {
				grid.resetData(result);
		    }
		});
	   	
	});
	
	const grid = new tui.Grid({
		el: document.getElementById('grid'),
		data: null,
		scrollX: false,
		scrollY: false,
		rowHeaders: ['checkbox'],
		columns: [
			{
				header: '사원번호',
				name: 'emp_no'
			},
			{
				header: '기본급',
				name: 'sal_basic_pay'
			},
			{
				header: '식대',
				name: 'sal_food_pay'
			},
			{
				header: '보너스',
				name: 'sal_bonus'
			},
			{
				header: '급여계',
				name: 'sal_total'
			},
			{
				header: '공제합계',
				name: 'sal_deducted',
			},
			{
				header: '차감수령액',
				name: 'sal_real',
			}
		]
	});
</script>
</html>