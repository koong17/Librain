<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>librain</title>
<style type="text/css">
body {
	background-image: url('resources/img/background-library.jpg');
	background-size: 100%;
}

.logo {
	width: 50%;
}
</style>

<!-- Bootstrap Core CSS -->
<link href="resources/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- MetisMenu CSS -->
<link href="resources/vendor/metisMenu/metisMenu.min.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link href="resources/dist/css/sb-admin-2.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="resources/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

<!-- Toast Grid CSS-->
<link rel="stylesheet"
	href="https://uicdn.toast.com/tui.date-picker/v3.3.0/tui-date-picker.css">
<link rel="stylesheet" type="text/css"
	href="https://uicdn.toast.com/tui.pagination/v3.3.0/tui-pagination.css" />
<link rel="stylesheet"
	href="https://uicdn.toast.com/tui-grid/latest/tui-grid.css" />

</head>
<body>
	<a class="btn btn-lg btn-success pull-right" href="./memberMain.jsp"
		role="button" ><i class="fa fa-home"></i></a>
	<div class="wrapper">
		<div class="panel panel-default" id="panel">
			<div class="panel-heading" align="left">
				<h3 class="panel-title">여기에 제목 입력 ex) 도서검색</h3>
			</div>
			<div class="panel-body">
				<div class="col-md-12">
					<div class="row">
						<div class="col-md-6">
							내용넣기
						</div>
						<div class="col-md-6">
							내용넣기
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- jQuery -->
	<script src="resources/vendor/jquery/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="resources/vendor/bootstrap/js/bootstrap.min.js"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script src="resources/vendor/metisMenu/metisMenu.min.js"></script>

	<!-- Toast pagination JS-->
	<script type="text/javascript"
		src="https://uicdn.toast.com/tui.code-snippet/v1.5.0/tui-code-snippet.js"></script>
	<script type="text/javascript"
		src="https://uicdn.toast.com/tui.pagination/v3.3.0/tui-pagination.js"></script>

	<!-- Toast Grid DatePicker JS-->
	<script type="text/javascript"
		src="https://uicdn.toast.com/tui.date-picker/v3.2.1/tui-date-picker.js"></script>

	<!-- Toast Grid JS -->
	<script src="https://uicdn.toast.com/tui-grid/v4.5.2/tui-grid.js"></script>

	<!-- Custom Theme JavaScript -->
	<script src="resources/dist/js/sb-admin-2.js"></script>
</body>
<script type="text/javascript">
	$(document).ready(function(e) {
		$("#panel").height(window.innerHeight * 0.8);
		$("#panel").width(window.innerWidth * 0.8);
		$("#panel").css("margin-top", window.innerHeight * 0.1);
		$("#panel").css("margin-left", window.innerWidth * 0.1);
	});
</script>
</html>