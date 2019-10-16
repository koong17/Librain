<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<script src="./resources/vendor/jquery/jquery.min.js"></script>
</head>
<body>
<h1>로그인 페이지</h1>	<a href="index.jsp">홈으로</a>
	<c:choose>
	<c:when test="${empty sessionScope.emp_no}">
			<form id="loginForm" name="loginForm" action="loginCheck.do">
				<table>
					<tr>
						<td>아이디</td>
						<td><input type="text" name="emp_no" id="emp_no" placeholder="10글자" maxlength="10"></td>
					</tr>
					
					<tr>
						<td>패스워드</td>
						<td><input type="password" name="emp_password" id="emp_password" maxlength="20"></td>
					</tr>
					<tr><td style="font-weight:bold">${msg }</td></tr>
					<tr>
						<td colspan=2>
							<input type="button" id="login" value="로그인"/>
						</td>
					</tr>
				</table>
			</form>
		</c:when>
		<c:otherwise>
			<h3>${sessionScope.emp_no }님 환영합니다</h3>
			<a href="logout.do">로그아웃</a><br>
			<a href="index.jsp">홈으로</a>
		</c:otherwise>
	</c:choose>
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