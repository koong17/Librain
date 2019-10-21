$(document).ready(function() {
	$('#book').hide();
	
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
	$('#inputBookBtn').click(function() {
		inputBookAjax();
	});
	showBookGrid();
	
});

function showBookGrid() {
	var flag = 0;
	setTimeout(function() {
		var gridGetData = grid.getData();
		console.log(grid.getData());
		for(var i = 0; i < gridGetData.length; i++) {
			console.log(i, ' = ', gridGetData[i].new_status);
			if(gridGetData[i].new_status == "승인") flag = 1; 
		}
		console.log('flag = ', flag);
		if(flag == 1) {
			$('#book').show();
				console.log(grid.getData()[0]);
				console.log(grid.getData()[0].new_status);
				bookGrid.checkAll();
		}
	}, 300);  
}

function addRowData() {
	var rowData = {
			book_name:"입력", book_author:"입력", book_pub_house:"입력", book_price:0
	};
	
	var option = {
			at:0,
			focus:true
	};
	
	grid.appendRow(rowData,option);
	grid.check(grid.getRowAt(0).rowKey);
}

function inputAjax() {
//	console.log('focus success >> ' + grid.focus(grid.getRowAt(0).rowKey, 'book_name', true));
	if(grid.getCheckedRows().length != 0) {
		var checkedGrid= grid.getCheckedRows();
		console.log(checkedGrid);
		var flag = 0;
		for (var i = 0; i < checkedGrid.length; i++) {
			if(checkedGrid[i].new_status == '신청 완료') flag = 1;
		}
		console.log("flag = ", flag);
		if(flag == 1) {
			alert("승인 신청한 항목은 재신청이 불가능합니다. \n다시 신청해주세요.");
		} else {
			grid.focus(grid.getRowAt(0).rowKey, 'new_book_num', true);
			setTimeout(function() {
				$.ajax({
					type : "POST",
					contentType : "application/json;charset=UTF-8",
					dataType : "json",
					data : JSON.stringify(grid.getCheckedRows()),
					url : "./newApply/input.do",
					success : function(data){
						console.log(data.result);
						grid.uncheckAll();
						confirm();
					},
					error : function(e) {
						alert('Error : ' + e);
					}
				});
			}, 100); 
		}
	} else {
		alert("신간 구입 신청할 도서를 선택해주세요.");
	}
}


function deleteAjax() {
	if(grid.getCheckedRows().length != 0) {
		console.log(grid.getCheckedRows());
		var checkedGrid= grid.getCheckedRows();
		var flag = 0;
		for (var i = 0; i < checkedGrid.length; i++) {
			if(checkedGrid[i].new_status == '승인') flag = 1;
		}
		if(flag == 1) {
			alert("승인한 항목은 삭제가 불가능합니다. \n다시 선택한 후 삭제해주세요.");
		} else {
			$.ajax({
				type : "POST",
				contentType : "application/json;charset=UTF-8",
				dataType : "json",
				data : JSON.stringify(grid.getCheckedRows()),
				url : "./newApply/delete.do",
				success : function(data){
					console.log(data.result);
					confirm();
				},
				error : function(e) {
					alert('Error : ' + e);
				}
			});
		}
	} else {
		alert("삭제할 도서를 선택해주세요.");
	}
}
function deleteNewBookAjax() {
	console.log(bookGrid.getCheckedRows());
	$.ajax({
		type : "POST",
		contentType : "application/json;charset=UTF-8",
		dataType : "json",
		data : JSON.stringify(bookGrid.getCheckedRows()),
		url : "./newApply/delete.do",
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
	if(grid.getCheckedRows().length != 0) {
		console.log(grid.getCheckedRows());
		var checkedGrid= grid.getCheckedRows();
		var flag = 0;
		for (var i = 0; i < checkedGrid.length; i++) {
			if(checkedGrid[i].new_status == '승인') flag = 1;
		}
		if(flag == 1) {
			alert("승인한 항목은 수정이 불가능합니다. \n다시 선택한 후 수정해주세요.");
		} else {
			$.ajax({
				type : "POST",
				contentType : "application/json;charset=UTF-8",
				dataType : "json",
				data : JSON.stringify(grid.getCheckedRows()),
				url : "./newApply/update.do",
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
	} else {
		alert("수정할 도서를 선택해주세요.");
	}
}

function inputBookAjax() {
	if(bookGrid.getCheckedRows().length != 0) {
		console.log(bookGrid.getCheckedRows());
		$.ajax({
			type : "POST",
			contentType : "application/json;charset=UTF-8",
			dataType : "json",
			data : JSON.stringify(bookGrid.getCheckedRows()),
			url : "./newApply/inputBook.do",
			success : function(data){
				console.log(data.result);
				confirm();
			},
			error : function(e) {
				alert('Error : ' + e);
			}
		});
		
		grid.checkAll();
		deleteNewBookAjax();
		console.log("complete");
	} else {
		alert("입력할 도서를 선택해주세요.");
	}
}

function confirm(){
	grid.readData(1,true);
	bookGrid.readData(1,true);
}

var Grid = tui.Grid;
Grid.setLanguage('ko');

var gridData =
{
	api: {
			readData: { url: 'http://localhost:8080/mvc/book/newApply.do/readData', method: 'GET' }
	}
}
var gridData2 =
{
	api: {
			readData: { url: 'http://localhost:8080/mvc/book/newApply.do/readData2', method: 'GET' }
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
		},
		{
			header: '신청일',
			name: 'new_input_date'
		},
		{
			header: '도서가격',
			name: 'book_price',
			editor: 'text'
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

const bookGrid = new tui.Grid({
	el: document.getElementById('bookGrid'),
	data: gridData2,
	rowHeaders: ['rowNum','checkbox'],
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
		},
		{
			header: '발행일',
			name: 'book_pub_date',
			editor: 'datePicker'
			
		},
		{
			header: 'ISBN',
			name: 'book_ISBN',
			editor: 'text'
		},
		{
			header: '부록여부',
			name: 'book_apdx_status',
			editor: {
				type: 'radio',
				options: {
					listItems: [
						{ text: 'O', value: 'O' },
						{ text: 'X', value: 'X' },
					]
				}
			}
		},
		{
			header: '분류기호',
			name: 'book_ctgr_num',
			editor: 'text'
		},
		{
			header: '대여여부',
			name: 'rent',
			editor: {
				type: 'radio',
				options: {
					listItems: [
						{ text: '대여가능', value: '대여가능' },
						{ text: '대여중', value: '대여중' },
					]
				}
			}
		},
		{
			header: '예약여부',
			name: 'book_rsrv_status',
			editor: {
				type: 'radio',
				options: {
					listItems: [
						{ text: '예약가능', value: '예약가능' },
						{ text: '예약중', value: '예약중' },
					]
				}
			}
		},
		{
			header: '입력일',
			name: 'book_input_date',
			
		}
	]
});
