<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head> <!-- 회원 리스트 페이지 -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 리스트 페이지</title>

<style type="text/css">

table {
	width: 100%;
	text-align: center;
	font-size: 20px;
	
}
table th{
	background-color: black;
	color: white;
}


table tr:nth-child(even) {
	background-color: lightgray;
}
table tr:HOVER {
	color: white;
	background-color: black;
}
table tr:ACTIVE{
	color: black;
	font-weight:bold;
	background-color: lightyellow;
}

#edit {
	background-color: #87cefa;
	color: blue;
}

#delete {
	background-color: pink;
	color: red;
}

button{
	font-size:20px;
	font-weight:bold;
	width: 100px;
	height: 90%;
}
#multi{
	display:none;  
}

</style>

<script type="text/javascript">

var message = '${message}';
if (message) alert(message);

	function listChange(params) {
		var url = params.value + "_list.do";
		window.location.href = url;
	}

	function multiDelete(){
		var t= document.getElementsByName("mem_id");
		var sum = new Array();
		var j=0;
		for (var i =0 ; i<t.length; i++){
			if(t[i].checked){
				sum[j] = t[i].value;
				j=j+1;
			}
		}
		window.location.href="multiDelete_Member.do?mem_id="+sum;
	}

</script>
</head>
<body>

<h3>
		<form action="search_member.do" method="post">
			검색어 입력 : <input size="30" type="search" name="keyvalue" placeholder="키워드 검색 가능합니다" list="MemberList"> <input type="submit" value="검색"> <a href="member_list.do" ><button id="delete">초기화</button></a> 
		</form>
	</h3> 
	<datalist id="MemberList">
	<c:forEach items="${list}" var="mem">
		<option value="${mem.id}"> ${mem.pw} | ${mem.name} | ${mem.jumin} | ${mem.address} | ${mem.phone} | ${mem.email} | ${mem.rank}</option>
	</c:forEach>
	</datalist>
<hr>
<div >
<hr>
</div>
	<fieldset>
		<legend>
			<select style="width: 350px; height: 50px; font-size: 30px; font-weight: bold;" onchange="listChange(this);">
				<option value="member">회원테이블</option>
			</select>
			<a href="list.do"><button>추가하기</button></a>&nbsp;&nbsp;
			<a href="#"><button id="multi" onclick="multiDelete()">삭제하기</button></a>&nbsp;&nbsp;
			<a href="#"><button id="edit" onclick="hide()">다중삭제</button></a>&nbsp;&nbsp;			
		</legend>

		<table cellpadding="5">
			<th><B>ID</B></th>
			<th><B>PW</B></th>
			<th><B>NAME</B></th>
			<th><B>JUMIN</B></th>
			<th><B>ADDRESS</B></th>
			<th><B>PHONE</B></th>
			<th><B>EMAIL</B></th>
			<th><B>RANK</B></th>
			<th><B></B></th>
			<th><B></B></th>
			<th id="multi"><B></B></th>
			<c:forEach items="${list}" var="mem" varStatus="status">
				<tr onclick="test(this)">
					<td>${mem.id}</td>
					<td>${mem.pw}</td>
					<td>${mem.name}</td>
					<td>${mem.jumin}</td>
					<td>${mem.address}</td>
					<td>${mem.phone}</td>
					<td>${mem.email}</td>
					<td>${mem.rank}</td>
					
					<td><a href="delete_dept2.do?dcode=${ mem_id}"><button
								id="delete">삭 제</button></a></td>
					<td><a href="updateform_dept2.do?dcode=${ mem_id}"><button
								id="edit">수 정</button></a></td>
					<td id="multi"><input style="width: 30px; height: 30px;" type="checkbox" name="mem_id" value="${mem.id}"> </td>
				</tr>
			</c:forEach>
		</table>

	</fieldset>

</body>
</html>