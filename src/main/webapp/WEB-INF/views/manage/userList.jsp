<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
</head>
<body>
	<div class="container-fluid">
		<ul class="breadcrumb">
			<li><i class="icon-home"></i> <a href="index.html">Home</a> <i
				class="icon-angle-right"></i></li>
			<li><a href="#">用户管理</a> <i class="icon-angle-right"></i></li>

			<li><a href="#">用户列表</a></li>

		</ul>
		<div class="portlet box blue">
			<div class="portlet-title">
				<div class="caption">
					<i class="icon-globe"></i>用户列表
				</div>
			</div>
			<div class="portlet-body">
				<div class="controls">
					<label class="help-inline">用户名：</label> 
					<input class="m-wrap small" size="8" type="text" id="search_LIKE_loginName" name="search_LIKE_loginName" placeholder="用户名"> 
					<label class="help-inline">姓名:</label> 
					<input class="m-wrap small" name="search_LIKE_name" id="search_LIKE_name" size="8" type="text" placeholder="姓名">
					<button class="btn red" onclick="reloadTable();">查询</button>
					<button class="btn green" onclick="reset();">重置</button>
				</div>

				<div class="clearfix">
					<!-- 按钮 -->
					<p>
						<button id="sample_editable_1_new" class="btn green"
							onclick="window.location.href='jump/manage_userAdd'">
							增加 <i class="icon-plus"></i>
						</button>
						<button id="sample_editable_1_del" class="btn red"
							onclick="delUsers()">
							删除<i class="icon-minus"></i>
						</button>
						<button id="sample_editable_1_tk" class="btn red"onclick="tankun()">
							弹框<i class="icon-minus"></i>
						</button>
					</p>
				</div>

				<table class="table table-striped table-bordered table-hover" id="usertable">
					<thead>

						<tr>

							<th style="width: 8px;"><input type="checkbox" class="group-checkable" data-set="#usertable .checkboxes" /></th>

							<th>用户名</th>

							<th class="hidden-480">姓名</th>

							<th class="hidden-480">角色</th>

							<th class="hidden-480">注册时间</th>
							
							<th class="hidden-480">操作</th>

							<th></th>

						</tr>

					</thead>

				</table>
			</div>

		</div>

	</div>
	<%@include file = "../commons/messageBox.jsp" %>
	<script src="js/manage/userList.js" type="text/javascript"></script>
	<script>
		jQuery(document).ready(
				function() {
					User.init();
					$("a[href='jump/manage_userList']").parent().addClass(
							"active");
					$("a[href='jump/manage_userList']").parent().parent()
							.parent().addClass("active");
				});
	</script>
</body>
</html>
