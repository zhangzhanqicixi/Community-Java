<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>网站简介</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="assets/css/dpl-min.css" rel="stylesheet" type="text/css" />
<link href="assets/css/bui-min.css" rel="stylesheet" type="text/css" />
<link href="assets/css/page-min.css" rel="stylesheet" type="text/css" />
<!-- 下面的样式，仅是为了显示代码，而不应该在项目中使用-->
<link href="assets/css/prettify.css" rel="stylesheet" type="text/css" />
<style type="text/css">
code {
	padding: 0px 4px;
	color: #d14;
	background-color: #f7f7f9;
	border: 1px solid #e1e1e8;
}
</style>
</head>
<body>

	<div class="container">
		<div class="detail-page">
			<h1>网站信息</h1>
			<div class="detail-section">
				<!-- <div class="span8">
					<label>站点：</label><span class="detail-text">本站是校园社团管理系统，若未登陆，请先后上角登陆</span>
				</div> -->
				<h2>基本信息</h2>
				<div class="row detail-row">
					<div class="span8">
						<h3>
							<label>简介：</label><span class="detail-text">${webInfo.introduction}</span>
						</h3>
					</div>
				</div>
				<div class="detail-section">
					<h2>联系我们</h2>
					<div class="row detail-row">
						<div class="span8">
							<h3>
								<label>联系方式：</label><span class="detail-text">${webInfo.contact_us}</span>
							</h3>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="../assets/js/jquery-1.8.1.min.js"></script>
	<script type="text/javascript" src="../assets/js/bui-min.js"></script>

	<script type="text/javascript" src="../assets/js/config-min.js"></script>
	<script type="text/javascript">
		BUI.use('common/page');
	</script>
	<!-- 仅仅为了显示代码使用，不要在项目中引入使用-->
	<script type="text/javascript" src="../assets/js/prettify.js"></script>
	<script type="text/javascript">
		$(function() {
			prettyPrint();
		});
	</script>
	<script type="text/javascript">
		
	</script>
<body>
</html>
