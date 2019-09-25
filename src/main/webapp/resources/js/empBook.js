$(document).ready(function() {
    $('#searchBtn').click(function() {
        searchAjax();
    });
    $('#inputBtn').click(function() {
        inputAjax();
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
			url: "empSearch.do",
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

function inputAjax() {
	$.ajax({
		type: "Post",
		url: "empSearch.do",
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