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
    
    getComment(uid)
    
    
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
			var uid = getUrlParam('uid')
			var content = $('#comment_textarea').val()
			
			if ('' == content.trim()) {
				alert('评论不能为空！')
				return false;
			}
			
			$.ajax({
				type: 'get',
				url: '../ajax!saveComment.action',
				data: 'username=' + username + '&uid=' + uid + '&content=' + content,
				dataType: 'json',
				success: function (data) {
					alert('评论成功！')
					$('#comment_textarea').val('')
					getComment(uid)
				}
			})
	    } else {
	    	alert('请先登录！')
	    }
	});
	
});

function getComment(uid) {
	$('.comment').remove()
	// 获得该新闻评论
    $.ajax({
        url: '../ajax!CommentByNews.action',
        type: 'GET',
        data: 'uid=' + uid,
        dataType: 'json',
        success: function (data) {
        	$.each(eval("(" + data.newsComment + ")"), function (i, value) {
        		var content = value.content
        		var commnet_user = eval("(" + data.newsCommentUser + ")")
        		var user_name = commnet_user[i].user_name
        		$('#showComment').after('<div class="comment" ><div class="comment_info"><div class="comment_content">' + value.insert_time.split('.')[0] + ' '+ user_name +'： ' + content + '</div></div></div>')
        	});
        	//newsDetails = JSON.parse(data.newsComment)
        	
        }
    });
}

//获取url中的参数
function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
    var r = window.location.search.substr(1).match(reg);  //匹配目标参数
    if (r != null) return unescape(r[2]); return null; //返回参数值
}

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