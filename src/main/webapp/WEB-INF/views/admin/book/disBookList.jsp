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

<title>도서 폐기 승인</title>
<%@include file="../../employee/includes/header.jsp"%>
</head>
<body>
<div class="wrapper">
   <div class="row">
      <div class="col-md-12">
         <h1 class="page-header">도서 폐기 승인</h1>
      </div>
   </div>
   <div class="row">
      <div class="container-fluid bg-light ">
		<div class="row align-items-center justify-content-center">
			<div class="col-md-1">
				<div class="form-group">
					<button type="button" class="btn btn-primary btn-block" id="approveBtn">
						선택 승인
					</button>
				</div>
			</div>
			<div class="col-md-1">
				<div class="form-group">
					<button type="button" class="btn btn-primary btn-block" id="returnBtn">
						선택 반려
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
	</div>
   </div>
   <div class="row">
		<div class="col-md-12">
			<div class="row align-items-center justify-content-center">
				<div class="col-md-12">
					<div id="grid"></div>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
<%@include file="../../employee/includes/footer.jsp"%>

<!-- Toast pagination JS-->
<script type="text/javascript" src="https://uicdn.toast.com/tui.code-snippet/v1.5.0/tui-code-snippet.js"></script>
<script type="text/javascript" src="https://uicdn.toast.com/tui.pagination/v3.3.0/tui-pagination.js"></script>
 
<!-- Toast Grid DatePicker JS-->
<script type="text/javascript" src="https://uicdn.toast.com/tui.date-picker/v3.2.1/tui-date-picker.js"></script>

<!-- Toast Grid CSS-->
<script src="https://uicdn.toast.com/tui-grid/v4.5.2/tui-grid.js"></script>

<!-- bookJS -->
<script src="${pageContext.request.contextPath}/resources/js/adminDisBook.js?after"></script>
</html>