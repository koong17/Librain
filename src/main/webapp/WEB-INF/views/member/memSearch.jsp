<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- jQuery -->
<script src="https://code.jquery.com/jquery-3.4.1.js"
	integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
	crossorigin="anonymous"></script>

<!-- boostrap -->
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	crossorigin="anonymous"></script>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<!-- Toast Grid -->
<link rel="stylesheet"
	href="https://uicdn.toast.com/tui-grid/latest/tui-grid.css" />
<script src="https://uicdn.toast.com/tui-grid/latest/tui-grid.js"></script>



<title>도서검색</title>
</head>
<body>
	<div class="container-fluid bg-light ">
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
				<input class="form-control" type="text" placeholder="검색어를 입력하세요."
					id="searchWord" name="searchWord">
			</div>
			<div class="col-md-1">
				<button type="button" class="btn btn-primary btn-block" id="searchBtn">
					<i class="fa fa-search"></i>
				</button>
			</div>
			<div class="col-md-1">
				<button type="button" class="btn btn-primary btn-block" id="homeBtn" onclick="location.href='/memSearch.do'">
					<i class="fa fa-home"></i>
				</button>
			</div>
		</div>
	</div>
	<hr>
	<div>
		<div id="grid" class="success"></div>
	</div>
</body>
<!-- bookJS -->
<script src="resources/js/memBook.js?after"></script>
</html>