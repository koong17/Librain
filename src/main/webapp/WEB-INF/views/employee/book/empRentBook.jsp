<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- Toast pagination -->
   <script type="text/javascript" src="https://uicdn.toast.com/tui.code-snippet/v1.5.0/tui-code-snippet.js"></script>
 <script type="text/javascript" src="https://uicdn.toast.com/tui.pagination/v3.3.0/tui-pagination.js"></script>
 <link rel="stylesheet" type="text/css" href="https://uicdn.toast.com/tui.pagination/v3.3.0/tui-pagination.css" />

<!-- jQuery -->
<script src="https://code.jquery.com/jquery-3.4.1.js"
	integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
	crossorigin="anonymous"></script>
	
<!-- boostrap -->
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<!-- Toast Grid -->
<link rel="stylesheet" href="https://uicdn.toast.com/tui.date-picker/latest/tui-date-picker.css">
<link rel="stylesheet" href="https://uicdn.toast.com/tui-grid/latest/tui-grid.css" />

 <!-- Toast Grid DatePicker -->
<script type="text/javascript" src="https://uicdn.toast.com/tui.date-picker/v3.2.1/tui-date-picker.js"></script>
<script src="https://uicdn.toast.com/tui-grid/latest/tui-grid.js"></script>


<title>도서검색</title>
</head>
<body>
	<div class="container-fluid bg-light ">
		<div class="row align-items-center justify-content-center">
			<div class="col-md-3">
			    <div class="input-group">
			      <input type="text" class="form-control" placeholder="회원번호" id="mem_id" name="mem_id">
			      <span class="input-group-btn">
			        <button class="btn btn-default" type="button" id="memBtn">
			        	<i class="fa fa-search"></i>
			        </button>
			      </span>
			    </div>
			</div>
			<div class="col-md-3">
			    <div class="input-group">
			      <input type="text" class="form-control" placeholder="도서번호" id="book_num" name="book_num">
			      <span class="input-group-btn">
			        <button class="btn btn-default" type="button" id="bookBtn">
			        	<i class="fa fa-search"></i>
			        </button>
			      </span>
			    </div>
			</div>
			<div class="col-md-1">
				<button type="button" class="btn btn-primary btn-block" id="rentBtn">
					대여
				</button>
			</div>
			<div class="col-md-1">
				<button type="button" class="btn btn-primary btn-block" id="returnBtn">
					반납
				</button>
			</div>
		</div>
	</div>
	<hr>
	<div>
		<div id="memGrid"></div>
		<div id="bookGrid"></div>
	</div>
</body>

<!-- bookJS -->
<script src="resources/js/empRentBook.js?after"></script>

</html>