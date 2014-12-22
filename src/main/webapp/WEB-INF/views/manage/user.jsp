<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<!-- 
Template Name: Metronic - Responsive Admin Dashboard Template build with Twitter Bootstrap 2.3.1
Version: 1.3
Author: KeenThemes
Website: http://www.keenthemes.com/preview/?theme=metronic
Purchase: http://themeforest.net/item/metronic-responsive-admin-dashboard-template/4021469
-->
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!--> <html lang="en" class="no-js"> <!--<![endif]-->
<!-- BEGIN HEAD -->
<head>	<base href="<%=basePath%>">

	<title>surfilter-flow</title>
	<!-- BEGIN GLOBAL MANDATORY STYLES -->
	<%@ include file="../commons/common_css.jsp"%>
	<!-- END GLOBAL MANDATORY STYLES -->
	<!-- BEGIN PAGE LEVEL STYLES --> 	<link rel="stylesheet" type="text/css" href="media/css/select2_metro.css" />

	<link rel="stylesheet" href="media/css/DT_bootstrap.css" />


	<!-- END PAGE LEVEL STYLES -->

</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body class="page-header-fixed">
	<!-- BEGIN HEADER -->	<%@ include file="../commons/head.jsp"%>
	<!-- END HEADER -->
	<!-- BEGIN CONTAINER -->
	<div class="page-container">
		<!-- BEGIN SIDEBAR -->
		<%@ include file="../commons/sidebar.jsp"%>
		<!-- END SIDEBAR -->
		<!-- BEGIN PAGE -->
		<div class="page-content">
			<!-- BEGIN SAMPLE PORTLET CONFIGURATION MODAL FORM-->
			<div id="portlet-config" class="modal hide">
				<div class="modal-header">
					<button data-dismiss="modal" class="close" type="button"></button>
					<h3>Widget Settings</h3>
				</div>
				<div class="modal-body">
					Widget settings form goes here
				</div>
			</div>
			<!-- END SAMPLE PORTLET CONFIGURATION MODAL FORM-->
			<!-- BEGIN PAGE CONTAINER-->
			<div class="container-fluid">
				<!-- BEGIN PAGE HEADER-->
				<div class="row-fluid">
					<div class="span12">

						<!-- END BEGIN STYLE CUSTOMIZER -->    
						<!-- BEGIN PAGE TITLE & BREADCRUMB-->
						<h3 class="page-title">
							用户管理 <small>列表</small>
						</h3>
						
						<!-- END PAGE TITLE & BREADCRUMB-->
					</div>
				</div>
				<!-- END PAGE HEADER-->
				<div class="portlet box blue">

							<div class="portlet-title">

								<div class="caption"><i class="icon-globe"></i>显示/隐藏  数据项</div>

								<div class="actions">

									<div class="btn-group">

										<a class="btn" href="#" data-toggle="dropdown">

										数据项

										<i class="icon-angle-down"></i>

										</a>
										<div id="ckcolum" class="dropdown-menu hold-on-click dropdown-checkboxes pull-right">

											<label><input type="checkbox" checked data-column="1">记录编号</label>

											<label><input type="checkbox" checked data-column="2">编码</label>

											<label><input type="checkbox" checked data-column="3">密码</label>

											<label><input type="checkbox" checked data-column="4">用户名</label>
											
											<label><input type="checkbox" checked data-column="5">操作</label>
										</div>

									</div>

								</div>

							</div>

							<div class="portlet-body">
								<div class="clearfix">
									<!-- 按钮 -->
									<div class="btn-group">
		
										<button id="sample_editable_1_new" class="btn green" onclick="addUser()" >
											增加 <i class="icon-plus"></i>
										</button>
										<button id="sample_editable_1_new" class="btn red" onclick="deleteUsers()" >
											删除<i class="icon-minus"></i>
										</button>
		
									</div>
								
								</div>
								<table class="table table-striped table-bordered table-hover table-full-width" id="usertable">

									<thead>

										<tr>
											<th style="width:8px;"><input type="checkbox" class="group-checkable" data-set="#sample_1 .checkboxes" onclick="selectAll()"/></th>
											
											<th>记录编号</th>

											<th>编码</th>

											<th>密码</th>
											
											<th>用户名</th>
											
											<th>操作</th>
										</tr>

									</thead>
								<!-- 	<tbody>
										<tr>
											<td colspan="5">Loading data from server</td>
										</tr>
							        </tbody> -->
									<tfoot>

										<tr>
											<th style="width:8px;"></th>
											
											<th>记录编号</th>

											<th>编码</th>

											<th>密码</th>
											
											<th>用户名</th>
											
											<th>操作</th>
										</tr>

									</tfoot>
									

								</table>

							</div>

						</div>
			</div>
			<!-- END PAGE CONTAINER-->    
		</div>
		<!-- END PAGE -->
	</div>
	<!-- END CONTAINER -->
	<!-- BEGIN FOOTER -->
	<%@ include file="../commons/footer.jsp"%>
	<!-- END FOOTER -->
	<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->
	<!-- BEGIN CORE PLUGINS -->
	<%@ include file="../commons/common_js.jsp"%>
	<!-- END CORE PLUGINS -->
	<!-- BEGIN PAGE LEVEL PLUGINS -->

	<!-- END PAGE LEVEL PLUGINS -->
	<!-- BEGIN PAGE LEVEL SCRIPTS -->
	<script type="text/javascript" src="media/js/select2.min.js"></script>

	<script type="text/javascript" src="media/js/jquery.dataTables.min.js"></script>

	<script type="text/javascript" src="media/js/DT_bootstrap.js"></script>

<!-- 	<script src="media/js/index.js" type="text/javascript"></script>   -->
	<script src="js/manage/user.js" type="text/javascript"></script>         
	<!-- END PAGE LEVEL SCRIPTS -->  
	<script>
		jQuery(document).ready(function() {    		   App.init(); // initlayout and core plugins

			
		   User.init();
		   //addClass("active");
		   $("a[href='jump/manage_user']").parent().addClass("active");		   $("a[href='jump/manage_user']").parent().parent().parent().addClass("active");
		 // alert(html);
			//alert( $("a[href='jump/user']").attr("href"));
		});
	</script>
	<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>