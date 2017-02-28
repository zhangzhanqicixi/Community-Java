<%@page contentType="text/html; charset=utf-8"%>
<%@ include file="../_frag/include/include.inc.jsp"%>

<div class="pageContent">
	
		<form method="post" action="applicationActivityCollege_Activity.action?navTabId=application_activity&callbackType=closeCurrent" enctype="multipart/form-data" class="pageForm required-validate" onsubmit="return iframeCallback(this,navTabAjaxDone);">
	
	<!--  <form method="post" enctype="multipart/form-data" action="applicationActivityCollege_Activity.action?navTabId=application_activity&callbackType=closeCurrent" class="required-validate pageForm" onsubmit="return validateCallback(this, navTabAjaxDone);">
		-->
		<div class="pageFormContent" layoutH="56">
			<div class="unit">
				<label>申请社团编号：</label>
				<input type="text" name="activity.collegeId" value="${college.collegeId}" size="30" class="required" readonly="readonly" />
			</div>
			<div class="unit">
				<label>活动名称：</label>
				<input type="text" name="activity.activityName" value="${activity.activityName}" size="30" maxlength="10"  class="required" />
			</div>
			<div class="unit">
				<label>活动日期：</label>
				<input type="date" name="activity.activityTime" value="${activity.activityTime}" size="30" maxlength="10" class="required"  />
			</div>
			<div class="unit">
				<label>活动地点：</label>
				<input type="text" name="activity.address" value="${activity.address}" size="30" class="required" />
			</div>
			<div class="unit">
				<label>活动类别：</label>
				单人<input type="radio" checked="checked" name="activity.singleOrTeam" value="个人" />
				团队<input type="radio"  name="activity.singleOrTeam" value="团队" />
			</div>
			<div class="unit">
				<label>活动类型：</label>
				<select name="activity.type">
					<option value="美术类">美术类</option>
					<option value="音乐类">音乐类</option>
					<option value="科技类">科技类</option>
					<option value="创业类">创业类</option>
					<option value="娱乐类">娱乐类</option>
				</select>	
			</div>
			
			<div class="unit">
				<label>活动内容介绍：</label>
				<textarea name="activity.remarks" cols="80" rows="2"></textarea>
			</div>
			
			<div class="unit">
				<label>证明材料：</label>
				<input type="file" name="upload" size="30" class="required" />
				请选择.jpg文件格式的文件进行上传，且文件大小不超过2MB
			</div>
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">提交</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div></li>
			</ul>
		</div>
	</form>
</div>

