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
	<div id="grid" />
	<form action="totalpay.do" method="post" name="infoForm">
		<div class="col-md-6 col-xs-12">
			<div class="form-group">
				<select class="mdb-select md-form" name="cmt_year">
				  <option value="" disabled selected>년</option>
				  <option value="2019">2019</option>
				  <option value="2020">2020</option>
				  <option value="2021">2021</option>
				</select>
				<select class="mdb-select md-form" name="cmt_month">
				  <option value="" disabled selected>월</option>
				  <option value="9">9</option>
				  <option value="10">10</option>
				  <option value="11">11</option>
				</select>
				<select class="mdb-select md-form" name="emp_dept_code">
				  <option value="" disabled selected>부서</option>
				  <option value="000">관장</option>
				  <option value="001">총무부</option>
				  <option value="002">교육부</option>
				  <option value="003">정보부</option>
				</select>
				<input type="text" name="emp_name" class="form-control" placeholder="이름">
				<input type="button" value="확인" id="check" class="btn btn-success btn-block btn-lg">
				<input type="submit" value="확인" class="btn btn-success btn-block btn-lg" tabindex="7">
			</div>
		</div>
	</form>
	<form action="totalpay.do" method="post">
		<div class="col-md-6 col-xs-12">
			<div class="form-group">
				<input type="number" name="emp_no" class="form-control" value="" readOnly>
			</div>
			<div class="form-group">
				<input type="text" name="emp_name" class="form-control" value="" readOnly>
			</div>
			<div class="form-group">
				<input type="number" name="emp_basic_pay" class="form-control" value="" readOnly>
			</div>
			<div class="form-group">
				<input type="number" name="sal_food_pay" class="form-control" value="" readOnly>
			</div>
			<div class="form-group">
				<input type="number" name="sal_bonus_pay" class="form-control" value="" readOnly>
			</div>
			<div class="form-group">
				<input type="number" name="sal_total" class="form-control" value="" readOnly>
			</div>
			<div class="form-group">
				<input type="number" name="sal_national_pension" class="form-control" value="" readOnly>
			</div>
			<div class="form-group">
				<input type="number" name="sal_health_insurance" class="form-control" value="" readOnly>
			</div>
			<div class="form-group">
				<input type="number" name="sal_longterm_care_insurance" class="form-control" value="" readOnly>
			</div>
			<div class="form-group">
				<input type="number" name="sal_employment_insurance" class="form-control" value="" readOnly>
			</div>
			<div class="form-group">
				<input type="number" name="sal_income_tax" class="form-control" value="" readOnly>
			</div>
			<div class="form-group">
				<input type="number" name="sal_local_income_tax" class="form-control" value="" readOnly>
			</div>
			<div class="form-group">
				<input type="number" name="sal_deducted" class="form-control" value="" readOnly>
			</div>
			<div class="form-group">
				<input type="number" name="sal_real" class="form-control" value="" readOnly>
			</div>
		</div>
	</form>
</body>
<script>
	$("#check").click(function(){
	   	$.ajax({											
			type: "POST",
			contentType : 'application/json;charset=UTF-8',
			dataType : 'json',
			url: "totalpay.do",
			data: JSON.stringify($('form[name="infoForm"]').serializeComponent()),
			/* {
				cmt_year: $('#cmt_year').val(),
				cmt_month: $('#cmt_month').val(),
				emp_dept_code: $('#emp_dept_code').val(),
				emp_name: $('#emp_name').val()
			}, */
			success :function(result) {
				console.log(result);
				grid.resetData(result);
		    }
		});
	});
	
	const grid = new tui.Grid({
		el: document.getElementById('grid'),
		data: ${gridData},
		scrollX: false,
		scrollY: false,
		rowHeaders: ['checkbox'],
		columns: [
			{
				header: 'no',
				name: 'cmt_no'
			},
			{
				header: '사원번호',
				name: 'cmt_emp_no',
			},
			{
				header: '상태',
				name: 'cmt_status',
			},
			{
				header: '상태2',
				name: 'cmt_status2',
			},
			{
				header: '일',
				name: 'cmt_day'
			},
			{
				header: '시',
				name: 'cmt_hour'
			},
			{
				header: '분',
				name: 'cmt_minute'
			}
		]
	});
</script>
</html>