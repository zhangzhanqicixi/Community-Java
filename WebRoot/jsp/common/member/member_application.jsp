<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../_frag/include/include.inc.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="edit" href="member!readyConfirm.action?uid={eId}&callbackType=closeCurrent" target="navTab" title="详情"><span>详情</span></a></li>
			<li class="line">line</li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th width="10">序号</th>
				<th width="120">成员姓名</th>
				<th width="80">成员学号</th>
				<th width="80">联系电话</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="user" items="${userList}">
				<tr target="eId" rel="${user.id}">
					<td width="10">
						${user.id}
					</td>
					<td>
						${user.user_name}
					</td>
					<td>
						${user.user_id}
					</td>
					<td>
						${user.user_tel}
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
