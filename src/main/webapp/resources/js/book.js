
function searchAjax() {
	console.log($('#searchCtgr').val());
	console.log($('#searchWord').val());
	
	if($('#searchWord').val()==""){
		alert("검색어를 입력해주세요.")
	}
	else {
		$.ajax({
			type: "Post",
			url: "search.do",
			data: {
				searchCtgr: $("#searchCtgr").val(),
				searchWord: $("#searchWord").val()
			},
			dataType: "json", //서버 -> 클라이언트
			contentType: "application/x-www-form-urlencoded;charset=UTF-8", //클라이언트 -> 서버
			success: function(response) {
				
				console.log(response);
				html = "<ol>";
				for(i = 0; i < response.result.length; i++) {
					html += "<li>도서명 : " + response.result[i].book_name
					 	  + "저자명 : " + response.result[i].book_author
					 	  + "출판사명 : " + response.result[i].book_pub_house
					 	  + "도서번호 : " + response.result[i].book_num  
					 	  + "대출여부 : " + response.result[i].rent + "</li>";
				}
				html += "</ol>";
				$('#success').html(html);
				$('#searchCtgr').val("전체");
				$('#searchWord').val('');
				$('#error').hide('slow');
				$('#success').show('slow');
			},
			error: function(e) {
				alert('Error : ' + e);
			}
		});
	}
}