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
<fieldset>
<table cellpadding="5">
			<th><B>NAME</B></th>
			<th><B>ID</B></th>
			<th><B>EMAIL</B></th>
			<th><B></B></th>
			<th><B></B></th>
			<th id="multi"><B></B></th>
			<c:forEach items="${list}" var="item" varStatus="status">
				<tr onclick="test(this)">
					<td>${item.mem_name}</td>
					<td>${item.mem_id}</td>
					<td>${item.mem_email}</td>
					
					<td><a href="delete_member.do?mem_id=${ item.mem_id}"><button
								id="delete">삭 제</button></a></td>
					<td><a href="rankform.do?mem_rank=${ item.mem_rank}"><button
								id="edit">수 정</button></a></td>
				</tr>
			</c:forEach>
		</table>
</fieldset>
</body>
</html>