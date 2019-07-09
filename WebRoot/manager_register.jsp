<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
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
		var mId = document.getElementById("mId");
		var mName = document.getElementById("mName");
		var pwd1 = document.getElementById("password1");
		var pwd2 = document.getElementById("password2");
		var mTel = document.getElementById("mTel");
		if (mName.value == "") {
			alert("姓名不能为空！");
			return false;
		}
		if (mId.value == ""){
			alert("学工号不能为空！");
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
		if(mTel.value == ""){
			alert("电话不能为空！");
			return false;
		}
	}
</script>
</head>

<body>
	<div class="left"></div>
	<div class="box">
		<div class="title">添加管理员</div>
		<form onsubmit="return check();" class="form-horizontal"
			action="RegisterServlet?identify=manager" method="post">
			<div class="form-group">
				<label> <span class="fa fa-user icon"></span> <input
					type="text" name="mName" class="form-control" id="mName"
					placeholder="请输入姓名"> </label>
			</div>
			<div class="form-group">
				<label> <span class="fa fa-star icon icon_"></span> <input
					type="text" name="mId" class="form-control" id="mId"
					placeholder="请输入学工号"> </label>
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
					type="tel" name="mTel" class="form-control" id="mTel"
					placeholder="请输入电话"> </label>
			</div>
			<div class="form-group">
				<label> <input type="radio" name="mSex" value="男" checked>
					<p>男</p> </label> <label> <input type="radio" name="mSex" value="女">
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