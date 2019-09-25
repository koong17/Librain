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
		근태 조회
	</div>
	<div id="grid"></div>
	<input type="button" id="update" value="선택 수정" >
	
</body>

<script type="text/javascript">	
	$("#update").click(function(){
		console.log(grid.getCheckedRows());
		console.log("========================")
		console.log(JSON.stringify(grid.getCheckedRows()));
	   	$.ajax({											
			type: "POST",
			contentType : 'application/json;charset=UTF-8',
			dataType : 'json',
			url: "cmtlist.do",
			data: JSON.stringify(grid.getCheckedRows()),
			success :function(result) {
				console.log(result);
				grid.resetData(result);
		    }
		});
	});
	
	var hours = "";
	hours += "[ ";
	for(i=1; i<=24; i++){
		if(i!=24)
			hours += '{ "text": "'+i+'", "value": "'+i+'"}, ';
		else hours += '{ "text": "'+i+'", "value": "'+i+'"}';
	}
	hours += " ]";
	
	var minutes = "";
	minutes += "[ ";
	for(i=1; i<=60; i++){
		if(i!=60)
			minutes += '{ "text": "'+i+'", "value": "'+i+'"}, ';
		else minutes += '{ "text": "'+i+'", "value": "'+i+'"}';
	}
	minutes += " ]";

	console.log(hours);
	const grid = new tui.Grid({
		el: document.getElementById('grid'),
		data: ${gridData},
		scrollX: false,
		scrollY: false,
		rowHeaders: ['checkbox'],
		columns: [
			{
				header: 'no',
				name: 'cmt_no'
			},
			{
				header: '사원번호',
				name: 'cmt_emp_no',
			},
			{
				header: '상태',
				name: 'cmt_status',
				formatter: 'listItemText',
				editor: {
					type: 'select',
					options: {
						listItems: [
							{ text: 'on', value: 'on' },
							{ text: 'off', value: 'off' }
						]
					}
				}
			},
			{
				header: '년',
				name: 'cmt_year'
			},
			{
				header: '월',
				name: 'cmt_month'
			},
			{
				header: '일',
				name: 'cmt_day'
			},
			{
				header: '시',
				name: 'cmt_hour',
				formatter: 'listItemText',
				editor: {
					type: 'select',
					options: {
						listItems: JSON.parse(hours)
					}
				}
			},
			{
				header: '분',
				name: 'cmt_minute' ,
				formatter: 'listItemText',
				editor: {
					type: 'select',
					options: {
						listItems: JSON.parse(minutes)
					}
				}
			}
		]
	});
		
	
</script>
</html>