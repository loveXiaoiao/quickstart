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
			<li><a href="#">评论列表</a></li>

		</ul>
		<div class="portlet box blue">
			<div class="portlet-title">
				<div class="caption">
					<i class="icon-globe"></i>评论列表
				</div>
			</div>
			<div class="portlet-body">
				<div class="controls">
					<label class="help-inline">评论内容：</label> <input class="m-wrap small"
						size="8" type="text" id="search_LIKE_content"
						name="search_LIKE_name" placeholder="评论内容">
					<button class="btn red" onclick="reloadTable();">查询</button>
					<button class="btn green" onclick="reset();">重置</button>
				</div>

				<div class="clearfix">
					<!-- 按钮 -->
					<p>
						<button id="sample_editable_1_del" class="btn red"
							onclick="delComments();">
							删除<i class="icon-minus"></i>
						</button>
					</p>
				</div>

				<table class="table table-striped table-bordered table-hover"
					id="commenttable">
					<thead>
						<tr>
							<th style="width: 8px;"><input type="checkbox"
								class="group-checkable" data-set="commenttable .checkboxes" /></th>

							<th>评论内容</th>

							<th class="hidden-480">图片</th>
							
							<th class="hidden-480">发表时间</th>
							
							<th class="hidden-480">所在说说</th>

							<th class="hidden-480">帐号</th>

							<th class="hidden-480">圈子</th>

							<th class="hidden-480">角色</th>
							
							<th class="hidden-480">父评论</th>

							<th class="hidden-480">操作</th>

							<th></th>

						</tr>

					</thead>

				</table>
			</div>
		</div>
	</div>
	<%@include file="../commons/messageBox.jsp"%>
	<%@include file="commentAdd.jsp" %>
	<script src="js/business/commentList.js" type="text/javascript"></script>
	
	<script>
		jQuery(document).ready(
				function() {
					App.init();
					Comment.init();
					$("#commentAdd").click(function(){
						addChildComment();
					});
					$("a[href='jump/business_commentList']").parent().addClass(
							"active");
					$("a[href='jump/business_commentList']").parent().parent()
							.parent().addClass("active");
				});
	</script>
</body>
</html>
