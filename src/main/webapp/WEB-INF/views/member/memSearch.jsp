<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
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
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- font CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<!-- Toast Grid CSS-->
<link rel="stylesheet"
	href="https://uicdn.toast.com/tui.date-picker/v3.3.0/tui-date-picker.css">
<link rel="stylesheet" type="text/css"
	href="https://uicdn.toast.com/tui.pagination/v3.3.0/tui-pagination.css" />
<link rel="stylesheet"
	href="https://uicdn.toast.com/tui-grid/latest/tui-grid.css" />

<!-- jQuery -->
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

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

<!-- BootStrap JS -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>도서검색</title>
</head>
<body>
<a class="btn btn-lg btn-success pull-right" href="${pageContext.request.contextPath}/memberMain.jsp"
		role="button" ><i class="fa fa-home"></i></a><br>
<div class="panel panel-default" id="panel" style="margin:2.5%; padding:0.5%">
			<div class="panel-heading" align="left">
				<h3 class="panel-title" style="font-weight:bold">도서검색</h3>
			</div>
   <div class="container-fluid bg-light">
		<br>
      <div class="row align-items-center justify-content-center">
         <div class="col-md-2 pt-3">
            <div class="form-group ">
               <select id="searchCtgr" name="searchCtgr" class="form-control">
                  <option selected>전체</option>
                  <option value="book_name">도서명</option>
                  <option value="book_author">저자명</option>
                  <option value="book_pub_house">출판사명</option>
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
         <div class="col-md-1">
            <button type="button" class="btn btn-primary btn-block" id="refreshBtn">
					<i class="fa fa-undo" aria-hidden="true"></i>
			</button>
         </div>
      </div>
     </div>
     
      <div class="row form-group" style="padding:0.5%">
     	 <div id="grid" class="success"></div> 
      </div>
      
      <div class="row form-group">
	      <div class="col-md-6">
	      	<div id="newBookGrid"></div>
	      </div>
	      <div class="col-md-6">
		      <div id="mostRentGrid"></div>
	      </div>
      </div>
</div>
</body>
<!-- bookJS -->
<script src="${pageContext.request.contextPath}/resources/js/memBook.js"></script>
</html>