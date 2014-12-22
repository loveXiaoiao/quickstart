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

	<!-- BEGIN GLOBAL MANDATORY STYLES -->
	<%@ include file="../commons/common_css.jsp"%>
	<!-- END GLOBAL MANDATORY STYLES -->
	<!-- BEGIN PAGE LEVEL STYLES --> 
	<link rel="stylesheet" type="text/css" href="media/css/select2_metro.css" />

	<link rel="stylesheet" href="media/css/DT_bootstrap.css" />
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
							流程定义 <small>列表</small>
						</h3>
						
						<!-- END PAGE TITLE & BREADCRUMB-->
					</div>
				</div>
				<!-- END PAGE HEADER-->
				<!-- BEGIN EXAMPLE TABLE PORTLET-->

						<div class="portlet box blue">

							<div class="portlet-title">

								<div class="caption"><i class="icon-globe"></i>Show/Hide Columns</div>

								<div class="actions">

									<div class="btn-group">

										<a class="btn" href="#" data-toggle="dropdown">

										Columns

										<i class="icon-angle-down"></i>

										</a>

										<div id="sample_2_column_toggler" class="dropdown-menu hold-on-click dropdown-checkboxes pull-right">

											<label><input type="checkbox" checked data-column="0">Rendering engine</label>

											<label><input type="checkbox" checked data-column="1">Browser</label>

											<label><input type="checkbox" checked data-column="2">Platform(s)</label>

											<label><input type="checkbox" checked data-column="3">Engine version</label>

											<label><input type="checkbox" checked data-column="4">CSS grade</label>

										</div>

									</div>

								</div>

							</div>

							<div class="portlet-body">

								<table class="table table-striped table-bordered table-hover table-full-width" id="sample_2">

									<thead>

										<tr>

											<th>Rendering engine</th>

											<th>Browser</th>

											<th class="hidden-480">Platform(s)</th>

											<th class="hidden-480">Engine version</th>

											<th class="hidden-480">CSS grade</th>

										</tr>

									</thead>

									<tbody>

										<tr>

											<td>Trident</td>

											<td>Internet

												Explorer 4.0

											</td>

											<td class="hidden-480">Win 95+</td>

											<td class="hidden-480">4</td>

											<td class="hidden-480">X</td>

										</tr>

										<tr >

											<td>Trident</td>

											<td>Internet

												Explorer 5.0

											</td>

											<td class="hidden-480">Win 95+</td>

											<td class="hidden-480">5</td>

											<td class="hidden-480">C</td>

										</tr>

										<tr >

											<td>Trident</td>

											<td>Internet

												Explorer 5.5

											</td>

											<td class="hidden-480">Win 95+</td>

											<td class="hidden-480">5.5</td>

											<td class="hidden-480">A</td>

										</tr>

										<tr >

											<td>Trident</td>

											<td>Internet

												Explorer 6

											</td>

											<td class="hidden-480">Win 98+</td>

											<td class="hidden-480">6</td>

											<td class="hidden-480">A</td>

										</tr>

										<tr >

											<td>Trident</td>

											<td>Internet Explorer 7</td>

											<td class="hidden-480">Win XP SP2+</td>

											<td class="hidden-480">7</td>

											<td class="hidden-480">A</td>

										</tr>

										<tr >

											<td>Trident</td>

											<td>AOL browser (AOL desktop)</td>

											<td class="hidden-480">Win XP</td>

											<td class="hidden-480">6</td>

											<td class="hidden-480">A</td>

										</tr>

										<tr >

											<td>Gecko</td>

											<td>Firefox 1.0</td>

											<td class="hidden-480">Win 98+ / OSX.2+</td>

											<td class="hidden-480">1.7</td>

											<td class="hidden-480">A</td>

										</tr>

										<tr >

											<td>Gecko</td>

											<td>Firefox 1.5</td>

											<td class="hidden-480">Win 98+ / OSX.2+</td>

											<td class="hidden-480">1.8</td>

											<td class="hidden-480">A</td>

										</tr>

										<tr >

											<td>Gecko</td>

											<td>Firefox 2.0</td>

											<td class="hidden-480">Win 98+ / OSX.2+</td>

											<td class="hidden-480">1.8</td>

											<td class="hidden-480">A</td>

										</tr>

										<tr >

											<td>Gecko</td>

											<td>Firefox 3.0</td>

											<td class="hidden-480">Win 2k+ / OSX.3+</td>

											<td class="hidden-480">1.9</td>

											<td class="hidden-480">A</td>

										</tr>

										<tr >

											<td>Gecko</td>

											<td>Camino 1.0</td>

											<td class="hidden-480">OSX.2+</td>

											<td class="hidden-480">1.8</td>

											<td class="hidden-480">A</td>

										</tr>

										<tr >

											<td>Gecko</td>

											<td>Camino 1.5</td>

											<td class="hidden-480">OSX.3+</td>

											<td class="hidden-480">1.8</td>

											<td class="hidden-480">A</td>

										</tr>

										<tr >

											<td>Gecko</td>

											<td>Netscape 7.2</td>

											<td class="hidden-480">Win 95+ / Mac OS 8.6-9.2</td>

											<td class="hidden-480">1.7</td>

											<td class="hidden-480">A</td>

										</tr>

										<tr >

											<td>Gecko</td>

											<td>Netscape Browser 8</td>

											<td class="hidden-480">Win 98SE+</td>

											<td class="hidden-480">1.7</td>

											<td class="hidden-480">A</td>

										</tr>

										<tr >

											<td>Gecko</td>

											<td>Netscape Navigator 9</td>

											<td class="hidden-480">Win 98+ / OSX.2+</td>

											<td class="hidden-480">1.8</td>

											<td class="hidden-480">A</td>

										</tr>

										<tr >

											<td>Gecko</td>

											<td>Mozilla 1.0</td>

											<td class="hidden-480">Win 95+ / OSX.1+</td>

											<td class="hidden-480">1</td>

											<td class="hidden-480">A</td>

										</tr>

										<tr >

											<td>Gecko</td>

											<td>Mozilla 1.1</td>

											<td class="hidden-480">Win 95+ / OSX.1+</td>

											<td class="hidden-480">1.1</td>

											<td class="hidden-480">A</td>

										</tr>

										<tr >

											<td>Gecko</td>

											<td>Mozilla 1.2</td>

											<td class="hidden-480">Win 95+ / OSX.1+</td>

											<td class="hidden-480">1.2</td>

											<td class="hidden-480">A</td>

										</tr>

										<tr >

											<td>Gecko</td>

											<td>Mozilla 1.3</td>

											<td class="hidden-480">Win 95+ / OSX.1+</td>

											<td class="hidden-480">1.3</td>

											<td class="hidden-480">A</td>

										</tr>

										<tr >

											<td>Gecko</td>

											<td>Mozilla 1.4</td>

											<td class="hidden-480">Win 95+ / OSX.1+</td>

											<td class="hidden-480">1.4</td>

											<td class="hidden-480">A</td>

										</tr>

										<tr >

											<td>Gecko</td>

											<td>Mozilla 1.5</td>

											<td class="hidden-480">Win 95+ / OSX.1+</td>

											<td class="hidden-480">1.5</td>

											<td class="hidden-480">A</td>

										</tr>

										<tr >

											<td>Gecko</td>

											<td>Mozilla 1.6</td>

											<td class="hidden-480">Win 95+ / OSX.1+</td>

											<td class="hidden-480">1.6</td>

											<td class="hidden-480">A</td>

										</tr>

										<tr >

											<td>Gecko</td>

											<td>Mozilla 1.7</td>

											<td class="hidden-480">Win 98+ / OSX.1+</td>

											<td class="hidden-480">1.7</td>

											<td class="hidden-480">A</td>

										</tr>

										<tr >

											<td>Gecko</td>

											<td>Mozilla 1.8</td>

											<td class="hidden-480">Win 98+ / OSX.1+</td>

											<td class="hidden-480">1.8</td>

											<td class="hidden-480">A</td>

										</tr>

										<tr >

											<td>Gecko</td>

											<td>Seamonkey 1.1</td>

											<td class="hidden-480">Win 98+ / OSX.2+</td>

											<td class="hidden-480">1.8</td>

											<td class="hidden-480">A</td>

										</tr>

										<tr >

											<td>Gecko</td>

											<td>Epiphany 2.20</td>

											<td class="hidden-480">Gnome</td>

											<td class="hidden-480">1.8</td>

											<td class="hidden-480">A</td>

										</tr>

										<tr >

											<td>Webkit</td>

											<td>Safari 1.2</td>

											<td class="hidden-480">OSX.3</td>

											<td class="hidden-480">125.5</td>

											<td class="hidden-480">A</td>

										</tr>

										<tr >

											<td>Webkit</td>

											<td>Safari 1.3</td>

											<td class="hidden-480">OSX.3</td>

											<td class="hidden-480">312.8</td>

											<td class="hidden-480">A</td>

										</tr>

										<tr >

											<td>Webkit</td>

											<td>Safari 2.0</td>

											<td class="hidden-480">OSX.4+</td>

											<td class="hidden-480">419.3</td>

											<td class="hidden-480">A</td>

										</tr>

										<tr >

											<td>Webkit</td>

											<td>Safari 3.0</td>

											<td class="hidden-480">OSX.4+</td>

											<td class="hidden-480">522.1</td>

											<td class="hidden-480">A</td>

										</tr>

										<tr >

											<td>Webkit</td>

											<td>OmniWeb 5.5</td>

											<td class="hidden-480">OSX.4+</td>

											<td class="hidden-480">420</td>

											<td class="hidden-480">A</td>

										</tr>

										<tr >

											<td>Webkit</td>

											<td>iPod Touch / iPhone</td>

											<td class="hidden-480">iPod</td>

											<td class="hidden-480">420.1</td>

											<td class="hidden-480">A</td>

										</tr>

										<tr >

											<td>Webkit</td>

											<td>S60</td>

											<td class="hidden-480">S60</td>

											<td class="hidden-480">413</td>

											<td class="hidden-480">A</td>

										</tr>

										<tr >

											<td>Presto</td>

											<td>Opera 7.0</td>

											<td class="hidden-480">Win 95+ / OSX.1+</td>

											<td class="hidden-480">-</td>

											<td class="hidden-480">A</td>

										</tr>

										<tr >

											<td>Presto</td>

											<td>Opera 7.5</td>

											<td class="hidden-480">Win 95+ / OSX.2+</td>

											<td class="hidden-480">-</td>

											<td class="hidden-480">A</td>

										</tr>

										<tr >

											<td>Presto</td>

											<td>Opera 8.0</td>

											<td class="hidden-480">Win 95+ / OSX.2+</td>

											<td class="hidden-480">-</td>

											<td class="hidden-480">A</td>

										</tr>

										<tr >

											<td>Presto</td>

											<td>Opera 8.5</td>

											<td class="hidden-480">Win 95+ / OSX.2+</td>

											<td class="hidden-480">-</td>

											<td class="hidden-480">A</td>

										</tr>

										<tr >

											<td>Presto</td>

											<td>Opera 9.0</td>

											<td class="hidden-480">Win 95+ / OSX.3+</td>

											<td class="hidden-480">-</td>

											<td class="hidden-480">A</td>

										</tr>

										<tr >

											<td>Presto</td>

											<td>Opera 9.2</td>

											<td class="hidden-480">Win 88+ / OSX.3+</td>

											<td class="hidden-480">-</td>

											<td class="hidden-480">A</td>

										</tr>

										<tr >

											<td>Presto</td>

											<td>Opera 9.5</td>

											<td class="hidden-480">Win 88+ / OSX.3+</td>

											<td class="hidden-480">-</td>

											<td class="hidden-480">A</td>

										</tr>

										<tr >

											<td>Presto</td>

											<td>Opera for Wii</td>

											<td class="hidden-480">Wii</td>

											<td class="hidden-480">-</td>

											<td class="hidden-480">A</td>

										</tr>

										<tr >

											<td>Presto</td>

											<td>Nokia N800</td>

											<td class="hidden-480">N800</td>

											<td class="hidden-480">-</td>

											<td class="hidden-480">A</td>

										</tr>

										<tr >

											<td>Presto</td>

											<td>Nintendo DS browser</td>

											<td class="hidden-480">Nintendo DS</td>

											<td class="hidden-480">8.5</td>

											<td class="hidden-480">C/A<sup>1</sup></td>

										</tr>

									</tbody>

								</table>

							</div>

						</div>

						<!-- END EXAMPLE TABLE PORTLET-->
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

	<!-- BEGIN PAGE LEVEL PLUGINS -->

	<script type="text/javascript" src="media/js/select2.min.js"></script>

	<script type="text/javascript" src="media/js/jquery.dataTables.min.js"></script>

	<script type="text/javascript" src="media/js/DT_bootstrap.js"></script>

	<!-- END PAGE LEVEL PLUGINS -->    
	<script src="media/js/app.js"></script>

	<script src="media/js/table-advanced.js"></script> 
	<script>
		jQuery(document).ready(function() {    
		   App.init(); // initlayout and core plugins
		   TableAdvanced.init();
		   //addClass("active");
		   $("a[href='jump/flowpage_flowdefinition']").parent().addClass("active");		   $("a[href='jump/flowpage_flowdefinition']").parent().parent().parent().addClass("active");
		 // alert(html);
			//alert( $("a[href='jump/user']").attr("href"));
		});
	</script>
	<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>