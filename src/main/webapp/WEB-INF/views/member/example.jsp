<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:forEach var="list" items="${list }">
ID : ${ list.mem_id } <br>
PW : ${ list.mem_pw } <br>
NAME : ${ list.mem_name } <br>
JUMIN : ${ list.mem_jumin } <br>
ADDRESS : ${ list.mem_address } <br>
PHONE : ${ list.mem_phone } <br>
EMAIL : ${ list.mem_email } <br>
RANK : ${ list.mem_rank } <br> <hr>
</c:forEach>

</body>
</html>