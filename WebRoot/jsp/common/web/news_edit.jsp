<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../_frag/include/include.inc.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<h2 class="contentTitle">社团管理</h2>
<div class="pageContent">
	<form method="post" action="webNews!save.action?callbackType=closeCurrent&navTabId=news_edit"
		class="pageForm required-validate"
		onsubmit="return validateCallback(this, navTabAjaxDone)">
		<div class="pageFormContent nowrap" layoutH="97">
			<input value="1" type="hidden" name="webNews.user_id"/>
			<dl>
				<dt>新闻标题：</dt>
				<dd>
					<input value="${webNews.news_title}" type="text" name="webNews.news_title" maxlength="2000" class="required" />
					<span class="info">请输入新闻标题</span>
				</dd>
			</dl>
			<dl>
				<dt>新闻内容：</dt>
				<dd>
					<textarea class="editor" name="webNews.news_content" rows="6" cols="100">此处输入新闻内容</textarea>
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
