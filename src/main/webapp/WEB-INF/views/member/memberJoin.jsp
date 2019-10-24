<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>

<!-- jquery -->
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

<!-- bootstrap -->
<!-- bootstrap -->

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
	<form action="./join.do" method="post">
		<div>
			<div class="col-md-4">
				<input class="form-control" type="text" placeholder="아이디를 입력하세요."
					id="mem_id" name="mem_id">
			</div>
			<p>
			<div class="col-md-4">
				<input class="form-control" type="text" placeholder="비밀번호를 입력하세요."
					id="mem_pw" name="mem_pw">
			</div>
			<p>
			<div class="col-md-4">
				<input class="form-control" type="text" placeholder="이름을 입력하세요."
					id="mem_name" name="mem_name">
			</div>
			<p>
			<div class="col-md-4">
				<input class="form-control" type="text" placeholder="주민번호를 입력하세요."
					id="mem_jumin" name="mem_jumin">
			</div>
			<p>
			<div class="col-md-4">
				<input class="form-control" type="text" placeholder="주소를 입력하세요."
					id="mem_address" name="mem_address">
			</div>
			<p>
			<div class="col-md-4">
				<input class="form-control" type="text" placeholder="전화번호를 입력하세요."
					id="mem_phone" name="mem_phone">
			</div>
			<p>
			<div class="col-md-4">
				<input class="form-control" type="text" placeholder="이메일을 입력하세요."
					id="mem_email" name="mem_email">
			</div>
			<p>
			<div class="col-md-1">
				<input type="submit" value="회원가입" class="btn btn-primary btn-block"
					id="joinBtn"> <i class="fa fa-join"></i>
			</div>
			<p>
			<div class="col-md-1">
				<button type="button" class="btn btn-primary btn-block" id="homeBtn"
					onclick="location.href='index.jsp'">
					<i class="fa fa-home">home</i>
				</button>
			</div>

		</div>
	</form>
</body>

</html>


