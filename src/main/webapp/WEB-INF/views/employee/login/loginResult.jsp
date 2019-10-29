<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<%@include file="../includes/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- Toast Grid CSS-->
<link rel="stylesheet"
	href="https://uicdn.toast.com/tui.date-picker/v3.3.0/tui-date-picker.css">
<link rel="stylesheet" type="text/css"
	href="https://uicdn.toast.com/tui.pagination/v3.3.0/tui-pagination.css" />
<link rel="stylesheet"
	href="https://uicdn.toast.com/tui-grid/latest/tui-grid.css" />
	
<!-- Toast Chart -->
<link rel="stylesheet" href="https://uicdn.toast.com/tui.chart/latest/tui-chart.css">
<body>
    <div id="wrapper">
        <div class="row">
			<c:choose>
				<c:when test='${!empty sessionScope.emp_no }'>
	            <div class="col-md-12">
	                <h1 class="page-header">${sessionScope.emp_name }님 환영합니다.</h1>
	            </div>
				</c:when>
			</c:choose>
            <!-- /.col-lg-12 -->
		</div>
		<!-- <a href="main.do">홈으로</a> -->
		<div class="col-md-12">
			<div class="col-md-4">
				<div class="form-group">
					<div id="chart-area"></div>
				</div>
			</div>
			<!-- <div class="col-md-2"></div>
			<div class="col-md-2"></div> -->
			<div class="col-md-8">
				<div class="form-group"><br><br><br>
					<div id="grid"></div>
				</div>
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


<!-- jQuery -->
<script
	src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery.min.js"></script>

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
<script
	src="${pageContext.request.contextPath}/resources/dist/js/sb-admin-2.js"></script>
	
<!-- Toast Chart JS -->
<script type='text/javascript' src='https://cdnjs.cloudflare.com/ajax/libs/core-js/2.5.7/core.js'></script>
<script type='text/javascript' src='https://uicdn.toast.com/tui.code-snippet/v1.5.0/tui-code-snippet.min.js'></script>
<script type='text/javascript' src='https://uicdn.toast.com/tui.chart/latest/raphael.js'></script>
<script src="https://uicdn.toast.com/tui.chart/latest/tui-chart.js"></script>

<script type="text/javascript">
	
	var Grid = tui.Grid;
	Grid.setLanguage('ko');
	
	var gridData1 =
	{
	   api: {
	         readData: { url: 'http://10.10.10.178:8080/librain/member/book/search.do/readData', method: 'GET' }
	   }
	}

	var gridData2 =
	{
	   api: {
	         readData: { url: 'http://10.10.10.178:8080/librain/member/book/search.do/readData2', method: 'GET' }
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
	
	var container = document.getElementById('chart-area');
	var data = {
	    categories: ['Books'],
	    series: [
	        {
	            name: '총류',
	            data: grid.getColumnValues("000")[0]
	        },
	        {
	            name: '철학',
	            data: grid.getColumnValues("100")[0]
	        },
	        {
	            name: '종교',
	            data: grid.getColumnValues("200")[0]
	        },
	        {
	            name: '사회학',
	            data: grid.getColumnValues("300")[0]
	        },
	        {
	            name: '언어',
	            data: grid.getColumnValues("400")[0]
	        },
	        {
	            name: '자연과학',
	            data: grid.getColumnValues("500")[0]
	        },
	        {
	            name: '기술과학',
	            data: grid.getColumnValues("600")[0]
	        },
	        {
	            name: '예술',
	            data: grid.getColumnValues("700")[0]
	        },
	        {
	            name: '문학',
	            data: grid.getColumnValues("800")[0]
	        },
	        {
	            name: '역사',
	            data: grid.getColumnValues("900")[0]
	        }
	    ]
	};
	var options = {
	    chart: {
	        width: 400,
	        height: 400,
	        title: '보유 도서'
	    },
	    tooltip: {
	        suffix: '권'
	    }
	};
	/* var theme = {
	    series: {
	        colors: [
	            '#83b14e', '#458a3f', '#295ba0', '#2a4175', '#289399',
	            '#289399', '#617178', '#8a9a9a', '#516f7d', '#dddddd'
	        ]
	    }
	};
	
	// For apply theme
	
	tui.chart.registerTheme('myTheme', theme);
	options.theme = 'myTheme'; */
	
	tui.chart.pieChart(container, data, options);
</script>
</html>
<%@include file="../includes/footer.jsp"%>