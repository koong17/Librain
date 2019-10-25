<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../../includes/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>직원 목록</title>
<link rel="stylesheet"
	href="https://uicdn.toast.com/tui-grid/latest/tui-grid.css" />
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://uicdn.toast.com/tui-grid/latest/tui-grid.js"></script>
</head>
<body>
	<div class="wrapper">
		<div class="row">
			<div class="col-md-12">
				<h1 class="page-header">직원 목록</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-md-2 pt-3">
				<div class="form-group">
					<select id="searchType" name="searchCtgr" class="form-control">
						<option value="emp_name" selected>사원명</option>
						<option value="dept_name">부서명</option>
					</select>
				</div>
			</div>
			<div class="col-md-4">
				<input class="form-control" type="text" placeholder="검색어를 입력하세요."
					id="searchWord" name="searchWord">
			</div>
			<div class="col-md-1">
				<input type="button" class="btn btn-primary btn-block" id="search"
					value="검색">
			</div>
		</div>
		<div class="row align-items-center justify-content-center"
			align="center">
			<div class="col-md-12">
				<div id="grid"></div>
			</div>
		</div>
	</div>
	<%@include file="../../includes/footer.jsp"%>
</body>

<script type="text/javascript">
	$(function() {
		grid.sort('emp_no',true,false);
	});
	$("#search").click(function(){
	    
	    console.log($('#searchCtgr').val());
	    console.log($('#searchWord').val());
	    
	    if($('#searchWord').val()==""){
	       alert("검색어를 입력해주세요.")
	    }
	    else {
	       $.ajax({
	          type : "POST",
	          url : "empSearch.do",
	          data : {
	             searchType : $("#searchType").val(),
	             searchWord : $("#searchWord").val()
	          },
	          dataType : "json",
	          contentType : "application/x-www-form-urlencoded;charset=UTF-8", //클라이언트 -> 서버
	          success: function(response) {
	             console.log(response);
	             grid.resetData(response);
	          }
	       });
	    }
	 });
	
	const grid = new tui.Grid({
		el: document.getElementById('grid'),
		data: ${gridData},
		scrollX: false,
		scrollY: false,
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
				name: 'emp_position'
			},
			{
				header: '입사일',
				name: 'emp_join_date'
			}
		]
	});
		
	
</script>
</html>