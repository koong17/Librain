<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../../includes/header.jsp"%>
<!DOCTYPE html>
<html><head><meta charset="UTF-8">
<title>급여</title>
<link rel="stylesheet" href="https://uicdn.toast.com/tui-grid/latest/tui-grid.css" />
<script src="https://uicdn.toast.com/tui-grid/latest/tui-grid.js"></script>
</head>
<body>
	<div class="container">
	<br><br>
	<h1>급여관리</h1>
	<hr>
		<div class="row form-group">
			<div class="col-md-8">
				<div class="form-group">
				</div>
				<div class="form-group">
					<div class="col-md-2">
						<select class="form-control" id="cmt_year">
						  <option value="" disabled selected>년</option>
						  <option value="2019">2019</option>
						  <option value="2020">2020</option>
						  <option value="2021">2021</option>
						</select>
					</div>
				</div>
				<div class="form-group">
					<div class="col-md-2">
						<select class="form-control" id="cmt_month">
						  <option value="" disabled selected>월</option>
						  <option value="9">9</option>
						  <option value="10">10</option>
						  <option value="11">11</option>
						</select>
					</div>
				</div>
				<div class="form-group">
					<div class="col-md-3">
						<select class="form-control" id="emp_dept_code">
						  <option value="" disabled selected>부서</option>
						  <option value="000">관장</option>
						  <option value="001">총무부</option>
						  <option value="002">교육부</option>
						  <option value="003">정보부</option>
						</select>
					</div>
				</div>
				<div class="form-group">
					<div class="col-md-3">
						<input type="text" id="emp_name" class="form-control" placeholder="이름">
					</div>
				</div>
				<div class="form-group">
					<div class="col-md-2">
						<input type="button" value="확인" id="check" class="btn btn-primary btn-block">
					</div>
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="col-md-10">
				<div id="grid"></div>
			</div>
		</div>
		<div class="form-group">
			<div class="col-md-10">
				<div id="days"></div>
			</div>
			<br><br><br>
		</div>
		<div class="form-group">
		</div>
		<form action="totalpay.do" method="post">
			<div class="row form-group">
				<input type="hidden" name="sal_year" value="">
				<input type="hidden" name="sal_month" value="">
				<div class="col-md-5">
					<div class="form-group">
						기본급<input type="number" name="sal_basic_pay" class="form-control" value="" readOnly>
					</div>
					<div class="form-group">
						식대<input type="number" name="sal_food_pay" class="form-control" value="" readOnly>
					</div>
					<div class="form-group">
						보너스<input type="number" name="sal_bonus" class="form-control" value="" readOnly>
					</div>
					<div class="form-group">
						급여계<input type="number" name="sal_total" class="form-control" value="" readOnly>
					</div>
					<div class="form-group">
						공제합계<input type="number" name="sal_deducted" class="form-control" value="" readOnly>
					</div>
					<div class="form-group">
						차감수령액<input type="number" name="sal_real" class="form-control" value="" readOnly>
					</div>
				</div>
				<div class="col-md-5">
					<div class="form-group">
						국민연금<input type="number" name="sal_national_pension" class="form-control" value="" readOnly>
					</div>
					<div class="form-group">
						건강보험<input type="number" name="sal_health_insurance" class="form-control" value="" readOnly>
					</div>
					<div class="form-group">
						장기요양<input type="number" name="sal_longterm_care_insurance" class="form-control" value="" readOnly>
					</div>
					<div class="form-group">
						고용보험<input type="number" name="sal_employment_insurance" class="form-control" value="" readOnly>
					</div>
					<div class="form-group">
						소득세<input type="number" name="sal_income_tax" class="form-control" value="" readOnly>
					</div>
					<div class="form-group">
						지방소득세<input type="number" name="sal_local_income_tax" class="form-control" value="" readOnly>
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="col-md-2">
					<input type="submit" value="확정" id="insertSal" class="btn btn-success btn-block btn-lg">
				</div>
			</div>
		</form>
	</div>
<%@include file="../../includes/footer.jsp"%>
</body>
<script>
	$("#check").click(function(){
		var year = document.getElementById("cmt_year");
		var month = document.getElementById("cmt_month");
		var dept = document.getElementById("emp_dept_code");
		var name = document.getElementById("emp_name").value;
		var cmtObject = new Object();
		cmtObject.cmt_year = year.options[year.selectedIndex].value;
		cmtObject.cmt_month = month.options[month.selectedIndex].value;
		cmtObject.dept = month.options[dept.selectedIndex].value;
		console.log(cmtObject.cmt_year);
		console.log(cmtObject.cmt_month);
		console.log(cmtObject.dept);
		console.log(name);
		if(cmtObject.cmt_year == "" || cmtObject.cmt_month == ""
				|| cmtObject.dept == "" || name == null) {
			alert('항목을 모두 입력하세요.');
		} else {
			var info = new Object();
			info.emp_dept_code = $("#emp_dept_code option:selected").val();
			info.emp_name = $("#emp_name").val();
			var emp_no;
			
		   	var date = new Object();
			date.cmt_year = $("#cmt_year").val();
			date.cmt_month = $("#cmt_month").val();
		   	$.ajax({											
				type: "POST",
				contentType : 'application/json;charset=UTF-8',
				dataType : 'json',
				url: "totalpay1.do",
				data: JSON.stringify(info),
				success :function(result) {
					console.log(result);
					console.log(result)
					emp_no = result.emp_no;
					date.emp_no = emp_no;
					console.log(date.emp_no);
				   	
					$.ajax({											
						type: "POST",
						contentType : 'application/json;charset=UTF-8',
						dataType : 'json',
						url: "totalpay2.do",
						data: JSON.stringify(date),
						success :function(gridData) {
							grid.resetData(gridData);
							var onCount = grid.findRows({cmt_status_kr:'정상출근'}).length;
							var offCount = grid.findRows({cmt_status_kr:'정상퇴근'}).length;
							var realCount = Math.min(onCount, offCount);
							var count = getDate(date.cmt_year, date.cmt_month);
							console.log(count);
							console.log(realCount);
							$('#days').html('정규 근무일 : '+count+', 실제 근무일: '+realCount);
							
							var sal_basic_pay = Math.round(result.sal_basic_pay * realCount / count);
							$('input[name=emp_no]').val(emp_no);
							$('input[name=sal_basic_pay]').val(sal_basic_pay);
							$('input[name=sal_total]').val(sal_basic_pay+7500*realCount);
							$('input[name=sal_national_pension]').val(Math.round(sal_basic_pay*0.045));
							$('input[name=sal_health_insurance]').val(Math.round(sal_basic_pay*0.0323));
							$('input[name=sal_longterm_care_insurance]').val(Math.round(sal_basic_pay*0.0323*0.0851));
							$('input[name=sal_employment_insurance]').val(Math.round(sal_basic_pay*0.0065));
							$('input[name=sal_income_tax]').val(Math.round(sal_basic_pay*0.01666));
							$('input[name=sal_local_income_tax]').val(Math.round(sal_basic_pay*0.01666*0.1));
							$('input[name=sal_deducted]').val(Math.round(sal_basic_pay*0.045+sal_basic_pay*0.0323+sal_basic_pay*0.0323*0.0851+sal_basic_pay*0.0065+sal_basic_pay*0.01666+sal_basic_pay*0.01666*0.1));
							$('input[name=sal_food_pay]').val(7500*realCount);
							$('input[name=sal_real]').val(Math.round(sal_basic_pay+7500*realCount-sal_basic_pay*0.045-sal_basic_pay*0.0323-sal_basic_pay*0.0323*0.0851-sal_basic_pay*0.0065-sal_basic_pay*0.01666-sal_basic_pay*0.01666*0.1));
							$('input[name=sal_bonus]').val(0);
							$('input[name=sal_year]').val($("#cmt_year").val());
							$('input[name=sal_month]').val($("#cmt_month").val());
							console.log($('input[name=sal_bonus]').val());
					    }
					});
			    }
			});
		}
	});
	
	function getDate(year, month) {
		var date1 = new Date(year, month-1, 1);
		var date2 = new Date(year, month, 0);
		var count = 0;
		
		while(true) {
			
			if(date1.getTime() >= date2.getTime()) break;
			else {
				var temp = date1.getDay();
				if(temp!=0 && temp !=6) count++;
			}
			date1.setDate(date1.getDate()+1);
		}
		return count;
	}
	
	const grid = new tui.Grid({
		el: document.getElementById('grid'),
		data: null,
		scrollX: false,
		scrollY: false,
		columns: [
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
			},
			{
				header: '상태',
				name: 'cmt_status',
			},
			{
				header: '상태2',
				name: 'cmt_status_kr',
			}
		]
	});
</script>
</html>