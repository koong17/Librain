
function searchAjax() {
	
	var searchCtgr = $('#searchCtgr').val();
	var searchWord = $('#searchWord').val();
	
	$.ajax({
		type: "Post",
		url: "search.do"	
	})
}