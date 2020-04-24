<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html><head><meta charset="UTF-8">
<title>전체 근태</title>
</head>
<body>

</body>
<script>
	const grid = new tui.Grid({
		el: document.getElementById('grid'),
		data: ${gridData},
		scrollX: false,
		scrollY: false,
		rowHeaders: ['checkbox'],
		pagination: {
			perPage: 5
		},
		columns: [
			{
				header: '사원번호',
				name: 'cmt_emp_no',
			},
			{
				header: '상태',
				name: 'cmt_status'
			},
			{
				header: '상태2',
				name: 'cmt_status_kr'
			},
			{
				header: '시',
				name: 'cmt_hour',
		        sortingType: 'asc',
		        sortable: true
				
			},
			{
				header: '분',
				name: 'cmt_minute',
		        sortingType: 'asc',
		        sortable: true
			}
		]
	});
</script>
</html>