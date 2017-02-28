<%@page contentType="text/html; charset=utf-8"%>
<%@ include file="../_frag/include/include.inc.jsp"%>

<div class="pageContent">
	
		<form method="post" action="doApplication_Activity.action?navTabId=application_activity&callbackType=closeCurrent" enctype="multipart/form-data" class="pageForm required-validate" onsubmit="return iframeCallback(this,navTabAjaxDone);">
	
	<!--  <form method="post" enctype="multipart/form-data" action="applicationActivityCollege_Activity.action?navTabId=application_activity&callbackType=closeCurrent" class="required-validate pageForm" onsubmit="return validateCallback(this, navTabAjaxDone);">
		-->
		<div class="pageFormContent" layoutH="56">

			<input type="hidden" name="activity.id" value="${activity.id}">
			<input type="hidden" name="activity.activityId" value="${activity.activityId}">
			<input type="hidden" name="activity.provePict" value="${activity.provePict}">
			<input type="hidden" name="activity.managerId" value="${activity.managerId}">
			<input type="hidden" name="activity.rate" value="${activity.rate}">
			<div class="unit">
				<label>活动名称：</label>
				<input type="text" name="activity.activityName" value="${activity.activityName}" size="30" maxlength="10"  readonly="readonly"/>
			</div>
			<div class="unit">
				<label>活动日期：</label>
				<input type="date" name="activity.activityTime" value="${activity.activityTime}" size="30" maxlength="10" readonly="readonly" />
			</div>
			<div class="unit">
				<label>活动地点：</label>
				<input type="text" name="activity.address" value="${activity.address}" size="30" readonly="readonly"/>
			</div>
			<div class="unit">
				<label>申请社团编号：</label>
				<input type="text" name="activity.collegeId" value="${activity.collegeId}" size="30" readonly="readonly" />
			</div>
			<div class="unit">
				<label>活动类别：</label>
				<input type="text" name="activity.singleOrTeam" value="${activity.singleOrTeam}" size="30" readonly="readonly" />
			</div>
			<div class="unit">
				<label>活动类型：</label>
				<input type="text" name="activity.type" value="${activity.type}" size="30" readonly="readonly" />
			</div>
			<div class="unit">
				<label>活动内容介绍：</label>
				<textarea name="activity.remarks" readonly="true" cols="80" rows="2">${activity.remarks}</textarea>
			</div>
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">报名</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div></li>
			</ul>
		</div>
	</form>
</div>

