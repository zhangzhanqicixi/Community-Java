<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../_frag/include/include.inc.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" href="jsp/common/activity/save.jsp" target="navTab"><span>添加</span></a></li>
			<li><a class="delete" href="activity!delete.action?uid={eId}&callbackType=closeCurrent" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
			<li><a class="edit" href="activity!getActByUid.action?uid={eId}" target="navTab"><span>修改</span></a></li>
			<li class="line">line</li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th width="80">序号</th>
				<th width="120">活动名称</th>
				<th width="80">活动内容</th>
				<th width="80">开始时间</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="activity" items="${activityList}">
				<tr target="eId" rel="${activity.id}">
					<td>
						${activity.id}
					</td>
					<td>
						${activity.activity_title}
					</td>
					<td>
						${activity.activity_content}
					</td>
					<td>
						${activity.start_time}
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
