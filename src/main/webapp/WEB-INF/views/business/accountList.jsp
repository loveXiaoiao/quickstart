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
			<li><a href="#">业务管理</a> <i class="icon-angle-right"></i></li>
			<li><a href="#">帐号列表</a></li>

		</ul>
		<div class="portlet box blue">
			<div class="portlet-title">
				<div class="caption">
					<i class="icon-globe"></i>帐号列表
				</div>
			</div>
			<div class="portlet-body">
				<div class="controls">
					<label class="help-inline">帐号：</label> <input class="m-wrap small"
						size="8" type="text" id="search_LIKE_accountName"
						name="search_LIKE_accountName" placeholder="微信号">
					<button class="btn red" onclick="reloadTable();">查询</button>
					<button class="btn green" onclick="reset();">重置</button>
				</div>

				<div class="clearfix">
					<!-- 按钮 -->
					<p>
						<button id="sample_editable_1_new" class="btn green"
							onclick="tankun()">
							增加 <i class="icon-plus"></i>
						</button>
						<button id="sample_editable_1_del" class="btn red"
							onclick="delUsers()">
							删除<i class="icon-minus"></i>
						</button>
					</p>
				</div>

				<table class="table table-striped table-bordered table-hover"
					id="accounttable">
					<thead>
						<tr>
							<th style="width: 8px;"><input type="checkbox"
								class="group-checkable" data-set="#accounttable .checkboxes" /></th>

							<th>帐号</th>

							<th class="hidden-480">密码</th>

							<th class="hidden-480">昵称</th>

							<th class="hidden-480">头像</th>

							<th class="hidden-480">创建时间</th>

							<th class="hidden-480">性别</th>

							<th class="hidden-480">地区</th>

							<th class="hidden-480">个性签名</th>

							<th class="hidden-480">操作</th>

							<th></th>

						</tr>

					</thead>

				</table>
			</div>
		</div>
	</div>
	<%@include file="../commons/messageBox.jsp"%>
	<%@include file="accountAdd.jsp" %>
	<%@include file="circleAdd.jsp" %>
	<script src="js/business/accountList.js" type="text/javascript"></script>
	<script>
		jQuery(document).ready(
				function() {
					App.init();
					Account.init();
					$("#circleAdd").click(function(){
						addCircle();
					});
					$("a[href='jump/business_accountList']").parent().addClass(
							"active");
					$("a[href='jump/business_accountList']").parent().parent()
							.parent().addClass("active");
				});
	</script>
</body>
</html>
