$(document).ready(function() {
	$('#searchBtn').click(function() {
		searchAjax();
	});
	$('#inputBtn').click(function() {
		addRowData();
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
			url : "empSearch.do",
			data : {
				searchCtgr : $("#searchCtgr").val(),
				searchWord : $("#searchWord").val()
			},
			dataType : "json", // 서버 -> 클라이언트
			contentType : "application/x-www-form-urlencoded;charset=UTF-8", // 클라이언트 -> 서버
			success : function(response) {
				console.log(response);
				grid.resetData(response);
			},
			error : function(e) {
				alert('일치하는 데이터가 없습니다.');
			}
		});
	}
}

function inputAjax() {
	$.ajax({
		type : "Get",
		url : "empBookInput.do",
		dataType : "json", // 서버 -> 클라이언트
		contentType : "application/x-www-form-urlencoded;charset=UTF-8", // 클라이언트 -> 서버
		success : function() {
			grid.appendRow(rowData,option);
            grid.check(grid.getRowAt(0).rowKey);
		},
		error : function(e) {
			alert('Error : ' + e);
		}
	});
}

function addRowData() {
   var rowData = {
	   book_num:"입력",  book_name:"입력", book_author:"입력", book_pub_house:"입력", book_pub_date:"선택", 
	   book_ISBN:"입력", book_apdx_status:"선택", book_ctgr_num:"입력", rent:"선택", book_rsrv_status:"선택"
   };
   var option = {
      at:0,
      focus:true
   };
	grid.appendRow(rowData,option);
    grid.check(grid.getRowAt(0).rowKey);
}