<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html><head><meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://uicdn.toast.com/tui-grid/latest/tui-grid.css" />
<script src="https://uicdn.toast.com/tui-grid/latest/tui-grid.js"></script>
</head>
<body>
	<div>
		사원 추가
	</div>
	
	<form action="empInsert.do" method="post">
		<div class="col-md-6 col-xs-12">
			<div class="form-group">
				<input type="text" name="emp_no" class="form-control" placeholder="사원번호" required="required">
			</div>
			<div class="form-group">
				<input type="text" name="emp_name" class="form-control" placeholder="이름" required="required">
			</div>
			<div class="form-group">
				<input type="text" name="emp_telephone" class="form-control" placeholder="전화번호" required="required">
			</div>
			<div class="form-group">
				<input type="text" name="emp_email" class="form-control" placeholder="이메일" required="required">
			</div>
			<div class="form-group">
				<input type="text" name="emp_dept_code" class="form-control" placeholder="부서번호" required="required">
			</div>
			<!-- <div class="form-group">
				<input type="text" name="emp_join_date" class="form-control" placeholder="입사일" required="required">
			</div> -->
			<div class="form-group">
				<input type="text" name="emp_rank_position" class="form-control" placeholder="직책" required="required">
			</div>
			<div class="form-group">
	          <input type="submit" value="사원 추가" class="btn btn-success btn-block btn-lg" tabindex="7">
	          <input type="button" value="취소" onclick="window.close()" class="btn btn-primary btn-block btn-lg" tabindex="7">
			</div>
		</div>
	</form>
</body>

<script type="text/javascript">
		
	
</script>
</html>