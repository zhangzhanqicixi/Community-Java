<%@page contentType="text/html; charset=utf-8"%>
<%@ include file="../_frag/include/include.inc.jsp"%>

<form id="pagerForm" method="post" action="module!list.action">
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="numPerPage" value="${numPerPage}" />
	<input type="hidden" name="orderField" value="${orderField}" />
	<input type="hidden" name="orderDirection" value="${orderDirection}" />
</form>

<div class="pageContent">
	<div class="pageFormContent" layoutH="80" style="margin-right:230px">
			<p>
				<label>社团名称:</label><span class="unit">${college.collegeName}</span>
			</p>
			<p>
				<label>社团编号:</label><span class="unit">${college.collegeId}</span>
			</p>
			<p>
				<label>成立时间:</label><span class="unit">${college.buildTime}</span>
			</p>
			<p>
				<label>社团简介:</label><span class="unit">${college.collegeMotto}</span>
			</p>
	</div>
</div>