/**
 * Created by zhangzhanqi on 2017/4/18.
 */
$(document).ready(function () {
    $.ajax({
        url: '../ajax!homepageInfo.action',
        type: 'GET',
        dataType: 'json',
        success: function (data) {
            $.each(eval("(" + data.msgNews + ")"), function (i, value) {
                var insert_time = value.insert_time.split(' ')[0]
                $('#list_news').append("<li class='list top'><span class='time'>" + insert_time + "</span><a href='#'>" + value.news_title + "</a></li>")
            });
            $.each(eval("(" + data.msgAct + ")"), function (i, value) {
                var start_time = value.start_time.split(' ')[0]
                $('#list_activities').append("<li class='list '><span class='time'>" + start_time + "</span><a href='#'>" + value.activity_title + "</a></li>")
            });
            $.each(eval("(" + data.msgCmnt + ")"), function (i, value) {
                $('#list_communities').append('<dl class="ind"><dt style="height: 80px;"><a href="#" target="_self">' +
                    '<img src="images/1342431883.jpg" alt="图片关键词" title="图片关键词" style="width:116px; ' +
                    'height:80px;"/></a></dt><dd style="width: 149px; height: 80px;"> <h4><a href="#" target="_self" title="示例案例六">' + value.community_name + '</a></h4> ' +
                    '<p class="desc" title="相关描述文字，相关描述文字，相关描述文字，相关描述文字，相关描述文字。">' + value.community_introduction + '</p>' +
                    ' </dd></dl>')
            });
            $('#list_communities').append('<div class="clear"></div>')
            web_info = JSON.parse(data.msgIntro)
            $('span.tel').text(web_info.tel);
            $('span.address').text(web_info.addres);
            $('#introduction').text(web_info.introduction);
        }
    });
});





