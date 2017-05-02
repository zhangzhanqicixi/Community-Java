<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../_frag/include/include.inc.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="delete" href="webNews!delete.action?uid={eId}" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
			<li><a class="edit" href="webMsg!getMsgByNews.action?uid={eId}" target="navTab"><span>查看该新闻留言</span></a></li>
			<li class="line">line</li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th width="40">序号</th>
				<th width="60">新闻标题</th>
				<th width="60">新闻内容</th>
				<th width="80">添加时间</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="webNews" items="${webNewsList}">
				<tr target="eId" rel="${webNews.id}">
					<td>${webNews.id}</td>
					<td>${webNews.news_title}</td>
					<td>${webNews.news_content}</td>
					<td>${webNews.insert_time}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
