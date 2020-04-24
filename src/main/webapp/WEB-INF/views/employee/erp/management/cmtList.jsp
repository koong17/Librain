<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../../includes/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet"
	href="https://uicdn.toast.com/tui-grid/latest/tui-grid.css" />
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://uicdn.toast.com/tui-grid/latest/tui-grid.js"></script>
</head>
<body>

	<div class="wrapper">
        <div class="row">
            <div class="col-md-12">
                <h1 class="page-header">근태 목록</h1>
            </div>
		</div>
		<div class="row">
			<div class="col-md-1 pt-3">
				<div class="form-group">
					<div class="years"></div>
					<select id="cmt_year" name="cmt_year" class="form-control">
						<option value="" disabled selected>년</option>
					</select>
				</div>
			</div>
			<div class="col-md-1 pt-3">
				<div class="form-group">
					<select id="cmt_month" name="cmt_month" class="form-control">
						<option value="" disabled selected>월</option>
						<option value="01">01</option>
						<option value="02">02</option>
						<option value="03">03</option>
						<option value="04">04</option>
						<option value="05">05</option>
						<option value="06">06</option>
						<option value="07">07</option>
						<option value="08">08</option>
						<option value="09">09</option>
						<option value="10">10</option>
						<option value="11">11</option>
						<option value="12">12</option>
					</select>
				</div>
			</div>
			<div class="col-md-2 pt-3">
				<div class="form-group">
					<input class="form-control" type="text" placeholder="사원번호(미입력시 전체사원 검색)"
						id="emp_no" name="emp_no">
				</div>
			</div>
			<div class="col-md-1">
				<input type="button" class="btn btn-primary btn-block" id="search" value="검색">
			</div>
			<div class="col-md-2">
				<input type="button" class="btn btn-primary btn-block" id="update" value="선택 수정">
			</div>
		</div>
		<div class="row">
			<div class="form-group">
				<div id="grid"></div>
			</div>
		</div>
	</div>
</body>

<script type="text/javascript">	

	$(function(){
		var date = new Date();
		var year = date.getFullYear();
		//var month = new String(date.getMonth()+1);
		for (var i = year-2; i <= year; i++) {
			$("#cmt_year").append('<option value="'+i+'">'+i+'</option>');
		}
	});
	
	$("#search").click(function(){
		var year = document.getElementById("cmt_year");
		var month = document.getElementById("cmt_month");
		var empNo = document.getElementById("emp_no").value;
		var cmtObject = new Object();
		cmtObject.cmt_year = year.options[year.selectedIndex].value;
		cmtObject.cmt_month = month.options[month.selectedIndex].value;
		
		if (cmtObject.cmt_year != "" 
				&& cmtObject.cmt_month != "" && empNo == "" ) {
		   	$.ajax({											
				type: "POST",
				contentType : 'application/json;charset=UTF-8',
				dataType : 'json',
				url: "cmtSearch.do",
				data: JSON.stringify(cmtObject),
				success :function(result) {
					console.log(result);
					grid.resetData(result);
			    }
			});
		}else if(cmtObject.cmt_year != "" 
				&& cmtObject.cmt_month != "" && empNo != "") {
			cmtObject.emp_no = empNo;
		   	$.ajax({											
				type: "POST",
				contentType : 'application/json;charset=UTF-8',
				dataType : 'json',
				url: "cmtSearchOne.do",
				data: JSON.stringify(cmtObject),
				success :function(result) {
					console.log(result);
					grid.resetData(result);
			    }
			});
		}else alert("년, 월을 선택하세요.");
	});
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
				alert('수정되었습니다.');
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

	const grid = new tui.Grid({
		el: document.getElementById('grid'),
		data: ${gridData},
		bodyHeight: 500,
		rowHeaders: ['checkbox'],
		columns: [
			{
				header: 'no',
				name: 'cmt_no'
			},
			{
				header: '사원번호',
				name: 'emp_no',
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
<%@include file="../../includes/footer.jsp"%>