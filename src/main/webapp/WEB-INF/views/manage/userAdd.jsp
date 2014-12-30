<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
</head>
<body>
	<div class="container-fluid">
		<ul class="breadcrumb">
			<li><i class="icon-home"></i> <a href="index.html">Home</a> <i
				class="icon-angle-right"></i></li>
			<li><a href="jump/jump/manage_userList">用户管理</a> <i
				class="icon-angle-right"></i></li>

			<li><a href="#">新增用户</a></li>

		</ul>

		<div class="portlet box blue tabbable">

			<div class="portlet-title">

				<div class="caption">

					<i class="icon-reorder"></i> <span class="hidden-480">新增用户</span>

				</div>

			</div>

			<div class="portlet-body form">

				<!-- BEGIN FORM-->

				<form action="" class="form-horizontal">


					<div class="control-group">

						<label class="control-label">用户名</label>

						<div class="controls">

							<input type="text" id="loginName" placeholder="用户名"
								class="m-wrap medium">
						</div>

					</div>

					<div class="control-group">

						<label class="control-label">姓名</label>

						<div class="controls">
							<input type="text" id="name" placeholder="姓名"
								class="m-wrap medium">
						</div>

					</div>
					<div class="control-group">

						<label class="control-label">密码</label>

						<div class="controls">
							<input type="password" id="password" placeholder="密码"
								class="m-wrap medium">
						</div>

					</div>

					<div class="control-group">

						<label class="control-label">角色</label>

						<div class="controls">

							<select class="small m-wrap" id="roles" tabindex="1">

								<option value="Category 1">普通用户</option>

								<option value="Category 2">管理员</option>

							</select>

						</div>

					</div>

					<div class="form-actions">

						<button type="submit" class="btn blue">
							<i class="icon-ok"></i>保存
						</button>

						<button type="button" class="btn">取消</button>

					</div>

				</form>

				<!-- END FORM-->
			</div>

		</div>
	</div>

	<script>
		jQuery(document).ready(
				function() {
					$("a[href='jump/manage_userAdd']").parent().addClass(
							"active");
					$("a[href='jump/manage_userAdd']").parent().parent()
							.parent().addClass("active");
				});
	</script>
</body>
</html>
