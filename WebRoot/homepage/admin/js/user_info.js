/**
 * Created by zhangzhanqi on 2017/4/18.
 */
$(document).ready(function () {
	
	
	
    $.ajax({
        url: '../ajax!user_info.action',
        type: 'GET',
        dataType: 'json',
        success: function (data) {
        	msgUser = JSON.parse(data.msgUser)
        	msgCmnt = JSON.parse(data.msgCmnt)
            $('#username').append('<span>用户名：</span>' + msgUser.username);
        	$('#user_name').append('<span>学生姓名：</span>' + msgUser.user_name);
        	$('#user_id').append('<span>学生学号：</span>' + msgUser.user_id);
        	$('#user_tel').append('<span>联系方式：</span>' + msgUser.user_tel);
        	$('#user_img').attr('src', 'http://127.0.0.1:8080/community/' + msgUser.user_img)
        	var community_name_str = ''
        	if (msgCmnt != null) {
		    	 $.each(msgCmnt, function (i, value) {
		    		 community_name_str = community_name_str + value.community_name
		    		 community_name_str += ','
		         });
		    	 community_name_str = community_name_str.substring(0, community_name_str.length - 1)
        	} 
        	if (community_name_str.trim() == '') {
        		community_name_str = '无'
        	}
        	$('#cmnt_info').append('<span>加入社团名称：</span>' + community_name_str);
        }
    });
    
    if (validateUser()) {
    	$('#nav_6').remove()
    	$('#list-none').append("<li id='nav_7' style='width:120px'><a href='user_info.jsp' class='hover-none nav'><span>个人信息</span></a><li class='line'></li>")
    	$('#list-none').append("<li id='nav_8' style='width:120px; border-top-right-radius: 5px;'><a href='../user!homepage_logout.action' class='hover-none nav'><span>退出登录</span></a>")
    } else {
    	$('#nav_6').remove()
    	$('#list-none').append("<li id='nav_6' style='width:120px; border-top-right-radius: 5px;'><a href='../login.jsp' target='_top' class='hover-none nav'><span>学生登录</span></a></li>")
    }
    
    // 鼠标动作事件
	$('#list-none li').hover(
		function() {
			$(this).attr('class', 'hover')
		},function() {
			$(this).attr('class', '')
			$('#nav_7').attr('class', 'hover')
		}
	);
});

//判断是否已经登录
function validateUser() {
	var flag = false
    var user = getCookie("USER_COOKIE")
    if (user != '' && user != '""') {
		flag = true
    }
    return flag
}

// 获得cookie
function getCookie(cname){
  var name = cname + "=";
  var ca = document.cookie.split(';');
  for(var i=0; i<ca.length; i++) {
    var c = ca[i].trim();
    if (c.indexOf(name)==0) return c.substring(name.length,c.length);
  }
  return "";
}


