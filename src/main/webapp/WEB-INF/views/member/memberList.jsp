<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html><head><meta charset="UTF-8">
<title>회원 목록 조회</title>
<!-- grid -->
<link rel="stylesheet" href="https://uicdn.toast.com/tui-grid/latest/tui-grid.css" />
<script src="https://uicdn.toast.com/tui-grid/latest/tui-grid.js"></script>
<!-- jquery -->
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

</head>
<body>
	<div>
		회원 목록 조회
	</div>
	<div id="grid"></div>
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