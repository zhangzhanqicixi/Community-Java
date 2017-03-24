<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/jsp/common/_frag/include/include.inc.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
  <title>欢迎进入社团管理系统</title>
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
   <link href="assets/css/dpl-min.css" rel="stylesheet" type="text/css" />
  <link href="assets/css/bui-min.css" rel="stylesheet" type="text/css" />
   <link href="assets/css/main-min.css" rel="stylesheet" type="text/css" />
 </head>
 <body>

  <div class="header">
    
      <div class="dl-title">
          <span class="lp-title-port">欢迎进入社团管理</span><span class="dl-title-text">系统</span>
      </div>

	<c:if test="${1 == 1}">
		<div class="dl-log">欢迎您，<span class="dl-log-user">${user.user_name}</span><a href="user!logout.action" title="退出系统" class="dl-log-quit">[退出]</a>
	    </div>
	</c:if>
	
	<c:if test="${1 == 2}">
		<div class="dl-log"><a href="user!login.action" title="登录系统" class="dl-log-quit">[登录] </a> <a href="jsp/common/web/login.jsp" title="登录系统" class="dl-log-quit">[注册]</a>
	    </div>
	</c:if>
    
  </div>
   <div class="content">
    <div class="dl-main-nav">
      <div class="dl-inform"><div class="dl-inform-title">贴心小秘书<s class="dl-inform-icon dl-up"></s></div></div>
      <ul id="J_Nav"  class="nav-list ks-clear">
        <li class="nav-item dl-selected"><div class="nav-item-inner nav-home">首页信息</div></li>
        <li class="nav-item"><div class="nav-item-inner nav-supplier">社团浏览</div></li>
        <li class="nav-item"><div class="nav-item-inner nav-marketing">在线互动</div></li>
      </ul>
    </div>
    <ul id="J_NavContent" class="dl-tab-conten">

    </ul>
   </div>
  <script type="text/javascript" src="assets/js/jquery-1.8.1.min.js"></script>
  <script type="text/javascript" src="./assets/js/bui.js"></script>
  <script type="text/javascript" src="./assets/js/config.js"></script>

  <script>
    BUI.use('common/main',function(){
      var config = [{
          id:'menu', 
          homePage : 'code',
          menu:[{
              text:'首页信息',
              items:[
                {id:'code',text:'网站信息',href:'webInfo!introduction.action',closeable : false},
                {id:'main-menu',text:'站内新闻',href:'webNews!news_list.action'},
              ]
            },]
          },{
            id:'form',
            menu:[{
                text:'社团浏览',
                items:[
                  {id:'code',text:'所有社团',href:'community!main_listCommunity.action'},
                ]
              },]
          },{
            id:'search',
            menu:[{
                text:'在线互动',
                items:[
                  {id:'code',text:'在线互动',href:'webMsg!chat_list.action'},
                  {id:'code',text:'留言添加',href:'webMsg!save_chat.action'},
                ]
              },]
          }];
      new PageUtil.MainPage({
        modulesConfig : config
      });
    });
  </script>
 </body>
</html>
