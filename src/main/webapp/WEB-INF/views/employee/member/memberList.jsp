<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html><head><meta charset="UTF-8">
<title>회원 목록 조회</title>

<!-- Toast pagination -->
 <script type="text/javascript" src="https://uicdn.toast.com/tui.code-snippet/v1.5.0/tui-code-snippet.js"></script>
 <script type="text/javascript" src="https://uicdn.toast.com/tui.pagination/v3.3.0/tui-pagination.js"></script>
 <link rel="stylesheet" type="text/css" href="https://uicdn.toast.com/tui.pagination/v3.3.0/tui-pagination.css" />
<!-- grid -->
<link rel="stylesheet" href="https://uicdn.toast.com/tui-grid/latest/tui-grid.css" />
<script src="https://uicdn.toast.com/tui-grid/latest/tui-grid.js"></script>
<!-- jquery -->
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<!-- boostrap -->

<!-- 
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
부가적인 테마
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
  -->
 
<%@ include file="../../employee/includes/header.jsp"%>
</head>
<body>

<div class="wrapper">
   <div class="row">
      <div class="col-md-12">
         <h1 class="page-header">회원 목록 관리</h1>
      </div>
   </div>
   <div class="row">
	<div class="container-fluid bg-light " align="center">
		<div class="row align-items-center justify-content-center" align="center">
			<div class="col-md-2 pt-3">
				<div class="form-group ">
					<select id="searchCtgr" name="searchCtgr" class="form-control">
						<option selected>전체</option>
						<option>회원 ID</option>
						<option>회원명</option>
					</select>
				</div>
			</div>
			<div class="col-md-4">
				<input class="form-control" type="text" placeholder="검색어를 입력하세요."
					id="searchWord" name="searchWord">
			</div>
			<div class="col-md-1">
				<button type="button" class="btn btn-primary btn-block" id="searchBtn">
					<i class="fa fa-search"></i>
				</button>
			</div>
			<div class="col-md-1">
				<button type="button" class="btn btn-primary btn-block" id="refresh" onclick="location.href='memberList.do'">
					<i class="fa fa-refresh" aria-hidden="true"></i>
				</button>
			</div>
		</div>
	</div>
	<hr>
	<div id="gridDIV">
		<div id="grid"></div>
	</div>
	<div id="searchGridDIV">
		<div id="searchGrid"></div>
	</div>
	<input type="button" class="btn btn-primary btn-block" value="선택 수정" onclick="rankUpdate()">
	</div>
</div>
</body>

<%@ include file="../../employee/includes/footer.jsp"%>

<script type="text/javascript">
   $(document).ready(function() {
	   $('#searchGridDIV').hide();
       $('#searchBtn').click(function() {
           searchAjax(); $('#gridDIV').hide(); $('#searchGridDIV').show(); $('#searchGridDIV').show();
       });
       $('#refresh').click(function() {
           //$('#gridDIV').show(); $('#searchGridDIV').hide();
       });
   
   });
	function searchAjax(){
		
		console.log($('#searchCtgr').val());
		console.log($('#searchWord').val());
		
		if($('#searchWord').val()==""){
			alert("검색어를 입력해주세요.")
		}
		else {
			$.ajax({
				type : "POST",
				url : "memberSearch.do",
				data : {
					searchCtgr : $("#searchCtgr").val(),
					searchWord : $("#searchWord").val()
				},
				dataType : "json",
				contentType : "application/x-www-form-urlencoded;charset=UTF-8", //클라이언트 -> 서버
				success: function(response) {
					console.log(response);
					grid.resetData(response);
					searchGrid.resetData(response);
				},
				error: function(e) {
					alert('Error : ' + e);
				}
			});
		}
	}
	
	function rankUpdate() {
		var data = grid.getCheckedRows();
		console.log(data);
		
		$.ajax({
			type : "POST",
			contentType : 'application/json;charset=UTF-8',
			dataType : 'json',
			data : JSON.stringify(data),
			url : "memberRankUpdate.do",
			success : function(data){
				console.log(data.result);
			}
		});
	}
	var Grid = tui.Grid;
	Grid.setLanguage('ko');
	
	var gridData =
	{
		api: {
			readData: { url: location.href+'/readData', method: 'GET' }
		}
	}
		
	const grid = new tui.Grid({
		el: document.getElementById('grid'),
		data: gridData,
		scrollX: false,
		scrollY: false,
		rowHeaders: ['checkbox'],
		pageOptions: {
			perPage: 10
		},
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
				header: '우편번호',
				name: 'mem_address_number'
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
				sortingType: 'desc',
		        sortable: true,
				name: 'mem_rank',
				editor: {
					type: 'select',
					options: {
						listItems: [
							{ text: '플러스 회원', value: '1' },
							{ text: '일반 회원', value: '2' },
							{ text: '마이너스 회원', value: '3' }
						]
					}
				}
			}
		]
	});
	
	const searchGrid = new tui.Grid({
		el: document.getElementById('searchGrid'),
		data: null,
		bodyHeight: 500,
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
				header: '우편번호',
				name: 'mem_address_number'
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
				sortingType: 'desc',
		        sortable: true,
				name: 'mem_rank',
				editor: {
					type: 'select',
					options: {
						listItems: [
							{ text: '플러스 회원', value: '1' },
							{ text: '일반 회원', value: '2' },
							{ text: '마이너스 회원', value: '3' }
						]
					}
				}
			}
		]
	});
	
	grid.on('check', function() {
		console.log(grid.getCheckedRows());
		console.log(grid.getModifiedRows());
	});
	
</script>
</html>