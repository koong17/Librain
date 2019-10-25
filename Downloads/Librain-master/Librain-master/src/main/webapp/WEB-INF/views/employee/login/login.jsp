<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>librain</title>
<style type="text/css">
	body{
		background-image: url('resources/img/background-library.jpg');
		background-size: 100%;
	}
	
	.logo{
		width: 50%;
	}
</style>

    <!-- Bootstrap Core CSS -->
    <link href="resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="resources/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="resources/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="resources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    
</head>
<body>
	<c:choose>
	<c:when test="${!empty sessionScope.emp_no }">
	<script>window.location.href='main.do'</script>
	</c:when>
	<c:when test="${empty sessionScope.emp_no}">
	<a class="btn btn-lg btn-success pull-right" href="./memberMain.jsp" role="button"  target="_blank">고객용 메뉴</a>
    <div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading" align="center">
                    	<img alt="" src="resources/img/logo.png" class="logo" >
                        <!-- <h3 class="panel-title"></h3> -->
                    </div>
                    <div class="panel-body">
                        <form role="form" id="loginForm" action="loginCheck.do">
                            <fieldset>
                                <div class="form-group">
                                    <input class="form-control" placeholder="사원번호" name="emp_no" id="emp_no" type="text" autofocus>
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="비밀번호" name="emp_password" id="emp_password" type="password" value="">
                                </div>
                                <!-- <div class="checkbox">
                                    <label>
                                        <input name="remember" type="checkbox" value="Remember Me">Remember Me
                                    </label>
                                </div> -->
                                <!-- Change this to a button or input when using this as a form -->
                                <input class="btn btn-lg btn-success btn-block" type="button" id="login" value="로그인">
                            </fieldset>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- ./container -->
    
	</c:when>
	<c:otherwise>
		<h3>${emp_name }님 환영합니다</h3>
		<a href="logout.do">로그아웃</a><br>
		<a href="index.jsp">홈으로</a>
	</c:otherwise>
	</c:choose>
    <!-- jQuery -->
    <script src="resources/vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="resources/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="resources/vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="resources/dist/js/sb-admin-2.js"></script>
</body>
<script type="text/javascript">
	$(document).ready(function(e){
		if("${param.check}"=="f") alert('사원번호와 비밀번호를 확인해주세요');
		
		$('#login').click(function(){
			//입력 값 체크
			if($.trim($('#emp_no').val()) == ''){
				alert("아이디를 입력하세요");
				$('#emp_no').focus();
				return;
			}else if($.trim($('#emp_password').val())==''){
				alert("패스워드를 입력하세요");
				$('#emp_password').focus();
				return;
			}
			
			//전송
			$('#loginForm').submit();
		});
	});
</script>
</html>