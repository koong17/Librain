<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html><head><meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<h3 align="center">개인정보 수정</h3>
	<form action="info.do" method="post">
		<div class="col-md-6 col-xs-12">
			<div class="form-group">
				<input type="text" name="emp_no" class="form-control" value=${employeeDTO.emp_no} readOnly>
			</div>
			<div class="form-group">
				<input type="text" name="emp_name" class="form-control" value=${employeeDTO.emp_name} required="required">
			</div>
			<div class="form-group">
				<input type="text" name="emp_telephone" class="form-control" value=${employeeDTO.emp_telephone} required="required">
			</div>
			<div class="form-group">
				<input type="text" name="emp_email" class="form-control" value=${employeeDTO.emp_email} required="required">
			</div>
			<div class="form-group">
				<input type="text" name="emp_dept_code" class="form-control" value=${employeeDTO.emp_dept_code} readOnly>
			</div>
			<!-- <div class="form-group">
				<input type="text" name="emp_join_date" class="form-control" value=${employeeDTO.emp_no} readOnly>
			</div> -->
			<div class="form-group">
				<input type="text" name="emp_rank_position" class="form-control" value=${employeeDTO.emp_rank_position} readOnly>
			</div>
			<div class="form-group">
	          <input type="submit" value="수정" class="btn btn-success btn-block btn-lg" tabindex="7">
	          <input type="button" value="취소" onclick="history.back()" class="btn btn-primary btn-block btn-lg" tabindex="7">
			</div>
		</div>
	</form>
</body>
</html>