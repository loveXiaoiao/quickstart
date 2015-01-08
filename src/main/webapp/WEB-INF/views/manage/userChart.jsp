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
			<li><a href="jump/manage_userList">用户管理</a> <i
				class="icon-angle-right"></i></li>

			<li><a href="#">新增用户</a></li>

		</ul>

		<div class="portlet blue box tabbable">

			<div class="portlet-title">

				<div class="caption">

					<i class="icon-reorder"></i> <span class="hidden-480">图表展示</span>

				</div>
				<div id="userChart" style="min-width:800px;height:400px"></div>
			</div>
			</div>
	</div>
	<script src="js/manage/userChart.js" type="text/javascript"></script>

	<script>
		jQuery(document).ready(
				function() {
					$("a[href='jump/manage_userChart']").parent().addClass(
							"active");
					$("a[href='jump/manage_userChart']").parent().parent()
							.parent().addClass("active");
				});
	</script>
</body>
</html>
			