<%@page contentType="text/html; charset=utf-8"%>
<%@ include file="../_frag/include/include.inc.jsp"%>

<div class="pageContent">
	
		<form method="post" action="doReg_College.action?navTabId=addCollege_manager&callbackType=closeCurrent" enctype="multipart/form-data" class="pageForm required-validate" onsubmit="return iframeCallback(this,navTabAjaxDone);">
	
	<!--  <form method="post" enctype="multipart/form-data" action="applicationActivityCollege_Activity.action?navTabId=application_activity&callbackType=closeCurrent" class="required-validate pageForm" onsubmit="return validateCallback(this, navTabAjaxDone);">
		-->
		<div class="pageFormContent" layoutH="56">
			
			<div class="unit">
				<label>用户名：</label>
				<input type="text" name="user.username"  size="30" maxlength="10" class="required"/>
			</div>
			<div class="unit">
				<label>输入密码：</label>
				<input type="password" name="user.password" size="30" maxlength="10" class="required"/>
			</div>
			<input type="hidden" value="2" name="user.roleId">
			<div class="unit">
				<label>确认密码：</label>
				<input type="password" name="passwordConfirm"  size="30" class="required"/>
			</div>
			<div class="unit">
				<label>社团名称：</label>
				<input type="text" name="college.collegeName" size="30" class="required"/>
			</div>
			<div class="unit">
				<label>社团简介：</label>
				<input type="text" name="college.collegeMotto" size="30" class="required" />
			</div>
			<div class="unit">
				<label>成立时间：</label>
				<input type="date" name="college.buildTime" size="30" class="required" />
			</div>
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">注册</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div></li>
			</ul>
		</div>
	</form>
</div>

