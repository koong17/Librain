<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- boostrap -->
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<!-- Toast pagination -->
   <script type="text/javascript" src="https://uicdn.toast.com/tui.code-snippet/v1.5.0/tui-code-snippet.js"></script>
 <script type="text/javascript" src="https://uicdn.toast.com/tui.pagination/v3.3.0/tui-pagination.js"></script>
 <link rel="stylesheet" type="text/css" href="https://uicdn.toast.com/tui.pagination/v3.3.0/tui-pagination.css" />

<!-- jQuery -->
<script src="https://code.jquery.com/jquery-3.4.1.js"
	integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
	crossorigin="anonymous"></script>

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<!-- Toast Grid -->
<link rel="stylesheet" href="https://uicdn.toast.com/tui.date-picker/latest/tui-date-picker.css">
<link rel="stylesheet" href="https://uicdn.toast.com/tui-grid/latest/tui-grid.css" />

 <!-- Toast Grid DatePicker -->
<script type="text/javascript" src="https://uicdn.toast.com/tui.date-picker/v3.2.1/tui-date-picker.js"></script>
<script src="https://uicdn.toast.com/tui-grid/v4.5.2/tui-grid.js"></script>


<title>도서검색</title>
</head>
<body>
<%@include file="../includes/header.jsp"%>
	<div class="container-fluid bg-light ">
	<br>
		<div class="row align-items-center justify-content-center">
			<div class="col-md-2">
				<input class="form-control" type="text" placeholder="도서번호를 입력하세요." id="searchWord" name="searchWord">
			</div>
			<div class="col-md-1">
				<button type="button" class="btn btn-primary btn-block" id="searchBtn">
					<i class="fa fa-search"></i>
				</button>
			</div>
			<div class="col-md-2">
				<button type="button" class="btn btn-primary btn-block" id="inputBtn">
					선택 폐기 신청
				</button>
			</div>
			<div class="col-md-1">
				<button type="button" class="btn btn-primary btn-block" id="deleteBtn">
					선택 삭제
				</button>
			</div>
			<div class="col-md-1">
				<button type="button" class="btn btn-primary btn-block" id="refreshBtn"  onclick="confirm()">
					<i class="fa fa-undo" aria-hidden="true"></i>
				</button>
			</div>
		</div>
	</div>
	<hr>
	<!-- <div>
		<div id="grid"></div>
	</div> -->
	<div>
		<div id="grid"></div>
		<br>
		<div id="book">
			<div class="col-md-2" style="margin-bottom: 10px;">
				<button type="button" class="btn btn-primary btn-block" id="deleteBookBtn">
					선택 도서 삭제
				</button>
			</div>
			<div id="bookGrid"></div>
		</div>
	</div>
	
	<%@include file="../includes/footer.jsp"%>
</body>

<!-- bookJS -->
<script src="${pageContext.request.contextPath}/resources/js/empDiscardBook.js?after"></script>

   
   
</html>