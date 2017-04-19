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
                var insert_time = value.start_time.split(' ')[0]
                $('ul').append("<li class='list top'><span>[" + insert_time + "]</span><a href='shownews.jsp' title='如何选择网站关键词?' target='_self'>" + value.activity_title + " &nbsp; -- &nbsp; 网球社</a></li>")
            });
        }
    })
});





