<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<html lang="en" class="no-js"><head>	<base href="<%=basePath%>">
	<title>surfilter-flow流程管理</title>	<%@ include file="../commons/common_css.jsp"%>	<link rel="stylesheet" type="text/css" href="media/css/select2_metro.css" />
	<link rel="stylesheet" href="media/css/DT_bootstrap.css" />
</head><body class="page-header-fixed">	<%@ include file="../commons/head.jsp"%>
	<div class="page-container">		<%@ include file="../commons/sidebar.jsp"%>		<div class="page-content">			<div id="portlet-config" class="modal hide">				<div class="modal-header">					<button data-dismiss="modal" class="close" type="button"></button>					<h3>Widget Settings</h3>				</div>				<div class="modal-body">					Widget settings form goes here				</div>			</div>			<div class="container-fluid">				<div class="row-fluid">					<div class="span12">						<h3 class="page-title">							流程管理 <small>列表</small>						</h3>					</div>				</div>				<div class="portlet box blue">
							<div class="portlet-title">
								<div class="caption"><i class="icon-globe"></i>显示/隐藏  数据项</div>
								<div class="actions">
									<div class="btn-group">
										<a class="btn" href="#" data-toggle="dropdown">
										数据项
										<i class="icon-angle-down"></i>
										</a>
										<div id="ckcolum" class="dropdown-menu hold-on-click dropdown-checkboxes pull-right">
											<label><input type="checkbox" checked data-column="1">任务ID</label>
											<label><input type="checkbox" checked data-column="2">任务Key</label>
											<label><input type="checkbox" checked data-column="3">任务名称</label>
											<label><input type="checkbox" checked data-column="4">流程定义id</label>
											<label><input type="checkbox" checked data-column="5">流程实例id</label>
											<label><input type="checkbox" checked data-column="6">优先级</label>
											<label><input type="checkbox" checked data-column="7">任务创建日期</label>
											<label><input type="checkbox" checked data-column="8">任务逾期日</label>
											<label><input type="checkbox" checked data-column="9">任务描述</label>
											<label><input type="checkbox" checked data-column="10">任务所属人</label>
											<label><input type="checkbox" checked data-column="11">操作</label>
										</div>
									</div>
								</div>
							</div>
							<div class="portlet-body">
								<div class="clearfix">
									<!-- 按钮 -->
									<div class="btn-group">
<!-- 										<button id="sample_editable_1_new" class="btn green" onclick="addUser()" > -->
<!-- 											增加 <i class="icon-plus"></i> -->
<!-- 										</button> -->
<!-- 										<button id="sample_editable_1_new" class="btn red" onclick="deleteUsers()" > -->
<!-- 											删除<i class="icon-minus"></i> -->
<!-- 										</button> -->
<!-- 										<button id="sample_editable_1_new" class="btn blue" onclick="deploy()" > -->
<!-- 											部署流程<i class="icon-gift"></i> -->
<!-- 										</button> -->
									</div>
								</div>
								<table class="table table-striped table-bordered table-hover table-full-width" id="flowtable">
									<thead>
										<tr>
											<th style="width:8px;"><input type="checkbox" class="group-checkable" data-set="#sample_1 .checkboxes" onclick="selectAll()"/></th>
											<th>任务ID</th>
											<th>任务Key</th>
											<th>任务名称</th>
											<th>流程定义id</th>
											<th>流程实例id</th>
											<th>优先级</th>
											<th>任务创建日期</th>
											<th>任务逾期日</th>
											<th>任务描述</th>
											<th>任务所属人</th>
											<th>操作</th>
										</tr>
									</thead>
									<tfoot>
										<tr>
											<th style="width:8px;"></th>
											<th>任务ID</th>
											<th>任务Key</th>
											<th>任务名称</th>
											<th>流程定义id</th>
											<th>流程实例id</th>
											<th>优先级</th>
											<th>任务创建日期</th>
											<th>任务逾期日</th>
											<th>任务描述</th>
											<th>任务所属人</th>
											<th></th>
										</tr>
									</tfoot>
								</table>
							</div>
						</div>			</div>		</div>	</div>	<%@ include file="../commons/footer.jsp"%>	<%@ include file="../commons/common_js.jsp"%>	<script type="text/javascript" src="media/js/select2.min.js"></script>
	<script type="text/javascript" src="media/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="media/js/DT_bootstrap.js"></script>
	<script src="js/manage/userFlows.js" type="text/javascript"></script>         	<script>
		jQuery(document).ready(function() {    		   App.init(); 
		   Flow.init();
		   $("a[href='jump/manage_user']").parent().addClass("active");		   $("a[href='jump/manage_user']").parent().parent().parent().addClass("active");
		});
	</script></body></html>