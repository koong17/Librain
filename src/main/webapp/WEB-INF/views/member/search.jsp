<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<title>도서검색</title>
</head>
<body>
	<form>
		<ul class="breadcrumb" style="padding-top: 19px;">
			<table>
				<tr>
					<td style="padding-right: 20px;">
						<div class="form-group">
							<select class="form-control" id="selectGroup">
								<option>전체</option>
								<option>도서명</option>
								<option>저자명</option>
								<option>출판사명</option>
							</select>
						</div>
					</td>
					<td style="padding-right: 20px;">
						<div class="form-group">
							<textarea class="form-control" id="search"
								style="height: 34px; width: 200%;" placeholder="검색어를 입력하세요."></textarea>
						</div>
					</td>
					<td>
						<div class="btn-group">
							<button type="button" class="btn btn-primary">
								<span class="glyphicon glyphicon-search"></span>
							</button>
						</div>
					</td>
				</tr>
			</table>
		</ul>
	</form>
</body>
</html>