$(document).ready(function() {
    $('#grid').hide(); 
    
    $('#searchBtn').click(function() {
       $('#grid').show(); 
        searchAjax();
    });

});

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

function confirm(){
   grid.readData(1,true);
   grid.sort("book_num",false);
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
      perPage: 5
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
      perPage: 5
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









