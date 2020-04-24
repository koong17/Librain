$(document).ready(function() {
    $('#memGridDiv').hide(); 
    $('#bookGridDiv').hide(); 
    
    $('#memBtn').click(function() {
    	$('#memGridDiv').show();
    	$('#bookGridDiv').show(); 
        memAjax();
        memBookAjax();
    });
    
    $('#bookBtn').click(function() {
    	$('#bookGridDiv').show(); 
        bookAjax();
    });
    
    $('#rentBtn').click(function() {
    	rentAjax();
    	memBookAjax();
    });
    
    $('#returnBtn').click(function() {
    	returnAjax();
    	memBookAjax();
    });
    
});

function returnAjax() {
	if (bookGrid.getCheckedRows().length == 0) {
		alert("반납할 책이 선택되지 않았습니다.")
	} else {
		$.ajax({
			type : "POST",
			contentType : "application/json;charset=UTF-8",
			dataType : "json",
			data : JSON.stringify(bookGrid.getCheckedRows()),
			url : "./rent/return.do",
			success : function(data){
				console.log(data.result);
				memBookAjax();
				$('#book_num').val("");
			},
			error : function(e) {
				alert('Error : ' + e);
			}
		});
	}
}

function rentAjax() {
//	console.log(memGrid.getData()[0].mem_id);
//	console.log(bookGrid.getCheckedRows()[0].rent);
	console.log(bookGrid.getCheckedRows().length);
/*	var object3=JSON.stringify(bookGrid.getCheckedRows());
	var object4=JSON.stringify({mem_id:memGrid.getCheckedRows()[0].mem_id});
	var object2=object3.concat(object4)
	console.log(JSON.stringify(object2))
	console.log(JSON.stringify(memGrid.getCheckedRows()[0].mem_id,bookGrid.getCheckedRows()));
	console.log(JSON.stringify(bookGrid.getCheckedRows()));
	
	array  concat
	object assign
	var object=  [JSON.stringify(object2),JSON.stringify(bookGrid.getCheckedRows())];
	console.log(object2);	
	
	*/
	if($('#mem_id').val()=="" && $('#book_num').val()==""){
		alert("회원 ID와 도서번호를 검색해주세요.")
	} else if($('#mem_id').val()==""){
		alert("회원 ID를 검색해주세요.")
	} else if($('#book_num').val()=="") {
		alert("도서번호를 검색해주세요.")
	} else if(bookGrid.getCheckedRows().length == 0) {
		alert("대여할 도서를 검색한 후 선택해주세요.")
	} else if(bookGrid.getCheckedRows()[0].rent == "대여가능") {
		var book= bookGrid.getCheckedRows();
		console.log(book);
		var flag = 0;
		for (var i = 0; i < book.length; i++) {
			if(book[i].rent == '대여중') flag = 1;
		}
		console.log("flag = ", flag);
		if(flag == 1) {
			alert("대여중인 항목은 재대여가 불가능합니다. \n도서를 다시 검색하여 대여해주세요.");
		} else {
			var mem_id = memGrid.getData()[0].mem_id;
			var bookArr = new Array();
			for (var i = 0; i < book.length; i++) {
				var object = new Object();
				object.mem_id = mem_id;
				object.book_num = book[i].book_num;
				bookArr.push(object);
			}
			console.log(bookArr.toString());
			if(bookArr.length == 0) {
				alert("대여할 책이 선택되지 않았습니다.")
			} else {
				$.ajax({
					type : "POST",
					contentType : "application/json;charset=UTF-8",
					dataType : "json",
					data : JSON.stringify(bookArr),
					url : "./rent/rent.do",
					success : function(data){
						console.log(data.result);
						memBookAjax();
						$('#book_num').val("");
					},
					error : function(e) {
						alert('Error : ' + e);
					}
				});
			}
		}
	} else {
		alert("이미 대여중인 도서입니다.");
	}
}

function bookAjax() {
	console.log($('#book_num').val());
	
	var option = {
		      at:0,
		      focus:true
	};
	
	if($('#book_num').val()==""){
		alert("도서 번호를 입력해주세요.")
	} else {
		$.ajax({
			type: "Post",
			url: "./rent/bookCheck.do",
			data: {
				book_num: $("#book_num").val()
			},
			dataType: "json", //서버 -> 클라이언트
			contentType: "application/x-www-form-urlencoded;charset=UTF-8", //클라이언트 -> 서버
			success: function(response) {
				console.log(response);
				console.log("1111 => " + bookGrid.findRows({book_num: response.book_num}));
				console.log(bookGrid.getRowCount());
				$('#bookGrid').show(); 
				if(bookGrid.getRowCount()==0){
					bookGrid.resetData([response]);
					bookGrid.checkAll();
				} else if(bookGrid.findRows({book_num: response.book_num}).length == 0) {
					bookGrid.appendRow(response, option);
					bookGrid.check(bookGrid.getRowAt(0).rowKey);
				};
				
			},
			error: function(e) {
				alert("해당 도서가 존재하지 않습니다.");
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
			url: "./rent/memCheck.do",
			data: {
				mem_id: $("#mem_id").val()
			},
			dataType: "json", //서버 -> 클라이언트
			contentType: "application/x-www-form-urlencoded;charset=UTF-8", //클라이언트 -> 서버
			success: function(response) {
				console.log(response);
				memGrid.resetData(response);
				memGrid.check(memGrid.getRowAt(0).rowKey);
			},
			error: function(e) { 
				alert('Error : ' + e);
			}
		});
	}
}

function memBookAjax() {
	$.ajax({
		type: "Post",
		url: "./rent/memBookCheck.do",
		data: {
			mem_id: $("#mem_id").val()
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
			header: '전화번호',
			name: 'mem_phone'
		},
		{
			header: '주소',
			name: 'mem_address'
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
