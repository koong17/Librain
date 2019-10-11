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
mgmt/totalpay.do <a href="mgmt/totalpay.do">급여관리-관리자</a><br>
mgmt/cmtlist.do <a href="mgmt/cmtlist.do">근태목록</a><br>
mypage/commute.do <a href="mypage/commute.do">근태관리</a><br>
mypage/info.do <a href="mypage/info.do">개인정보 수정</a><br>
mypage/pay.do <a href="mypage/pay.do">개인 급여</a><br>
<a href="memberList.do">회원조회</a>
<a href="test.do">직원목록</a>
<a href="commute.do">근태관리</a>
 <br />
 <hr>
<h3>직원 도서</h3> 
<a href="memSearch.do">고객 검색</a> 
<a href="empSearch.do">직원 검색</a>
<a href="empRentBook.do">도서 대여</a>
<a href="empNewBook.do">도서 구입 신청</a>
<a href="empRentBook.do">도서 폐기 신청</a>
<hr>
 <br />
 <hr>
<h3>admin 도서</h3> 
<a href="empRentBook.do">도서 구입 승인</a>
<a href="empRentBook.do">도서 폐기 승인</a>
<hr>

<div class="searchForm" align="right">
	<a href="#">도서검색</a>
</div>
<div class="boardTest" align="right">
	<a href="${pageContext.request.contextPath}/employee/board/list">게시판</a>
</div>
<div class="loginForm" align="center">
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
</div>
</body>
</html>


