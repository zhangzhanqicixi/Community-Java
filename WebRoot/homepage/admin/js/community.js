/**
 * Created by zhangzhanqi on 2017/4/18.
 */
$(document).ready(function () {
	$.ajax({
		url: '../ajax!getAllCommunity.action',
        type: 'GET',
        data: '{}',
        dataType: 'json',
        success: function (data) {
        	var tr = ''
            $.each(eval("(" + data.msgCmnt + ")"), function (i, value) {
            	var tr_head = ''
            	var tr_tail = ''
            	
            	if (i % 3 == 0) {
            		//如果是0,3,6 ....
            		tr_head = '<tr>'
            	}
            	if (i % 3 == 2) {
            		// 如果是2,5,8
            		tr_tail = '</tr>'
            	}
                tr = tr + tr_head + '<td style="display: table-cell"><dt><a href="showcommunity.jsp?uid=' + value.id + '" target="_self"><img src="http://127.0.0.1:8080/community/' + value.community_img_path + '" alt="图片关键词" title="图片关键词" style="width:200px; height:150px;" /></a>' +
                	'</dt><dd><h4><a href="showcommunity.jsp?uid=' + value.id + '" target="_self" title="' + value.community_name + '">' + value.community_name + '</a></h4></dd></td>' + tr_tail
            });
        	$('.table_list').append(tr)
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
			$('#nav_3').attr('class', 'hover')
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


