/**
 * Created by zhangzhanqi on 2017/4/18.
 */
$(document).ready(function () {
	
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
	
    uid = location.search.split('=')[1]
    $.ajax({
        url: '../ajax!getActivityDetails.action',
        type: 'GET',
        data: 'uid=' + uid,
        dataType: 'json',
        success: function (data) {
        	var community = JSON.parse(data.msgActCmnt)
        	var activity = JSON.parse(data.msgAct)
        	$('#activity_name').append('<span>活动名称：</span>' + activity.activity_title)
        	$('#cmnt_name').append('<span>主办社团：</span>' + community.community_name)
        	$('#activity_start_time').append('<span>开始时间：</span>' + activity.start_time)
        	$('#activity_intro').append('<span>活动介绍：</span>' + activity.activity_content)
        }
    });
    
	
	$('#apply_button').click(function() {
		if (validateUser()) {
			var username = getCookie("USER_COOKIE").split(',')[0].replace('"', '')
			var uid = getUrlParam('uid')
			var content = $('#apply_textarea').val()
			
			if ('' == content.trim() || '申请加入理由' == content.trim()) {
				alert('申请理由不能为空！')
				return false;
			}
			
			// 判断该学生是否已加入社团
			$.ajax({
				type: 'get',
				url: '../ajax!validateMember.action',
				data: 'username=' + username + '&uid=' + uid + '&content=' + content,
				dataType: 'json',
				success: function (data) {
					var member = JSON.parse(data.msgMember)
					if (member.id != null && member.id != 0) {
						alert('您已申请或已加入该社团，请勿重复操作')
					} else {
						alert('申请成功！请等待审核')
					}
				}
			})
	    } else {
	    	alert('请先登录！')
	    }
	});
	
});

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