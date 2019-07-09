<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>读者添加</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css" />
<script src="js/bootstrap.min.js"></script>
<style type="text/css">
body {
	background: #d0c7b2b8;
}

form {
	padding: 0 0 10px 0;
}

.left {
	width: 600px;
	height: 400px;
	position: fixed;
	left: 15%;
	top: 13%;
	background-image: url("img/index.png");
	background-repeat: no-repeat;
	background-position: center;
}

.box {
	position: fixed;
	top: 4%;
	right: 20%;
	width: 260px;
	height: 422px;
	padding: 0 30px;
	background: #FFFFFF;
	opacity: 0.9;
}

.icon {
	display: block;
	position: absolute;
	margin-top: 8px;
	left: 20px;
	font-size: 20px;
}

.icon_ {
	font-size: 18px;
}

.form-control {
	padding: 6px 25px;
	border-radius: 0;
}

.sub {
	width: 200px;
	font-weight: 700;
	color: #FFFFFF;
	background: #337AB7;
}

.title {
	padding: 25px 0;
	color: #337AB7;
	font-size: 20px;
	font-weight: bold;
}

input[type=radio] {
	position: absolute;
	width: 14px;
	height: 14px;
	margin-left: 10px;
}

label p {
	margin: 0 30px;
}

.form-group {
	margin-bottom: 10px;
}

.res {
	margin-bottom: 0;
}

.mess {
	text-align: center;
	position: relative;
}
</style>
<script src="js/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
<script type="text/javascript">
	function check() {
		var rId = document.getElementById("rId");
		var rName = document.getElementById("rName");
		var pwd1 = document.getElementById("password1");
		var pwd2 = document.getElementById("password2");
		var rTel = document.getElementById("rTel");
		if (rName.value == "") {
			alert("姓名不能为空！");
			return false;
		}
		if (rId.value == ""){
			alert("学号不能为空！");
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
		if(pwd2.value!=pwd1.value){
			alert("两次密码不一致！");
			return false;
		}
		if(rTel.value == ""){
			alert("电话不能为空！");
			return false;
		}
	}
</script>
</head>

<body>
	<div class="left"></div>
	<div class="box">
		<div class="title">添加读者</div>
		<form onsubmit="return check();" class="form-horizontal"
			action="RegisterServlet?identify=reader" method="post">
			<div class="form-group">
				<label> <span class="fa fa-user icon"></span> <input
					type="text" name="rName" class="form-control" id="rName"
					placeholder="请输入姓名"> </label>
			</div>
			<div class="form-group">
				<label> <span class="fa fa-star icon icon_"></span> <input
					type="text" name="rId" class="form-control" id="rId"
					placeholder="请输入学号"> </label>
			</div>
			<div class="form-group">
				<label> <span class="fa fa-lock icon"></span> <input
					type="password" name="password" class="form-control" id="password1"
					placeholder="请输入密码"> </label>
			</div>
			<div class="form-group">
				<label> <span class="fa fa-lock icon"></span> <input
					type="password" class="form-control" id="password2"
					placeholder="再次输入密码"> </label>
			</div>
			<div class="form-group">
				<label> <span class="fa fa-phone icon icon_"></span> <input
					type="tel" name="rTel" class="form-control" id="rTel"
					placeholder="请输入电话"> </label>
			</div>
			<div class="form-group">
				<label> <input type="radio" name="rSex" value="男" checked>
					<p>男</p> </label> <label> <input type="radio" name="rSex" value="女">
					<p>女</p> </label>
			</div>
			<div class="form-group text-center res">
				<input type="submit" class="btn btn-default sub" value="注册" />
			</div>
			<div class="mess">
				<font color="red">${message }</font>
			</div>
		</form>
	</div>
</body>

</html>