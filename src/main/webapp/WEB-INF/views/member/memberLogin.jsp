<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member Login</title>

<!-- grid -->
<link rel="stylesheet" href="https://uicdn.toast.com/tui-grid/latest/tui-grid.css" />
<script src="https://uicdn.toast.com/tui-grid/latest/tui-grid.js"></script>
<!-- jquery -->
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script
   src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
   integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
   crossorigin="anonymous"></script>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>
<body>

<div class="container">
	<form action="mypage.do" method="post">
		<div class="row form-group">
			<div class="form-group">
				<label for="inputID" class="col-xs-5 control-label">아이디</label>
				<div class="col-xs-5">
					<input class="form-control" type="text" placeholder="ID입력" id="mem_id" name="mem_id" required>
				</div>
			</div>
			<div class="form-group">
				<label for="inputPW" class="col-xs-5 control-label">비밀번호</label>
				<div class="col-xs-5">
					<input class="form-control" type="text" placeholder="ID입력" id="mem_pw" name="mem_pw" maxlength="12" required>
				</div>
			</div>
		</div>
		<div class="row form-group">
			<div class="form-group">
				<div class="col-xs-10">
					<input type="submit" class="btn btn-primary btn-block" id="LoginBtn" value="Login">
				</div>
			</div>
		</div>
	</form>		
</div>
</body>
<script type="text/javascript">
$(function() {
	if("${param.check}"=="f") alert("아이디 및 비밀번호를 확인해주세요.");
	
});
</script>
</html>