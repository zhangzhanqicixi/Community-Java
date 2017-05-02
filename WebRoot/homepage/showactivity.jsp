<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/jsp/common/_frag/include/include.inc.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
<title>社团活动 - 学生社团管理系统</title>
<meta name="description"
	content="网站描述，一般显示在搜索引擎搜索结果中的描述文字，用于介绍网站，吸引浏览者点击。" />
<meta name="keywords" content="网站关键词" />
<meta name="generator" content="MetInfo 5.1.7" />
<link href="favicon.ico" rel="shortcut icon" />
<link rel="stylesheet" type="text/css" href="images/metinfo.css" />
<script src="images/jQuery1.7.2.js" type="text/javascript"></script>
<script src="images/ch.js" type="text/javascript"></script>
<script src="admin/js/activityDetails.js" type="text/javascript"></script>
</head>
<body>
	<header>
	<div class="inner">
		<div class="top-logo"></div>
		<nav>
		<ul class="list-none" id="list-none">
			<li id="nav_0" style='width:121px;'><a href='index.jsp'
				class='nav'><span>网站首页</span></a></li>
			<li class="line"></li>
			<li id='nav_1' style='width:121px;'><a href='about.jsp'
				class='hover-none nav'><span>网站简介</span></a></li>
			<li class="line"></li>
			<li id='nav_2' style='width:121px;'><a href='news.jsp'
				class='hover-none nav'><span>站内新闻</span></a></li>
			<li class="line"></li>
			<li id='nav_3' style='width:121px;'><a href='community.jsp'
				class='hover-none nav'><span>社团浏览</span></a></li>
			<li class="line"></li>
			<li id='nav_4' style='width:121px;' class='navdown'><a
				href='activity.jsp' class='hover-none nav'><span>社团活动</span></a></li>
			<li class="line"></li>
			<li id='nav_5' style='width:121px;'><a href='index.jsp'
				class='hover-none nav'><span>联系我们</span></a></li>
			<li class="line"></li>
			<li id='nav_6' style='width:120px;'><a href='../login.jsp'
				class='hover-none nav'><span>学生登录</span></a></li>
		</ul>
		</nav>
	</div>
	</header>

	<div class="inner met_flash">
		<div class="flash">
			<a href='#' target='_blank' title='社团管理系统'></a>
		</div>
	</div>


	<div class="sidebar inner">
		<div class="sb_nav">

			<h3 class='title myCorner' data-corner='top 5px'>社团活动</h3>
			<div class="active" id="sidebar" data-csnow="2" data-class3="0"
				data-jsok="2">
				<dl class="list-none navnow">
					<dt id='part2_4'>
						<a href='./community.jsp' title='所有社团' class="zm"><span>所有活动</span></a>
					</dt>
				</dl>
				<div class="clear"></div>
			</div>

			<h3 class='title line myCorner' data-corner='top 5px'>联系方式</h3>
			<div class="active editor">
				<div>XXX大学XXX学院</div>
				<div>电 &nbsp;话：0000-888888</div>
				<div>邮 &nbsp;编：000000</div>
				<div>Email：admin@admin.cn</div>
				<div>网 &nbsp;址：www.xxxxx.cn</div>
				<div class="clear"></div>
			</div>
		</div>
		<div class="sb_box">
			<h3 class="title">
				<div class="position">
					当前位置：<a href="index.jsp" title="网站首页">网站首页</a> &gt; <a
						href=./community.jsp>社团活动</a> > <a href="#">活动详情</a>
				</div>
				<span>活动详情</span>
			</h3>
			<div class="clear"></div>

			<div class="active" id="shownews" align="center">

				<div class="met_hits"></div>

				<table class="table_list" width="780px">

					<tr>
						<td style="display: table-cell" align="left">
							<li class='list top' id="activity_name"></li>
						</td>
					</tr>
					<tr>
						<td style="display: table-cell" align="left">
							<li class='list top' id="cmnt_name"></li>
						</td>
						<td style="display: table-cell" align="left">
							<li class='list top' id="activity_start_time"></li>
						</td>
					</tr>
					<tr>
						<td style="display: table-cell" align="left">
							<li class='list top' id="activity_intro"></li>
						</td>
					</tr>
				</table>
				<div style="margin: 20px"></div>

				<div class="met_hits"></div>
			</div>
		</div>
		<div class="clear"></div>
</div>

<footer data-module="2" data-classnow="5">
    <div class="inner">

    </div>
</footer>
<script src="images/fun.inc.js" type="text/javascript"></script>


</body>
</html>