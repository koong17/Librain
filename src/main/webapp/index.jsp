<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
mgmt/emplist.do <a href="mgmt/emplist.do">직원목록</a><br>
mgmt/emplist2.do <a href="mgmt/emplist2.do">직원목록-관리자</a><br>
mgmt/cmtlist.do <a href="mgmt/cmtlist.do">근태목록</a><br>
mgmt/totalpay.do <a href="mgmt/totalpay.do">급여관리-관리자</a><br><hr>
mypage/commute.do <a href="mypage/commute.do">근태관리</a><br>
mypage/info.do <a href="mypage/info.do">개인정보 수정</a><br>
<!-- mypage/pay.do <a href="mypage/pay.do">개인 급여</a><br><hr> -->
 <hr>
memberList.do<a href="memberList.do">회원조회</a><br><hr>

member/book/search.do<a href="member/book/search.do">고객 도서 검색</a> <br>
book/search.do<a href="book/search.do">직원 도서 검색</a><br>
book/rent.do<a href="book/rent.do">도서 대여</a><br>
book/newApply.do<a href="book/newApply.do">도서 구입 신청</a><br>
book/discardApply.do<a href="book/discardApply.do">도서 폐기 신청</a><br>
 <br />
 <hr>
admin/book/approve/newBook.do<a href="admin/book/approve/newBook.do">도서 구입 승인</a><br>
admin/book/approve/disBook.do<a href="admin/book/approve/disBook.do">도서 폐기 승인</a>
<hr>
<div class="boardTest">
	/employee/board/list<a href="${pageContext.request.contextPath}/employee/board/list">게시판</a>
</div><hr>


<!-- <div class="loginForm" align="center">
<form action="#" method="post">
	<table>
		<tr>
			<td>id : </td>
			<td><input type="text" name="id" placeholder="아이디 입력"></td>
		</tr>
		
		<tr>
			<td>pw : </td>
			<td><input type="password" name="pw" placeholder="비밀번호 입력"></td>
		</tr>
		
		<tr>
			<td align="right" colspan="2">
				<input type="submit" value="로그인"><input type="reset" value="취소">
			</td>
		</tr>	
	</table>
	</form>
</div> -->
</body>
</html>


