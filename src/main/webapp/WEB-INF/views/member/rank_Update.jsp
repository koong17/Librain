<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member Rank Update Page</title>
</head>
<body>
<fieldset>
	<legend>
		<h3>회원의 등급을 변경할 수 있습니다.</h3>
	</legend>
	<form action="member/rank.do">
		회원명 : ${ mem_name }
		회원 ID : ${ mem_pw}
		회원 등급 : <input type="number" name="mem_rank" value="${ mem_rank }">
		<input type="submit" value="수정하기">
	</form>
</fieldset>
</body>
</html>