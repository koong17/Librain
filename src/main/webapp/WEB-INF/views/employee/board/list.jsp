<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="../includes/header.jsp"%>

<c:choose>
	<c:when test="${empty sessionScope.emp_no }">
	<script>window.location.href='${pageContext.request.contextPath}/login.do'</script>
	</c:when>
</c:choose>
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">사내게시판</h1>
	</div>
</div>
<!-- /.row -->

<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				<button id='regBtn' type="button" class="btn btn-primary btn-xs" style='margin-right:5px'>일반글 등록</button>
				<c:choose>
				<c:when test="${sessionScope.emp_position == '관장' || sessionScope.emp_position == '팀장'}">
				<button id='noticeBtn' type="button" class="btn btn-primary btn-xs">공지글 등록</button>
				</c:when>
				</c:choose>
				<span class="pull-right" style="font-weight:bold; color:red">*게시판 이용 전 규칙을 숙지해주시기 바랍니다.</span>
			</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<table class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th>번호</th>
							<th>제목</th>
							<th>작성자</th>
							<th>작성일</th>
							<th>수정일</th>
						</tr>
					</thead>
					<!-- 공지글 -->
					<c:forEach items="${notice }" var="notice">
						<tr>
							<td style="width: 6%"><img src="../resources/img/ico_notice.png" width="25px"/></td>
							<td style="width: 49%; font-weight:bold">
								<a class='moveN' href='<c:out value="${notice.board_no}"/>'>
									<c:out value="${notice.board_title }"/></a>
							</td>
							<td style="width: 15%"><c:out value="${notice.board_writer }" /></td>
							<td style="width: 15%"><fmt:formatDate pattern="yyyy-MM-dd"
									value="${notice.board_regdate }" /></td>
							<td style="width: 15%"><fmt:formatDate pattern="yyyy-MM-dd"
									value="${notice.board_updateDate }" /></td>
						</tr>
					</c:forEach>
					<!-- <tr><td colspan="5"></td></tr> -->
					<!-- 일반 글 -->
					<c:forEach items="${list }" var="board">
						<tr>
							<td style="width: 6%"><c:out value="${board.board_no }" /></td>
							<td style="width: 49%">
								<a class='move' href='<c:out value="${board.board_no}"/>'>
									<c:out value="${board.board_title }"/></a>
							</td>
							<td style="width: 15%"><c:out value="${board.board_writer }" /></td>
							<td style="width: 15%"><fmt:formatDate pattern="yyyy-MM-dd"
									value="${board.board_regdate }" /></td>
							<td style="width: 15%"><fmt:formatDate pattern="yyyy-MM-dd"
									value="${board.board_updateDate }" /></td>
						</tr>
					</c:forEach>
				</table>
			
				<!-- 검색 -->
		<div class="row">
			<div class="col-lg-12">
			
			<form id="searchForm" action="${pageContext.request.contextPath}/board/list.do" method="get">
				<div class="col-lg-2">
				<select class="form-control" name="type">
					<option value=""
						<c:out value="${pageMaker.cri.type == null?'selected':''}"/>>--</option>
					<option value="T"
						<c:out value="${pageMaker.cri.type eq 'T'?'selected':''}"/>>제목</option>
					<option value="C"
						<c:out value="${pageMaker.cri.type eq 'C'?'selected':''}"/>>내용</option>
					<option value="W"
						<c:out value="${pageMaker.cri.type eq 'W'?'selected':''}"/>>작성자</option>
					<option value="TC"
						<c:out value="${pageMaker.cri.type eq 'TC'?'selected':''}"/>>제목 or 내용</option>
					<option value="TW"
						<c:out value="${pageMaker.cri.type eq 'TW'?'selected':''}"/>>제목 or 작성자</option>
					<option value="TWC"
						<c:out value="${pageMaker.cri.type eq 'TWC'?'selected':''}"/>>제목 or 내용 or 작성자</option>
				</select></div>
				
				<div class="col-lg-4">
					<input class="form-control" type='text'  name='keyword'
						value='<c:out value="${pageMaker.cri.keyword}"/>'/>
					<input type='hidden' name='pageNum'
						value='<c:out value="${pageMaker.cri.pageNum}"/>'/>
					<input type='hidden' name='amount'
						value='<c:out value="${pageMaker.cri.amount}"/>'/>
				</div>
				<button class="btn btn-info btn-sm">검색</button>
			</form>
		</div>
	</div>
				<!-- 페이지 처리 추가... 검색 후 페이지 이동시에도 조건 가져가야 함 -->
				<div class='pull-right'>
					<ul class="pagination">
					
						<c:if test="${pageMaker.prev }">
							<li class="paginate_button previous"><a
								href="${pageMaker.startPage-1 }">Previous</a></li>
						</c:if>

						<c:forEach var="num" begin="${pageMaker.startPage }"
							end="${pageMaker.endPage}">
							<li
								class="paginate_button ${pageMaker.cri.pageNum==num ? "active":""}">
								<a href="${num }">${num }</a>
							</li>
						</c:forEach>

						<c:if test="${pageMaker.next }">
							<li class="paginate_button next"><a
								href="${pageMaker.endPage+1 }">Next</a></li>
						</c:if>
					</ul>
				</div>

				<form id='actionForm' action="${pageContext.request.contextPath}/board/list.do" method='get'>
					<input type='hidden' name='pageNum'
						value='${pageMaker.cri.pageNum }'> 
					<input type='hidden'name='amount' 
						value='${pageMaker.cri.amount }'>
					<input type='hidden'name='type' 
						value='<c:out value="${pageMaker.cri.type}"/>'>
					<input type='hidden'name='keyword' 
						value='<c:out value="${pageMaker.cri.keyword }"/>'>
				</form>
				<!-- 페이지 처리 끝 -->

				<!-- MODAL 추가 -->
				<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
					aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">&times;</button>
								<h4 class="modal-title" id="myModalLabel">Modal title</h4>
							</div>
							<div class="modal-body">처리가 완료되었습니다.</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-primary"
									data-dismiss="modal">Close</button>
							</div>
						</div>
						<!--  /.modal-comment -->
					</div>
					<!--  /.modal dialog -->
				</div>
				<!-- /.modal -->
			</div>
			<!-- /.panel-body -->
		</div>
		<!-- /.panel -->
	</div>
</div>
<!-- /.row -->

<script type="text/javascript">
$(document).ready(function(){
	var result = '<c:out value="${result}"/>';
	checkModal(result);
	history.replaceState({}, null, null);
	
	function checkModal(result){
		if(result=='' || history.state){//뒤로가기 처리
			return;
		}
		
		if (parseInt(result) > 0){
			$(".modal-body").html("게시글 " + parseInt(result) + " 번이 등록되었습니다.");
		}
		
		$("#myModal").modal("show");
	}
//일반글	
	$("#regBtn").on("click", function(){
		self.location="${pageContext.request.contextPath}/board/register.do";
	});
	
	var actionForm = $("#actionForm");
	$(".paginate_button a").on("click", function(e){
		e.preventDefault();
		console.log('click');
		actionForm.find("input[name='pageNum']").val($(this).attr("href"));
		actionForm.submit();
	});
	
	//제목 클릭시 상세보기로 이동
	$(".move").on("click", function(e){
		e.preventDefault();
		actionForm.append("<input type='hidden' name='board_no' value='"+$(this).attr("href")+"'>");
		actionForm.attr("action", "${pageContext.request.contextPath}/board/get.do");
		actionForm.submit();
});	//end .move


//공지글
$("#noticeBtn").on("click", function(){
		self.location="${pageContext.request.contextPath}/board/registerNotice.do";
	});
	
	var actionForm = $("#actionForm");
	$(".paginate_button a").on("click", function(e){
		e.preventDefault();
		console.log('click');
		actionForm.find("input[name='pageNum']").val($(this).attr("href"));
		actionForm.submit();
	});
	
	//제목 클릭시 상세보기로 이동
	$(".moveN").on("click", function(e){
		e.preventDefault();
		actionForm.append("<input type='hidden' name='board_no' value='"+$(this).attr("href")+"'>");
		actionForm.attr("action", "${pageContext.request.contextPath}/board/getNotice.do");
		actionForm.submit();
});	//end .move


	//검색버튼 이벤트
   	var searchForm = $("#searchForm");
	$("#searchForm button").on("click", function(e){
		if(!searchForm.find("option:selected").val()){
			alert("검색 종류를 선택하세요");
			return false;
		}
		
		if(!searchForm.find("input[name='keyword']").val()){
			alert("키워드를 입력하세요");
			return false;
		}
		
		searchForm.find("input[name='pageNum']").val("1");	//3페이지 보다가 거기서 검색하면 검색결과도 3페이지를 보여주는 것 막음
		e.preventDefault();
		searchForm.submit(); 
	});	//검색버튼 이벤트 끝
});	//end document
</script>
<%@include file="../includes/footer.jsp"%>
