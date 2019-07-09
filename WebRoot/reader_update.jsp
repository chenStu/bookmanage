<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>读者信息修改</title>
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

table tr:last-child {
	height: 100px;
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
		<h2>读者信息修改</h2>
		<form action="ReaderServlet?do=upd&rId=${login.rId }" method="post">
			<table>
				<tr>
					<td>学号</td>
					<td>${login.rId }</td>
				</tr>
				<tr>
					<td>姓名</td>
					<td><input type="text" name="rName" class="form-control"
						value="${login.rName }">
					</td>
				</tr>
				<tr>
					<td>性别</td>
					<td><label class="radio-inline"> <input type="radio"
							name="rSex" id="inlineRadio1" value="男" ${login.rSex=='男' ? 'checked': '' }>男
					</label> <label class="radio-inline"> <input type="radio"
							name="rSex" id="inlineRadio2" value="女" ${login.rSex=='女' ? 'checked': '' }>女
					</label></td>
				</tr>
				<tr>
					<td>电话</td>
					<td><input type="tel" name="rTel" class="form-control"
						value="${login.rTel }">
					</td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" class="btn btn-info"
						value="确定" /><br /> <font style="color: red;">${message }</font>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>

</html>