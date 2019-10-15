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
	<div>
		<div class="col-md-4">
			<input class="form-control" type="text" placeholder="아이디를 입력하세요."
				id="mem_id" name="mem_id">
		</div><br><br>
		<div class="col-md-4">
			<input class="form-control" type="text" placeholder="비밀번호를 입력하세요."
				id="mem_pw" name="mem_pw">
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
			<button type="button" class="btn btn-primary btn-block" id="joinBtn"
				onclick="location.href='memberjoin.do'">
				<i class="fa fa-join">회원가입</i>
			</button>
		</div>
		<div class="col-md-1">
			<button type="button" class="btn btn-primary btn-block" id="homeBtn"
				onclick="location.href='index.jsp'">
				<i class="fa fa-home">돌아가기</i>
			</button>
		</div>
	</div><p>
	<div id="grid"></div><p>
</body>
</html>

