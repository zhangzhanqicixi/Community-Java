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
        }
    })
});



function getQueryString(name) {
	var reg = new RegExp('(^|&)' + name + '=([^&]*)(&|$)', 'i');
	var r = window.location.search.substr(1).match(reg);
	if (r != null) {
		return unescape(r[2]);
	}
	return null;
}
	

