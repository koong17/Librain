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
	<hr>
	오늘의 출근현황
	<div id="gridTop"></div>
	<hr>
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
				console.log(result);
				update(result);
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
				console.log(result);
				update(result);
		    }
		});
	});
	
	function update(result) {
		grid.resetData(result[0]);
		gridTop.resetData(result[1]);
	}

	var Grid = tui.Grid;
	Grid.setLanguage('ko');
	
	const gridTop = new tui.Grid({
		el: document.getElementById('grid'),
		data: ${gridTopData},
		scrollX: false,
		scrollY: false,
		pagination: {
			perPage: 5
		},
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
				header: '상태2',
				name: 'cmt_status_kr'
			},
			{
				header: '시',
				name: 'cmt_hour',
		        sortingType: 'asc',
		        sortable: true
				
			},
			{
				header: '분',
				name: 'cmt_minute',
		        sortingType: 'asc',
		        sortable: true
			}
		]
	});
	const grid = new tui.Grid({
		el: document.getElementById('grid'),
		data: ${gridData},
		scrollX: false,
		scrollY: false,
		rowHeaders: ['checkbox'],
		pagination: {
			perPage: 5
		},
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
		        sortingType: 'asc',
		        sortable: true
				
			},
			{
				header: '분',
				name: 'cmt_minute',
		        sortingType: 'asc',
		        sortable: true
			}
		]
	});
	Grid.setLanguage('ko');
	$(function(){
		grid.sort('cmt_hour',true,true);
		grid.sort('cmt_minute',true,true);
		
	});
</script>
</html>