<%@page contentType="text/html; charset=utf-8"%>
<%@ include file="../_frag/include/include.inc.jsp"%>

<!-- 这个是分页的表单，暂时没有用到 -->
<form id="pagerForm" method="post" action="">
	<input type="hidden" name="pageNum" value="1" /> <input type="hidden"
		name="numPerPage" value="${numPerPage}" /> <input type="hidden"
		name="orderField" value="${orderField}" /> <input type="hidden"
		name="orderDirection" value="${orderDirection}" />
</form>

<form method="post" action="customer!list.action"
	onsubmit="return navTabSearch(this)" rel="pagerForm">
	<!-- 修改numPerPage=20后，关键字搜索时，rel='pagerForm'并没有将分页参数传递action，
		 导致仍然每页显示10行， 故不得已将分页参数再次复制于此 -->
	<input type="hidden" name="pageNum" value="1" /> <input type="hidden"
		name="numPerPage" value="${numPerPage}" /> <input type="hidden"
		name="orderField" value="${orderField}" /> <input type="hidden"
		name="orderDirection" value="${orderDirection}" />
	<!-- 搜索框
	<div class="pageHeader">
		<div class="searchBar">
			<ul class="searchContent">
				<li>
					<label>Keywords：</label>
					<input type="text" name="keywords" value="${param.keywords}"/>
				</li>
			</ul>
			<div class="subBar">
				<ul><li><div class="buttonActive"><div class="buttonContent"><button type="submit">Search</button></div></div></li></ul>
			</div>
		</div>
	</div>
	 -->
</form>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">

			<li><a class="edit"
				href="gradeHis_Activity.action?ids={ids}"
				target="navTab" rel="addCusNavId" title="主办方评分分析" warn="请选择一个活动信息"><span>历史评分分析</span></a></li>
				
		</ul>
	</div>

	<table class="table" layoutH="135" width="100%">
		<thead>
			<tr>
				<th width="100" orderField="collegeId">主办方编号</th>
				<th width="200" orderField="collegeName">主办方名称</th>
				<th width="150" orderField="collegeMotto">主办方简介</th>
				<th width="150" orderField="buildTime">成立日期</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="college" items="${listAllCollege}">
				<tr target="ids" rel="${college.id}">
					<td>${college.collegeId}</td>
					<td>${college.collegeName}</td>
					<td>${college.collegeMotto}</td>
					<td>${college.buildTime}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>