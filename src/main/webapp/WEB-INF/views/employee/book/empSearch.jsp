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
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>

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
				<input class="form-control" type="text" placeholder="검색어를 입력하세요." id="searchWord" name="searchWord">
			</div>
			<div class="col-md-1">
				<button type="button" class="btn btn-primary btn-block" id="searchBtn">
					<i class="fa fa-search"></i>
				</button>
			</div>
			<div class="col-md-1">
				<button type="button" class="btn btn-primary btn-block" id="homeBtn" onclick="location.href='/empSearch.do'">
					<i class="fa fa-home"></i>
				</button>
			</div>
			<div class="col-md-1">
				<button type="button" class="btn btn-primary btn-block" id="inputBtn" onclick="location.href='/empSearch.do'">
					<i class="fa fa-plus"></i>
				</button>
			</div>
		</div>
	</div>
	<hr>
	<div>
		<div id="grid"></div>
	</div>
</body>

<!-- bookJS -->
<script src="resources/js/empBook.js"></script>
<script type="text/javascript">
var Grid = tui.Grid;
Grid.setLanguage('ko');

const grid = new tui.Grid({
	el: document.getElementById('grid'),
	data: ${ gridData },
	rowHeaders: ['rowNum','checkbox'],
	scrollX: false,
	scrollY: false,
	columns: [
		{
			header: '도서번호',
			name: 'book_num'
		},
		{
			header: '도서명',
			name: 'book_name'
		},
		{
			header: '저자명',
			name: 'book_author'
		},
		{
			header: '출판사명',
			name: 'book_pub_house'
		},
		{
			header: '발행일',
			name: 'book_pub_date'
		},
		{
			header: 'ISBN',
			name: 'book_ISBN'
		},
		{
			header: '부록여부',
			name: 'book_apdx_status'
		},
		{
			header: '분류기호',
			name: 'book_ctgr_num'
		},
		{
			header: '대출여부',
			name: 'rent'
		},
		{
			header: '예약여부',
			name: 'book_rsrv_status'
		}
	]
});
</script>
</html>