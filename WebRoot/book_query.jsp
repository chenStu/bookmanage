<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>图书查询</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
<script src="js/bootstrap.min.js"></script>
<style type="text/css">
body {
	background: #d0c7b2b8;
}

header {
	text-align: center;
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
    padding: 12px 15px 0 15px;
}
</style>
<script src="js/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>

<body>
	<header>
		<h2>查询图书</h2>
	</header>
	<div class="box text-center">
		<font style="color: red;">${message }</font>
		<div class="panel-body">
			<table class="table table-hover table-bordered center">
				<tr class="active">
					<th>编号</th>
					<th>书名</th>
					<th>作者</th>
					<th>出版社</th>
					<th>类型</th>
					<th>总数量</th>
					<th>剩余数量</th>
					<th colspan="2">操作</th>
				</tr>
				<c:forEach var="allBook" items="${allBook }">
					<tr>
						<th>${allBook.bId }</th>
						<th>${allBook.bName }</th>
						<th>${allBook.author }</th>
						<th>${allBook.publish }</th>
						<th>${allBook.bType }</th>
						<th>${allBook.count }</th>
						<th>${allBook.remain }</th>
						<c:if test="${identify=='manager' }">
							<th><a href="BookServlet?id=${allBook.bId }&do=find"
								title="点击编辑"><span class="glyphicon glyphicon-edit"></span>
							</a>
							</th>
							<th><a
								href="javascript:del('${allBook.bId }','${allBook.bName }');"
								title="点击删除"><span class="glyphicon glyphicon-remove"></span>
							</a>
							</th>
						</c:if>
						<c:if test="${identify=='reader' }">
							<th><a href="BookServlet?do=addCollection&id=${allBook.bId }&rId=${login.rId }" title="点击收藏"><span
									class="glyphicon glyphicon-heart"></span> </a>
							</th>
							<th><a
								href="javascript:borrow('${allBook.bName }','${allBook.author }','${login.rId }','${login.rName }');"
								title="点击借阅"><span class="glyphicon glyphicon-plus"></span>
							</a>
							</th>
						</c:if>
					</tr>
				</c:forEach>
				<tr>
					<th colspan="9">
						<a href="BookServlet?do=all&page=${pages.firstPage }" title="首页">&lt;&lt;首页</a>
						<a href="BookServlet?do=all&page=${pages.curPage-1 }" title="点击收藏">&lt;上一页</a>
						<strong>第${pages.curPage}页/共${pages.totalPages}页</strong>
						<a href="BookServlet?do=all&page=${pages.curPage+1 }" title="点击收藏">下一页&gt;</a>
						<a href="BookServlet?do=all&page=${pages.totalPages }" title="点击收藏">尾页&gt;&gt;</a><br>
						<font>共有${pages.totalItems }本</font>
					</th>
				</tr>
			</table>
		</div>
	</div>
	<script type="text/javascript">
		function del(id, name) {
			var rel = confirm("确定删除《" + name + "》这本书吗?");
			if (rel) {
				location.assign("BookServlet?do=del&id=" + id);
			}
		}

		function borrow(bname, author, id, rname) {
			var rel = confirm("确定借阅《" + bname + "》这本书吗?");
			if (rel) {
				location.assign("BookServlet?do=borrowbook&bName=" + bname
						+ "&author=" + author + "&id=" + id + "&name=" + rname);
			}
		}
	</script>
</body>
</html>