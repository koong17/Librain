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
			url: "/memSearch.do",
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
