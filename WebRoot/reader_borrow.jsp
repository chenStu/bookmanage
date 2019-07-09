<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>图书借阅查询</title>
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
		<h2>借阅信息</h2>
	</header>
	<div class="box text-center">
		<font color="red"> ${message }</font>
		<div class="panel-body">
			<table class="table table-hover table-bordered center">
				<tr class="active">
					<th>书名</th>
					<th>作者</th>
					<th>借出时间</th>
					<th>归还时间</th>
					<th>是否归还</th>
					<th>是否损坏</th>
					<th colspan="2">操作</th>
				</tr>
				<c:forEach var="readerBorrow" items="${ReaderBorrow }">
				<tr>
					<th>${readerBorrow.bName }</th>
					<th>${readerBorrow.author }</th>
					<th>${readerBorrow.outtime }</th>
					<th>${readerBorrow.intime }</th>
					<th>${readerBorrow.isreturn }</th>
					<th>${readerBorrow.isdamage }</th>
					<th><a href="javascript:moretime('${readerBorrow.rId }','${readerBorrow.bName }','${readerBorrow.isreturn }');" title="点击续借"><span
							class="glyphicon glyphicon-ok-sign"></span> </a></th>
					<th><a href="javascript:cancel('${readerBorrow.rId }','${readerBorrow.bName }','${readerBorrow.isreturn }');" title="点击归还"><span
							class="glyphicon glyphicon-remove-sign"></span> </a></th>
				</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	<script type="text/javascript">
		function moretime(id, name,isreturn) {
			if(isreturn == '是'){
				alert("你已经归还此书，请重新借阅！");
				return false;
			}
			var rel = confirm("确定续借《" + name + "》这本书吗?");
			if (rel) {
				location.assign("BookServlet?do=moretime&id=" + id +"&name="+name+" ");
			}
		}
		
		function cancel(id, name,isreturn) {
			if(isreturn == '是'){
				alert("你已经归还此书！");
				return false;
			}
			var rel = confirm("确定归还《" + name + "》这本书吗?");
			if (rel) {
				location.assign("BookServlet?do=cancel&id=" + id +"&name="+name+" ");
			}
		}
	</script>
</body>
</html>