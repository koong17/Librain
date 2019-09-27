<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html><head><meta charset="UTF-8">
<title>급여</title>
</head>
<body>
	<form action="totalpay.do" method="post">
		<div class="col-md-6 col-xs-12">
			<div class="form-group">
				<input type="number" name="emp_no" class="form-control" value="" readOnly>
			</div>
			<div class="form-group">
				<input type="date" name="emp_name" class="form-control" required="required">
			</div>
		</div>
	</form>
</body>
</html>