<%@page contentType="text/html; charset=utf-8"%>
<%@ include file="../_frag/include/include.inc.jsp"%>

<div class="pageContent">
	<!--
		<form method="post" action="addGrade_Activity.action?navTabId=grade_activity&callbackType=closeCurrent" enctype="multipart/form-data" class="pageForm required-validate" onsubmit="return iframeCallback(this,navTabAjaxDone);">
	-->
	  <form method="post" action="addGrade_Activity.action?navTabId=grade_activity&callbackType=closeCurrent" class="required-validate pageForm" onsubmit="return validateCallback(this, navTabAjaxDone);">
		
		<div class="pageFormContent" layoutH="56">
		<div class="demo">
		    <div class="unit">
                <div class="stars">
                    <label>活动效果：</label>
                    <img src="images/star_gray.png"/>
                    <img src="images/star_gray.png"/>
                    <img src="images/star_gray.png"/>
                    <img src="images/star_gray.png"/>
                    <img src="images/star_gray.png"/>
                    <input name="activityGrade.grade1" id="grade1" type="hidden">
                </div>
                <div class="stars">
                    <label>活动趣味性：</label>
                    <img src="images/star_gray.png"/>
                    <img src="images/star_gray.png"/>
                    <img src="images/star_gray.png"/>
                    <img src="images/star_gray.png"/>
                    <img src="images/star_gray.png"/>
                    <input name="activityGrade.grade2" id="grade2" type="hidden">
              </div>
                <div class="stars">
                    <label>活动收获：</label>
                    <img src="images/star_gray.png"/>
                    <img src="images/star_gray.png"/>
                    <img src="images/star_gray.png"/>
                    <img src="images/star_gray.png"/>
                    <img src="images/star_gray.png"/>
                    <input name="activityGrade.grade3" id="grade3" type="hidden">
                </div>
                <div class="stars">
                    <label>主办方态度：</label>
                    <img src="images/star_gray.png"/>
                    <img src="images/star_gray.png"/>
                    <img src="images/star_gray.png"/>
                    <img src="images/star_gray.png"/>
                    <img src="images/star_gray.png"/>
                    <input name="activityGrade.grade4" id="grade4" type="hidden">
                </div>
                <input name="activityGrade.collegeId" value="${activity.collegeId}" type="hidden">
                <input name="activityGrade.activityId" value="${activity.activityId}" type="hidden">
           		<input name="activityGrade.userId" value="${user.userId}" type="hidden">
            </div>
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">评价</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div></li>
			</ul>
		</div>
	</form>
	
     <script type="text/javascript">
            $(function() {
                //定义三维数组
                var data = [
                    [
                        ['', ''],
                        ['', ''],
                        ['', ''],
                        ['', ''],
                        ['', '']
                    ],
                    [
                        ['', ''],
                        ['', ''],
                        ['', ''],
                        ['', ''],
                        ['', '']
                    ],
                    [
                        ['', ''],
                        ['', ''],
                        ['', ''],
                        ['', ''],
                        ['', '']
                    ],
                    [
                        ['', ''],
                        ['', ''],
                        ['', ''],
                        ['', ''],
                        ['', '']
                    ]
                ];
                //定义悬浮每行各个星星图片
                var stars = [
                    ['star_hover.png', 'star_gray.png', 'star_gray.png', 'star_gray.png', 'star_gray.png'],
                    ['star_hover.png', 'star_hover.png', 'star_gray.png', 'star_gray.png', 'star_gray.png'],
                    ['star_gold.png', 'star_gold.png', 'star_gold.png', 'star_gray.png', 'star_gray.png'],
                    ['star_gold.png', 'star_gold.png', 'star_gold.png', 'star_gold.png', 'star_gray.png'],
                    ['star_gold.png', 'star_gold.png', 'star_gold.png', 'star_gold.png', 'star_gold.png'],
                ];

                $(".stars").find("img").hover(function() { //星星悬浮触发
                    var obj = $(this);//当前对象
                    var star_area = obj.parent(".stars"); //当前父级.stars
                    var star_area_index = star_area.parent().find(".stars").index(star_area);//当前父级.stars索引
                    var index = star_area.find("img").index(obj);//当前星星索引
                   
                    var left = obj.position().left;
                    var top = obj.position().top + 25;
                    var comment_title = data[star_area_index][index][0];//标题
                    var comment_description = data[star_area_index][index][1];//描述
                    $("#tip").css({"left": left, "top": top}).show().html(comment_title);//显示定位提示信息
                    for (var i = 0; i < 5; i++) {
                        star_area.find("img").eq(i).attr("src", "images/" + stars[index][i]);//切换每个星星
                    }
                    star_area.find(".comment_description").remove();//星星右侧切换描述
                    star_area.append("<span class='comment_description'><span class='comment_title'>" + comment_title + "</span><span class='intro'>" + comment_description + "</span></span>");

                }, function() { //鼠标离开星星
                    $("#tip").hide();//隐藏提示
                    var obj = $(this);//当前对象
                    var star_area = obj.parent(".stars");//当前父级.stars
                    var star_area_index = star_area.parent().find(".stars").index(star_area);//当前父级.stars索引
                    var index = star_area.attr("data-default-index");//点击后的索引
                    if (index >= 0) { //若该行点击后的索引大于等于0，说明该行星星已被点击
                        var comment_title = data[star_area_index][index][0];//标题
                        var comment_description = data[star_area_index][index][1];//描述
                        star_area.find(".comment_description").remove();//显示切换描述
                        star_area.append("<span class='comment_description'><span class='comment_title'>" + comment_title + "</span><span class='intro'>" + comment_description + "</span></span>");
                        for (var i = 0; i < 5; i++) {
                            star_area.find("img").eq(i).attr("src", "images/" + stars[index][i]);//更新该行星星
                        }
                    } else {
                        var obj = $(this);
                        var star_area = obj.parent(".stars");
                        star_area.find(".comment_description").remove();
                        for (var i = 0; i < 5; i++) {
                            star_area.find("img").eq(i).attr("src", "images/star_gray.png");//更新该行星星都变初始状态
                        }
                    }
                })
                $(".stars").find("img").click(function() { //当点击每颗星星
                    var obj = $(this);//当前对象
                    var star_area = obj.parent(".stars"); //当前父级.stars
                    var star_area_index = star_area.parent().find(".stars").index(star_area);//当前父级.stars索引
                    var index = obj.parent(".stars").find("img").index($(this));//当前星星索引
                    
					document.getElementById("grade" + (star_area_index + 1)).value = index + 1;//复制给相应的input
					
                    var comment_title = data[star_area_index][index][0];//标题
                    var comment_description = data[star_area_index][index][1];//描述
                    star_area.attr("data-default-index", index);//记录点击后的索引，用来鼠标移出星星后，获取之前点击后的星星索引
                    star_area.find(".comment_description").remove();//显示切换描述
                    star_area.append("<span class='comment_description'><span class='comment_title'>" + comment_title + "</span><span class='intro'>" + comment_description + "</span></span>");
                })
            })
        </script>
</div>

