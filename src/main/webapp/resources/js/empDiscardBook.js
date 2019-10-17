$(document).ready(function() {
	$('#searchBtn').click(function() {
		searchAjax();
	});
	$('#inputBtn').click(function() {
		inputAjax();
	});
	$('#deleteBtn').click(function() {
		deleteAjax();
	});
	
});

function searchAjax() {
	console.log($('#searchWord').val());
	
	var option = {
		      at:0,
		      focus:true
	};
	
	if($('#searchWord').val()==""){
		alert("도서 번호를 입력해주세요.")
	} else {
		$.ajax({
			type: "POST",
			url: "./discardApply/search.do",
			data: {
				book_num: $("#searchWord").val()
			},
			dataType: "json", //서버 -> 클라이언트
			contentType: "application/x-www-form-urlencoded;charset=UTF-8", //클라이언트 -> 서버
			success: function(response) {
				console.log(response);
				console.log(grid.findRows({book_num: response.book_num}));
				console.log(grid.getRowCount());
				if(grid.getRowCount()==0){
					$('#grid').show(); 
					grid.resetData([response]);
					grid.checkAll();
				} else if(grid.findRows({book_num: response.book_num}).length == 0) {
					$('#grid').show(); 
					grid.appendRow(response, option);
					grid.check(grid.getRowAt(0).rowKey);
				};
				
			},
			error: function(e) {
				alert('Error : ' + e);
			}
		});
	}
}

function inputAjax() {
	console.log('#search_word');
	$.ajax({
		type : "POST",
		contentType : "application/json;charset=UTF-8",
		dataType : "json",
		data : JSON.stringify(grid.getCheckedRows()),
		url : "./discardApply/input.do",
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
		url : "empDiscardBook/delete.do",
		success : function(data){
			console.log(data.result);
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
			readData: { url: 'http://localhost:8080/mvc/book/disApply.do/readData', method: 'GET' }
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
			header: '발행일',
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
	]
});