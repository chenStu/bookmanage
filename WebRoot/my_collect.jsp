<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>我的收藏</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
<script src="js/bootstrap.min.js"></script>
<style type="text/css">
body {
	background: #d0c7b2b8;
}

header {
	text-align: center;
}

header h2 {
	margin-top: 20px;
}

.box {
	border-radius: 10px;
	width: 100%;
	height: auto;
	margin: auto;
}

.table {
	background: #fff;
	margin-bottom: 0;
}

tr th {
	text-align: center;
}

.btn-primary {
	background: #bb6262;
	border-color: #bb6262;
}

.btn-primary:hover {
	background: #bb6262;
	border-color: #bb6262;
}

.btn-primary.active.focus,.btn-primary.active:focus,.btn-primary.active:hover,.btn-primary:active.focus,.btn-primary:active:focus,.btn-primary:active:hover,.open>.dropdown-toggle.btn-primary.focus,.open>.dropdown-toggle.btn-primary:focus,.open>.dropdown-toggle.btn-primary:hover
	{
	background: #bb6262;
	border-color: #bb6262;
}

.panel-body {
	padding-top: 0;
}
</style>
<script src="js/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>

<body>
	<header>
		<h2>我的收藏</h2>
	</header>
	<div class="text-center">
		<font color="red">${message }</font>
	</div>
	<div class="box text-center">
		<div class="panel-body">
			<table class="table table-hover table-bordered center">
				<tr class="active" disabled>
					<th>编号</th>
					<th>书名</th>
					<th>作者</th>
					<th>出版社</th>
					<th>类型</th>
					<th>操作</th>
				</tr>
				<c:forEach var="collections" items="${collections }">
					<tr>
						<th>${collections.bId }</th>
						<th>${collections.bName }</th>
						<th>${collections.author }</th>
						<th>${collections.publish }</th>
						<th>${collections.bType }</th>
						<th><a href="ReaderServlet?do=delCollection&id=${login.rId }&bName=${collections.bName }"
							title="点击删除"><span class="glyphicon glyphicon-remove"></span>
						</a></th>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>

</html>