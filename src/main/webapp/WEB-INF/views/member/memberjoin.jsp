<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>

<!-- grid -->
<link rel="stylesheet"
	href="https://uicdn.toast.com/tui-grid/latest/tui-grid.css" />
<script src="https://uicdn.toast.com/tui-grid/latest/tui-grid.js"></script>
<!-- jquery -->
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<!-- boostrap -->
<!-- boostrap -->
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
<div class="container">
	<form action="memberjoin.do" method="post" name="joinForm" id="joinForm" onsubmit="javascript:return formCheck();">
		<div class="form-group">
		
			<div class="row form-group">
				<label for="inputID" class="col-xs-2 control-label">아이디</label>
				<div class="col-xs-5">
					<input class="form-control" type="text" placeholder="4~12자의 영문 대소문자와 숫자로만 입력"
						id="mem_id" name="mem_id">
				</div>
				<button type="button" id="mem_idCheck" class="btn btn-default btm-sm" onclick="memberIDCheck()">중복확인</button>
			</div>
			
			<br><br>
			
			<div>
				<label for="inputPW" class="col-xs-2 control-label">비밀번호</label>
				<input class="form-control" type="password" placeholder="4~12자의 영문 대소문자와 숫자로만 입력."
					id="mem_pw" name="mem_pw">
				<input type="password" class="form-control" placeholder="비밀번호 확인"
					id="mem_pwCheck" name="mem_pwCheck"><br><br>
			</div><br><br>
			<div>
			<label for="inputName" class="col-xs-2 control-label">이름</label>
				<input class="form-control" type="text" placeholder="이름을 입력하세요."
					id="mem_name" name="mem_name">
			</div><br><br>
			<div class="row form-group" id="divPos">
                <label for="inputJumin" class="col-xs-2 control-label">주민번호</label>
                <div class="col-xs-5">
                    <input type="text" name="mem_jumin1" class="form-control" placeholder="920101" id="mem_jumin1" maxlength="6" required>
                </div>
                <div class="col-xs-5">
                    <input type="text" name="mem_jumin2" class="form-control" placeholder="2222222" id="mem_jumin2" maxlength="7" required>
                </div>
            </div>
			<br><br>
			
			<!-- 주소 -->
			<div>
		    	<input type="hidden" id="mem_address" name="mem_address" value="">
                <label for="inputAddressNumber" class="col-xs-2 control-label">우편번호</label>
                <div class="col-xs-2">
                    <input type="text" name="mem_address_number" class="form-control" placeholder="00000" id="mem_address_number" maxlength="30" required readOnly>
                </div>
                <div class="col-xs-2">
                	<input type="button" class="btn" value="검색" onclick="daumPostcode()">
                </div>
                <div class="col-xs-6">
                	<input type="text" name="mem_address1" class="form-control" id="mem_address1" placeholder="기본주소" maxlength="30" required readOnly>
                </div>
            </div>
		    <div>
                <label for="inputId" class="col-xs-2 control-label">주소</label>
                <div class="col-xs-10">
                    <input type="text" name="mem_address2" class="form-control" id="mem_address2" placeholder="상세주소" maxlength="30" required>
                </div>
            </div>
			<br><br>
			
			<!-- 전화번호 -->
			<div>
				<input class="form-control" type="text" placeholder="전화번호를 입력하세요."
					id="mem_phone" name="mem_phone">
			</div><br><br>
			<div class="row form-group" id="divEmail">
                <label for="inputEmail" class="col-xs-2 control-label">이메일</label>
                <div class="col-xs-10">
                    <input type="email" name="mem_email" class="form-control" id="mem_email" placeholder="ex) librain@librain.org" maxlength="40" required>
                </div>
            </div>
			<div class="col-xs-6">
				<input type="submit" class="btn btn-primary btn-block" id="joinBtn" value="회원가입"
					onclick="location.href='/mvc/memberjoin.do'">
			</div>
			<div class="col-xs-6">
				<button type="button" class="btn btn-primary btn-block" id="homeBtn"
					onclick="location.href='index.jsp'">
					<i class="fa fa-home">돌아가기</i>
				</button>
			</div>
		</div><p>
	</form>
</div>
</body>

<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script type="text/javascript">

var idck=0;
$(function(){
	
	$("#memberIDCheck").click(fucntion(){
		
		var mem_id = $("#mem_id").val();
		
		$.ajax({
			async : true,
			type : 'POST',
			data : mem_id,
			url : "memberIDCheck.do",
			dataType : "json",
			contentType : "application/json; charset=UTF-8",
			success : function(data){
				if(data.cnt > 0){
					alert("존재하는 아이디입니다.");
					$("#inputID").addClass("has-error")
					$("#inputID").removeClass("has-success")
					$("#mem_id").focus();
				} else {
					alert("사용이 가능한 아이디입니다.");
					$("#inputID").addClass("has-error")
					$("#inputID").removeClass("has-success")
					$("#mem_id").focus();
					idck=1;
				}
			}, error : function(error){
				alert("error : "+error);
			}
		});
	});
});
	function formCheck(){
		
		var regID = /^[a-zA-Z0-9]{4,12}$/ 
		var regPW = /^[a-zA-Z0-9]{4,12}$/
		var regJumin1 = /^(?:[0-9]{2}(?:0[1-9]|1[0-2])(?:0[1-9]|[1,2][0-9]|3[0,1]))/;
		var regJumin2 = /[1-4][0-9]{6}$/;
		
		document.getElementById("mem_address").value = document.getElementById("mem_address1").value + document.getElementById("mem_address2").value;
		document.getElementById("mem_jumin").value = document.getElementById("mem_jumin1").value + document.getElementById("mem_jumin2").value;
		
		if(!regID.test(document.getElementById("mem_id").value)){
			alert("ID를 확인하세요"); return false;
		} else if(!regPW.test(document.getElementById("mem_pw").value)){
			alert("PW를 확인하세요"); return false;
		} else if(document.getElementById("mem_pw").value != document.getElementByID("mem_pwCheck").value){
			alert("비밀번호와 재입력한 비밀번호가 일치하지 않습니다.")
		} else if(!regJumin1.test(document.getElementById("mem_jumin1").value) || !regJumin2.test(document.getElementById("mem_jumin2").value)) {
			alert("주민번호를 확인하세요"); return false;
		} else if(document.getElementById("emp_address_number").value.length < 2) {
			alert("우편번호를 입력하세요"); return false;
		} else if(document.getElementById("emp_address1").value.length < 2) {
			alert("기본주소를 입력하세요"); return false;
		} else{
			alert("회원 가입을 축하합니다!"); return true;
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
	           
	            document.getElementById('mem_address_number').value = data.zonecode;
	            document.getElementById("mem_address1").value = addr;
	            document.getElementById("mem_address2").focus();
	        }
	    }).open();
	}

</script>

</html>

