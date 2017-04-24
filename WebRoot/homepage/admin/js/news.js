/**
 * Created by zhangzhanqi on 2017/4/18.
 */
$(document).ready(function () {
    $.ajax({
        url: '../ajax!getAllNews.action',
        type: 'GET',
        data: '{}',
        dataType: 'json',
        success: function (data) {
            $.each(eval("(" + data.msgNews + ")"), function (i, value) {
                var insert_time = value.insert_time.split(' ')[0]
                $('ul').append("<li class='list top'><span>[" + insert_time + "]</span><a href='shownews.jsp?uid=" + value.id + "' title='如何选择网站关键词?' target='_self'>" 
                		+ value.news_title + "</a><img class='listhot' src='images/hot.gif' alt='图片关键词' /></li>")
            });
        }
    })
});





