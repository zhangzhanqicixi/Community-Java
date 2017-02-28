<%@page contentType="text/html; charset=utf-8"%>
<%@ include file="../_frag/include/include.inc.jsp"%>

<form id="pagerForm" method="post" action="module!list.action">
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="numPerPage" value="${numPerPage}" />
	<input type="hidden" name="orderField" value="${orderField}" />
	<input type="hidden" name="orderDirection" value="${orderDirection}" />
</form>

<form method="post" action="module!list.action" onsubmit="return navTabSearch(this)" rel="pagerForm">
	<!-- 修改numPerPage=20后，关键字搜索时，rel='pagerForm'并没有将分页参数传递action，
		 导致仍然每页显示10行， 故不得已将分页参数再次复制于此 -->
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="numPerPage" value="${numPerPage}" />
	<input type="hidden" name="orderField" value="${orderField}" />
	<input type="hidden" name="orderDirection" value="${orderDirection}" />
</form>
<div class="pageContent">
	<div class="pageFormContent" layoutH="80" style="margin-right:230px">
		<p>
			<label>学生姓名:</label><span class="unit">${stu.stuName}</span>
		</p>
		<p>
			<label>学生学号:</label><span class="unit">${stu.stuId}</span>
		</p>
		<p>
			<label>所属学院:</label><span class="unit">${stu.stuCollege}</span>
		</p>
		<p>
			<label>所属专业:</label><span class="unit">${stu.stuSpeciality}</span>
		</p>
		<p>
			<label>所在班级:</label><span class="unit">${stu.stuClass}</span>
		</p>
	</div>
</div>