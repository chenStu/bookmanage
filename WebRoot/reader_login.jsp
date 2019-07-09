<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>读者登录</title>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css" />
	<style type="text/css">
	body{
		background: #d0c7b2b8;
	}
	
	.left{
		width: 600px;
		height: 400px;
		position: fixed;
		left: 15%;
		top: 18%;
		background-image: url("img/index.png");
		background-repeat: no-repeat;
		background-position: center;
	}
	
	form {
		padding: 0 0 10px 0;
	}
	
	.box {
		position: fixed;
		right: 20%;
		width: auto;
		height: 250px;
		top: 25%;
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
	
	.form-control {
		padding: 6px 22px;
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
	
	input[type=checkbox] {
		position: absolute;
		width: 14px;
		height: 14px;
	}
	
	label p {
		margin: 0 20px;
	}
	.mess{
		text-align: center;
		position: relative;
	}
.form-horizontal .checkbox, .form-horizontal .checkbox-inline, .form-horizontal .radio, .form-horizontal .radio-inline {
    padding-top: 0px;
    margin-top: -2px;
}
</style>
	<script src="js/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script type="text/javascript">
		function check() {
			var rId = document.getElementById("rId");
			var pwd = document.getElementById("password");
			if (rId.value == "") {
				alert("学工号不能为空！");
				return false;
			}
			if (pwd.value == "") {
				alert("密码不能为空！");
				return false;
			}
		}
	</script>
</head>
<body>
	<div class="left"></div>
	<div class="box">
		<div class="title">读者登录</div>
		<form onsubmit="return check();" class="form-horizontal" action="LoginServlet?identify=reader" method="post">
			<div class="form-group">
				<label> <span class="fa fa-user icon"></span> <input
					type="text" name="rId" class="form-control" id="rId"
					placeholder="请输入账号"> </label>
			</div>
			<div class="form-group">
				<label> <span class="fa fa-lock icon"></span> <input
					type="password" name="password" class="form-control" id="password"
					placeholder="请输入密码"> </label>
			</div>
			<div class="form-group text-center" style="margin-bottom: 2px">
				<input type="submit" class="btn btn-default sub" value="登录" />
				
			</div>
			<div class="mess">
				<font color="red">${message }</font>
			</div>
		</form>
	</div>
</body>
</html>