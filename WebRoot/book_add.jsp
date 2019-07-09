<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>图书添加</title>
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
		<script src="js/bootstrap.min.js"></script>
		<style type="text/css">
			body {
				padding: 10px;
				background: #d0c7b2b8;
			}
			
			header {
				text-align: center;
			}
			
			header h2 {
				/* margin-top: 20px; */
				/* margin-bottom: 30px; */
			}
			
			.box {
				border-radius: 10px;
				width: 400px;
				height: auto;
				margin: auto;
			}
			table {
				width: 400px;
				margin: auto;
			}
			
			table tr {
				height: 40px;
			}
			
			table tr:last-child {
				height: 60px;
				text-align: center;
			}
			
			table tr td:FIRST-CHILD {
				width: 100px;
				text-align: left;
			}
			
			table tr:last-child td{
				text-align: center;
			}
			
		</style>
		<script src="js/jquery.js"></script>
		<script src="js/bootstrap.min.js"></script>
	</head>

	<body>
		<header>
			<h2>请输入图书信息</h2>
		</header>
		<div class="box">
			<form action="BookServlet?do=add" method="post">
				<table>
					<tr>
						<td>编号</td>
						<td><input type="text" name="bId" class="form-control" id="bId"></td>
					</tr>
					<tr>
						<td>书名</td>
						<td><input type="text" name="bName" class="form-control" id="bName"></td>
					</tr>
					<tr>
						<td>作者</td>
						<td><input type="text" name="author" class="form-control" id="author"></td>
					</tr>
					<tr>
						<td>出版社</td>
						<td><input type="text" name="publish" class="form-control" id="publish"></td>
					</tr>
					<tr>
						<td>类型</td>
						<td><input type="text" name="bType" class="form-control" id="bType"></td>
					</tr>
					<tr>
						<td>总数量</td>
						<td><input type="text" name="count" class="form-control" id="count"></td>
					</tr>
					<tr>
						<td>剩余数量</td>
						<td><input type="text" name="remain" class="form-control" id="remain"></td>
					</tr>
					<tr>
						<td>添加时间</td>
						<td><input type="date" name="date" class="form-control" id="date" placeholder="格式为----/--/--"></td>
					</tr>
					<tr>
						<td colspan="2" align="center">
							<input type="submit" class="btn btn-info" value="确定" /><br />
							<font style="color: red;">${message }</font>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</body>

</html>