<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html><head><meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://uicdn.toast.com/tui-grid/latest/tui-grid.css" />
<script src="https://uicdn.toast.com/tui-grid/latest/tui-grid.js"></script>
</head>
<body>
	<div>
		회원 목록 조회
	</div>
	<div id="grid" style="width: 500"></div>
	<input type="button" id="insert" value="직원 추가">
	<input type="button" id="delete" value="직원 삭제">
	
</body>

<script type="text/javascript">
		
	const grid = new tui.Grid({
		el: document.getElementById('grid'),
		data: ${gridData},
		scrollX: false,
		scrollY: false,
		rowHeaders: ['checkbox'],
		columns: [
			{
				header: '회원 ID',
				name: 'mem_id',
		        sortingType: 'desc',
		        sortable: true
			},
			{
				header: '회원명',
				name: 'mem_name'
			},
			{
				header: '주소',
				name: 'mem_address'
			},
			{
				header: '전화번호',
				name: 'mem_phone'
			},
			{
				header: '이메일',
				name: 'mem_email'
			},
			{
				header: '회원 등급',
				name: 'mem_rank'
			}
		]
	});
		
	grid.on('check', function() {
		console.log(grid.getCheckedRows());
	});
		
	
</script>
</html>