<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- Toast Grid CSS-->
<link rel="stylesheet" href="https://uicdn.toast.com/tui.date-picker/v3.3.0/tui-date-picker.css">
<link rel="stylesheet" type="text/css" href="https://uicdn.toast.com/tui.pagination/v3.3.0/tui-pagination.css" />
<link rel="stylesheet" href="https://uicdn.toast.com/tui-grid/latest/tui-grid.css" />

<title>도서 구입 신청</title>
<%@include file="../../includes/header.jsp"%>
</head>
<body>
<div class="wrapper">
	<div class="row">
		<div class="col-md-12">
			<h1 class="page-header">도서 구입 신청</h1>
		</div>
	</div>
	<div class="row">
		<div id="searchGridDiv">
			<div class="col-md-12">
				<h4>구입할 도서 검색</h4><hr>
		      	<div class="row align-items-center justify-content-center">
					<div class="col-lg-4">
						<input type="text" placeholder="책 제목을 입력하세요" class="form-control" id="search">
					</div>
					<div class="col-lg-1">
						<input type="button" class="btn btn-primary btn-block" value="책 검색" id="searchBtn"><br>
					</div>
					<div class="col-lg-1">
						<input type="button" class="btn btn-primary btn-block" value="선택 추가" id="searchInputBtn"><br>
					</div>
				</div>
				<div class="row align-items-center justify-content-center">
		      		<div class="form-group">
						<div class="col-md-12">
							<div id="searchGrid"></div><br><br>
						</div>
		      		</div>
		      	</div>
			</div>
		</div>
    </div>
    <div class="row">
		<div id="gridDiv">
			<div class="col-md-12">
				<h4>도서 구입 신청 목록</h4><hr>
			</div>
			<div>
				<div class="col-md-2">
					<div class="form-group">
						<button type="button" class="btn btn-primary btn-block" id="inputBtn">
							선택 구입 신청
						</button>
					</div>
				</div>
				<div class="col-md-1">
					<div class="form-group">
						<button type="button" class="btn btn-primary btn-block" id="updateBtn">
							선택 수정
						</button>
					</div>
				</div>
				<div class="col-md-1">
					<div class="form-group">
						<button type="button" class="btn btn-primary btn-block" id="deleteBtn">
							선택 삭제
						</button>
					</div>
				</div>
				<div class="col-md-1">
					<div class="form-group">
						<button type="button" class="btn btn-primary btn-block" id="refreshBtn"  onclick="confirm()">
							<i class="fa fa-undo" aria-hidden="true"></i>
						</button>
					</div>
				</div>
			</div>
			<div class="col-md-12">
				<div class="row align-items-center justify-content-center">
		      		<div class="col-md-12">
						<div id="grid"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="row">
	   	<div id="bookGridDiv">
	   		<div class="col-md-12">
				<h4>도서 구입 완료 후 입력</h4><hr>
			</div>
			<div id="book">
				<div class="col-md-1">
					<div class="form-group">
					<button type="button" class="btn btn-primary btn-block" id="inputBookBtn">
						선택 입력
					</button>
					</div>
				</div>
				<div class="col-md-12">
					<div class="row align-items-center justify-content-center">
		      			<div class="col-md-12">
							<div id="bookGrid"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
<%@include file="../../includes/footer.jsp"%>

<!-- Toast pagination JS-->
<script type="text/javascript" src="https://uicdn.toast.com/tui.code-snippet/v1.5.0/tui-code-snippet.js"></script>
<script type="text/javascript" src="https://uicdn.toast.com/tui.pagination/v3.3.0/tui-pagination.js"></script>
 
<!-- Toast Grid DatePicker JS-->
<script type="text/javascript" src="https://uicdn.toast.com/tui.date-picker/v3.2.1/tui-date-picker.js"></script>

<!-- Toast Grid CSS-->
<script src="https://uicdn.toast.com/tui-grid/v4.5.2/tui-grid.js"></script>

<!-- bookJS -->
<script src="${pageContext.request.contextPath}/resources/js/empNewBook.js?after"></script>

</html>