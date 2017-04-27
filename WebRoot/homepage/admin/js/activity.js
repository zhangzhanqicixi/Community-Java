/**
 * Created by zhangzhanqi on 2017/4/18.
 */
$(document).ready(function () {
    $.ajax({
        url: '../ajax!getAllActivity.action',
        type: 'GET',
        data: '{}',
        dataType: 'json',
        success: function (data) {
            $.each(eval("(" + data.msgAct + ")"), function (i, value) {
            	community = eval("(" + data.msgActCmnt + ")")[i]
            	name = "未知社团";
            	if (community != null) {
            		name = community.community_name
            	}
                var insert_time = value.start_time.split(' ')[0]
                $('ul').append("<li class='list top'><span>[" + insert_time + "]</span><a href='shownews.jsp' title='如何选择网站关键词?' target='_self'>" 
                		+ value.activity_title + " &nbsp; -- &nbsp; 【" + name + "】</a></li>")
            });
        }
    })
    
    if (validateUser()) {
    	$('#nav_6').remove()
    	$('#list-none').append("<li id='nav_7' style='width:120px'><a href='../login.jsp' class='hover-none nav'><span>个人信息</span></a><li class='line'></li>")
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
			$('#nav_4').attr('class', 'hover')
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


