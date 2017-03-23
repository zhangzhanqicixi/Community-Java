	<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="jsp/common/_frag/include/include.inc.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1
-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>校园活动信息管理系统</title>
<link href="css/login.css" rel="stylesheet" rev="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="js/jQuery1.7.js"></script>
<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="js/jquery1.42.min.js"></script>
<script type="text/javascript" src="js/jquery.SuperSlide.js"></script>
<!-- 这个需要账号密码验证的时候可以用到 -->
<!-- 
	<script type="text/javascript" src="js/Validform_v5.3.2_min.js"></script>
 -->
<script type="text/javascript">
	$(document).ready(function() {
		var $tab_li = $('#tab ul li');
		$tab_li.hover(function() {
			$(this).addClass('selected').siblings().removeClass('selected');
			var index = $tab_li.index(this);
			$('div.tab_box > div').eq(index).show().siblings().hide();
		});
	});
</script>
<script type="text/javascript">
	$(function() {
		/*业主登录信息验证*/
		$("#stu_username_hide").focus(function() {
			var username = $(this).val();
			if (username == '输入账号') {
				$(this).val('');
			}
		});
		$("#stu_username_hide").focusout(function() {
			var username = $(this).val();
			if (username == '') {
				$(this).val('输入账号');
			}
		});
		$("#stu_password_hide").focus(function() {
			var username = $(this).val();
			if (username == '输入密码') {
				$(this).val('');
			}
		});
		$("#stu_password_hide").focusout(function() {
			var username = $(this).val();
			if (username == '') {
				$(this).val('输入密码');
			}
		});
		$("#stu_code_hide").focus(function() {
			var username = $(this).val();
			if (username == '输入验证码') {
				$(this).val('');
			}
		});
		$("#stu_code_hide").focusout(function() {
			var username = $(this).val();
			if (username == '') {
				$(this).val('输入验证码');
			}
		});
		$(".stu_login_error").Validform({
			tiptype : function(msg, o, cssctl) {
				var objtip = $(".stu_error_box");
				cssctl(objtip, o.type);
				objtip.text(msg);
			},
			ajaxPost : true
		});
		/*物业登录信息验证*/
		$("#tea_username_hide").focus(function() {
			var username = $(this).val();
			if (username == '输入账号') {
				$(this).val('');
			}
		});
		$("#tea_username_hide").focusout(function() {
			var username = $(this).val();
			if (username == '') {
				$(this).val('输入账号');
			}
		});
		$("#tea_password_hide").focus(function() {
			var username = $(this).val();
			if (username == '输入密码') {
				$(this).val('');
			}
		});
		$("#tea_password_hide").focusout(function() {
			var username = $(this).val();
			if (username == '') {
				$(this).val('输入密码');
			}
		});
		$("#tea_code_hide").focus(function() {
			var username = $(this).val();
			if (username == '输入验证码') {
				$(this).val('');
			}
		});
		$("#tea_code_hide").focusout(function() {
			var username = $(this).val();
			if (username == '') {
				$(this).val('输入验证码');
			}
		});
		$(".tea_login_error").Validform({
			tiptype : function(msg, o, cssctl) {
				var objtip = $(".tea_error_box");
				cssctl(objtip, o.type);
				objtip.text(msg);
			},
			ajaxPost : true
		});
		/*管理员登录信息验证*/
		$("#sec_username_hide").focus(function() {
			var username = $(this).val();
			if (username == '输入账号') {
				$(this).val('');
			}
		});
		$("#sec_username_hide").focusout(function() {
			var username = $(this).val();
			if (username == '') {
				$(this).val('输入账号');
			}
		});
		$("#sec_password_hide").focus(function() {
			var username = $(this).val();
			if (username == '输入密码') {
				$(this).val('');
			}
		});
		$("#sec_password_hide").focusout(function() {
			var username = $(this).val();
			if (username == '') {
				$(this).val('输入密码');
			}
		});
		$("#sec_code_hide").focus(function() {
			var username = $(this).val();
			if (username == '输入验证码') {
				$(this).val('');
			}
		});
		$("#sec_code_hide").focusout(function() {
			var username = $(this).val();
			if (username == '') {
				$(this).val('输入验证码');
			}
		});
		$(".sec_login_error").Validform({
			tiptype : function(msg, o, cssctl) {
				var objtip = $(".sec_error_box");
				cssctl(objtip, o.type);
				objtip.text(msg);
			},
			ajaxPost : true
		});
	});
</script>
<script type="text/javascript">
	$(function() {
		$(".screenbg ul li").each(function() {
			$(this).css("opacity", "0");
		});
		$(".screenbg ul li:first").css("opacity", "1");
		var index = 0;
		var t;
		var li = $(".screenbg ul li");
		var number = li.size();
		function change(index) {
			li.css("visibility", "visible");
			li.eq(index).siblings().animate({
				opacity : 0
			}, 3000);
			li.eq(index).animate({
				opacity : 1
			}, 3000);
		}
		function show() {
			index = index + 1;
			if (index <= number - 1) {
				change(index);
			} else {
				index = 0;
				change(index);
			}
		}
		t = setInterval(show, 8000);
		//根据窗口宽度生成图片宽度
		var width = $(window).width();
		$(".screenbg ul img").css("width", width + "px");
	});
</script>
</head>

<body>
<div id="tab">
  <ul class="tab_menu">
    <li class="selected">学生登录</li>
    <li>社长登录</li>
    <li>管理员登录</li>
  </ul>
  <div class="tab_box"> 
    <!-- 学生登录开始 -->
    <div>
      <div class="stu_error_box"></div>
      <form action="user!login.action" method="post" class="stu_login_error">
      <input type="hidden" name="user.user_type" value="1" />
      		  <c:if test="${!empty loginFlag}">
				<p style="color: red">${loginFlag}</p>
			</c:if>
        <div id="username">
          <label>账&nbsp;&nbsp;&nbsp;号：</label>
          <input type="text" id="stu_username_hide" name="user.username" value="" nullmsg="账号不能为空！" datatype="s3-18" errormsg="账号范围在3~18个字符之间！" sucmsg="账号验证通过！"/>
          <!--ajaxurl="demo/valid.jsp"--> 
        </div>
        <div id="password">
          <label>密&nbsp;&nbsp;&nbsp;码：</label>
          <input type="password" id="stu_password_hide" name="user.password" value="" nullmsg="密码不能为空！" datatype="*6-16" errormsg="密码范围在6~16位之间！" sucmsg="密码验证通过！"/>
        </div>
        <div id="login">
          <button type="submit">登录</button>
        </div>
      </form>
    </div>
   <!-- 学生登录结束-->
   <!-- 社长登录开始-->
    <div class="hide">
     <div class="tea_error_box"></div>
      <form action="user!login.action" method="post" class="tea_login_error">
        <input type="hidden" value="2" name="user.user_type" />
             <c:if test="${!empty loginFlag}">
				<p style="color: red">${loginFlag}</p>
			</c:if>
        <div id="username">
          <label>账&nbsp;&nbsp;&nbsp;号：</label>
          <input type="text" id="tea_username_hide" name="user.username" value="" nullmsg="帐号不能为空！"  datatype="*3-16" errormsg="账号范围在3~18个字符之间！"  sucmsg="账号验证通过！"/>
          <!--ajaxurl="demo/valid.jsp"--> 
        </div>
        <div id="password">
          <label>密&nbsp;&nbsp;&nbsp;码：</label>
          <input type="password" id="tea_password_hide" name="user.password" value="" nullmsg="密码不能为空！" datatype="*6-16" errormsg="密码范围在6~16位之间！" sucmsg="密码验证通过！"/>
        </div>
        <div id="login">
          <button type="submit">登录</button>
        </div>
      </form>
    </div>
     <!-- 社长登录结束-->
     <!-- 管理员登录开始-->
    <div class="hide">
    <div class="sec_error_box"></div>
      <form action="user!login.action" method="post" class="sec_login_error">
         <input type="hidden" value="3" name="user.user_type"/>
             <c:if test="${!empty loginFlag}">
				<p style="color: red">${loginFlag}</p>
			</c:if>
        <div id="username">
          <label>账&nbsp;&nbsp;&nbsp;号：</label>
          <input type="text" id="sec_username_hide" name="user.username" value="" nullmsg="账号不能为空！" datatype="s3-18" errormsg="账号范围在3~18个字符之间！" sucmsg="账号验证通过！"/>
          <!--ajaxurl="demo/valid.jsp"--> 
        </div>
        <div id="password">
          <label>密&nbsp;&nbsp;&nbsp;码：</label>
          <input type="password" id="sec_password_hide" name="user.password" value="" nullmsg="密码不能为空！" datatype="*6-16" errormsg="密码范围在6~16位之间！" sucmsg="密码验证通过！"/>

        </div>
        <div id="login">
          <button type="submit">登录</button>
        </div>
      </form>
    </div>
     <!-- 管理员登录结束-->
  </div>
</div>
<div class="bottom">©2017 xxxxxx <a href="javascript:;" target="_blank">关于</a> <span>浙ICP证xxxxxx号</span><img width="13" height="16" src="images/copy_rignt_24.png" /></div>
<div class="screenbg">
  <ul>
    <li><a href="javascript:;"><img src="images/index_3.png"></a></li>
  </ul>
</div>
</body>
</html>
