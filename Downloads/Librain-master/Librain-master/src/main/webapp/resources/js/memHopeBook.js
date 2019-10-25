$(document).ready(function() {
    $('#searchGrid').hide();
    
    $('#hopeSearchBtn').click(function() {
		memAjax();
	});
	$('#hopeSearchInputBtn').click(function() {
		searchInputAjax();
	});
});

function memAjax() {
	console.log($('#mem_id').val());
	
	if($('#mem_id').val()==""){
		alert("회원 ID를 입력해주세요.")
	}
	else {
		$.ajax({
			type: "Post",
			url: "./hope/memCheck.do",
			data: {
				mem_id: $("#mem_id").val()
			},
			dataType: "json", //서버 -> 클라이언트
			contentType: "application/x-www-form-urlencoded;charset=UTF-8", //클라이언트 -> 서버
			success: function(response) {
				console.log(response);
				
				if(response.result == "success") {
					$('#searchGrid').show();
					testBookApi();
				} else {
					alert("등록된 회원정보가 존재하지 않습니다.");
				}
			},
			error: function(e) { 
				alert('Error : ' + e);
			}
		});
	}
}

function testBookApi() {
	$.ajax({
		url: "https://dapi.kakao.com/v3/search/book",
		headers: {'Authorization': 'KakaoAK 3e527a0c575e552fee7c82cf676cf81f'},
		type: "get",
		data: {
			query: document.getElementById("search").value,
			size: 50
		},
		success: function(result) {
			console.log(result);
			for (var i = 0; i < result.documents.length; i++) {
				result.documents[i].thumbnail = '<img alt="no thumbnail" src="'+result.documents[i].thumbnail+'">';
			}
			searchGrid.uncheckAll();
			searchGrid.resetData(result.documents);
		}
	})
}

function searchInputAjax() {
	var flag = 0;
	var length = searchGrid.getCheckedRows().length;
	
	if(length != 0) {
		console.log(searchGrid.getCheckedRows());
		
		for(var i = 0; i < length; i++) {
			flag = 1;
			searchData(searchGrid.getCheckedRows()[i]);
		}
		
		if(flag != 0 ) {
			alert("희망 도서 신청이 완료되었습니다.");
			confirm();
		}
		$('#search').val("");
		$('#searchGrid').hide();
		
	} else {
		alert("희망 도서를 선택해주세요.");
	}
}

function searchData(array) {
	var author = "";
	
	var option = {
			at:0,
			focus:true
	};
	
	if(array.authors.length != 1) {
		for (var i = 0; i < array.authors.length - 1; i++) {
			author += array.authors[i] + ", ";
		}
	}
	author += array.authors[array.authors.length - 1];
	console.log(author);
	
	var searchData = {
			book_name: array.title, book_author: author, book_pub_house: array.publisher,
			book_pub_date: array.datetime.substring(0, 10), book_ISBN: array.isbn, book_price: array.price
	}
	
	inputAjax(searchData);
}

function inputAjax(searchData) {
	console.log("inputAjax");
	console.log("searchData = ", searchData);
	console.log("JSON.stringify([searchData]) = ", JSON.stringify([searchData]));
	
	$.ajax({
		type : "POST",
		contentType : "application/json;charset=UTF-8",
		dataType : "json",
		data : JSON.stringify([searchData]),
		url : "./hope/input.do",
		success : function(data){
			console.log(data.result);
		},
		error : function(e) {
			alert('Error : ' + e);
		}
	});
}

var Grid = tui.Grid;
Grid.setLanguage('ko');

function confirm(){
	grid.readData(1,true);
}


const searchGrid = new tui.Grid({
	el: document.getElementById('searchGrid'),
	data: null,
	bodyHeight: 720,
	rowHeight: 180,
	rowHeaders: ['rowNum','checkbox'],
	columns: [
		{
			header: '이미지',
			name: 'thumbnail'
		},
		{
			header: '제목',
			name: 'title'
		},
		{
			header: '저자',
			name: 'authors'
		},
		{
			header: '출판사',
			name: 'publisher'
		},
		{
			header: '발행일',
			name: 'datetime'
		},
		{
			header: 'isbn',
			name: 'isbn'
		},
		{
			header: '정가',
			name: 'price'
		}
	],
	columnOptions: {
	      resizable: true
	}
});

var gridData =
{
	api: {
			readData: { url: location.href+'/readData', method: 'GET' }
	}
}

const grid = new tui.Grid({
	el: document.getElementById('grid'),
	data: gridData,
	rowHeaders: ['rowNum'],
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
			header: '신청일',
			name: 'hope_input_date'
		},
		{
			header: '상태',
			name: 'hope_status'
		}
	],
	columnOptions: {
	      resizable: true
	}
});





