<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<style type="text/css">
body {
	background-image: url('${pageContext.request.contextPath}/resources/img/background-library.jpg');
	background-size: 100%;
}

.logo {
	width: 50%;
}
</style>
<!-- BootStrap CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

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
<a class="btn btn-lg btn-success pull-right" href="${pageContext.request.contextPath}/memberMain.jsp"
		role="button" ><i class="fa fa-home"></i></a><br>
<div class="panel panel-default" id="panel" style="margin:2.5%; padding:0.5%">
			<div class="panel-heading" align="left">
				<h3 class="panel-title" style="font-weight:bold">도서검색</h3>
			</div>
	<div class="container-fluid bg-light ">
		<br>
		<h4>희망 도서 신청</h4>
		<hr>
		<div class="row align-items-center justify-content-center" align="center">
			<div class="col-lg-2">
				<input type="text" placeholder="회원 ID를 입력하세요" class="form-control" id="mem_id">
			</div>
			<div class="col-lg-4">
				<input type="text" placeholder="책 제목을 입력하세요" class="form-control" id="search">
			</div>
			<div class="col-lg-1">
				<input type="button" class="btn btn-primary btn-block" value="책 검색" id="hopeSearchBtn"><br>
			</div>
			<div class="col-lg-1">
				<input type="button" class="btn btn-primary btn-block" value="선택 신청" id="hopeSearchInputBtn"><br>
			</div>
			<div class="form-group">
				<div class="col-md-12">
					<div id="searchGrid"></div><br><br>
				</div>
				<br><br>
				<div class="col-md-12">
					<div id="grid"></div>
				</div>
			</div>
		</div>
	</div>
</div>
</body>

<!-- bookJS -->
<script
	src="${pageContext.request.contextPath}/resources/js/memHopeBook.js?after"></script>

</html>