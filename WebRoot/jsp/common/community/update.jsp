<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../_frag/include/include.inc.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<h2 class="contentTitle">社团管理</h2>


<div class="pageContent">

	<form enctype="multipart/form-data" method="post"
		action="community!saveOrUpdate.action?callbackType=closeCurrent"
		class="pageForm required-validate"
		onsubmit="return iframeCallback(this, navTabAjaxDone);">
		<div class="pageFormContent nowrap" layoutH="97">
			<input value="${community.id}" type="hidden" name="community.id" />
			<input value="${community.community_img_path}" type="hidden" name="community.community_img_path"/>
			<input value="${user.id}" type="hidden" name="user_id_origin" />
			<input value="${user.user_id}" type="hidden" name="uid" />
			<dl>
				<dt>社团名称：</dt>
				<dd>
					<input value="${community.community_name}" type="text"
						name="community.community_name" maxlength="20" class="required" />
					<span class="info">请输入社团名称</span>
				</dd>
			</dl>
			<dl>
				<dt>社长姓名：</dt>
				<dd>
					<input value="${user.user_name}" type="text" name="user.user_name" readonly="readonly"
						class="required" />
				</dd>
			</dl>
			<dl>
				<dt>社长学号：</dt>
				<dd>
					<input value="${user.user_id}" type="text" name="user.user_id"
						class="required" />
				</dd>
			</dl>
			<dl>
				<dt>社团简介：</dt>
				<dd>
					<textarea rows="3" cols="70" name="community.community_introduction" class="required" > ${community.community_introduction} </textarea> <span
						class="info">请输入社团简介"</span>
				</dd>
			</dl>
			<dl>
				<dt>社团图片：</dt>
				<dd>
					<img alt="${community.community_name}" src="${community.community_img_path}" height="250px" >
				</dd>
			</dl>
			<dl>
				<dt>图片重置：</dt>
				<dd>
					<input type="file" name="file" />
				</dd>
			</dl>
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive">
						<div class="buttonContent">
							<button type="submit">修改</button>
						</div>
					</div>
				</li>
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
