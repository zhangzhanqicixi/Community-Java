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
				<input type="text" name="college.collegeName" value="${college.collegeName}" size="30" maxlength="10" class="required" readonly="readonly" />
			</div>
			<div class="unit">
				<label>活动效果历史平均分：</label>
				<input type="text" name="grade1Ave" value="${grade1Ave}" size="30" maxlength="10" readonly="readonly" />
			</div>
			<div class="unit">
				<label>活动趣味性历史平均分：</label>
				<input type="text" name="grade2Ave" value="${grade2Ave}" size="30" maxlength="10" readonly="readonly" />
			</div>
			<div class="unit">
				<label>活动收获历史平均分：</label>
				<input type="text" name="grade3Ave" value="${grade3Ave}" size="30" maxlength="10" readonly="readonly" />
			</div>
			<div class="unit">
				<label>主办方态度历史平均分：</label>
				<input type="text" name="grade4Ave" value="${grade4Ave}" size="30" maxlength="10" readonly="readonly" />
			</div>
			
			<div class="unit">
				<label>活动历史综合评分：</label>
				<input type="text" name="gradeSingle" value="${gradeSingle}" size="30" maxlength="10" readonly="readonly" />
			</div>
		</div>
	</form>
</div>

