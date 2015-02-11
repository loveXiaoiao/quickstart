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
			<li><a href="#">说说列表</a></li>

		</ul>
		<div class="portlet box blue">
			<div class="portlet-title">
				<div class="caption">
					<i class="icon-globe"></i>说说列表
				</div>
			</div>
			<div class="portlet-body">
				<div class="controls">
					<label class="help-inline">内容：</label> <input class="m-wrap small"
						size="8" type="text" id="search_LIKE_content" name="search_LIKE_content" placeholder="内容">
					<button class="btn red" onclick="reloadTable();">查询</button>
					<button class="btn green" onclick="reset();">重置</button>
				</div>

				<div class="clearfix">
					<!-- 按钮 -->
					<p>
						<button id="sample_editable_1_new" class="btn green"
							onclick="addTK();">
							增加 <i class="icon-plus"></i>
						</button>
						<button id="sample_editable_1_del" class="btn red"
							onclick="batchDel();">
							删除<i class="icon-minus"></i>
						</button>
					</p>
				</div>

				<table class="table table-striped table-bordered table-hover"
					id="topictable">
					<thead>
						<tr>
							<th style="width: 8px;"><input type="checkbox"
								class="group-checkable" data-set="topictable .checkboxes" /></th>

							<th>内容</th>

							<th class="hidden-480">图片</th>
							
							<th class="hidden-480">发表时间</th>

							<th class="hidden-480">发表帐号</th>

							<th class="hidden-480">圈子</th>

							<th class="hidden-480">角色</th>

							<th class="hidden-480">操作</th>

							<th></th>

						</tr>

					</thead>

				</table>
			</div>
		</div>
	</div>
	<%@include file="../commons/messageBox.jsp"%>
	<%@include file="topicAdd.jsp" %>
	<script src="js/business/topicList.js" type="text/javascript"></script>
	
	<script>
		jQuery(document).ready(
				function() {
					App.init();
					Topic.init();
					$("a[href='jump/business_topicList']").parent().addClass(
							"active");
					$("a[href='jump/business_topicList']").parent().parent()
							.parent().addClass("active");
				});
	</script>
</body>
</html>
