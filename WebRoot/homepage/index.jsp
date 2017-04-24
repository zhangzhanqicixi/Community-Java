<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/jsp/common/_frag/include/include.inc.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8"/>
    <title>网站关键词-网站名称</title>
    <meta name="description" content="网站描述，一般显示在搜索引擎搜索结果中的描述文字，用于介绍网站，吸引浏览者点击。"/>
    <meta name="keywords" content="网站关键词"/>
    <meta name="generator" content="MetInfo 5.1.7"/>
    <link href="favicon.ico" rel="shortcut icon"/>
    <link rel="stylesheet" type="text/css" href="images/metinfo.css"/>
    <script src="images/jQuery1.7.2.js" type="text/javascript"></script>
    <script src="images/ch.js" type="text/javascript"></script>
	<script src="admin/js/info.js" type="text/javascript"></script>
</head>
<body>
<header>
    <div class="inner">
        <div class="top-logo">
            <a href="index_1.jsp" title="网站名称" id="web_logo"></a>

            <ul class="top-nav list-none">

                <li class="b">
                    <!-- <a href="admin/index_1.jsp"><strong><span style="color:#ffff00;"><span style="font-size: 14px;">后台演示请点击这里进入</span></span></strong></a> -->
                </li>
            </ul>
        </div>

        <nav>
            <ul class="list-none">
                <li id="nav_10001" style='width:121px;' class='navdown'><a href='index_1.jsp' class='nav'><span>网站首页</span></a></li>
                <li class="line"></li>
                <li id='nav_1' style='width:121px;'><a href='about.jsp' class='hover-none nav'><span>网站简介</span></a>
                </li>
                <li class="line"></li>
                <li id='nav_2' style='width:121px;'><a href='news.jsp' class='hover-none nav'><span>站内新闻</span></a>
                </li>
                <li class="line"></li>
                <li id='nav_3' style='width:121px;'><a href='community.jsp' class='hover-none nav'><span>社团浏览</span></a>
                </li>
                <li class="line"></li>
                <li id='nav_4' style='width:121px;'><a href='activity.jsp' class='hover-none nav'><span>社团活动</span></a>
                </li>
                <li class="line"></li>
                <li id='nav_32' style='width:121px;'><a href='index.jsp' class='hover-none nav'><span>联系我们</span></a>
                </li>
                <li class="line"></li>
                <li id='nav_36' style='width:120px;'><a href='index.jsp' class='hover-none nav'><span>学生登录</span></a>
                </li>
            </ul>
        </nav>
    </div>
</header>

<div class="inner met_flash">
    <link href='images/css.css' rel='stylesheet' type='text/css'/>
    <script src='images/jquery.bxSlider.min.js'></script>
    <div class='flash flash6' style='width:980px; height:245px;'>
        <ul id='slider6' class='list-none'>
            <li><a href='#' target='_blank'><img src='images/community_1.jpg' width='980' height='245'></a></li>
            <li><a href='#' target='_blank'><img src='images/community_2.jpg' width='980' height='245'></a></li>
            <li><a href='#' target='_blank'><img src='images/community_3.png' width='980' height='245'></a></li>
            <li><a href='#' target='_blank'><img src='images/community_4.jpg' width='980' height='245'></a></li>
        </ul>
    </div>
    <script type='text/javascript'>$(document).ready(function () {
        $('#slider6').bxSlider({
            mode: 'vertical',
            autoHover: true,
            auto: true,
            pager: true,
            pause: 5000,
            controls: false
        });
    });</script>
</div>


<div class="index inner">
    <div class="aboutus style-1">
        <h3 class="title">
            <span class='myCorner' data-corner='top 5px'>网站简介</span>
            <a href="about.jsp" class="more" title="链接关键词">更多>></a>
        </h3>
        <div class="active editor clear contour-1">
			<div style="padding-top:10px;">
                <span style="font-size:14px;"><strong>XXX大学XXX学院社团管理系统</strong></span></div>
            <div id="introduction"></div>
            <div>&nbsp;</div>
            <!--<div><span style="font-size:14px;"><strong>管理系统标题2</strong></span></div>-->
            <!--<div>-->
                <!--<span style="font-size:12px;">这里可以写其他内容XXXXXX，</span></div>-->
            <div class="clear"></div>            
        </div>
    </div>

    <div class="case style-2">
        <h3 class='title myCorner' data-corner='top 5px'><a href="" title="链接关键词" class="more">更多>></a>社团介绍</h3>
        <div class="active dl-jqrun contour-1" id="list_communities" style="height: 202px;"></div>
    </div>
    <div class="clear"></div>

    <div class="index-news style-1">
        <h3 class="title">
            <span class='myCorner' data-corner='top 5px'>站内新闻</span>
            <a href="./news.jsp" class="more" title="链接关键词">更多>></a>
        </h3>
        <div class="active clear listel contour-2" style="height: 360px;">
            <ol class='list-none metlist' id='list_news'></ol>
        </div>
    </div>

    <div class="index-news style-1">
        <h3 class="title"><span class='myCorner' data-corner='top 5px'>社团活动</span><a href="./activity.jsp" class="more" title="链接关键词">更多>></a>
        </h3>
        <div class="active clear listel contour-2" style="height: 360px;">
            <ol class='list-none metlist' id='list_activities'></ol>
        </div>
    </div>
    <div class="index-conts style-2">
        <h3 class='title myCorner' data-corner='top 5px'>

            联系我们
        </h3>
        <div class="active clear listel contour-2">
            <ol class='list-none metlist'>
                <li class='list top'><span class='tel'></span><a href='#'>联系电话</a></li>
                <li class='list '><span class='address'></span><a href='#'>地址</a></li>
            </ol>
        </div>
    </div>
    <div class="clear p-line"></div>

    <div class="clear"></div>


</div>

<!-- 样式固定 -->
<footer data-module="10001" data-classnow="10001">
    <div class="foot-text">
        <p></p>
        <p>我的网站 版权所有 2008-2017</p>
        <p>电话：1234567 QQ:88888888 Email:abcdfbg@gmail.com</p>


    </div>
</footer>
<script src="images/fun.inc.js" type="text/javascript"></script>

</body>
</html>