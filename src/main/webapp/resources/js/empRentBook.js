$(document).ready(function() {
    $('#memGrid').hide(); 
    $('#bookGrid').hide(); 
    
    $('#memBtn').click(function() {
    	$('#memGrid').show(); 
        memAjax();
    });
    
    $('#bookBtn').click(function() {
    	$('#bookGrid').show(); 
        bookAjax();
    });

});

function bookAjax() {
	console.log($('#book_num').val());
	
	if($('#book_num').val()==""){
		alert("도서 번호를 입력해주세요.")
	}
	else {
		$.ajax({
			type: "Post",
			url: "/empRent/bookCheck.do",
			data: {
				book_num: $("#book_num").val()
			},
			dataType: "json", //서버 -> 클라이언트
			contentType: "application/x-www-form-urlencoded;charset=UTF-8", //클라이언트 -> 서버
			success: function(response) {
				console.log(response);
				bookGrid.resetData(response);
			},
			error: function(e) {
				alert('Error : ' + e);
			}
		});
	}
}
function memAjax() {
	console.log($('#mem_id').val());
	
	if($('#mem_id').val()==""){
		alert("회원 ID를 입력해주세요.")
	}
	else {
		$.ajax({
			type: "Post",
			url: "/empRent/memCheck.do",
			data: {
				mem_id: $("#mem_id").val()
			},
			dataType: "json", //서버 -> 클라이언트
			contentType: "application/x-www-form-urlencoded;charset=UTF-8", //클라이언트 -> 서버
			success: function(response) {
				console.log(response);
				memGrid.resetData(response);
			},
			error: function(e) {
				alert('Error : ' + e);
			}
		});
	}
}

var Grid = tui.Grid;
Grid.setLanguage('ko');

const bookGrid = new tui.Grid({
	el: document.getElementById('bookGrid'),
	data: null,
	rowHeaders: ['rowNum', 'checkbox'],
	scrollX: false,
	scrollY: false,
	columns: [
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
			header: '대출여부',
			name: 'rent'
		}
	]
});

const memGrid = new tui.Grid({
	el: document.getElementById('memGrid'),
	data: null,
	scrollX: false,
	scrollY: false,
	rowHeaders: ['rowNum', 'checkbox'],
	columns: [
		{
			header: '회원 ID',
			name: 'mem_id'
		},
		{
			header: '회원명',
			name: 'mem_name'
		},
		{
			header: '주소',
			name: 'mem_address'
		},
		{
			header: '전화번호',
			name: 'mem_phone'
		},
		{
			header: '이메일',
			name: 'mem_email'
		},
		{
			header: '회원 등급',
			name: 'mem_rank'
			
		}
	]
});
