<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
</head><body><div class="container-fluid">
				<!-- BEGIN PAGE HEADER-->
				<div class="row-fluid">
					<div class="span12">
						<h3 class="page-title">
							用户管理<small>用户列表</small>
						</h3>
					</div>
				</div>
				 <div class="portlet box blue">
							<div class="portlet-title">

								<div class="caption"><i class="icon-globe"></i>用户列表</div>
							</div>
							<div class="portlet-body">
								<div class="controls">
								<label class="help-inline">用户名：</label>
									<input class="m-wrap small" size="8" type="text"
										placeholder="用户名">
								<label class="help-inline">姓名:</label>
									<input class="m-wrap small" size="8" type="text"
										placeholder="姓名">
									<button class="btn red">查询</button>
									<button class="btn green">重置</button>
								</div>

								<div class="btn-group pull-right">

										<button class="btn dropdown-toggle" data-toggle="dropdown">选择 <i class="icon-angle-down"></i>

										</button>

										<ul class="dropdown-menu pull-right">

											<li><a href="#">打印</a></li>


											<li><a href="#">导出到excel</a></li>

										</ul>

									</div>
								<table class="table table-striped table-bordered table-hover dataTable" id="usertable" aria-describedby="sample_1_info">
									<thead>
										<tr role="row">
<!-- 										<th style="width: 24px;" class="sorting_disabled" role="columnheader" rowspan="1" colspan="1" aria-label=""> -->
<!-- 										<div class="checker"> -->
<!-- 										<span><input type="checkbox" class="group-checkable" data-set="#sample_1 .checkboxes"></span></div> -->
<!-- 										</th> -->
<!-- 										<th style="width: 24px;" class="sorting_disabled" role="columnheader" rowspan="1" colspan="1" aria-label=""> -->
<!-- 										<div class="checker"><span class=""> -->
<!-- 										<input type="checkbox" class="group-checkable" data-set="#usertable .checkboxes"> -->
<!-- 										</span></div></th> -->
										<th style="width:8px;"><input type="checkbox" class="group-checkable" data-set="#usertable .checkboxes"/></th>

										<th class="sorting" role="columnheader" tabindex="0" aria-controls="sample_1" rowspan="1" colspan="1" aria-label="Username: activate to sort column ascending" style="width: 172px;">用户名</th>
										<th class="hidden-480 sorting_disabled" role="columnheader" rowspan="1" colspan="1" aria-label="Email" style="width: 317px;">姓名</th>
										<th class="hidden-480 sorting" role="columnheader" tabindex="0" aria-controls="sample_1" rowspan="1" colspan="1" aria-label="Points: activate to sort column ascending" style="width: 135px;">角色</th>
										<th class="hidden-480 sorting_disabled" role="columnheader" rowspan="1" colspan="1" aria-label="Joined" style="width: 204px;">注册时间</th>
										<th class="sorting_disabled" role="columnheader" rowspan="1" colspan="1" aria-label="" style="width: 181px;">操作</th>
										</tr>

									</thead>

								</table>
								</div>
							
							</div>

						</div>

			<script type="text/javascript" src="media/js/select2.min.js"></script>

			<script type="text/javascript" src="media/js/jquery.dataTables.min.js"></script>
			<script type="text/javascript" src="media/js/jquery.dataTables.js"></script>
		
			<script type="text/javascript" src="media/js/DT_bootstrap.js"></script>
			
			<script src="js/manage/user.js" type="text/javascript"></script>    			<script>

				jQuery(document).ready(function() {    
				   App.init(); // initlayout and core plugins
				   User.init();
				   $("a[href='jump/manage_user']").parent().addClass("active");
				   $("a[href='jump/manage_user']").parent().parent().parent().addClass("active");
				});
		</script>
</body></html>