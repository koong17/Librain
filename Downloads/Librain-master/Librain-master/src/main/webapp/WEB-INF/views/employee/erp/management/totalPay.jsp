<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../../includes/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>급여</title>
<link rel="stylesheet"
	href="https://uicdn.toast.com/tui-grid/latest/tui-grid.css" />
<script src="https://uicdn.toast.com/tui-grid/latest/tui-grid.js"></script>
</head>
<body>
	<!-- Modal -->

	<div class="modal fade" id="selectEmp" role="dialog"  tabindex="-1" aria-labelledby="modal-login-label" aria-hidden="true">
		<div class="modal-dialog">
		
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header" style="padding: 30px 30px;">
					<button type="button" class="close" data-dismiss="modal" style="margin-top: 7px;">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4><span class="glyphicon glyphicon-user"></span>회원 선택</h4>
				</div>

				<form class="form-horizontal" method="POST" id="Frm" name="Frm">
					<div class="modal-body" style="padding: 40px 50px; height: 200px;">
						<div id="names">
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" id="search" name="search" class="btn btn-success btn-default pull-left"  value="Send" style="margin: 10px; margin-left: 35px">
							<span class="glyphicon glyphicon-plus"></span>완 료
						</button>
						<button type="button" class="btn btn-danger btn-default pull-left"
							data-dismiss="modal" value="Input Button" style="margin: 10px">
							<span class="glyphicon glyphicon-remove"></span>취 소
						</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<div class="wrapper">
		<div class="row">
			<div class="col-md-12">
				<h1 class="page-header">급여 관리</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-md-1">
				<div class="form-group">
					<select class="form-control" id="cmt_year">
						<option value="" disabled selected>년</option>
					</select>
				</div>
			</div>
			<div class="col-md-1">
				<div class="form-group">
					<select class="form-control" id="cmt_month">
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
					<select class="form-control" id="emp_dept_code">
						<option value="" disabled selected>부서</option>
						<option value="000">관장</option>
						<option value="001">총무부</option>
						<option value="002">교육부</option>
						<option value="003">정보부</option>
					</select>
				</div>
			</div>
			<div class="col-md-1">
				<div class="form-group">
					<input type="button" value="회원검색" id="check"
						class="btn btn-primary btn-block">
				</div>
			</div>
			<div class="col-md-2">
				<div class="form-group">
					<input type="text" id="emp_name" class="form-control"
						placeholder="이름" readOnly>
				</div>
			</div>
			<!-- <div class="col-md-1">
				<div class="form-group">
					<input type="button" value="확인" id="search"
						class="btn btn-primary btn-block">
				</div>
			</div> -->
		</div>
		<form action="totalpay.do" method="post" onsubmit='return checkAgain();'>
			<div class="row">
				<input type="hidden" name="emp_no" value="">
				<input type="hidden" name="sal_year" value=""> <input
					type="hidden" name="sal_month" value="">
				<div class="col-md-3">
					<div class="form-group">
						기본급<input type="number" name="sal_basic_pay" class="form-control"
							value="" readOnly>
					</div>
					<div class="form-group">
						식대<input type="number" name="sal_food_pay" class="form-control"
							value="" readOnly>
					</div>
					<div class="form-group">
						보너스<input type="number" name="sal_bonus" class="form-control"
							value="" readOnly>
					</div>
					<div class="form-group">
						급여계<input type="number" name="sal_total" class="form-control"
							value="" readOnly>
					</div>
					<div class="form-group">
						공제합계<input type="number" name="sal_deducted" class="form-control"
							value="" readOnly>
					</div>
					<div class="form-group">
						차감수령액<input type="number" name="sal_real" class="form-control"
							value="" readOnly>
					</div>
					<div class="form-group">
						<input type="submit" value="확정" id="insertSal"
								class="btn btn-success btn-block">
					</div>
				</div>
				<div class="col-md-3">
					<div class="form-group">
						국민연금<input type="number" name="sal_national_pension"
							class="form-control" value="" readOnly>
					</div>
					<div class="form-group">
						건강보험<input type="number" name="sal_health_insurance"
							class="form-control" value="" readOnly>
					</div>
					<div class="form-group">
						장기요양<input type="number" name="sal_longterm_care_insurance"
							class="form-control" value="" readOnly>
					</div>
					<div class="form-group">
						고용보험<input type="number" name="sal_employment_insurance"
							class="form-control" value="" readOnly>
					</div>
					<div class="form-group">
						소득세<input type="number" name="sal_income_tax" class="form-control"
							value="" readOnly>
					</div>
					<div class="form-group">
						지방소득세<input type="number" name="sal_local_income_tax"
							class="form-control" value="" readOnly>
					</div>
				</div>
				<div class="col-md-6">
					<div class="row">
						<div class="col-md-8">
							<div class="form-group">
								근무일<input type="text" id="days" class="form-control" readOnly>
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
			</div>
			<div class="row">
			</div>
		</form>
	</div>
</body>
<script>

	$(function(){
		//confirm("입력하면 수정 할 수 없습니다. 급여를 확정하시겠습니까?");
		var date = new Date();
		var year = date.getFullYear();
		//var month = new String(date.getMonth()+1);
		for (var i = year-2; i <= year; i++) {
			$("#cmt_year").append('<option value="'+i+'">'+i+'</option>');
		}
	});

	$("#check").click(function() {
		var year = document.getElementById("cmt_year");
		var month = document.getElementById("cmt_month");
		var dept = document.getElementById("emp_dept_code");
		// var name = document.getElementById("emp_name").value;
		var empDept = new Object();
		empDept.emp_dept_code = dept.options[dept.selectedIndex].value;
		var cmtObject = new Object();
		cmtObject.cmt_year = year.options[year.selectedIndex].value;
		cmtObject.cmt_month = month.options[month.selectedIndex].value;
		cmtObject.dept = dept.options[dept.selectedIndex].value;
		if (cmtObject.cmt_year == ""
				|| cmtObject.cmt_month == ""
				|| cmtObject.dept == "" ) {
			alert('항목을 모두 입력하세요.');
		} else {
			$.ajax({
				type : 'POST',
				url : 'empDept.do',
				contentType : 'application/json;charset=UTF-8',
				dataType : 'json',
				data : JSON.stringify(empDept),
				success : function(data) {
					if (data.length == 0) {
						alert("사원이 존재하지 않습니다.");
					} else {
						$("#names").html('');
						$("#selectEmp").modal();
						$("#names").append('<label>');
						for (var i = 0; i < data.length; i++) {
							if(i==0)
								$("#names").append('<div class="radio"><input type="radio" name="radio" value="'+data[i].emp_name+'" checked>'+data[i].emp_name+'</label></div>');							
							else 
								$("#names").append('<div class="radio"><input type="radio" name="radio" value="'+data[i].emp_name+'">'+data[i].emp_name+'</label></div>');
						}
						$("#names").append('</label>');
					}
				}
			});
		}
	});
	
 	$("#search").click(function() {
 		$("#emp_name").val( $('input[name="radio"]:checked').val());
		$("#selectEmp").modal('hide');
		var year = document.getElementById("cmt_year");
		var month = document.getElementById("cmt_month");
		var dept = document.getElementById("emp_dept_code");
		var name = document.getElementById("emp_name").value;
		var cmtObject = new Object();
		cmtObject.cmt_year = year.options[year.selectedIndex].value;
		cmtObject.cmt_month = month.options[month.selectedIndex].value;
		cmtObject.dept = month.options[dept.selectedIndex].value;
		if (cmtObject.cmt_year == ""
				|| cmtObject.cmt_month == ""
				|| cmtObject.dept == "" || name == null) {
			alert('항목을 모두 입력하세요.');
		} else {
			var info = new Object();
			info.emp_dept_code = $(
					"#emp_dept_code option:selected").val();
			info.emp_name = $("#emp_name").val();
			var emp_no;

			var date = new Object();
			date.cmt_year = $("#cmt_year").val();
			date.cmt_month = $("#cmt_month").val();
			$.ajax({
				type : "POST",
				contentType : 'application/json;charset=UTF-8',
				dataType : 'json',
				url : "totalpay1.do",
				data : JSON.stringify(info),
				success : function(result) {
					emp_no = result.emp_no;
					console.log(emp_no);
					date.emp_no = emp_no;
	
					$.ajax({
						type : "POST",
						contentType : 'application/json;charset=UTF-8',
						dataType : 'json',
						url : "totalpay2.do",
						data : JSON.stringify(date),
						success : function(gridData) {
							console.log(gridData);
							grid.resetData(gridData);
							var onCount = grid.findRows({
										cmt_status_kr : '정상출근'
									}).length;
							var offCount = grid.findRows({
										cmt_status_kr : '정상퇴근'
									}).length;
							var realCount = Math.min(onCount,offCount);
							var count = getDate(date.cmt_year,date.cmt_month);
							$('#days').val('정규 근무일 : '+ count
									+ ', 실제 근무일: '+ realCount);

							var sal_basic_pay = Math.round(result.sal_basic_pay* realCount/ count);
							$('input[name=emp_no]').val(emp_no);
							$('input[name=sal_basic_pay]').val(sal_basic_pay);
							$('input[name=sal_total]').val(sal_basic_pay+ 7500* realCount);
							$('input[name=sal_national_pension]').val(Math.round(sal_basic_pay * 0.045));
							$('input[name=sal_health_insurance]').val(Math.round(sal_basic_pay * 0.0323));
							$('input[name=sal_longterm_care_insurance]')
									.val(Math.round(sal_basic_pay * 0.0323 * 0.0851));
							$('input[name=sal_employment_insurance]')
									.val(Math.round(sal_basic_pay * 0.0065));
							$('input[name=sal_income_tax]')
									.val(Math.round(sal_basic_pay * 0.01666));
							$('input[name=sal_local_income_tax]')
									.val(Math.round(sal_basic_pay * 0.01666 * 0.1));
							$('input[name=sal_deducted]')
									.val(Math.round(sal_basic_pay* 0.045
										+ sal_basic_pay* 0.0323+ sal_basic_pay* 0.0323
										* 0.0851+ sal_basic_pay* 0.0065+ sal_basic_pay
										* 0.01666+ sal_basic_pay* 0.01666* 0.1));
							$('input[name=sal_food_pay]').val(7500 * realCount);
							$('input[name=sal_real]')
									.val(Math.round(sal_basic_pay+ 7500
										* realCount- sal_basic_pay* 0.045
										- sal_basic_pay* 0.0323- sal_basic_pay* 0.0323
										* 0.0851- sal_basic_pay* 0.0065- sal_basic_pay
										* 0.01666- sal_basic_pay* 0.01666* 0.1));
							$('input[name=sal_bonus]').val(0);
							$('input[name=sal_year]').val($("#cmt_year").val());
							$('input[name=sal_month]').val($("#cmt_month").val());
						}
					});
				}
			});
		}
	});
 	
 	function checkAgain(){
 		try {
	 		if(confirm("확정하면 수정 할 수 없습니다. 급여를 확정하시겠습니까?")) return true;
	 		else return false;
			
		} catch (e) {
			alert(e.message);
		}
 	}

	function getDate(year, month) {
		var date1 = new Date(year, month - 1, 1);
		var date2 = new Date(year, month, 0);
		var count = 0;

		while (true) {

			if (date1.getTime() >= date2.getTime())
				break;
			else {
				var temp = date1.getDay();
				if (temp != 0 && temp != 6)
					count++;
			}
			date1.setDate(date1.getDate() + 1);
		}
		return count;
	}

	const grid = new tui.Grid({
		el : document.getElementById('grid'),
		data : null,
		bodyHeight: 500,
		columns : [ {
			header : '일',
			name : 'cmt_day',
	        sortingType: 'asc',
	        sortable: true
		}, {
			header : '시',
			name : 'cmt_hour'
		}, {
			header : '분',
			name : 'cmt_minute'
		}, {
			header : '상태',
			name : 'cmt_status',
		}, {
			header : '상태2',
			name : 'cmt_status_kr',
		} ]
	});
</script>
</html>
<%@include file="../../includes/footer.jsp"%>