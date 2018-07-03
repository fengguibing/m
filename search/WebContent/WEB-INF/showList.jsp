<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<title>结果列表</title>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
		<link href="https://cdn.bootcss.com/bootstrap-table/1.11.1/bootstrap-table.min.css" rel="stylesheet">
		<script src="https://cdn.bootcss.com/jquery/2.2.3/jquery.min.js"></script>
		<script src="https://cdn.bootcss.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
		
		<!-- bootstrap-table.min.js -->
		<script src="https://cdn.bootcss.com/bootstrap-table/1.11.1/bootstrap-table.min.js"></script>
		<!-- 引入中文语言包 -->
		<script src="https://cdn.bootcss.com/bootstrap-table/1.11.1/locale/bootstrap-table-zh-CN.min.js"></script>
	</head>
	<body>
		<center>
			<nav class="navbar navbar-light bg-light">
			  <a class="navbar-brand">result list (共${total }条结果)</a>
			  <form class="form-inline" action="${pageContext.request.contextPath }/search.action" method="post">
			    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" name="searchName">
			    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
			  </form>
			</nav>
			<table data-toggle="table" data-url="data1.json" data-striped="true">
		   		<thead>
	       		 <tr>
		            <th data-width="5%" data-align="center">序号</th>
		            <th data-align="center">文件名</th>
		            <th data-align="center">magnet</th>
		            <th data-width="7%" data-align="center">收录时间</th>
		            <th data-width="5%" data-align="center">文件数量</th>
		            <th data-width="5%" data-align="center">文件大小</th>
		       	 </tr>
			   	 </thead>
			   	 <c:forEach var="resource" items="${list }" varStatus="vs">
				   	 <tr>
			            <td data-width="5%" data-align="center">${vs.count }</td>
			            <td data-align="center">${resource.name }</td>
			            <td data-align="center">${resource.magent }</td>
			            <td data-width="7%" data-align="center">${resource.recordTime }</td>
			            <td data-width="5%" data-align="center">${resource.fileCount }</td>
			            <td data-width="5%" data-align="center">${resource.size }</td>
			       	 </tr>
				 </c:forEach>
			</table>
			<span>第${currentPage }页/共${totalPage }页</span><br />
			<a class="btn btn-outline-primary" href="${pageContext.request.contextPath }/search.action?searchName=${searchName }" role="button">首页</a>
			<a class="btn btn-outline-primary" href="${pageContext.request.contextPath }/search.action?searchName=${searchName }&p=${currentPage - 1}" role="button">上一页</a>
			<a class="btn btn-outline-primary" href="${pageContext.request.contextPath }/search.action?searchName=${searchName }&p=${currentPage + 1}" role="button">下一页</a>
			<a class="btn btn-outline-primary" href="${pageContext.request.contextPath }/search.action?searchName=${searchName }&p=${totalPage }" role="button">未页</a>
		</center>
		
		
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>	
	</body>
</html>
