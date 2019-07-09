<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>读者信息</title>
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

.pagination {
	margin-top: 10px;
	margin-bottom: 0;
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
</style>
<script src="js/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>

<body>
	<header>
		<h2>查询读者</h2>
	</header>
	<div class="box text-center">
		<font style="color: red;">${message }</font>
		<div class="panel-body">
			<table class="table table-hover table-bordered center">
				<tr class="active" disabled>
					<th>姓名</th>
					<th>学号</th>
					<th>性别</th>
					<th>电话</th>
					<th colspan="2">操作</th>
				</tr>
				<c:forEach var="readers" items="${allReader }">
					<tr>
						<th>${readers.rName }</th>
						<th>${readers.rId }</th>
						<th>${readers.rSex }</th>
						<th>${readers.rTel }</th>
						<th><a href="ReaderServlet?do=find&id=${readers.rId }"
							title="点击编辑"><span class="glyphicon glyphicon-edit"></span>
						</a>
						</th>
						<th><a href="javascript:del('${readers.rId }','${readers.rName }');" title="点击移除该读者"><span
								class="glyphicon glyphicon-remove"></span>
						</a>
						</th>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	<script type="text/javascript">
		function del(id, name) {
			var rel = confirm("确定删除读者" + name + "吗?");
			if (rel) {
				location.assign("ReaderServlet?do=del&id=" + id);
			}
		}
	</script>
</body>
</html>