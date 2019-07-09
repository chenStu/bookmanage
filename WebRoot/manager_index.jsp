<%@ page language="java" import="java.util.*,com.bean.*"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员主页</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css" />
<script src="js/bootstrap.min.js"></script>
<style type="text/css">
body {
	background: #d0c7b2b8;
}

header {
	width: 100%;
	height: 160px;
	background: url(img/header.png) no-repeat;
	background-position: center;
	background-size: cover;
}

.navbar-default,.container-fluid {
	border-radius: 0;
	border: 0;
	background: #b99e69;
	height: 60px;
	margin-bottom: 0;
}

.navbar-default .dropdown {
	width: 100px;
	text-align: center;
}

.navbar-default .dropdown .dropdown-menu {
	min-width: 100px;
}

.navbar-default .navbar-nav>li>a {
	color: #ffffff;
}

.navbar-nav>li>a {
	padding-top: 20px;
	padding-bottom: 20px;
}

.navbar-default .navbar-nav>.open>a,.navbar-default .navbar-nav>.open>a:focus,.navbar-default .navbar-nav>.open>a:hover
	{
	color: #983a3a;
	background-color: transparent;
}

.navbar-default .navbar-nav>li>a:hover,.navbar-default .navbar-nav>li>a:focus
	{
	color: #983a3a;
	background-color: transparent;
}

.navbar-default .dropdown {
	width: auto;
}
.navbar-right .dropdown-menu {
    left: 0;
}
.dropdown-menu{
	text-align: center;
}
#section {
	position: relative;
	height: 465px;
}

#footer {
	width: 100%;
	bottom: 0;
	background: #b99e69;
	position: fixed;
	padding: 10px 0;
	text-align: center;
}
</style>
<script src="js/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>
<body>
	<header id="header"> </header>
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="BookServlet?do=new" target="bottomContent">首页</a>
					</li>
					<li><a href="BookServlet?do=all" target="bottomContent">图书查询</a>
					</li>
					<li><a href="book_add.jsp" target="bottomContent">图书添加</a>
					</li>
					<li><a href="BookServlet?do=borrow" target="bottomContent">图书借阅信息</a>
					</li>
					<li><a href="ReaderServlet?do=all" target="bottomContent">读者信息查询</a>
					</li>
					<li><a href="reader_register.jsp" target="bottomContent">读者信息添加</a>
					</li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false"> 当前管理员：${login.mId }<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="manager_information.jsp" target="bottomContent">个人信息</a>
							</li>
							<li><a href="updatePwd.jsp" target="bottomContent">修改密码</a>
							</li>
							<li><a href="manager_register.jsp" target="bottomContent">添加管理员</a>
							</li>
							<li><a href="LoginServlet?exit=1">退出</a></li>
						</ul>
					</li>
					<li><a>在线人数 【${onlineUserNum }】</a>
					</li>
				</ul>
			</div>
		</div>
	</nav>
	<section id="section">
		<iframe src="BookServlet?do=new" name="bottomContent"
			style="position: absolute;border: 0;width: 100%;height: 100%;">

		</iframe>
	</section>
	<div id="footer">© 图书馆管理系统 - 版权所有</div>
</body>
</html>