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

 <br />
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
	<script>window.location.href='book/search.do'</script>
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
    
    <!-- /.row -->
<!--    <div class="row">
 	<div class="col-lg-4">
 	 <div class="well">
  		<h4 style="font-weight:bold; color:red">기존 인덱스 파일에 있던 링크들</h4>
  		<hr>
  		memberjoin.do<a href="memberjoin.do">회원가입</a><br>
  		memberList.do<a href="memberList.do">회원조회</a><br>
  		<hr>
  		mgmt/emplist.do <a href="mgmt/emplist.do">직원목록</a><br>
		mgmt/emplist2.do <a href="mgmt/emplist2.do">직원목록-관리자</a><br>
		mgmt/cmtlist.do <a href="mgmt/cmtlist.do">근태목록</a><br>
		mgmt/totalpaylist.do <a href="mgmt/totalpaylist.do">급여목록-관리자</a><br>
		mgmt/totalpay.do <a href="mgmt/totalpay.do">급여관리-관리자</a><br>
	  </div>
 	 </div>
 	
 	<div class="col-lg-4">
 	 <div class="well">
  		mypage/commute.do <a href="mypage/commute.do">근태관리</a><br>
		mypage/info.do <a href="mypage/info.do">개인정보 수정</a><br>
		mypage/pay.do <a href="mypage/pay.do">개인 급여</a><br>
		mypage/test.do <a href="mypage/test.do">도서 검색</a><br>
		<hr>
		member/book/search.do<a href="member/book/search.do">고객 도서 검색</a> <br>
		member/book/hope.do<a href="member/book/hope.do">고객 희망 도서</a> <br>
		book/hope.do<a href="book/hope.do">희망 도서 승인</a> <br>
		book/search.do<a href="book/search.do">직원 도서 검색</a><br>
		book/rent.do<a href="book/rent.do">도서 대여</a><br>
		book/newApply.do<a href="book/newApply.do">도서 구입 신청</a><br>
		book/discardApply.do<a href="book/discardApply.do">도서 폐기 신청</a><br>
   	 </div>
 	 </div>
 	
 	<div class="col-lg-4">
 	 <div class="well">
  		./facility<a href="./facility">시설 </a><br>
		./facilityapproval<a href="./facilityapproval">시설승인</a>
		<hr>
		admin/book/approve/newBook.do<a href="admin/book/approve/newBook.do">도서 구입 승인</a><br>
		admin/book/approve/disBook.do<a href="admin/book/approve/disBook.do">도서 폐기 승인</a>
		<hr>
		board/list.do<a href="board/list.do">게시판</a>
		<hr>
		mvc/login.do<a href="login.do">직원로그인</a>
   	 </div>
 	 </div>
 	</div> -->
    
	</c:when>
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