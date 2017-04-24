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
});





