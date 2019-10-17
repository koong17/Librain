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
	<form action="memberjoin.do" method="post" name="joinForm" id="joinForm">
		<div>
			<div class="col-md-4">
				<input class="form-control" type="text" placeholder="아이디를 입력하세요."
					id="mem_id" name="mem_id">
			</div>
			<div>
				<input type="button" class="btn btn-default btm-sm" value="중복확인" onclick="overlapCheck(this.form)"><span id="overlapText"></span>
			</div>
			<br><br>
			<div class="col-md-4">
				<input class="form-control" type="password" placeholder="비밀번호를 입력하세요."
					id="mem_pw" name="mem_pw">
				<input type="password" class="form-control" placeholder="비밀번호 확인" name="passwordCheck"><br><br>
			</div><br><br>
			<div class="col-md-4">
				<input class="form-control" type="text" placeholder="이름을 입력하세요."
					id="mem_name" name="mem_name">
			</div><br><br>
			<div class="col-md-4">
				<input class="form-control" type="text" placeholder="주민번호를 입력하세요."
					id="mem_jumin" name="mem_jumin">
			</div><br><br>
			<div class="col-md-4">
				<input class="form-control" type="text" placeholder="주소를 입력하세요."
					id="mem_address" name="mem_address">
			</div><br><br>
			<div class="col-md-4">
				<input class="form-control" type="text" placeholder="전화번호를 입력하세요."
					id="mem_phone" name="mem_phone">
			</div><br><br>
			<div class="col-md-4">
				<input class="form-control" type="text" placeholder="이메일을 입력하세요."
					id="mem_email" name="mem_email">
			</div><br><br>
			<div class="col-md-1">
				<input type="submit" class="btn btn-primary btn-block" id="joinBtn" value="회원가입"
					onclick="location.href='/mvc/memberjoin.do'">
			</div>
			<div class="col-md-1">
				<button type="button" class="btn btn-primary btn-block" id="homeBtn"
					onclick="location.href='index.jsp'">
					<i class="fa fa-home">돌아가기</i>
				</button>
			</div>
		</div><p>
	</form>
</body>

<script type="text/javascript">

function memberjoinCheck(){
	
	var re = /^[a-zA-Z0-9]{4,12}$/
	var re2 = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	
	var id = document.getElementById("mem_id");
	var pw = document.getElementById("mem_pw");
	var name = document.getElementById("mem_name");
	var jumin = document.getElementById("mem_jumin");
	var address = documnet.getElementById("mem_address");
	var phone = document.getElementById("mem_phone");
	var email = document.getElementById("mem_email");
	
	
	if(!check(re,mem_id,"아이디는 4~12자의 영문 대소문자와 숫자로만 입력")){
		return false;
	}
	
	if(!check(re,mem_pw,"패스워드는 4~12자의 영문 대소문자와 숫자로만 입력")){
		return false;
	}
	
	if(join.pw.value != join.checkpw.value){
		alert("비밀번호가 다릅니다. 다시 확인해 주세요.");
		join.check.value="";
		join.checkpw.focus();
		return false;
	}
	
	
}

</script>

</html>

