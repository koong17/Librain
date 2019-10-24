<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member Login</title>
<style type="text/css">
	html, body{
		background-image: url('${pageContext.request.contextPath}/resources/img/background-member.jpg');
		background-size: 100%;
		margin: 0;
	    height: 100%;
	    overflow: hidden;
	}
	.logo{
		width: 50%;
	}
</style>

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

<!-- index에서 가져온 부트스트랩 -->
	<!-- Bootstrap Core CSS -->
	<link href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<!-- MetisMenu CSS -->
	<link href="${pageContext.request.contextPath}/resources/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">
	<!-- Custom CSS -->
	<link href="${pageContext.request.contextPath}/resources/dist/css/sb-admin-2.css" rel="stylesheet">
	<!-- Custom Fonts -->
	<link href="${pageContext.request.contextPath}/resources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

</head>
<body>
<div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading" align="center">
                    	<img alt="" src="${pageContext.request.contextPath}/resources/img/logo.png" class="logo" >
                    </div>
                    <div class="panel-body">
                        <form role="form" action="mypage.do" method="post">
							<fieldset>
								<div class="form-group">
									<input class="form-control" type="text" placeholder="ID입력" id="mem_id" name="mem_id" required>
								</div>
								<div class="form-group">
										<input class="form-control" type="password" placeholder="비밀번호입력" id="mem_pw" name="mem_pw" maxlength="12" required>
								</div>
								<div class="form-group">
										<input type="submit" class="btn btn-primary btn-block" id="LoginBtn" value="Login">
								</div>
							</fieldset>
						</form>	
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
<script type="text/javascript">
$(function() {
	if("${param.check}"=="f") alert("아이디 및 비밀번호를 확인해주세요.");
	
});
</script>
</html>