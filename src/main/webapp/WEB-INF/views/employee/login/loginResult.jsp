<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<%@include file="../includes/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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

<!-- Toast Grid JS -->
<script src="https://uicdn.toast.com/tui-grid/v4.5.2/tui-grid.js"></script>

<!-- BootStrap JS -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="content">
		<c:choose>
			<c:when test='${!empty sessionScope.emp_no }'>
				<h3>${sessionScope.emp_name }님환영합니다.</h3>
				<!-- <a href="logout.do">로그아웃</a> -->
			</c:when>
		</c:choose>
		<br>
		<!-- <a href="main.do">홈으로</a> -->
		<div class="form-group">
			<div class="col-md-12">
				<div id="grid"></div>
			</div>
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
<script type="text/javascript">
	
	var Grid = tui.Grid;
	Grid.setLanguage('ko');
	
	var gridData1 =
	{
	   api: {
	         readData: { url: 'http://localhost:8080/mvc/member/book/search.do/readData', method: 'GET' }
	   }
	}
	
	var gridData2 =
	{
	   api: {
	         readData: { url: 'http://localhost:8080/mvc/member/book/search.do/readData2', method: 'GET' }
	   }
	}
	
	const grid = new tui.Grid({
	   el: document.getElementById('grid'),
	   data: ${gridData},
	    header: {
	         height: 70,
	         complexColumns: [
	           {
	             header: '보유도서',
	             name: '보유도서',
	             childNames: ['000', '100', '200', '300', '400', '500', '600', '700', '800', '900', 'total']
	           }
	         ]
	       },
	   scrollX: false,
	   scrollY: false,
	   columns: [
	      {
	         header: '총류',
	         name: '000'
	      },
	      {
	         header: '철학',
	         name: '100'
	      },
	      {
	         header: '종교',
	         name: '200'
	      },
	      {
	         header: '사회학',
	         name: '300'
	      },
	      {
	         header: '언어',
	         name: '400'
	      },
	      {
	         header: '자연과학',
	         name: '500'
	      },
	      {
	         header: '기술과학',
	         name: '600'
	      },
	      {
	         header: '예술',
	         name: '700'
	      },
	      {
	         header: '문학',
	         name: '800'
	      },
	      {
	         header: '역사',
	         name: '900'
	      },
	      {
	         header: '총 합',
	         name: 'total'
	      }
	   ]
	});
	
	const newBookGrid = new tui.Grid({
	   el: document.getElementById('newBookGrid'),
	   data: gridData1,
	    header: {
	         height: 70,
	         complexColumns: [
	           {
	             header: '신간도서',
	             name: '신간도서',
	             childNames: ['book_num', 'book_name', 'book_author']
	           }
	         ]
	       },
	   rowHeaders: ['rowNum'],
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
	         name: 'book_name'
	      },
	      {
	         header: '저자명',
	         name: 'book_author'
	      }
	   ]
	});
	
	const mostRentGrid = new tui.Grid({
	   el: document.getElementById('mostRentGrid'),
	   data: gridData2,
	   header: {
	      height: 70,
	      complexColumns: [
	         {
	            header: '최다대여도서',
	            name: '최다대여도서',
	            childNames: ['book_num', 'book_name', 'book_author']
	         }
	         ]
	   },
	   rowHeaders: ['rowNum'],
	   pageOptions: {
	      perPage: 10
	   },
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
	      }
	      ]
	});
</script>
</html>
<%@include file="../includes/footer.jsp"%>