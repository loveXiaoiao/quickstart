<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
</head>
<body>
			<!-- BEGIN PAGE CONTAINER-->
<div class="container-fluid">

				<!-- BEGIN PAGE HEADER-->

				<div class="row-fluid">

					<div class="span12">

						<!-- BEGIN STYLE CUSTOMIZER

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

					<div class="row-fluid">

						<div class="span3 responsive" data-tablet="span6" data-desktop="span3">

							<div class="dashboard-stat blue">

								<div class="visual">

									<i class="icon-comments"></i>

								</div>

								<div class="details">

									<div class="number">

										1349

									</div>

									<div class="desc">                           

										待办任务

									</div>

								</div>

								<a class="more" href="#">

								查看详情 <i class="m-icon-swapright m-icon-white"></i>

								</a>                 

							</div>

						</div>

						<div class="span3 responsive" data-tablet="span6" data-desktop="span3">

							<div class="dashboard-stat green">

								<div class="visual">

									<i class="icon-shopping-cart"></i>

								</div>

								<div class="details">

									<div class="number">549</div>

									<div class="desc">完成任务</div>

								</div>

								<a class="more" href="#">

								查看详情 <i class="m-icon-swapright m-icon-white"></i>

								</a>                 

							</div>

						</div>

						<div class="span3 responsive" data-tablet="span6  fix-offset" data-desktop="span3">

							<div class="dashboard-stat purple">

								<div class="visual">

									<i class="icon-globe"></i>

								</div>

								<div class="details">

									<div class="number">112</div>

									<div class="desc">流程总数</div>

								</div>

								<a class="more" href="#">

								查看详情 <i class="m-icon-swapright m-icon-white"></i>

								</a>                 

							</div>

						</div>

						<div class="span3 responsive" data-tablet="span6" data-desktop="span3">

							<div class="dashboard-stat yellow">

								<div class="visual">

									<i class="icon-bar-chart"></i>

								</div>

								<div class="details">

									<div class="number">12,5M$</div>

									<div class="desc">用户数量</div>

								</div>

								<a class="more" href="#">

								查看详情 <i class="m-icon-swapright m-icon-white"></i>

								</a>                 

							</div>

						</div>

					</div>

					<!-- END DASHBOARD STATS -->

					<div class="clearfix"></div>

					<div class="row-fluid">

						<div class="span6">

							<!-- BEGIN PORTLET-->

							<div class="portlet solid bordered light-grey">

								<div class="portlet-title">

									<div class="caption"><i class="icon-bar-chart"></i>流程统计</div>

									<div class="tools">

										<div class="btn-group pull-right" data-toggle="buttons-radio">

											<a href="" class="btn mini">Users</a>

											<a href="" class="btn mini active">Feedbacks</a>

										</div>

									</div>

								</div>

								<div class="portlet-body">

									<div id="site_statistics_loading">

										<img src="media/image/loading.gif" alt="loading" />

									</div>

									<div id="site_statistics_content" class="hide">

										<div id="site_statistics" class="chart"></div>

									</div>

								</div>

							</div>

							<!-- END PORTLET-->

						</div>

						<div class="span6">

							<!-- BEGIN PORTLET-->

							<div class="portlet solid light-grey bordered">

								<div class="portlet-title">

									<div class="caption"><i class="icon-bullhorn"></i>用户数量统计</div>

									<div class="tools">

										<div class="btn-group pull-right" data-toggle="buttons-radio">

											<a href="" class="btn blue mini active">Users</a>

											<a href="" class="btn blue mini">Orders</a>

										</div>

									</div>

								</div>

								<div class="portlet-body">

									<div id="site_activities_loading">

										<img src="media/image/loading.gif" alt="loading" />

									</div>

									<div id="site_activities_content" class="hide">

										<div id="site_activities" style="height:100px;"></div>

									</div>

								</div>

							</div>

							<!-- END PORTLET-->

							<!-- BEGIN PORTLET-->

							<div class="portlet solid bordered light-grey">

								<div class="portlet-title">

									<div class="caption"><i class="icon-signal"></i>系统负载</div>

									<div class="tools">

										<div class="btn-group pull-right" data-toggle="buttons-radio">

											<a href="" class="btn red mini active">

											<span class="hidden-phone">Database</span>

											<span class="visible-phone">DB</span></a>

											<a href="" class="btn red mini">Web</a>

										</div>

									</div>

								</div>

								<div class="portlet-body">

									<div id="load_statistics_loading">

										<img src="media/image/loading.gif" alt="loading" />

									</div>

									<div id="load_statistics_content" class="hide">

										<div id="load_statistics" style="height:108px;"></div>

									</div>

								</div>

							</div>

							<!-- END PORTLET-->

						</div>

					</div>

					<div class="clearfix"></div>
				</div>

			</div>	<script src="media/js/jquery.vmap.js" type="text/javascript"></script>   

	<script src="media/js/jquery.vmap.russia.js" type="text/javascript"></script>

	<script src="media/js/jquery.vmap.world.js" type="text/javascript"></script>

	<script src="media/js/jquery.vmap.europe.js" type="text/javascript"></script>

	<script src="media/js/jquery.vmap.germany.js" type="text/javascript"></script>

	<script src="media/js/jquery.vmap.usa.js" type="text/javascript"></script>

	<script src="media/js/jquery.vmap.sampledata.js" type="text/javascript"></script>  

	<script src="media/js/jquery.flot.js" type="text/javascript"></script>

	<script src="media/js/jquery.flot.resize.js" type="text/javascript"></script>

	<script src="media/js/jquery.pulsate.min.js" type="text/javascript"></script>

	<script src="media/js/date.js" type="text/javascript"></script>

	<script src="media/js/daterangepicker.js" type="text/javascript"></script>     

	<script src="media/js/jquery.gritter.js" type="text/javascript"></script>

	<script src="media/js/fullcalendar.min.js" type="text/javascript"></script>

	<script src="media/js/jquery.easy-pie-chart.js" type="text/javascript"></script>

	<script src="media/js/jquery.sparkline.min.js" type="text/javascript"></script>  

	<!-- END PAGE LEVEL PLUGINS -->

	<!-- BEGIN PAGE LEVEL SCRIPTS -->

	<script src="media/js/app.js" type="text/javascript"></script>

	<script src="media/js/index.js" type="text/javascript"></script>        

			<!-- END PAGE CONTAINER-->    	<script>

		jQuery(document).ready(function() {    

		   App.init(); // initlayout and core plugins

		   Index.init();

		 //  Index.initJQVMAP(); // init index page's custom scripts

		   Index.initCalendar(); // init index page's custom scripts

		   Index.initCharts(); // init index page's custom scripts

		   Index.initChat();

		   Index.initMiniCharts();

		   Index.initDashboardDaterange();

		   Index.initIntro();
		   

		});

	</script>
	<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>