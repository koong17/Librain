<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록 조회</title>

<!-- Toast pagination -->
 <script type="text/javascript" src="https://uicdn.toast.com/tui.code-snippet/v1.5.0/tui-code-snippet.js"></script>
 <script type="text/javascript" src="https://uicdn.toast.com/tui.pagination/v3.3.0/tui-pagination.js"></script>
 <link rel="stylesheet" type="text/css" href="https://uicdn.toast.com/tui.pagination/v3.3.0/tui-pagination.css" />
<!-- grid -->
<link rel="stylesheet" href="https://uicdn.toast.com/tui-grid/latest/tui-grid.css" />
<script src="https://uicdn.toast.com/tui-grid/latest/tui-grid.js"></script>
<!-- jquery -->
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<!-- boostrap -->
<!-- boostrap -->
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


</head>
<body>
	<div> &lt 회원 목록 조회 &gt &nbsp;

            <select name="searchMember">
                <option value="0">전체</option>
                <option value="1">아이디</option>
                <option value="2">이름</option>
            </select>
            <input type="text" size="20" name="condition"/>&nbsp;
            <input type="submit" value="검색"/>&nbsp;

		<button type="button" class="btn btn-primary btn-block" id="homeBtn"
			onclick="location.href='index.jsp'">
			<i class="fa fa-home">home</i>
		</button>
	</div><p>
	<div id="grid"></div><p>
	<input type="button" value="선택 수정" onclick="rankUpdate()">

</body>

<script type="text/javascript">
	
	function rankUpdate() {
		var data = grid.getCheckedRows();
		console.log(data);
		
		$.ajax({
			type : "POST",
			contentType : 'application/json;charset=UTF-8',
			dataType : 'json',
			data : JSON.stringify(data),
			url : "memberRankUpdate.do",
			success : function(data){
				console.log(data.result);
			}
		});
	}

	// 그리드 출력
	var Grid = tui.Grid;
	Grid.setLanguage('ko');
		
	const grid = new tui.Grid({
		el: document.getElementById('grid'),
		data: ${gridData},
		scrollX: false,
		scrollY: false,
		rowHeaders: ['checkbox'],
		columns: [
			{
				header: '회원 ID',
				name: 'mem_id',
		        sortingType: 'desc',
		        sortable: true
			},
			{
				header: '회원명',
				name: 'mem_name'
			},
			{
				header: '주소',
				name: 'mem_address'
			},
			{
				header: '전화번호',
				name: 'mem_phone'
			},
			{
				header: '이메일',
				name: 'mem_email'
			},
			{
				header: '회원 등급',
				sortingType: 'desc',
		        sortable: true,
				name: 'mem_rank',
				editor: {
					type: 'select',
					options: {
						listItems: [
							{ text: '플러스 회원', value: '1' },
							{ text: '일반 회원', value: '2' },
							{ text: '마이너스 회원', value: '3' }
						]
					}
				}
			}
		]
	});
		
	grid.on('check', function() {
		console.log(grid.getCheckedRows());
		console.log(grid.getModifiedRows());
	});
	
</script>
</html>