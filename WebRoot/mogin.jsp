<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="jsp/common/_frag/include/include.inc.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>社团管理系统后台登录页面</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<link rel="stylesheet" type="text/css" href="css/style.css" />
	<link rel="stylesheet" type="text/css" href="css/body.css"/> 
</head>
<body>
	<div class="container">
	<section id="content">
		<form action="user!login.action">
			<h1>后台登录</h1>
			<div>
				<input type="text" placeholder="用户名" name="user.username" required="" id="username" />
			</div>
			<div>
				<input type="password" placeholder="密码" name="user.password" required="" id="password" />
			</div>
			 <div class="">
				<span class="help-block u-errormessage" id="js-server-helpinfo">&nbsp;</span>			</div> 
			<div>
				<!-- <input type="submit" value="Log in" /> -->
				<input type="submit" value="登录" class="btn btn-primary" id="js-btn-login" />
				<!-- <a href="#">忘记密码?</a> -->
				<!-- <a href="#">Register</a> -->
			</div>
		</form><!-- form -->
	</section><!-- content -->
</div>
<!-- container -->
</body>
</html>