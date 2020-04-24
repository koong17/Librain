<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html><head><meta charset="UTF-8">
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
				size: 50
			},
			success: function(result) {
				console.log(result);
				for (var i = 0; i < result.documents.length; i++) {
					result.documents[i].thumbnail = '<img alt="no thumbnail" src="'+result.documents[i].thumbnail+'">';
				}
				grid.resetData(result.documents);
			}
		})
	}
	
	const grid = new tui.Grid({
		el: document.getElementById('grid'),
		data: null,
		bodyHeight: 500,
		columns: [
			{
				header: '이미지',
				name: 'thumbnail'
			},
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