<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../_frag/include/include.inc.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<h2 class="contentTitle">社团管理</h2>


<div class="pageContent">
	<form method="post"
		action="community!update_intro.action?callbackType=closeCurrent"
		class="pageForm required-validate"
		onsubmit="return validateCallback(this, navTabAjaxDone)">
		<div class="pageFormContent nowrap" layoutH="97">
			<input value="${community.id}" type="hidden" name="community.id" />
			<input value="${community.community_name}" type="hidden"
				name="community.community_name" /> <input
				value="${community.proper_name}" type="hidden"
				name="community.proper_name" /> <input
				value="${community.community_img_path}" type="hidden"
				name="community.community_img_path" />
			<dl>
				<dt>社团简介：</dt>
				<dd>
					<textarea class="editor" name="community.community_introduction"
						rows="6" cols="100">${community.community_introduction}</textarea>
					<span class="info">请更新社团简介</span>
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
