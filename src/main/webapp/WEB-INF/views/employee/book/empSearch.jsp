<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- font CSS -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<!-- Toast Grid CSS-->
<link rel="stylesheet" href="https://uicdn.toast.com/tui.date-picker/v3.3.0/tui-date-picker.css">
<link rel="stylesheet" type="text/css" href="https://uicdn.toast.com/tui.pagination/v3.3.0/tui-pagination.css" />
<link rel="stylesheet" href="https://uicdn.toast.com/tui-grid/latest/tui-grid.css" />

<!-- jQuery -->
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

<!-- Toast pagination JS-->
<script type="text/javascript" src="https://uicdn.toast.com/tui.code-snippet/v1.5.0/tui-code-snippet.js"></script>
<script type="text/javascript" src="https://uicdn.toast.com/tui.pagination/v3.3.0/tui-pagination.js"></script>
 
<!-- Toast Grid DatePicker JS-->
<script type="text/javascript" src="https://uicdn.toast.com/tui.date-picker/v3.2.1/tui-date-picker.js"></script>

<!-- Toast Grid CSS-->
<script src="https://uicdn.toast.com/tui-grid/v4.5.2/tui-grid.js"></script>

<title>도서검색</title>

</head>
<body>
<%@include file="../includes/header.jsp"%>
	<div class="container-fluid bg-light ">
		<br>
		<div class="row align-items-center justify-content-center">
			<div class="col-md-2 pt-3">
				<div class="form-group ">
					<select id="searchCtgr" name="searchCtgr" class="form-control">
						<option selected>전체</option>
						<option>도서명</option>
						<option>저자명</option>
						<option>출판사명</option>
					</select>
				</div>
			</div>
			<div class="col-md-4">
				<input class="form-control" type="text" placeholder="검색어를 입력하세요." id="searchWord" name="searchWord">
			</div>
			<div class="col-md-1">
				<button type="button" class="btn btn-primary btn-block" id="searchBtn">
					<i class="fa fa-search"></i>
				</button>
			</div>
			<!-- <div class="col-md-1">
				<button type="button" class="btn btn-primary btn-block" id="refreshBtn"  onclick="confirm()">
					<i class="fa fa-undo" aria-hidden="true"></i>
				</button>
			</div>
			<div class="col-md-1">
				<button type="button" class="btn btn-primary btn-block" id="addRowBtn">
					행 추가
				</button>
			</div>
			<div class="col-md-1">
				<button type="button" class="btn btn-primary btn-block" id="inputBtn">
					선택 입력
				</button>
			</div>-->
			<div class="col-md-1">
				<button type="button" class="btn btn-primary btn-block" id="updateBtn">
					선택 수정
				</button>
			</div>
			<!-- <div class="col-md-1">
				<button type="button" class="btn btn-primary btn-block" id="deleteBtn">
					선택 삭제
				</button>
			</div> -->
		</div>
	</div>
	 <div class="row align-items-center justify-content-center" align="center">
      	<div class="col-md-12">
			<div id="grid"></div>
      	</div>
      </div>
	<%@include file="../includes/footer.jsp"%>
</body>

<!-- bookJS -->
<script src="${pageContext.request.contextPath}/resources/js/empSearchBook.js?after"></script>

   
</html>