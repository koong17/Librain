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
				<button type="button" class="btn btn-primary btn-block" id="refreshBtn"  onclick="confirm()">
					<i class="fa fa-undo" aria-hidden="true"></i>
				</button>
			</div>
			<div class="col-md-1">
				<button type="button" class="btn btn-primary btn-block" id="addRowBtn">
					행 추가
				</button>
			</div>
			<div class="col-md-1">
				<button type="button" class="btn btn-primary btn-block" id="inputBtn">
					선택 입력
				</button>
			</div>
			<div class="col-md-1">
				<button type="button" class="btn btn-primary btn-block" id="updateBtn">
					선택 수정
				</button>
			</div>
			<div class="col-md-1">
				<button type="button" class="btn btn-primary btn-block" id="deleteBtn">
					선택 삭제
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
<script src="resources/js/empSearchBook.js?after"></script>
<script type="text/javascript">

function confirm(){
	grid.readData(1,true);
	grid.sort("book_num",false);
}

var Grid = tui.Grid;
Grid.setLanguage('ko');

var gridData =
{
	api: {
			readData: { url: 'http://localhost:8080/empSearch.do/readData', method: 'GET' }
	}
}
const grid = new tui.Grid({
	el: document.getElementById('grid'),
	data: gridData,
	rowHeaders: ['rowNum','checkbox'],
	pageOptions: {
		perPage: 10
	},
	scrollX: false,
	scrollY: false,
	columns: [
		{
			header: '도서번호',
			name: 'book_num',
			sortingType: 'desc',
			sortable: true
		},
		{
			header: '도서명',
			name: 'book_name',
			editor: 'text'
		},
		{
			header: '저자명',
			name: 'book_author',
			editor: 'text'
		},
		{
			header: '출판사명',
			name: 'book_pub_house',
			editor: 'text'
		},
		{
			header: '발행일',
			name: 'book_pub_date',
			editor: 'datePicker'
			
		},
		{
			header: 'ISBN',
			name: 'book_ISBN',
			editor: 'text'
		},
		{
			header: '부록여부',
			name: 'book_apdx_status',
			editor: {
				type: 'radio',
				options: {
					listItems: [
						{ text: 'O', value: 'O' },
						{ text: 'X', value: 'X' },
					]
				}
			}
		},
		{
			header: '분류기호',
			name: 'book_ctgr_num',
			editor: 'text'
		},
		{
			header: '대여여부',
			name: 'rent',
			editor: {
				type: 'radio',
				options: {
					listItems: [
						{ text: '대여가능', value: '대여가능' },
						{ text: '대여중', value: '대여중' },
					]
				}
			}
		},
		{
			header: '예약여부',
			name: 'book_rsrv_status',
			editor: {
				type: 'radio',
				options: {
					listItems: [
						{ text: '예약가능', value: '예약가능' },
						{ text: '예약중', value: '예약중' },
					]
				}
			}
		},
		{
			header: '입력일',
			name: 'book_input_date',
			
		}
	]
});
</script>

   
   
</html>