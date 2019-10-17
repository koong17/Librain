$(document).ready(function() {
	$('#approveBtn').click(function() {
		approveAjax();
	});
	$('#returnBtn').click(function() {
		returnAjax();
	});
	
});

function approveAjax() {
	console.log(grid.getData());
	$.ajax({
		type : "POST",
		contentType : "application/json;charset=UTF-8",
		dataType : "json",
		data : JSON.stringify(grid.getData()),
		url : "./newBook/approve.do",
		success : function(data){
			console.log(data.result);
			confirm();
		},
		error : function(e) {
			alert('Error : ' + e);
		}
	});
}

function returnAjax() {
	console.log(grid.getData());
	$.ajax({
		type : "POST",
		contentType : "application/json;charset=UTF-8",
		dataType : "json",
		data : JSON.stringify(grid.getData()),
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
}

function confirm(){
	grid.readData(1,true);
}

var Grid = tui.Grid;
Grid.setLanguage('ko');

var gridData =
{
	api: {
			readData: { url: 'http://localhost:8080/mvc/admin/book/approve/newBook.do/readData', method: 'GET' }
	}
}
const grid = new tui.Grid({
	el: document.getElementById('grid'),
	data: gridData,
	rowHeaders: ['rowNum'],
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
			header: '신청일',
			name: 'new_input_date'
		},
		{
			header: '도서가격',
			name: 'book_price'
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
			new_status: {
				template: function(valueMap) {
					return `권수: ${valueMap.cnt}`;
				}
			}
		},
		
	}
});