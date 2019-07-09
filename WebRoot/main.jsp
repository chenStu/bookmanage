<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>首页</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
<script src="js/bootstrap.min.js"></script>
<style type="text/css">
body {
	padding: 15px;
	background: #d0c7b2b8;
}

header {
	text-align: center;
}

header h2 {
	margin-top: 20px;
	margin-bottom: 30px;
}

.panel {
	border: 0;
}

.panel-info .panel-heading {
	border-radius: 0;
	background: transparent;
}

.panel-info .panel-heading a {
	text-decoration: none;
	color: #000000;
	font-size: 13px;
}

.panel-info .panel-heading a:hover {
	text-decoration: underline;
	color: #31708F;
}

.panel-info .panel-body {
	text-align: center;
}

.panel-info>.panel-heading {
	color: #983a3a;
	border-color: #d3d3d3;
}

tr th {
	text-align: center;
}
</style>
<script src="js/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>

<body>
	<header>
		<h2>欢迎进入图书管理系统</h2>
	</header>
	<section>
		<div class="panel panel-info">
			<div class="panel-heading">
				最近添加书籍 <a href="book_query.jsp" class="pull-right">更多 》</a>
			</div>
			<div class="panel-body">
				<table class="table table-hover">
					<tr class="active">
						<th>书名</th>
						<th>作者</th>
						<th>出版社</th>
						<th>类型</th>
						<th>时间</th>
					</tr>
					<c:forEach var="book" items="${newBook}">
						<tr>
							<td>${book.bName }</td>
							<td>${book.author }</td>
							<td>${book.publish }</td>
							<td>${book.bType }</td>
							<td>${book.date }</td>
						</tr>
					</c:forEach>
				</table>

			</div>
		</div>
	</section>
</body>

</html>