$(document).ready(function() {
	$('#searchGridDiv').hide();
	
	$('#searchBtn').click(function() {
		$('#grid').hide();
		$('#searchGridDiv').show();
		searchAjax();
	});
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
	$('#refreshBtn').click(function() {
		confirm();
	});
	
});


function searchAjax() {
	console.log($('#searchCtgr').val());
	console.log($('#searchWord').val());

	if ($('#searchWord').val() == "") {
		alert("검색어를 입력해주세요.")
	} else {
		$.ajax({
			type : "Post",
			url : "./search.do",
			data : {
				searchCtgr : $("#searchCtgr").val(),
				searchWord : $("#searchWord").val()
			},
			dataType : "json", // 서버 -> 클라이언트
			contentType : "application/x-www-form-urlencoded;charset=UTF-8", // 클라이언트 -> 서버
			success : function(response) {
				console.log(response);
				searchGrid.resetData(response);
			},
			error : function(e) {
				alert('일치하는 데이터가 없습니다.');
			}
		});
	}
}

function inputAjax() {
	grid.focus(grid.getRowAt(0).rowKey, 'book_num', true);
	$.ajax({
		type : "POST",
		contentType : "application/json;charset=UTF-8",
		dataType : "json",
		data : JSON.stringify(grid.getCheckedRows()),
		url : "./search/input.do",
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

function addRowData() {
	var today = new Date();
	var dd = today.getDate();
	var mm = today.getMonth()+1; //January is 0!
	var yyyy = today.getFullYear();

	if(dd<10) {
	    dd='0'+dd
	} 

	if(mm<10) {
	    mm='0'+mm
	} 

	today = yyyy + "-" + mm + "-" + dd;
	
   var rowData = {
	   book_num:"",  book_name:"입력", book_author:"입력", book_pub_house:"입력", book_pub_date: today, 
	   book_ISBN:"입력", book_apdx_status:"X", book_ctgr_num:"1", rent:"대여가능", book_rsrv_status:"예약가능",
	   book_input_date: today
   };
   
   var option = {
      at:0,
      focus:true
   };
   
	grid.appendRow(rowData,option);
    grid.check(grid.getRowAt(0).rowKey);
}

function deleteAjax() {
	console.log(grid.getCheckedRows());
	$.ajax({
		type : "POST",
		contentType : "application/json;charset=UTF-8",
		dataType : "json",
		data : JSON.stringify(grid.getCheckedRows()),
		url : "./search/delete.do",
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
		grid.focus(grid.getRowAt(0).rowKey, 'book_num', true);
		setTimeout(function() {
			$.ajax({
				type : "POST",
				contentType : "application/json;charset=UTF-8",
				dataType : "json",
				data : JSON.stringify(grid.getCheckedRows()),
				url : "./search/update.do",
				success : function(data){
					console.log(data.result);
					grid.uncheckAll();
					confirm();
				},
				error : function(e) {
					alert('Error : ' + e);
				}
			});
		}, 200); 
	} else {
		alert("수정할 도서를 선택해주세요.");
	}
}


function confirm(){
	$('#searchGridDiv').hide();
	$('#grid').show();
	grid.readData(1,true);
	grid.sort("book_num",false);
	$('#searchWord').val("");
	$('#searchCtgr').val("전체");
	
}


var Grid = tui.Grid;
Grid.setLanguage('ko');

var gridData =
{
	api: {
			readData: { url: location.href+'/readData', method: 'GET' }
	}
}
const searchGrid = new tui.Grid({
	el: document.getElementById('searchGrid'),
	data: gridData,
	rowHeaders: ['rowNum','checkbox'],
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
			header: '발행년도',
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
			filter: 'select'/*,
			editor: {
				type: 'radio',
				options: {
					listItems: [
						{ text: '대여가능', value: '대여가능' },
						{ text: '대여중', value: '대여중' },
					]
				}
			}*/
		},
		{
			header: '예약여부',
			name: 'book_rsrv_status'/*,
			editor: {
				type: 'radio',
				options: {
					listItems: [
						{ text: '예약가능', value: '예약가능' },
						{ text: '예약중', value: '예약중' },
					]
				}
			}*/
		},
		{
			header: '입력일',
			name: 'book_input_date',
		}
	],
	columnOptions: {
	      resizable: true
	}
});

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
			header: '발행년도',
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
			filter: 'select'/*,
			editor: {
				type: 'radio',
				options: {
					listItems: [
						{ text: '대여가능', value: '대여가능' },
						{ text: '대여중', value: '대여중' },
					]
				}
			}*/
		},
		{
			header: '예약여부',
			name: 'book_rsrv_status'/*,
			editor: {
				type: 'radio',
				options: {
					listItems: [
						{ text: '예약가능', value: '예약가능' },
						{ text: '예약중', value: '예약중' },
					]
				}
			}*/
		},
		{
			header: '입력일',
			name: 'book_input_date',
		}
	],
	columnOptions: {
	      resizable: true
	}
});