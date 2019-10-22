$(document).ready(function() {
    $('#grid').hide(); 
    $('#searchGrid').hide();
    
    $('#searchBtn').click(function() {
       $('#grid').show(); 
        searchAjax();
    });
    
    $('#refreshBtn').click(function() {
    	console.log("refresh");
    	$('#searchWord').val("");
    	$('#searchCtgr').val("전체");
    	$('#grid').hide();
    });
    $('#hopeSearchBtn').click(function() {
		$('#searchGrid').show();
		testBookApi();
	});
	$('#hopeSearchInputBtn').click(function() {
		searchInputAjax();
	});
});

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
	var length = searchGrid.getCheckedRows().length;
	
	if(length != 0) {
		console.log(searchGrid.getCheckedRows());
		
		for(var i = 0; i < length; i++) {
			searchData(searchGrid.getCheckedRows()[i]);
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
	console.log(searchData);
	console.log(JSON.stringify(searchData));
	$.ajax({
		type : "POST",
		contentType : "application/json;charset=UTF-8",
		dataType : "json",
		data : [JSON.stringify(searchData)],
		url : "./hopeInput.do",
		success : function(data){
			console.log(data.result);
			alert('희망 도서 구입 신청이 완료되었습니다.')
		},
		error : function(e) {
			alert('Error : ' + e);
		}
	});
}

function searchAjax() {
   console.log($('#searchCtgr').val());
   console.log($('#searchWord').val());
   
   if($('#searchWord').val()==""){
      alert("검색어를 입력해주세요.")
   }
   else {
      $.ajax({
         type: "Post",
         url: "./search.do",
         data: {
            searchCtgr: $("#searchCtgr").val(),
            searchWord: $("#searchWord").val()
         },
         dataType: "json", //서버 -> 클라이언트
         contentType: "application/x-www-form-urlencoded;charset=UTF-8", //클라이언트 -> 서버
         success: function(response) {
            console.log(response);
            grid.resetData(response);
         },
         error: function(e) {
            alert('Error : ' + e);
         }
      });
   }
}

var Grid = tui.Grid;
Grid.setLanguage('ko');

var gridData =
{
   api: {
         readData: { url: 'http://localhost:8080/mvc/member/book/search.do/readData', method: 'GET' }
   }
}

var gridData2 =
{
   api: {
         readData: { url: 'http://localhost:8080/mvc/member/book/search.do/readData2', method: 'GET' }
   }
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

const grid = new tui.Grid({
   el: document.getElementById('grid'),
   data: null,
   rowHeaders: ['rowNum'],
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

const newBookGrid = new tui.Grid({
   el: document.getElementById('newBookGrid'),
   data: gridData,
    header: {
         height: 70,
         complexColumns: [
           {
             header: '신간도서',
             name: '신간도서',
             childNames: ['book_num', 'book_name', 'book_author']
           }
         ]
       },
   rowHeaders: ['rowNum'],
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
         name: 'book_name'
      },
      {
         header: '저자명',
         name: 'book_author'
      }
   ]
});

const mostRentGrid = new tui.Grid({
   el: document.getElementById('mostRentGrid'),
   data: gridData2,
   header: {
      height: 70,
      complexColumns: [
         {
            header: '최다대여도서',
            name: '최다대여도서',
            childNames: ['book_num', 'book_name', 'book_author']
         }
         ]
   },
   rowHeaders: ['rowNum'],
   pageOptions: {
      perPage: 10
   },
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
      }
      ]
});









