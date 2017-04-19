<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>社团管理系统学生客户页面</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="js/jquery-1.9.0.min.js"></script>
<script type="text/javascript" src="images/login.js"></script>
<link href="css/login2.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<h1>
		社团管理系统学生客户页面<sup>V2017</sup>
	</h1>

	<div class="login" style="margin-top:50px;">
		<div class="header">
			<div class="switch" id="switch">
				<a class="switch_btn_focus" id="switch_qlogin"
					href="javascript:void(0);" tabindex="7">快速登录</a> <a
					class="switch_btn" id="switch_login" href="javascript:void(0);"
					tabindex="8">快速注册</a>
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
						<form action="user!login.action" name="loginform"
							accept-charset="utf-8" id="login_form" class="loginForm"
							method="post">
							<input type="hidden" name="user.user_type" value="1" />
							<div align="center">${loginFlag}</div>
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
				<form id="regUser" accept-charset="utf-8"
					action="user!register.action" method="post">
					<input type="hidden" name="to" value="reg" /> <input type="hidden"
						name="did" value="0" />

					<ul class="reg_form" id="reg-ul">
						<div align="center">${message}</div>
						<li><label for="user" class="input-tips2">用户名：</label>
							<div class="inputOuter2">
								<input type="text" name="user.username" maxlength="16"
									class="inputstyle2" />
							</div></li>

						<li><label for="passwd" class="input-tips2">密码：</label>
							<div class="inputOuter2">
								<input type="password" name="user.password" maxlength="16"
									class="inputstyle2" />
							</div></li>
						<li><label for="passwd2" class="input-tips2">确认密码：</label>
							<div class="inputOuter2">
								<input type="password" name="newPassword" maxlength="16"
									class="inputstyle2" />
							</div></li>
						<li><label for="qq" class="input-tips2">学生姓名：</label>
							<div class="inputOuter2">
								<input type="text" name="user.user_name" maxlength="10"
									class="inputstyle2" />
							</div></li>
						<li><label for="qq" class="input-tips2">学号：</label>
							<div class="inputOuter2">
								<input type="text" name="user.user_id" maxlength="10"
									class="inputstyle2" />
							</div></li>

						<li><label for="qq" class="input-tips2">联系电话：</label>
							<div class="inputOuter2">

								<input type="text" name="user.user_tel" maxlength="10"
									class="inputstyle2" />
							</div></li>

						<input type="hidden" name="user.user_type" maxlength="10"
							class="inputstyle2" value="1" />

						<li>
							<div class="inputArea">
								<input type="submit" id="reg"
									style="margin-top:10px;margin-left:85px;" class="button_blue"
									value="注册" />
							</div>
						</li>
				</form>
			</div>
		</div>
		<!--注册end-->
	</div>
	<div class="jianyi">*推荐使用ie8或以上版本ie浏览器或Chrome内核浏览器访问本站</div>
</body>
</html>