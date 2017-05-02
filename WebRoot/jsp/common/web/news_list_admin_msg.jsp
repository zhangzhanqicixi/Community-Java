<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../_frag/include/include.inc.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="delete" href="webMsg!delete.action?uid={eId}" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
			<li class="line">line</li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th width="80">序号</th>
				<th width="120">评论内容</th>
				<th width="80">评论时间</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="webMsg" items="${webMsgList}">
				<tr target="eId" rel="${webMsg.id}">
					<td>${webMsg.id}</td>
					<td>${webMsg.content}</td>
					<td>${webMsg.insert_time}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
