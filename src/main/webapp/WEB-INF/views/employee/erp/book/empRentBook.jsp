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

<title>도서대여</title>
<%@include file="../../includes/header.jsp"%>
</head>
<body>
<div class="wrapper">
   <div class="row">
      <div class="col-md-12">
         <h1 class="page-header">도서 대여</h1>
      </div>
   </div>
   <div class="row">
		<div class="container-fluid bg-light ">
			<div class="row align-items-center justify-content-center">
				<div class="col-md-3">
				    <div class="input-group">
					    <input type="text" class="form-control" placeholder="회원ID" id="mem_id" name="mem_id">
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
					<div class="form-group">
						<button type="button" class="btn btn-primary btn-block" id="rentBtn"> 
							대여
						</button>
					</div>
				</div>
				<div class="col-md-1">
					<div class="form-group">
						<button type="button" class="btn btn-primary btn-block" id="returnBtn">
							반납
						</button>
					</div>
				</div>
			</div>
		</div>
	</div>
    <div class="row">
		<div id="memGridDiv">
			<div class="col-md-12">
				<h4>회원 조회</h4>
				<div class="row align-items-center justify-content-center">
	      			<div class="col-md-12">
						<div id="memGrid"></div> 
					</div>
	      		</div>
			</div>
     	</div>
     </div>
     <br>
     <div class="row">
   		<div id="bookGridDiv">
   			<div class="col-md-12">
  				<h4>도서 조회</h4>
	   			<div class="row align-items-center justify-content-center">
	   				<div class="col-md-12">
	 				<!-- <div class="row form-group"> -->
						<div id="bookGrid"></div>
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
<script src="${pageContext.request.contextPath}/resources/js/empRentBook.js?after"></script>

</html>