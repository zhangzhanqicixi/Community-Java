<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../_frag/include/include.inc.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="edit"
				href="member!queryProperByCommunity.action?uid={eId}"
				target="navTab"><span>社长任命</span></a></li>
			<li class="line">line</li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th width="80">序号</th>
				<th width="120">社团名称</th>
				<th width="120">社长姓名</th>
				<th>社团介绍</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="community" items="${communityList}">
				<tr target="eId" rel="${community.id}">
					<td>${community.id}</td>
					<td>${community.community_name}</td>
					<td>${community.proper_name}</td>
					<td>${community.community_introduction}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
