<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div class="searchForm" align="right">
	<a href="#">도서검색</a>
</div>

<div class="dbTest" align="right">
	<a href="./aa.do">연결테스트</a>
</div>
<div class="boardTest" align="right">
	<a href="${pageContext.request.contextPath}/employee/board/list">게시판</a>
</div>
<div class="loginForm" align="center">
<form action="#" method="post">
	<table>
		<tr>
			<td>id : </td>
			<td><input type="text" name="id" placeholder="아이디 입력"></td>
		</tr>
		
		<tr>
			<td>pw : </td>
			<td><input type="password" name="pw" placeholder="비밀번호 입력"></td>
		</tr>
		
		<tr>
			<td align="right" colspan="2">
				<input type="submit" value="로그인"><input type="reset" value="취소">
			</td>
		</tr>	
	</table>
	</form>
</div>
</html>