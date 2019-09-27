$(document).ready(function() {
	$('#searchBtn').click(function() {
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
		type : "POST",
		contentType : "application/json;charset=UTF-8",
		dataType : "json",
		data : JSON.stringify(grid.getCheckedRows()),
		url : "empBookInput.do",
		success : function(data){
			console.log(data.result);
			grid.uncheckAll();
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
	   book_num:"입력",  book_name:"입력", book_author:"입력", book_pub_house:"입력", book_pub_date: today, 
	   book_ISBN:"입력", book_apdx_status:"X", book_ctgr_num:"1", rent:"대여가능", book_rsrv_status:"예약가능"
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
		url : "empBookDelete.do",
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
	console.log(grid.getCheckedRows());
	$.ajax({
		type : "POST",
		contentType : "application/json;charset=UTF-8",
		dataType : "json",
		data : JSON.stringify(grid.getCheckedRows()),
		url : "empBookUpdate1.do",
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