<%@page contentType="text/html; charset=utf-8"%>
<%@ include file="../_frag/include/include.inc.jsp"%>

<div class="pageContent">
	
	<form method="post" action="doUpdateStu_Stu.action?navTabId=information_update&callbackType=closeCurrent" class="required-validate pageForm" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
            <input type="hidden" name="college.id" value="${college.id}"/>
			<div class="unit">
				<label>社团编号：</label>
				<input type="text" name="college.collegeId" value="${college.collegeId}" size="30" maxlength="10" class="required number" readonly="readonly" />
			</div>
			<div class="unit">
				<label>社团名称：</label>
				<input type="text" name="college.collegeName" value="${college.collegeName}" size="30" maxlength="10" class="required" />
			</div>
			<div class="unit">
				<label>社团简介：</label>
				<input type="text" name="college.collegeMotto" value="${college.collegeMotto}" size="30" class="required" />
			</div>
			<div class="unit">
				<label>成立时间：</label>
				<input type="date" name="college.buildTime" value="${college.buildTime}" size="30" class="required" width="20" height="30" />
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

