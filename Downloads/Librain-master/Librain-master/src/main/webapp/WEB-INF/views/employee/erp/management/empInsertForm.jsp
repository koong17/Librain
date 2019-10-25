<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html><head><meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://uicdn.toast.com/tui-grid/latest/tui-grid.css" />
<script src="https://uicdn.toast.com/tui-grid/latest/tui-grid.js"></script>
</head>
<body>
<div class="container">
	<br>
	<form action="empInsert.do" method="post" name="f" onsubmit="javascript:return formCheck();">
		<div class="form-group">
		    <div class="row form-group" id="divName">
                <label for="inputId" class="col-xs-2 control-label">이름</label>
                <div class="col-xs-4">
                    <input type="text" name="emp_name" class="form-control" placeholder="홍길동" id="id" maxlength="10" required>
                </div>
                <label for="inputPhoneNumber" class="col-xs-2 control-label">휴대폰 번호</label>
                <div class="col-xs-4">
                    <input type="tel" name="emp_telephone" class="form-control" id="emp_telephone" placeholder="-를 제외한 숫자만 입력" maxlength="11" required>
                </div>
            </div><!-- 
            <div class="row form-group" id="divTel">
            </div> -->
            <div class="row form-group" id="divEmail">
                <label for="inputEmail" class="col-xs-2 control-label">이메일</label>
                <div class="col-xs-10">
                    <input type="email" name="emp_email" class="form-control" id="emp_email" placeholder="ex) librain@librain.org" maxlength="40" required>
                </div>
            </div>
            <div class="row form-group" id="divDept">
                <label for="inputDept" class="col-xs-2 control-label">부서</label>
                <div class="col-xs-4">
                    <select name="emp_dept_code" class="form-control" id="emp_dept_code" required>
					  <option value="" disabled selected>선택</option>
					  <option value="000">관장</option>
					  <option value="001">총무부</option>
					  <option value="002">교육부</option>
					  <option value="003">정보부</option>
					</select>
                </div>
                <label for="inputPosition" class="col-xs-2 control-label">직책</label>
                <div class="col-xs-4">
                    <input type="text" name="emp_position" class="form-control" placeholder="사원" id="emp_position" maxlength="10" required>
                </div>
            </div>
            <div class="row form-group" id="divPos">
                <label for="inputPosition" class="col-xs-2 control-label">기본급</label>
                <div class="col-xs-3">
                    <input type="number" name="emp_basic_pay" class="form-control" placeholder="2500000" id="emp_basic_pay" maxlength="8" required>
                </div>
                <div class="col-xs-1">
                    원
                </div>
                <label for="inputPosition" class="col-xs-2 control-label">은행명</label>
                <div class="col-xs-4">
                    <input type="text" name="emp_bank_name" class="form-control" placeholder="우리" id="emp_bank_name" maxlength="20" required>
                </div>
            </div>
            <div class="row form-group" id="divPos">
                <label for="inputPosition" class="col-xs-2 control-label">계좌번호</label>
                <div class="col-xs-10">
                    <input type="text" name="emp_account_number" class="form-control" placeholder="-를 제외한 숫자만 입력" id="emp_account_number" maxlength="30" required>
                </div>
            </div>
		    <div class="row form-group" id="divAddrNum">
		    	<input type="hidden" id="emp_address" name="emp_address" value="">
                <label for="inputAddressNumber" class="col-xs-2 control-label">우편번호</label>
                <div class="col-xs-2">
                    <input type="text" name="emp_address_number" class="form-control" placeholder="00000" id="emp_address_number" maxlength="30" required readOnly>
                </div>
                <div class="col-xs-2">
                	<input type="button" class="btn" value="검색" onclick="daumPostcode()">
                </div>
                <div class="col-xs-6">
                	<input type="text" name="emp_address1" class="form-control" id="emp_address1" placeholder="기본주소" maxlength="30" required readOnly>
                </div>
            </div>
		    <div class="row form-group" id="divAddr">
                <label for="inputId" class="col-xs-2 control-label">주소</label>
                <div class="col-xs-10">
                    <input type="text" name="emp_address2" class="form-control" id="emp_address2" placeholder="상세주소" maxlength="30" required>
                    
                </div>
            </div>
            <div class="row form-group">
                <label for="inputGender" class="col-xs-2 control-label">성별</label>
                <div class="col-xs-2">
                    <select class="form-control" name="emp_gender" id="emp_gender" required>
                        <option value="F">여</option>
                        <option value="M">남</option>
                    </select>
                </div>
                <input type="hidden" id="emp_join_date" name="emp_join_date" value="">
                <input type="hidden" id="emp_join_day" name="emp_join_day" value="">
                <label for="inputJoindate" class="col-xs-2 control-label">입사일</label>
               	<div class="col-xs-2">
               		<input class="form-control" type="number" name="emp_join_year" id="emp_join_year" placeholder="년" required>
               	</div>
               	<div class="col-xs-2">
                   <select class="form-control" name="emp_join_month" id="emp_join_month" required>
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
               	<div class="col-xs-2">
               		<input class="form-control" type="number" name="emp_join_dayInt" id="emp_join_dayInt" placeholder="일" required>
               	</div>
            </div>
            <div class="row form-group" id="divPos">
            	<input type="hidden" id="emp_password" name="emp_password" value="">
            	<input type="hidden" id="emp_jumin" name="emp_jumin" value="">
                <label for="inputPosition" class="col-xs-2 control-label">주민번호</label>
                <div class="col-xs-5">
                    <input type="text" name="emp_jumin1" class="form-control" placeholder="920101" id="emp_jumin1" maxlength="6" required onclick="console.log( document.getElementById('emp_address_number').value)">
                </div>
                <div class="col-xs-5">
                    <input type="text" name="emp_jumin2" class="form-control" placeholder="2222222" id="emp_jumin2" maxlength="7" required>
                </div>
            </div>
			<div class="row form-group">
				<div class="col-xs-6">
					<input type="submit" value="사원 추가" class="btn btn-success btn-block btn-lg" tabindex="7">
               	</div>
				<div class="col-xs-6">
					<input type="button" value="취소" onclick="window.close()" class="btn btn-primary btn-block btn-lg" tabindex="7">
               	</div>
			</div>
		</div>
	</form>
</div>
</body>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script type="text/javascript">
	function formCheck() {
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
			alert("전화번호를 확인하세요"); f.emp_telephone.focus(); return false;
		} else if(document.getElementById("emp_basic_pay").value*1 <= 100000 || document.getElementById("emp_basic_pay").value*1 > 20000000 ) {
			alert("기본급을 확인하세요"); return false;
		} else if(document.getElementById("emp_account_number").value.length <= 8) {
			alert("계좌번호를 확인하세요"); return false;
		} else if(document.getElementById("emp_address_number").value.length < 2) {
			alert("우편번호를 입력하세요"); return false;
		} else if(document.getElementById("emp_address1").value.length < 2) {
			alert("기본주소를 입력하세요"); return false;
		} else if(year < 1950 || year > today.getFullYear() || day < 1 || day > 31) {
			alert("입사일을 입력하세요"); return false;
		} else if(!regJumin1.test(document.getElementById("emp_jumin1").value) || !regJumin2.test(document.getElementById("emp_jumin2").value)) {
			alert("주민번호를 확인하세요"); return false;
		} else {
			alert("사원이 추가되었습니다.");
			return true;
		}
	}
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
	            document.getElementById("emp_address2").focus();
	        }
	    }).open();
	}
	
</script>
</html>