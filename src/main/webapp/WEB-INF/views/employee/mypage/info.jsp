<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../includes/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>개인 정보 수정</title>
<link rel="stylesheet" href="https://uicdn.toast.com/tui-grid/latest/tui-grid.css" />
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://uicdn.toast.com/tui-grid/latest/tui-grid.js"></script>
</head>
<body>
	<!-- Modal -->

	<div class="modal fade" id="changePwd" role="dialog"  tabindex="-1" aria-labelledby="modal-login-label" aria-hidden="true">
		<div class="modal-dialog">
		
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header" style="padding: 30px 30px;">
					<button type="button" class="close" data-dismiss="modal" style="margin-top: 7px;">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4><span class="glyphicon glyphicon-user"></span>비밀번호 수정</h4>
				</div>

				<form class="form-horizontal" method="POST" id="Frm" name="Frm">
					<div class="modal-body" style="padding: 40px 50px; height: 200px;">
						<div id="wrongPwd">
						</div>
						<div class="form-group" id="divPwd">
							<input type="password" class="pwd form-control" id="oldPwd" name="oldPwd"
								placeholder="기존 비밀번호 입력" maxlength="12" required>
						</div>
						<div class="form-group" id="divPwd">
							<input type="password" class="pwd form-control" id="pwd" name="pwd"
								placeholder="새 비밀번호 입력(영문 및 숫자 6~12자)" maxlength="12" required>
						</div>
						<div class="form-group" id="divPwd2">
							<input type="password" class="form-control" id="pwd2" name="pwd2"
								placeholder="새 비밀번호 확인" maxlength="12" required>
						</div>
					</div>
				<div class="modal-footer">
					<button type="button" id="updatePwd" name="updatePwd" class="btn btn-success btn-default pull-left"  value="Send" style="margin: 10px; margin-left: 35px">
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
				<h1 class="page-header">개인 정보 수정</h1>
			</div>
		</div>
		<div class="row"><br><br></div>
		<div class="row">
			<form action="" method="post" onsubmit="javascript:return formCheck();">
				<div class="col-md-7 col-md-offset-2">
					<input hidden="emp_no" value=${ employeeDTO.emp_no }>
					<div class="row form-group">
						<label for="inputEmpno" class="col-md-2 control-label">사원번호</label>
						<div class="col-md-5">
							<input type="text" name="emp_no" class="form-control"
								value=${ employeeDTO.emp_no } maxlength="10" readOnly>
						</div>
					</div>
					<div class="row form-group">
						<label for="inputId" class="col-md-2 control-label">이름</label>
						<div class="col-md-4">
							<input type="text" name="emp_name" class="form-control"
								value=${ employeeDTO.emp_name } id="id" maxlength="10" readOnly required>
						</div>
						<label for="inputPhoneNumber" class="col-md-2 control-label">휴대폰
							번호</label>
						<div class="col-md-4">
							<input type="tel" name="emp_telephone" class="form-control"
								id="emp_telephone" value=${ employeeDTO.emp_telephone }
								maxlength="11" required>
						</div>
					</div>
					<div class="row form-group">
						<label for="inputEmail" class="col-md-2 control-label">이메일</label>
						<div class="col-md-10">
							<input type="email" name="emp_email" class="form-control"
								id="emp_email" value=${ employeeDTO.emp_email } maxlength="40"
								required>
						</div>
					</div>
					<div class="row form-group">
						<label for="inputEmail" class="col-md-2 control-label">비밀번호</label>
						<div class="col-md-3">
							<input type="password" name="emp_password" class="form-control"
								id="emp_password" value=${ employeeDTO.emp_password } maxlength="12"
								readOnly required>
						</div>
						<div class="col-md-2">
							<input type="button" class="btn" value="비밀번호 수정"
								data-toggle="modal" data-target="#changePwd">
						</div>
					</div>
					<div class="row form-group">
						<label for="inputDept" class="col-md-2 control-label">부서</label>
						<div class="col-md-4">
							<select name="emp_dept_code" class="form-control"
								id="emp_dept_code" disabled required>
								<option value="" disabled selected>선택</option>
								<option value="000">관장</option>
								<option value="001">총무부</option>
								<option value="002">교육부</option>
								<option value="003">정보부</option>
							</select>
						</div>
						<label for="inputPosition" class="col-md-2 control-label">직책</label>
						<div class="col-md-4">
							<input type="text" name="emp_position" class="form-control"
								value=${ employeeDTO.emp_position } id="emp_position"
								maxlength="10" readOnly required>
						</div>
					</div>
					<div class="row form-group">
						<label for="inputPosition" class="col-md-2 control-label">기본급</label>
						<div class="col-md-3">
							<div class="form-group input-group">
								<input type="number" name="emp_basic_pay" class="form-control"
									value=${ employeeDTO.emp_basic_pay } id="emp_basic_pay"
									maxlength="8" readOnly required> <span
									class="input-group-addon">원</span>
							</div>
						</div>
						<div class="col-md-1"> </div>
						<label for="inputPosition" class="col-md-2 control-label">은행명</label>
						<div class="col-md-4">
							<input type="text" name="emp_bank_name" class="form-control"
								value=${ employeeDTO.emp_bank_name } id="emp_bank_name"
								maxlength="20" required>
						</div>
					</div>
					<div class="row form-group">
						<label for="inputPosition" class="col-md-2 control-label">계좌번호</label>
						<div class="col-md-10">
							<input type="text" name="emp_account_number"
								class="form-control" value=${ employeeDTO.emp_account_number }
								id="emp_account_number" maxlength="30" required>
						</div>
					</div>
					<div class="row form-group">
						<input type="hidden" id="emp_address" name="emp_address" value="">
						<label for="inputAddressNumber" class="col-md-2 control-label">우편번호</label>
						<div class="col-md-2">
							<input type="text" name="emp_address_number"
								class="form-control" value=${ employeeDTO.emp_address_number }
								id="emp_address_number" maxlength="30" required readOnly>
						</div>
						<div class="col-md-2">
							<input type="button" class="btn" value="검색"
								onclick="daumPostcode()">
						</div>
						<div class="col-md-6">
							<input type="text" name="emp_address1" class="form-control"
								id="emp_address1" placeholder="기본주소" maxlength="30" required
								readOnly>
						</div>
					</div>
					<div class="row form-group">
						<label for="inputId" class="col-md-2 control-label">주소</label>
						<div class="col-md-10">
							<input type="text" name="emp_address" class="form-control"
								id="emp_address2" maxlength="30" required>

						</div>
					</div>
					<div class="row form-group">
						<label for="inputGender" class="col-md-2 control-label">성별</label>
						<div class="col-md-2">
							<select class="form-control" name="emp_gender" id="emp_gender"
								disabled required>
								<option value="F">여</option>
								<option value="M">남</option>
							</select>
						</div>
						<input type="hidden" id="emp_join_date" name="emp_join_date"
							value=""> <input type="hidden" id="emp_join_day"
							name="emp_join_day" value=""> <label for="inputJoindate"
							class="col-md-2 control-label">입사일</label>
						<div class="col-md-2">
							<input class="form-control" type="number" name="emp_join_year"
								id="emp_join_year" value=${ employeeDTO.emp_join_date }
								readOnly required>
						</div>
						<div class="col-md-2">
							<select class="form-control" name="emp_join_month"
								id="emp_join_month" disabled required>
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
						<div class="col-md-2">
							<input class="form-control" type="number" name="emp_join_dayInt"
								id="emp_join_dayInt" placeholder="일" disabled required>
						</div>
					</div>
					<div class="row form-group">
						<input type="hidden" id="emp_password" name="emp_password"
							value=""> <input type="hidden" id="emp_jumin"
							name="emp_jumin" value=""> <label for="inputPosition"
							class="col-md-2 control-label">주민번호</label>
						<div class="col-md-5">
							<input type="text" name="emp_jumin1" class="form-control"
								placeholder="920101" id="emp_jumin1" maxlength="6" readOnly required>
						</div>
						<div class="col-md-5">
							<input type="text" name="emp_jumin2" class="form-control"
								placeholder="2222222" id="emp_jumin2" maxlength="7" readOnly required>
						</div>
					</div>
					<div class="row form-group">
						<div class="col-md-6">
							<input type="submit" value="수정"
								class="btn btn-success btn-block btn-lg" tabindex="7">
						</div>
						<div class="col-md-6">
							<input type="button" value="리셋" onclick="location.reload()"
								class="btn btn-primary btn-block btn-lg" tabindex="7">
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script type="text/javascript">
	$(function() {
		var addrSplit = ("${employeeDTO.emp_address}").split(",",2);
		document.getElementById("emp_address1").value =addrSplit[0];
		document.getElementById("emp_address2").value =addrSplit[1];
		$("#emp_dept_code").val("${employeeDTO.emp_dept_code}").prop("selected", true);
		$("#emp_gender").val("${employeeDTO.emp_gender}").prop("selected", true);
		document.getElementById("emp_jumin1").value =("${employeeDTO.emp_jumin}").substring(0,6);
		document.getElementById("emp_jumin2").value =("${employeeDTO.emp_jumin}").substring(6);
		document.getElementById("emp_join_year").value =("${employeeDTO.emp_join_date}").substring(0,4);
		$("#emp_join_month").val(("${employeeDTO.emp_join_date}").substring(5,7)).prop("selected", true);
		var joinDay = ("${employeeDTO.emp_join_date}").substring(8,10);
		if(joinDay.startsWith("0")) joinDay = joinDay.substring(1);
		console.log(joinDay);
		document.getElementById("emp_join_dayInt").value = joinDay;
	});
	
	function formCheck() {
		document.getElementById("emp_dept_code").disabled = false;
		document.getElementById("emp_gender").disabled = false;
		document.getElementById("emp_join_month").disabled = false;
		var regTel = /^((01[1|6|7|8|9])[1-9]+[0-9]{6,7})|(010[1-9][0-9]{7})$/;
		var regJumin1 = /^(?:[0-9]{2}(?:0[1-9]|1[0-2])(?:0[1-9]|[1,2][0-9]|3[0,1]))/;
		var regJumin2 = /[1-4][0-9]{6}$/;
		var day = document.getElementById("emp_join_dayInt").value;
		if(day<10) document.getElementById("emp_join_day").value = ""+0+day;
		else document.getElementById("emp_join_day").value = day;
		console.log("length: "+document.getElementById("emp_account_number").value.length);
		console.log(document.getElementById("emp_basic_pay").value);
		document.getElementById("emp_address").value = document.getElementById("emp_address1").value+","+document.getElementById("emp_address2").value;
		document.getElementById("emp_join_date").value = document.getElementById("emp_join_year").value+document.getElementById("emp_join_month").value+document.getElementById("emp_join_day").value;
		document.getElementById("emp_jumin").value = document.getElementById("emp_jumin1").value+document.getElementById("emp_jumin2").value;
		document.getElementById("emp_password").value = document.getElementById("emp_jumin1").value;
		console.log("pwd: "+document.getElementById("emp_password").value);
		var today = new Date();
		var year = document.getElementById("emp_join_year").value;
		if(!regTel.test(document.getElementById("emp_telephone").value)) {
			alert("전화번호를 확인하세요"); return false;
		} else if(document.getElementById("emp_basic_pay").value*1 <= 100000 || document.getElementById("emp_basic_pay").value*1 > 20000000 ) {
			alert("기본급을 확인하세요"); return false;
		} else if(document.getElementById("emp_account_number").value.length <= 8) {
			alert("계좌번호를 확인하세요"); return false;
		} else if(document.getElementById("emp_address_number").value.length < 2) {
			alert("우편번호를 입력하세요"); return false;
		} else if(document.getElementById("emp_address1").value.length < 2) {
			alert("기본주소를 입력하세요"); return false;
		} else if(year < 1950 || year > today.getFullYear() || day < 1 || day > 31) {
			alert("입사일을 확인하세요"); return false;
		} else if(!regJumin1.test(document.getElementById("emp_jumin1").value) || !regJumin2.test(document.getElementById("emp_jumin2").value)) {
			alert("주민번호를 확인하세요"); return false;
		} else {
			alert("사원이 수정되었습니다.");
			return true;
		}
	}
	
	$('#updatePwd').click(function() {
		var regPwd = /^[a-zA-Z0-9]{6,12}$/;
		
		if(!regPwd.test(Frm.oldPwd.value) || !regPwd.test(Frm.pwd.value) || !regPwd.test(Frm.pwd2.value)) {
			alert("비밀번호 형식을 확인하세요"); return false;
		} else if(Frm.pwd.value != Frm.pwd2.value){
			alert("비밀번호와 재입력한 비밀번호가 일치하지 않습니다."); return false;
		} else{
			$.ajax({
				url : 'updatePwd.do',
				type : 'post',
				data : $('#Frm').serialize(),
				success : function(data) {
					if (data == "0") {
						console.log(data);
						alert("비밀번호가 틀렸습니다.");
						$("#oldPwd").val("");
						$("#pwd").val("");
						$("#pwd2").val("");
					} else {
						alert("비밀번호가 수정되었습니다.");
						$("#oldPwd").val("");
						$("#pwd").val("");
						$("#pwd2").val("");
						$("#changePwd").modal('hide');
					}
				}
			});
		}
	});
	
	function daumPostcode() {
	    new daum.Postcode({
	        oncomplete: function(data) {
	            var addr = '';
	            var extraAddr = '';
	            
	            if (data.userSelectedType === 'R') {
	                addr = data.roadAddress;
	            } else {
	                addr = data.jibunAddress;
	            }
	            if(data.userSelectedType === 'R'){
	                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
	                    extraAddr += data.bname;
	                }
	                if(data.buildingName !== '' && data.apartment === 'Y'){
	                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
	                }
	                if(extraAddr !== ''){
	                    extraAddr = ' (' + extraAddr + ')';
	                }
	                addr += extraAddr;
	            }
	           /*  else {
	                document.getElementById("sample6_extraAddress").value = '';
	            } */
	            document.getElementById('emp_address_number').value = data.zonecode;
	            document.getElementById("emp_address1").value = addr;
	            document.getElementById("emp_address1").focus();
	        }
	    }).open();
	}
	
</script>
</html>
<%@include file="../includes/footer.jsp"%>