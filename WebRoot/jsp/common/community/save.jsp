<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../_frag/include/include.inc.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<h2 class="contentTitle">社团管理</h2>


<div class="pageContent">

	<form method="post" action="community!saveOrUpdate.action?callbackType=closeCurrent"
		class="pageForm required-validate"
		onsubmit="return validateCallback(this, navTabAjaxDone)">
		<div class="pageFormContent nowrap" layoutH="97">
			<input value="9999" type="hidden" name="community.id"/>
			<dl>
				<dt>社团名称：</dt>
				<dd>
					<input value="${community.community_name}" type="text" name="community.community_name" maxlength="20" class="required" />
					<span class="info">请输入社团名称</span>
				</dd>
			</dl>
			<dl>
				<dt>社团简介：</dt>
				<dd>
					<input value="${community.community_introduction}" type="text" name="community.community_introduction" class="required" /> <span
						class="info">请输入社团简介"</span>
				</dd>
			</dl>
			<dl>
				<dt>图片上传：</dt>
				<dd>
					<input id="testFileInput" type="file" name="image"
						uploaderOption="{
			swf:'uploadify/scripts/uploadify.swf',
			uploader:'demo/common/ajaxDone.html',
			formData:{PHPSESSID:'xxx', ajax:1},
			buttonText:'请选择文件',
			fileSizeLimit:'200KB',
			fileTypeDesc:'*.jpg;*.jpeg;*.gif;*.png;',
			fileTypeExts:'*.jpg;*.jpeg;*.gif;*.png;',
			auto:true,
			multi:true,
			onUploadSuccess:uploadifySuccess,
			onQueueComplete:uploadifyQueueComplete
		}" />
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
