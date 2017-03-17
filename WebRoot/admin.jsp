<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>校园社团管理系统（管理员）</title>

<link href="themes/default/style.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="themes/css/core.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="themes/css/print.css" rel="stylesheet" type="text/css" media="print"/>
<link href="uploadify/css/uploadify.css" rel="stylesheet" type="text/css" media="screen"/>
<!--[if IE]>
<link href="themes/css/ieHack.css" rel="stylesheet" type="text/css" media="screen"/>
<![endif]-->

<!--[if lt IE 9]><script src="js/speedup.js" type="text/javascript"></script><script src="js/jquery-1.11.3.min.js" type="text/javascript"></script><![endif]-->
<!--[if gte IE 9]><!--><script src="js/jquery-2.1.4.min.js" type="text/javascript"></script><!--<![endif]-->

<script src="js/jquery.cookie.js" type="text/javascript"></script>
<script src="js/jquery.validate.js" type="text/javascript"></script>
<script src="js/jquery.bgiframe.js" type="text/javascript"></script>
<script src="xheditor/xheditor-1.2.2.min.js" type="text/javascript"></script>
<script src="xheditor/xheditor_lang/zh-cn.js" type="text/javascript"></script>
<script src="uploadify/scripts/jquery.uploadify.js" type="text/javascript"></script>

<!-- svg图表  supports Firefox 3.0+, Safari 3.0+, Chrome 5.0+, Opera 9.5+ and Internet Explorer 6.0+ -->
<script type="text/javascript" src="chart/raphael.js"></script>
<script type="text/javascript" src="chart/g.raphael.js"></script>
<script type="text/javascript" src="chart/g.bar.js"></script>
<script type="text/javascript" src="chart/g.line.js"></script>
<script type="text/javascript" src="chart/g.pie.js"></script>
<script type="text/javascript" src="chart/g.dot.js"></script>


<script src="bin/dwz.min.js" type="text/javascript"></script>

<script src="js/dwz.regional.zh.js" type="text/javascript"></script>

<script type="text/javascript">
$(function(){
	DWZ.init("dwz.frag.xml", {
		loginUrl:"login_dialog.html", loginTitle:"登录",	// 弹出登录对话框
//		loginUrl:"login.html",	// 跳到登录页面
		statusCode:{ok:200, error:300, timeout:301}, //【可选】
		pageInfo:{pageNum:"pageNum", numPerPage:"numPerPage", orderField:"orderField", orderDirection:"orderDirection"}, //【可选】
		keys: {statusCode:"statusCode", message:"message"}, //【可选】
		ui:{hideMode:'offsets'}, //【可选】hideMode:navTab组件切换的隐藏方式，支持的值有’display’，’offsets’负数偏移位置的值，默认值为’display’
		debug:false,	// 调试模式 【true|false】
		callback:function(){
			initEnv();
			$("#themeList").theme({themeBase:"themes"}); // themeBase 相对于index页面的主题base路径
		}
	});
});
</script>
</head>

<body scroll="no">
	<div id="layout">
		<div id="header">
			<div class="headerNav">
				<!-- 
					<a class="logo" href="http://j-ui.com">标志</a>
				-->
				<ul class="nav">
					<li><a href="logout_Login.action">退出</a></li>
				</ul>
				<ul class="themeList" id="themeList">
					<li theme="default"><div class="selected">蓝色</div></li>
					<li theme="green"><div>绿色</div></li>
					<!--<li theme="red"><div>红色</div></li>-->
					<li theme="purple"><div>紫色</div></li>
					<li theme="silver"><div>银色</div></li>
					<li theme="azure"><div>天蓝</div></li>
				</ul>
			</div>
		<!-- navMenu -->
		</div>
		<!-- 左侧导航栏开始 -->
		<div id="leftside">
			<div id="sidebar_s">
				<div class="collapse">
					<div class="toggleCollapse"><div>
						</div></div>
				</div>
			</div>
			<div id="sidebar">
				<div class="toggleCollapse"><h2>主菜单</h2><div>收缩</div></div>

				<div class="accordion" fillSpace="sidebar">
					<div class="accordionHeader">
						<h2><span>Folder</span>网站管理</h2>
					</div>
					<div class="accordionContent">
						<ul class="tree treeFolder">
							<li><a href="/jsp/common/web/news_edit.jsp" target="navTab" rel="news_edit" title="新闻编辑">新闻编辑</a></li>
							<li><a href="updateStu_Stu.action" target="navTab" rel="msg_edit" title="留言管理">留言管理</a></li>
							<li><a href="webInfo!select_info.action" target="navTab" rel="webInfo_edit" title="其他信息">其他信息</a></li>
						</ul>
					</div>
					
					<div class="accordionHeader">
						<h2><span>Folder</span>社团管理</h2>
					</div>	
					<div class="accordionContent">
						<ul class="tree treeFolder">
							<li><a href="community!listCommunity.action" rel="application_activity" target="navTab"  title="社团管理">社团管理</a></li>
							<li><a href="strust2Test!saveUser.action" target="navTab"  title="社长管理">社长管理</a></li>
						</ul>
					</div>	
				</div>
			</div>
		</div>
		<!-- 左侧导航栏结束 -->
		<!-- 右侧内容栏开始 -->
		<div id="container">
			<div id="navTab" class="tabsPage">
				<div class="tabsPageHeader">
					<div class="tabsPageHeaderContent"><!-- 显示左右控制时添加 class="tabsPageHeaderMargin" -->
						<ul class="navTab-tab">
							<li tabid="main" class="main"><a href="javascript:;"><span><span class="home_icon">我的主页</span></span></a></li>
						</ul>
					</div>
					<div class="tabsLeft">left</div><!-- 禁用只需要添加一个样式 class="tabsLeft tabsLeftDisabled" -->
					<div class="tabsRight">right</div><!-- 禁用只需要添加一个样式 class="tabsRight tabsRightDisabled" -->
					<div class="tabsMore">more</div>
				</div>
				<ul class="tabsMoreList">
					<li><a href="javascript:;">我的主页</a></li>
				</ul>
				<div class="navTab-panel tabsPageContent layoutBox">
					<div class="page unitBox">
						<div class="accountInfo">
							<div class="alertInfo">
								<p><a href="https://code.csdn.net/dwzteam/dwz_jui/tree/master/doc" target="_blank" style="line-height:19px"><span>欢迎进入社团管理系统</span></a></p>
							</div>
							<div class="right">
								<p style="color:red">联系电话 ：0571-xxxxxxxx</a></p>
							</div>
							<p><span>欢迎进入社团管理系统（管理员）</span></p>
							<p>个人信息：</p>
						</div>
						<div class="pageFormContent" layoutH="80" style="margin-right:230px">
								<p>
									<label>欢迎您:</label><span class="unit">${stu.stuName}</span>
								</p>
								<p>
									<label>您的学号:</label><span class="unit">${stu.stuId}</span>
								</p>
								<p>
									<label>所属专业:</label><span class="unit">${stu.stuSpeciality}</span>
								</p>
								<p>
									<label>所在班级:</label><span class="unit">${stu.stuClass}</span>
								</p>
						</div>
						
						<div style="width:230px;position: absolute;top:60px;right:0" layoutH="80">
							<iframe width="100%" height="430" class="share_self"  frameborder="0" scrolling="no" src="http://widget.weibo.com/weiboshow/index.php?width=0&height=430&fansRow=2&ptype=1&skin=1&isTitle=0&noborder=1&isWeibo=1&isFans=0&uid=1739071261&verifier=c683dfe7"></iframe>
						</div>
					</div>
					
				</div>
			</div>
		</div>

	</div>

	<div id="footer">Copyright &copy; 2010 <a href="demo_page2.html" target="dialog">zhangzhe</a> 浙ICP备00000000号-10</div>


</body>
</html>