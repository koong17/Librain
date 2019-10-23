<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 변경</title>
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
	<c:when test="${empty sessionScope.emp_no }">
	<script>window.location.href='login.do'</script>
	</c:when>
	<c:otherwise>
    <div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading" align="center">
                    	<img alt="" src="resources/img/logo.png" class="logo" ><br>
                        <h3 class="panel-title">현재 기본 비밀번호를 사용하고 있습니다.<br> 비밀번호를 변경해주세요.</h3>
                    </div>
                    <div class="panel-body">
                        <form role="form" name="f" method="post" action="changepwd.do" onsubmit="javascript:return formCheck();">
                            <fieldset>
                                <div class="form-group">
                                    <input class="form-control" placeholder="비밀번호 입력(영문 및 숫자 6~12자)" name="emp_password" id="emp_password" type="password" maxlength="12" autofocus>
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="비밀번호 확인" name="emp_password_ck" id="emp_password_ck" type="password" maxlength="12">
                                </div>
                                <input class="btn btn-lg btn-success btn-block" type="submit" id="login" value="비밀번호 변경">
                            </fieldset>
                        </form>
                        <a href="main.do">다음에 변경하기</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
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
	
	function formCheck(){
		var regPwd = /^[a-zA-Z0-9]{6,12}$/;
		
		if(!regPwd.test(f.emp_password.value)) {
			alert("비밀번호를 확인하세요"); return false;
		} else if(f.emp_password.value != f.emp_password_ck.value){
			alert("비밀번호와 재입력한 비밀번호가 일치하지 않습니다."); return false;
		} else{
			alert("비밀번호가 변경되었습니다."); return true;
		}
	}
</script>
</html>