$(document).ready(function() {
	$('#approveBtn').click(function() {
		approveAjax();
	});
	$('#returnBtn').click(function() {
		returnAjax();
	});
	
});

function approveAjax() {
	if(grid.getCheckedRows().length != 0) {
		console.log(grid.getData());
		$.ajax({
			type : "POST",
			contentType : "application/json;charset=UTF-8",
			dataType : "json",
			data : JSON.stringify(grid.getCheckedRows()),
			url : "./newBook/approve.do",
			success : function(data){
				console.log(data.result);
				confirm();
			},
			error : function(e) {
				alert('Error : ' + e);
			}
		});
	} else {
		alert("신간 구입을 승인할 신청번호를 선택해주세요.");
	}
}

function returnAjax() {
	if(grid.getCheckedRows().length != 0) {
		console.log(grid.getData());
		$.ajax({
			type : "POST",
			contentType : "application/json;charset=UTF-8",
			dataType : "json",
			data : JSON.stringify(grid.getCheckedRows()),
			url : "./newBook/return.do",
			success : function(data){
				console.log(data.result);
				grid.uncheckAll();
				confirm();
			},
			error : function(e) {
				alert('Error : ' + e);
			}
		});
	} else {
		alert("신간 구입을 반려할 신청번호를 선택해주세요.");
	}
}

function confirm(){
	grid.readData(1,true);
}

var Grid = tui.Grid;
Grid.setLanguage('ko');

var gridData =
{
	api: {
			readData: { url: location.href+'/readData', method: 'GET' }
	}
}
const grid = new tui.Grid({
	el: document.getElementById('grid'),
	data: gridData,
	rowHeaders: ['rowNum','checkbox'],
	pageOptions: {
		perPage: 1000
	},
	scrollX: false,
	scrollY: false,
	columns: [
		{
			header: '신청 번호',
			name: 'new_book_num'
		},
		{
			header: '권수',
			name: 'bookCnt'
		},
		{
			header: '도서가격',
			name: 'book_price'
		},
		{
			header: '신청일',
			name: 'new_input_date'
		},
		{
			header: '상태',
			name: 'new_status'
		}
	],
	summary: {
		height: 40,
		position: 'bottom', // or 'top'
		columnContent: {
			book_price: {
				template: function(valueMap) {
					return `합계: ${valueMap.sum}`;
				}
			},
			bookCnt: {
				template: function(valueMap) {
					return `권수: ${valueMap.sum}`;
				}
			}
		},
		
	}
});