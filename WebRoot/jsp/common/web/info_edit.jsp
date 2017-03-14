<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../_frag/include/include.inc.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<h2 class="contentTitle">社团管理</h2>


<div class="pageContent">                                                                                                                        geContent">

	<form method="post"
		action="webInfo!saveOrUpdate.action?callbackType=closeCurrent&navTabId=news_edit"
		class="pageForm required-validate"
		onsubmit="return validateCallback(this, navTabAjaxDone)">
		<input type="hidden" name="webInfo.id" value="${webInfo.id}"></input>
		<div class="pageFormContent nowrap" layoutH="97">
			<dl>
				<dt>网站简介：</dt>
				<dd>
					<textarea class="editor" name="webInfo.introduction" rows="6"
						cols="100">${webInfo.introduction}</textarea>
				</dd>
			</dl>
			<dl>
				<dt>联系我们：</dt>
				<dd>
					<textarea class="editor" name="webInfo.contact_us" rows="6"
						cols="100">${webInfo.contact_us}</textarea>
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
