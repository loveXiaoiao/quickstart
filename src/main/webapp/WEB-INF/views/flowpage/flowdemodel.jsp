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
	<meta charset="utf-8" />
	<title>surfilter-flow</title>
	<meta content="width=device-width, initial-scale=1.0" name="viewport" />
	<meta content="" name="description" />
	<meta content="" name="author" />
	<!-- BEGIN GLOBAL MANDATORY STYLES -->
	<%@ include file="../commons/common_css.jsp"%>
	<!-- END GLOBAL MANDATORY STYLES -->
	<!-- BEGIN PAGE LEVEL STYLES --> 
	<link href="media/css/jquery.gritter.css" rel="stylesheet" type="text/css"/>
	<link href="media/css/daterangepicker.css" rel="stylesheet" type="text/css" />
	<link href="media/css/fullcalendar.css" rel="stylesheet" type="text/css"/>
	<link href="media/css/jqvmap.css" rel="stylesheet" type="text/css" media="screen"/>
	<link href="media/css/jquery.easy-pie-chart.css" rel="stylesheet" type="text/css" media="screen"/>
	<!-- END PAGE LEVEL STYLES -->
	<link rel="shortcut icon" href="media/image/favicon.ico" />
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
							系统状态 <small>统计数据</small>
						</h3>
						
						<!-- END PAGE TITLE & BREADCRUMB-->
					</div>
				</div>
				<!-- END PAGE HEADER-->
				<div id="dashboard">
					<!-- BEGIN DASHBOARD STATS -->
					流程模板
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
	<script src="media/js/app.js" type="text/javascript"></script>
	<script src="media/js/index.js" type="text/javascript"></script>        
	<!-- END PAGE LEVEL SCRIPTS -->  
	<script>
		jQuery(document).ready(function() {    
		   App.init(); // initlayout and core plugins
		   //addClass("active");
		   $("a[href='jump/flowpage_flowdemodel']").parent().addClass("active");		   $("a[href='jump/flowpage_flowdemodel']").parent().parent().parent().addClass("active");
		 // alert(html);
			//alert( $("a[href='jump/user']").attr("href"));
		});
	</script>
	<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>