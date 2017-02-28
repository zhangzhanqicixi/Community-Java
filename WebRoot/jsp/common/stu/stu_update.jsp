<%@page contentType="text/html; charset=utf-8"%>
<%@ include file="../_frag/include/include.inc.jsp"%>

<div class="pageContent">
	
	<form method="post" action="doUpdateStu_Stu.action?navTabId=information_update&callbackType=closeCurrent" class="required-validate pageForm" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
            <input type="hidden" name="stu.id" value="${stu.id}"/>
			<input type="hidden" name="stu.userId" value="${stu.userId}" />
			<div class="unit">
				<label>学号：</label>
				<input type="text" name="stu.stuId" value="${stu.stuId}" size="30" maxlength="10" class="required number" readonly="readonly" />
			</div>
			<div class="unit">
				<label>姓名：</label>
				<input type="text" name="stu.stuName" value="${stu.stuName}" size="30" class="required" />
			</div>
			<div class="unit">
				<label>所属学院：</label>
				<input type="text" name="stu.stuCollege" value="${stu.stuCollege}" size="30" class="required" />
			</div>
			<div class="unit">
				<label>所属专业：</label>
				<input type="text" name="stu.stuSpeciality" value="${stu.stuSpeciality}" size="30" class="required" />
			</div>
			<div class="unit">
				<label>所在班级：</label>
				<input type="text" name="stu.stuClass" value="${stu.stuClass}" size="30" class="required" />
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

