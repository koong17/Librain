<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html><head><meta charset="UTF-8">
<title>Insert title here</title>

<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://uicdn.toast.com/tui-grid/latest/tui-grid.css" />
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://uicdn.toast.com/tui-grid/latest/tui-grid.js"></script>
</head>
<body>
	<div class="container">
	<br>
      <div class="row align-items-center justify-content-center" align="center">
      	<div class="form-group">
			<div class="col-lg-5">
				<input type="text" placeholder="책 제목을 입력하세요" class="form-control" id="search">
			</div>
			<div class="col-lg-2">
				<input type="button" class="btn btn-primary btn-block" value="책검색" onclick="testBookApi()"><br>
			</div>
      	</div>
	  </div>
      <div class="row align-items-center justify-content-center" align="center">
      	<div class="form-group">
			<div class="col-md-12">
				<div id="grid"></div>
			</div>
      	</div>
	  </div>
	</div>
</body>
<script type="text/javascript">
	function testBookApi() {
		$.ajax({
			url: "https://dapi.kakao.com/v3/search/book",
			headers: {'Authorization': 'KakaoAK 3e527a0c575e552fee7c82cf676cf81f'},
			type: "get",
			data: {
				query: document.getElementById("search").value,
				target: 'title'
			},
			success: function(result) {
				console.log(result);
				grid.resetData(result.documents);
				document.getElementById("author").value = result.documents[0].authors[0];
				document.getElementById("contents").value = result.documents[0].contents;
				document.getElementById("datetime").value = result.documents[0].datetime;
				document.getElementById("isbn").value = result.documents[0].isbn;
				document.getElementById("price").value = result.documents[0].publisher;
			}
		})
	}
	
	const grid = new tui.Grid({
		el: document.getElementById('grid'),
		data: null,
		scrollX: false,
		scrollY: false,
		rowHeaders: ['checkbox'],
		columns: [
			{
				header: '제목',
				name: 'title'
			},
			{
				header: '저자',
				name: 'authors'
			},
			{
				header: '출판사',
				name: 'publisher'
			},
			{
				header: '발행일',
				name: 'datetime'
			},
			{
				header: 'isbn',
				name: 'isbn'
			},
			{
				header: '정가',
				name: 'price'
			}
		]
	});
</script>
</html>