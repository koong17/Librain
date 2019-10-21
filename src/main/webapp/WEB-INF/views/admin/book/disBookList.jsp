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


<title>도서 구입 승인</title>
</head>
<body>
<%@include file="../../employee/includes/header.jsp"%>
	<div class="container-fluid bg-light ">
	<br>
		<div class="row align-items-center justify-content-center">
			<div class="col-md-1">
				<button type="button" class="btn btn-primary btn-block" id="approveBtn">
					승인
				</button>
			</div>
			<div class="col-md-1">
				<button type="button" class="btn btn-primary btn-block" id="returnBtn">
					반려
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
	<div>
		<div id="grid"></div>
	</div>
	<%@include file="../../employee/includes/footer.jsp"%>
</body>

<!-- bookJS -->
<script src="${pageContext.request.contextPath}/resources/js/adminDisBook.js"></script>

   
   
</html>