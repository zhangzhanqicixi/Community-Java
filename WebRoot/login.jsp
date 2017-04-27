<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="jsp/common/_frag/include/include.inc.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>社团管理系统学生登录页面</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<script type="text/javascript" src="js/jquery-1.9.0.min.js"></script>
	<script type="text/javascript" src="images/login.js"></script>
	<link href="css/login2.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<h1>
		社团管理系统登录<sup>V2017</sup>
	</h1>

	<div class="login" style="margin-top:50px;">

		<div class="header">
			<div class="switch" id="switch">
				<a class="switch_btn_focus" id="switch_qlogin"
					href="javascript:void(0);" tabindex="7">学生登录</a> <a
					class="switch_btn" id="switch_login" href="javascript:void(0);"
					tabindex="8">账号注册</a>
				<div class="switch_bottom" id="switch_bottom"
					style="position: absolute; width: 64px; left: 0px;"></div>
			</div>
		</div>


		<div class="web_qr_login" id="web_qr_login"
			style="display: block; height: 235px;">

			<!--登录-->
			<div class="web_login" id="web_login">
				<div class="login-box">
					<div class="login_form">
						<form action="user!homepage_login.action" name="loginform"
							accept-charset="utf-8" id="login_form" class="loginForm"
							method="post">
							<h4 align="center" style="color: red;"> ${flag} </h4>
							<input type="hidden" name="did" value="0" /> <input
								type="hidden" name="to" value="log" />
							<div class="uinArea" id="uinArea">
								<label class="input-tips" for="u">帐号：</label>
								<div class="inputOuter" id="uArea">
									<input type="text" id="u" name="user.username"
										class="inputstyle" />
								</div>
							</div>
							<div class="pwdArea" id="pwdArea">
								<label class="input-tips" for="p">密码：</label>
								<div class="inputOuter" id="pArea">
									<input type="password" id="p" name="user.password"
										class="inputstyle" />
								</div>
							</div>

							<div style="padding-left:50px;margin-top:20px;">
								<input type="submit" value="登 录" style="width:150px;"
									class="button_blue" />
							</div>
						</form>
					</div>

				</div>

			</div>
			<!--登录end-->
		</div>

		<!--注册-->
		<div class="qlogin" id="qlogin" style="display: none; ">
			<div class="web_login">
				<form name="form2" id="regUser" accept-charset="utf-8" action="user!register.action"
					method="post">
					<input type="hidden" name="to" value="reg" /> 
					<input type="hidden" name="did" value="0" />
					<ul class="reg_form" id="reg-ul">
					<h4 align="center" style="color: red;" id='userCue'> ${flag} </h4>
						<li><label for="user" class="input-tips2">用户名：</label>
							<div class="inputOuter2">
								<input type="text" id="user" name="user.username" maxlength="16"
									class="inputstyle2" />
							</div></li>

						<li><label for="passwd" class="input-tips2">密码：</label>
							<div class="inputOuter2">
								<input type="password" id="passwd" name="user.password" maxlength="16"
									class="inputstyle2" />
							</div></li>
						<li><label for="passwd2" class="input-tips2">确认密码：</label>
							<div class="inputOuter2">
								<input type="password" id="passwd2" name="password" maxlength="16"
									class="inputstyle2" />
							</div></li>
						<li><label for="user_name" class="input-tips2">昵称：</label>
							<div class="inputOuter2">

								<input type="text" id="user_name" name="user.user_name"
									maxlength="10" class="inputstyle2" />
							</div></li>
						<li><label for="user_id" class="input-tips2">学号：</label>
							<div class="inputOuter2">

								<input type="text" id="user_id" name="user.user_id" maxlength="10"
									class="inputstyle2" />
							</div></li>

						<li><label for="tel" class="input-tips2">联系电话：</label>
							<div class="inputOuter2">

								<input type="text" id="tel" name="user.user_tel" maxlength="10"
									class="inputstyle2" />
							</div></li>

						<div class="inputArea">
							<input type="button" id="reg"
								style="margin-top:10px;margin-left:90px;" class="button_blue"
								value="注册账号" />
						</div>
						<div class="cl"></div>
					</ul>
				</form>


			</div>


		</div>
		<!--注册end-->
	</div>
	<div class="jianyi">*推荐使用ie8或以上版本ie浏览器或Chrome内核浏览器访问本站</div>
</body>
</html>