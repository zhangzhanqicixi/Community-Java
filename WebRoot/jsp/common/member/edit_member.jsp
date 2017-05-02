<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../_frag/include/include.inc.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<h2 class="contentTitle">成员详情</h2>


<div class="pageContent">
	<form method="post" enctype="multipart/form-data"
		action="member!confirm.action?callbackType=closeCurrent"
		class="pageForm required-validate"
		onsubmit="return iframeCallback(this, navTabAjaxDone);">
		<div class="pageFormContent nowrap" layoutH="97">
			<input value="${user.id}" type="hidden" name="user.id" />
			<input value="${member.id}" type="hidden" name="uid" />
			<dl>
				<dt>学生姓名：</dt>
				<dd>
					<input type="text" name="user.user_name" readonly="readonly" value="${user.user_name}"/>
				</dd>
			</dl>
			<dl>
				<dt>学生照片：</dt>
				<dd>
					<img alt="${user.user_name}" src="${user.user_img}" height="250px" >
				</dd>
			</dl>
			<dl>
				<dt>申请理由：</dt>
				<dd>
					<input type="text" readonly="readonly" value="${member.member_apply_reason}"/>
				</dd>
			</dl>
			<dl>
				<dt>学生学号：</dt>
				<dd>
					<input type="text" name="user.user_id" readonly="readonly" value="${user.user_id}"/>
				</dd>
			</dl>
			<dl>
				<dt>联系电话：</dt>
				<dd>
					<input type="text" name="user.user_tel" readonly="readonly" value="${user.user_tel}"/>
				</dd>
			</dl>
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive">
						<div class="buttonContent">
							<button type="submit">通过</button>
						</div>
					</div></li>
				<li><div class="button">
						<div class="buttonContent">
							<button type="button" class="close">取消</button>
						</div>
					</div></li>
			</ul>
		</div>
	</form>
</div>


<script type="text/javascript">
	function customvalidXxx(element) {
		if ($(element).val() == "xxx")
			return false;
		return true;
	}
</script>
