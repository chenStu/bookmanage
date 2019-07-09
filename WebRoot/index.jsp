<!--<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>-->
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<style type="text/css">
body {
	background: #d0c7b2b8;
	margin: 0;
}

#header div{
	width: 100%;
	height: 150px;
	padding-top: 60px;
	background: url(img/header.png) no-repeat;
	background-position: center;
	background-size: cover;
}

.box {
	width: 150px;
	margin: 8% auto;
	text-align: center;
}

.box a {
	border-radius: 15px;
	padding: 13px 25px;
	background: #b99e69;
	color: #FFFFFF;
	text-decoration: none;
	font-weight: bold;
	font-size: 20px;
}
</style>
</head>

<body>
	<header id="header">
		<div></div>
	</header>
	<div class="box">
		<a href="manager_login.jsp">管理员入口</a><br />
		<br />
		<br />
		<br />
		<a href="reader_login.jsp">读者入口</a>
	</div>
</body>

</html>