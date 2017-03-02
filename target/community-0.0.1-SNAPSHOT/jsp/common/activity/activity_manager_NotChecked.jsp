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
				href="readyToCheck_Activity.action?ids={ids}"
				target="navTab" rel="addCusNavId" title="确认审核" warn="请选择一个活动信息"><span>审核</span></a></li>

		</ul>
	</div>

	<table class="table" layoutH="135" width="100%">
		<thead>
			<tr>
				<th width="100" orderField="activityId">活动编号</th>
				<th width="200" orderField="activityName">活动名称</th>
				<th width="150" orderField="activityTime">活动时间</th>
				<th width="150" orderField="address">举办地点</th>
				<th width="150" orderField="singleOrTeam">活动类别</th>
				<th width="150" orderField="type">活动类型</th>
				<th width="150" orderField="collegeId">举办单位</th>
				<th width="150" orderField="rate">状态</th>
				<th width="150" orderField="provePict">证书查看</th>

			</tr>
		</thead>
		<tbody>
			<c:forEach var="activity" items="${listAllActivity}">
				<tr target="ids" rel="${activity.id}">
					<td>${activity.activityId}</td>
					<td>${activity.activityName}</td>
					<td>${activity.activityTime}</td>
					<td>${activity.address}</td>
					<td>${activity.singleOrTeam}</td>
					<td>${activity.type}</td>
					<td>${activity.collegeId}</td>
					<td>${activity.rate}</td>
					<td><a
						href="lookProvePict_Activity.action?pictPath=${activity.provePict}"
						target="navTab" title="查看证明">查看证明</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>