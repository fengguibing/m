<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>搜索</title>
<style type="text/css">
	input {
		margin-top: 20%;
		width: 30%;
		height: 30px;
	}
</style>
</head>
<body style="background-image: url('img/background.jpg')">
	<center>
		<form action="${pageContext.request.contextPath }/search.action" method="post">
			<input type="text" name="searchName" />
			<input type="submit" value="search" style="width: 5%; background:green;"/>
		</form>
	</center>
</body>
</html>