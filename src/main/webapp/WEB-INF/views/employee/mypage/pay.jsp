<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp"%>
<!DOCTYPE html>
<html><head><meta charset="UTF-8">
<title>급여</title>
<link rel="stylesheet" href="https://uicdn.toast.com/tui-grid/latest/tui-grid.css" />
<script src="https://uicdn.toast.com/tui-grid/latest/tui-grid.js"></script>
</head>
<body>

<br>
	<div class="row form-group">
		<div class="col-md-5">
			<div class="form-group">
				<div class="col-md-4">
					<select class="form-control" id="sal_year">
					  <option value="" disabled selected>년</option>
					  <option value="2019">2019</option>
					  <option value="2020">2020</option>
					  <option value="2021">2021</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<div class="col-md-4">
					<select class="form-control" id="sal_month">
					  <option value="" disabled selected>월</option>
					  <option value="9">9</option>
					  <option value="10">10</option>
					  <option value="11">11</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<div class="col-md-4">
					<input type="button" value="확인" id="check" class="btn btn-success btn-block btn-md">
				</div>
			</div>
		</div>
	</div>
	<div class="form-group">
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
	
<%@include file="../includes/footer.jsp"%>
</body>
<script>
	$("#check").click(function(){
		
	   	var date = new Object();
		date.sal_year = $("#sal_year").val();
		date.sal_month = $("#sal_month").val();
		if(date.sal_year==null || date.sal_month==null){
			alert('년, 월을 선택하세요');
		} else {
			$.ajax({											
				type: "POST",
				contentType : 'application/json;charset=UTF-8',
				dataType : 'json',
				url: "pay.do",
				data: JSON.stringify(date),
				success :function(result) {
					$('input[name=emp_no]').val(result.emp_no);
					$('input[name=sal_basic_pay]').val(result.sal_basic_pay);
					$('input[name=sal_total]').val(result.sal_total);
					$('input[name=sal_national_pension]').val(result.sal_national_pension);
					$('input[name=sal_health_insurance]').val(result.sal_health_insurance);
					$('input[name=sal_longterm_care_insurance]').val(result.sal_longterm_care_insurance);
					$('input[name=sal_employment_insurance]').val(result.sal_employment_insurance);
					$('input[name=sal_income_tax]').val(result.sal_income_tax);
					$('input[name=sal_local_income_tax]').val(result.sal_local_income_tax);
					$('input[name=sal_deducted]').val(result.sal_deducted);
					$('input[name=sal_food_pay]').val(result.sal_food_pay);
					$('input[name=sal_real]').val(result.sal_real);
					$('input[name=sal_bonus]').val(result.sal_bonus);
					$('input[name=sal_year]').val(result.sal_year);
					$('input[name=sal_month]').val(result.sal_month);
			    }
			});
		}
	});
</script>
</html>