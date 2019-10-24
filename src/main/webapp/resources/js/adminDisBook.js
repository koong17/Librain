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
			url : "./disBook/approve.do",
			success : function(data){
				console.log(data.result);
				confirm();
			},
			error : function(e) {
				alert('Error : ' + e);
			}
		});
	} else {
		alert("폐기 승인할 도서를 선택해주세요.");
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
			url : "./disBook/return.do",
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
		alert("폐기 반려할 도서를 선택해주세요.");
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
			header: '폐기신청번호',
			name: 'dis_book_num'
		},
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
		},
		{
			header: '출판사명',
			name: 'book_pub_house'
		},
		{
			header: '발행년도',
			name: 'book_pub_date'
			
		},
		{
			header: 'ISBN',
			name: 'book_ISBN'
		},
		{
			header: '부록여부',
			name: 'book_apdx_status'
		},
		{
			header: '분류기호',
			name: 'book_ctgr_num'
		},
		{
			header: '대여여부',
			name: 'rent'
		},
		{
			header: '예약여부',
			name: 'book_rsrv_status'
		},
		{
			header: '입력일',
			name: 'book_input_date',
			
		},
		{
			header: '신청일',
			name: 'dis_input_date',
			
		},
		{
			header: '신청 상태',
			name: 'dis_status',
			
		}
	],
	columnOptions: {
	      resizable: true
	}
});