
function searchAjax() {
	var sendData = {
		searchCtgr: $('#searchCtgr').val(),
		searchWord: $('#searchWord').val()
	}
	
	$.ajax({
		type: "Post",
		url: "search.do",
		data: JSON.strigify(sendData),
		dataType: "json",
		contentType: "applicaition/json; charset=UTF-8",
		async: true,
		
	})
}