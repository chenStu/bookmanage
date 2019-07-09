<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>重置密码</title>
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
<script type="text/javascript">
	function check() {
		var old = document.getElementById("oldPwd");
		var pwd1 = document.getElementById("newPwd");
		var pwd2 = document.getElementById("pwd");
		if(old.value == "" ){
			alert("旧密码不能为空！");
			return false;
		}
		if (pwd1.value == "") {
			alert("密码不能为空！");
			return false;
		}
		if(pwd1.value.length < 6){
			alert("密码长度必须大于6");
			return false;
		}
		if(old.value == pwd1.value){
			alert("新密码不能与旧密码一样");
			return false;
		}
		if(pwd1.value!=pwd2.value){
			alert("两次密码不一致！");
			return false;
		}
	}
</script>
</head>

<body>
	<div class="box">
		<h2>重置密码</h2>
		<c:if test="${identify=='reader' }">
			<form onsubmit="return check();"
				action="ReaderServlet?do=updPwd&id=${login.rId }" method="post">
				<table>
					<tr>
						<td>旧密码</td>
						<td><input type="password" name="oldPwd" class="form-control"
							id="oldPwd" placeholder="请输入旧密码"></td>
					</tr>
					<tr>
						<td>新密码</td>
						<td><input type="password" name="newPwd" class="form-control"
							id="newPwd" placeholder="请输入新密码"></td>
					</tr>
					<tr>
						<td>确认新密码</td>
						<td><input type="password" name="pwd" class="form-control"
							id="pwd" placeholder="再次输入密码"></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" class="btn btn-info"
							value="确定" /><br> <font color="red">${message}</font></td>
					</tr>
				</table>
			</form>
		</c:if>
		<c:if test="${identify=='manager' }">
			<form onsubmit="return check();"
				action="ManagerServlet?do=updPwd&id=${login.mId }" method="post">
				<table>
					<tr>
						<td>旧密码</td>
						<td><input type="password" name="oldPwd" class="form-control"
							id="oldPwd" placeholder="请输入旧密码"></td>
					</tr>
					<tr>
						<td>新密码</td>
						<td><input type="password" name="newPwd" class="form-control"
							id="newPwd" placeholder="请输入新密码"></td>
					</tr>
					<tr>
						<td>确认新密码</td>
						<td><input type="password" name="pwd" class="form-control"
							id="pwd" placeholder="再次输入密码"></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" class="btn btn-info"
							value="确定" /><br> <font color="red">${message}</font></td>
					</tr>
				</table>
			</form>
		</c:if>
	</div>
</body>

</html>