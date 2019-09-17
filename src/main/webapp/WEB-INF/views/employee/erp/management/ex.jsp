<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html><head><meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://uicdn.toast.com/tui-grid/latest/tui-grid.css" />
</head>
<body>
	<div id="empGrid"></div>
	<c:forEach var="emp" items="${list }">
		${emp.empName } / 
	</c:forEach>
</body>

<script src="https://uicdn.toast.com/tui-grid/latest/tui-grid.js"></script>
<script type="text/javascript">
	
	window.onload = function() {
		const data = [
			{
				name: 'aa'
			},
			{
				name: 'bb'
			}
		];
		
		const grid = new tui.Grid({
			el: document.getElementById('grid'),
			data: data,
			scrollX: false,
			scrollY: false,
			columns: [
				{
					header: 'Name',
					name: 'name'
				}
			]
		});
				
	}
	
	
</script>
</html>