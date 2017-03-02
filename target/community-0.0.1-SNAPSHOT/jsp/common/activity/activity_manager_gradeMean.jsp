<%@page contentType="text/html; charset=utf-8"%>
<%@ include file="../_frag/include/include.inc.jsp"%>

<div class="pageContent">
	
		<form method="post" action="doCheck_Activity.action?navTabId=queryNoCheckedActivity_activity&callbackType=closeCurrent" enctype="multipart/form-data" class="pageForm required-validate" onsubmit="return iframeCallback(this,navTabAjaxDone);">
	
	<!--  <form method="post" enctype="multipart/form-data" action="applicationActivityCollege_Activity.action?navTabId=application_activity&callbackType=closeCurrent" class="required-validate pageForm" onsubmit="return validateCallback(this, navTabAjaxDone);">
		-->
		<div class="pageFormContent" layoutH="56">

			<input type="hidden" name="activity.id" value="${activity.id}">
			<input type="hidden" name="activity.activityId" value="${activity.activityId}">
			<input type="hidden" name="activity.provePict" value="${activity.provePict}">
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
				<label>活动效果平均分：</label>
				<input type="text" name="grade1Ave" value="${grade1Ave}" size="30" maxlength="10" readonly="readonly" />
			</div>
			<div class="unit">
				<label>活动趣味性平均分：</label>
				<input type="text" name="grade2Ave" value="${grade2Ave}" size="30" maxlength="10" readonly="readonly" />
			</div>
			<div class="unit">
				<label>活动收获平均分：</label>
				<input type="text" name="grade3Ave" value="${grade3Ave}" size="30" maxlength="10" readonly="readonly" />
			</div>
			<div class="unit">
				<label>主办方态度平均分：</label>
				<input type="text" name="grade4Ave" value="${grade4Ave}" size="30" maxlength="10" readonly="readonly" />
			</div>
			
			<div class="unit">
				<label>活动综合评分：</label>
				<input type="text" name="gradeSingle" value="${gradeSingle}" size="30" maxlength="10" readonly="readonly" />
			</div>
			
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">审核</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div></li>
			</ul>
		</div>
	</form>
</div>

