<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html><head><meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://uicdn.toast.com/tui-grid/latest/tui-grid.css" />
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://uicdn.toast.com/tui-grid/latest/tui-grid.js"></script>
</head>
<body>
	<div>
		사원 목록 조회
	</div>
	<input type="button" id="insert" value="직원 추가">
	<input type="button" id="delete" value="직원 삭제">
	<div id="grid"></div>
	
</body>

<script type="text/javascript">
	$("#delete").click(function(){
	   	$.ajax({											
			type: "POST",
			contentType : 'application/json;charset=UTF-8',
			dataType : 'json',
			url: "empDelete.do",
			data: JSON.stringify(grid.getCheckedRows()),
			success :function(result) {
				console.log(result);
				grid.resetData(result);
		    }
		});
	});
	$("#insert").click(function(){
		popup = window.open("empInsert.do", '사원 추가', 'width=450, height=600, status=no, toolbar=no, location=no, top=200, left=200');
        timer = setInterval(function(){
           if(popup.closed){
        	   location.href=""
           }
        }, 1000);
	});
	
	const grid = new tui.Grid({
		el: document.getElementById('grid'),
		data: ${gridData},
		scrollX: false,
		scrollY: false,
		rowHeaders: ['checkbox'],
		columns: [
			{
				header: '사원번호',
				name: 'emp_no',
		        sortingType: 'desc',
		        sortable: true
			},
			{
				header: '이름',
				name: 'emp_name'
			},
			{
				header: '전화번호',
				name: 'emp_telephone'
			},
			{
				header: '이메일',
				name: 'emp_email'
			},
			{
				header: '부서',
				name: 'emp_dept_code'
			},
			{
				header: '직책',
				name: 'emp_rank_position'
			},
			{
				header: '입사일',
				name: 'emp_join_date'
			}
		]
	});
		
	grid.on('check', function() {
		console.log(grid.getCheckedRows());
	});
		
	
</script>
</html>