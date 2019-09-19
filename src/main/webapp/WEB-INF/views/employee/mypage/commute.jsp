<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html><head><meta charset="UTF-8">
<title>근태관리</title>
<link rel="stylesheet" href="https://uicdn.toast.com/tui-grid/latest/tui-grid.css" />
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://uicdn.toast.com/tui-grid/latest/tui-grid.js"></script>
</head>
<body>
	<input type="button" id="work" value="출근" >
	<input type="button" id="leave" value="퇴근">
	<div id="grid"></div>
</body>
<script>

	$("#work").click(function(){
	   $.ajax({											
			type: "POST",
			contentType : 'application/x-www-form-urlencoded;charset=UTF-8',
			dataType : 'json',	// dataType 은 호출되는 서버쪽의 함수의 리턴타입
			url: "commute.do",
			data: {cmt_status:"on"},
			success :function(result) {
				console.log("resetData");
				grid.resetData(result);
		    }
		});
	});
	$("#leave").click(function(){
	   $.ajax({											
			type: "POST",
			contentType : 'application/x-www-form-urlencoded;charset=UTF-8',
			dataType : 'json',
			url: "commute.do",
			data: {cmt_status:"off"},
			success :function(result) {
				console.log("resetData");
				grid.resetData(result);
		    }
		});
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
				name: 'cmt_emp_no',
			},
			{
				header: '상태',
				name: 'cmt_status'
			},
			{
				header: '시',
				name: 'cmt_hour',
		        sortingType: 'desc',
		        sortable: true
				
			},
			{
				header: '분',
				name: 'cmt_second'
			}
		]
	});
</script>
</html>