<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>${ msg}</h1>
<c:choose>
	<c:when test='${!empty sessionScope.emp_no }'>
${sessionScope.emp_no }님 환영합니다.
<a href="logout.do">로그아웃</a>
	</c:when>
</c:choose>
<a href="index.jsp">홈으로</a>
</body>
</html>