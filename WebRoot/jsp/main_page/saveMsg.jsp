<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>添加留言</title>
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
		<div class="row">
			<form id="J_Form" class="form-horizontal span24" action="webMsg!save.action" method="post">
				<div class="row">
					<div class="control-group span8">
						<label class="control-label"><s>*</s>您的姓名：</label>
						<div class="controls">
							<input name="webMsg.user_name" value="${webMsg.user_name }" data-rules="{required:true}"
								class="input-normal control-text">
						</div>

						<label class="control-label"><s>*</s>您的留言：</label>
						<div class="controls">
							<input id="newPassword" name="webMsg.content" value="${webMsg.content}" data-rules="{required:true}"
								class="input-normal control-text">
						</div>
					</div>
				</div>
				</div>
				</div>
				<div class="row form-actions actions-bar">
					<div class="span13 offset3 ">
						<button type="submit" class="button button-primary">添加</button>
					</div>
				</div>
			</form>
		</div>


	</div>
	<script type="text/javascript" src="assets/js/jquery-1.8.1.min.js"></script>
	<script type="text/javascript" src="assets/js/bui-min.js"></script>

	<script type="text/javascript" src="assets/js/config-min.js"></script>

<body>
</html>
