$(document).ready(function() {
	$('#addRowBtn').click(function() {
		addRowData();
	});
	$('#inputBtn').click(function() {
		inputAjax();
	});
	$('#deleteBtn').click(function() {
		deleteAjax();
	});
	$('#updateBtn').click(function() {
		updateAjax();
	});
	
});

function addRowData() {
	var rowData = {
			book_name:"입력", book_author:"입력", book_pub_house:"입력"
	};
	
	var option = {
			at:0,
			focus:true
	};
	
	grid.appendRow(rowData,option);
	grid.check(grid.getRowAt(0).rowKey);
}

function inputAjax() {
	$.ajax({
		type : "POST",
		contentType : "application/json;charset=UTF-8",
		dataType : "json",
		data : JSON.stringify(grid.getCheckedRows()),
		url : "empNewBook/input.do",
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


function deleteAjax() {
	console.log(grid.getCheckedRows());
	$.ajax({
		type : "POST",
		contentType : "application/json;charset=UTF-8",
		dataType : "json",
		data : JSON.stringify(grid.getCheckedRows()),
		url : "empNewBook/delete.do",
		success : function(data){
			console.log(data.result);
			confirm();
		},
		error : function(e) {
			alert('Error : ' + e);
		}
	});
}

function updateAjax() {
	console.log(grid.getCheckedRows());
	$.ajax({
		type : "POST",
		contentType : "application/json;charset=UTF-8",
		dataType : "json",
		data : JSON.stringify(grid.getCheckedRows()),
		url : "empNewBook/update.do",
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
			readData: { url: 'http://localhost:8080/empNewBook.do/readData', method: 'GET' }
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
		}
	]
});