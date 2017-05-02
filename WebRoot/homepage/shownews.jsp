<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/jsp/common/_frag/include/include.inc.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
<title>网站关键词-网站名称</title>
<meta name="description"
	content="网站描述，一般显示在搜索引擎搜索结果中的描述文字，用于介绍网站，吸引浏览者点击。" />
<meta name="keywords" content="网站关键词" />
<meta name="generator" content="MetInfo 5.1.7" />
<link href="favicon.ico" rel="shortcut icon" />
<link rel="stylesheet" type="text/css" href="images/metinfo.css" />
<script src="images/jQuery1.7.2.js" type="text/javascript"></script>
<script src="images/ch.js" type="text/javascript"></script>
<script src="admin/js/newsDetails.js" type="text/javascript"></script>
<script src="admin/js/common.js" type="text/javascript"></script>

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
			<li id='nav_2' style='width:121px;' class='navdown'><a
				href='news.jsp' class='hover-none nav'><span>站内新闻</span></a></li>
			<li class="line"></li>
			<li id='nav_3' style='width:121px;'><a href='community.jsp'
				class='hover-none nav'><span>社团浏览</span></a></li>
			<li class="line"></li>
			<li id='nav_4' style='width:121px;'><a href='news.jsp'
				class='hover-none nav'><span>社团活动</span></a></li>
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
			<a href='#' target='_blank' title='企业网站管理系统'></a>
		</div>
	</div>


	<div class="sidebar inner">
		<div class="sb_nav">

			<h3 class='title myCorner' data-corner='top 5px'>站内新闻</h3>
			<div class="active" id="sidebar" data-csnow="2" data-class3="0"
				data-jsok="2">
				<dl class="list-none navnow">
					<dt id='part2_4'>
						<a href='#' title='公司动态' class="zm"><span>新闻资讯</span></a>
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
					当前位置：<a href="http://demo.metinfo.cn/" title="网站首页">网站首页</a> &gt; <a
						href=./news.jsp>新闻资讯</a> > <a href="#">文章详情</a>
				</div>
				<span>业界资讯</span>
			</h3>
			<div class="clear"></div>

			<div class="active" id="shownews">
				<div class="info">
					<h1 class="title"></h1>
					<div class="author_time">作者：管理员&nbsp;&nbsp;&nbsp;&nbsp;更新时间：&nbsp;</div>
				</div>
				<div class="editor">
					<div>
						<div class="article"></div>
						<br />
						<div id="metinfo_additional"></div>
					</div>
					<div class="imgshow" align="center">
						<img id="news_img">
					</div>
					<div class="clear"></div>
				</div>
				<div class="met_hits" />
			</div>
			
			<h2 align="left">写评论:</h2>
			<div class="comment_write">
				<textarea rows="3" cols="76" id="comment_textarea"></textarea>
				<button type="button" id="comment_button" > 提交 </button>
			</div>
			
			<h2 align="left" id="showComment">相关评论:</h2>
		</div>
		<div class="clear"></div>
	</div>

	<footer data-module="2" data-classnow="5">
	<div class="inner"></div>
	</footer>
	<script src="images/fun.inc.js" type="text/javascript"></script>

</body>
</html>