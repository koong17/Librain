$(document).ready(function() {
	$('#approveBtn').click(function() {
		approveAjax();
	});
	$('#returnBtn').click(function() {
		returnAjax();
	});
	$('#deleteBtn').click(function() {
		deleteAjax();
	});
	
});

function approveAjax() {
	if(grid.getCheckedRows().length != 0) {
		var checkedGrid= grid.getCheckedRows();
		console.log(checkedGrid);
		var flag = 0;
		for (var i = 0; i < checkedGrid.length; i++) {
			if(checkedGrid[i].hope_status == '승인') flag = 1;
		}
		console.log("flag = ", flag);
		if(flag == 1) {
			alert("승인한 항목은 재승인이 불가능합니다.");
		} else {
			console.log(grid.getData());
			$.ajax({
				type : "POST",
				contentType : "application/json;charset=UTF-8",
				dataType : "json",
				data : JSON.stringify(grid.getCheckedRows()),
				url : "./hope/approve.do",
				success : function(data){
					console.log(data.result);
					confirm();
					inputAjax();
				},
				error : function(e) {
					alert('Error : ' + e);
				}
			});
		}
	} else {
		alert("신간 구입을 승인할 신청번호를 선택해주세요.");
	}
}

function inputAjax() {
	if(grid.getCheckedRows().length != 0) {
		console.log(grid.getData());
		$.ajax({
			type : "POST",
			contentType : "application/json;charset=UTF-8",
			dataType : "json",
			data : JSON.stringify(grid.getCheckedRows()),
			url : "./newApply/input.do",
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
			url : "./hope/return.do",
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

function deleteAjax() {
	console.log(grid.getData());
	$.ajax({
		type : "POST",
		contentType : "application/json;charset=UTF-8",
		dataType : "json",
		data : JSON.stringify(grid.getData()),
		url : "./hope/delete.do",
		success : function(data){
			console.log(data.result);
			grid.uncheckAll();
			confirm();
			alert("최근 일주일 이전 항목의 삭제가 완료되었습니다.")
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
			readData: { url: location.href+'/readData', method: 'GET' }
	}
}

const grid = new tui.Grid({
	el: document.getElementById('grid'),
	data: gridData,
	rowHeaders: ['rowNum','checkbox'],
	pageOptions: {
		perPage: 10
	},
	scrollX: false,
	scrollY: false,
	columns: [
		{
			header: '신청 번호',
			name: 'hope_book_num'
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
			header: '발행일',
			name: 'book_pub_date'
		},
		{
			header: 'ISBN',
			name: 'book_ISBN'
		},
		{
			header: '신청일',
			name: 'hope_input_date'
		},
		{
			header: '도서가격',
			name: 'book_price'
		},
		{
			header: '상태',
			name: 'hope_status'
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
			hope_status: {
				template: function(valueMap) {
					return `권수: ${valueMap.cnt}`;
				}
			}
		},
		
	},
	columnOptions: {
	      resizable: true
	}
});