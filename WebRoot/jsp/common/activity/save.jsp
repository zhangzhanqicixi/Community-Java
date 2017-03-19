<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../_frag/include/include.inc.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<h2 class="contentTitle">社团管理</h2>


<div class="pageContent">

	<form method="post" action="activity!saveOrUpdate.action?callbackType=closeCurrent"
		class="pageForm required-validate"
		onsubmit="return validateCallback(this, navTabAjaxDone)">
		<div class="pageFormContent nowrap" layoutH="97">
			<input value="9999" type="hidden" name="activity.id"/>
			<dl>
				<dt>活动标题：</dt>
				<dd>
					<input value="${activity.activity_title}" type="text" name="activity.activity_title" maxlength="20" class="required" />
					<span class="info">请输入活动标题</span>
				</dd>
			</dl>
			<dl>
				<dt>活动内容：</dt>
				<dd>
					<textarea class="editor" name="activity.activity_content" rows="6"
						cols="100">${activity.activity_content}</textarea>
				</dd>
			</dl>
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive">
						<div class="buttonContent">
							<button type="submit">提交</button>
						</div>
					</div></li>
				<li><div class="button">
						<div class="buttonContent">
							<button type="button" class="close">取消</button>
						</div>
					</div>
				</li>
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
