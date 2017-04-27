/**
 * Created by zhangzhanqi on 2017/4/18.
 */
$(document).ready(function () {
    uid = location.search.split('=')[1]
    $.ajax({
        url: '../ajax!getWebNewsDetails.action',
        type: 'GET',
        data: 'uid=' + uid,
        dataType: 'json',
        success: function (data) {
        	newsDetails = JSON.parse(data.webNews)
        	$('h1.title').text(newsDetails.news_title)
        	$('div.author_time').text('作者：管理员 ；   更新时间：' + newsDetails.insert_time.split('.')[0] + ' ')
        	$('div.article').text('    ' + newsDetails.news_content)
        	$('#news_img').attr('src', 'http://127.0.0.1:8080/community/' + newsDetails.news_img_path)
        }
    });
    
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
			$('#nav_2').attr('class', 'hover')
		}
	);
	
	$('#comment_button').click(function() {
		if (validateUser()) {
			var username = getCookie("USER_COOKIE").split(',')[0].replace('"', '')
//			$.ajax({
//				type: 'get',
//				url: 'ajax!saveComment.action',
//				data: 'username=' + username,
//				dataType: 'json',
//				success: function (data) {
//					
//				}
//			})
	    } else {
	    	alert('请先登录！')
	    }
	});
	
});


function getQueryString(name) {
	var reg = new RegExp('(^|&)' + name + '=([^&]*)(&|$)', 'i');
	var r = window.location.search.substr(1).match(reg);
	if (r != null) {
		return unescape(r[2]);
	}
	return null;
}
	

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
function getCookie(cname) {
  var name = cname + "=";
  var ca = document.cookie.split(';');
  for(var i=0; i<ca.length; i++) {
    var c = ca[i].trim();
    if (c.indexOf(name)==0) return c.substring(name.length,c.length);
  }
  return "";
}