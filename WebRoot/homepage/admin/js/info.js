/**
 * Created by zhangzhanqi on 2017/4/18.
 */
$(document).ready(function () {
    $.ajax({
        url: '../ajax!homepageInfo.action',
        type: 'GET',
        dataType: 'json',
        success: function (data) {
            $.each(eval("(" + data.msgNews.replace('\n', '\\n') + ")"), function (i, value) {
            	if (i < 10) {
	                var insert_time = value.insert_time.split(' ')[0]
	                $('#list_news').append("<li class='list top'><span class='time'>" + insert_time + "</span><a href='shownews.jsp?uid=" + value.id + "'>" + value.news_title + "</a></li>")
            	}
            });
            $.each(eval("(" + data.msgAct + ")"), function (i, value) {
            	if (i < 10) {
	                var start_time = value.start_time.split(' ')[0]
	                $('#list_activities').append("<li class='list '><span class='time'>" + start_time + "</span><a href='showactivity.jsp?uid=" + value.id + "'>" + value.activity_title + "</a></li>")
            	}
            });
            $.each(eval("(" + data.msgCmnt + ")"), function (i, value) {
            	if (i < 2) {
	                $('#list_communities').append('<dl class="ind"><dt style="height: 80px;"><a href="showcommunity.jsp?uid=' + value.id + '" target="_self">' +
	                    '<img src="http://127.0.0.1:8080/community/' + value.community_img_path + '" alt="图片关键词" title="图片关键词" style="width:116px; ' +
	                    'height:80px;"/></a></dt><dd style="width: 149px; height: 80px;"> <h4><a href="#" target="_self" title="社团信息">' + value.community_name + '</a></h4> ' +
	                    '<p class="desc" title="社团介绍">' + value.community_introduction + '</p>' +
	                    ' </dd></dl>')
            	}
            });
            $('#list_communities').append('<div class="clear"></div>')
            web_info = JSON.parse(data.msgIntro)
            $('span.tel').text(web_info.tel);
            $('span.address').text(web_info.addres);
            $('#introduction').text(web_info.introduction);
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
			$('#nav_0').attr('class', 'hover')
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


