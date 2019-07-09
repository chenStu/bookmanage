<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>管理员信息</title>
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
		<style type="text/css">
			body {
				padding: 15px;
				background: #d0c7b2b8;
			}
			
			.box {
				border-radius: 10px;
				width: 400px;
				height: 300px;
				margin: auto;
			}
			
			.box h2 {
				text-align: center;
				margin-bottom: 20px;
			}
			
			table {
				width: 400px;
				margin: auto;
			}
			
			table tr {
				height: 50px;
			}
			
			table tr td {
				width: 200px;
				text-align: center;
			}
		</style>
		<script src="js/jquery.js"></script>
		<script src="js/bootstrap.min.js"></script>
	</head>

	<body>
		<div class="box">
			<h2>管理员信息</h2>
			<table>
				<tr>
					<td>学工号</td>
					<td>${login.mId }</td>
				</tr>
				<tr>
					<td>姓名</td>
					<td>${login.mName }</td>
				</tr>
				<tr>
					<td>性别</td>
					<td>${login.mSex }</td>
				</tr>
				<tr>
					<td>电话</td>
					<td>${login.mTel }</td>
				</tr>
				<tr>
					<td colspan="2">
						<a class="btn btn-danger" href="manager_update.jsp">修改</a>
					</td>
				</tr>
			</table>
		</div>
	</body>
</html>