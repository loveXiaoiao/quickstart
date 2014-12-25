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

								<div class="clearfix">


									<div class="btn-group pull-right">

										<button class="btn dropdown-toggle" data-toggle="dropdown">选择 <i class="icon-angle-down"></i>

										</button>

										<ul class="dropdown-menu pull-right">

											<li><a href="#">打印</a></li>


											<li><a href="#">导出到excel</a></li>

										</ul>

									</div>

								</div>

								<div id="sample_1_wrapper" class="dataTables_wrapper form-inline" role="grid"><div class="row-fluid"><div class="span6"><div id="sample_1_length" class="dataTables_length"><label><select size="1" name="sample_1_length" aria-controls="sample_1" class="m-wrap small"><option value="5" selected="selected">5</option><option value="15">15</option><option value="20">20</option><option value="-1">All</option></select> 条每页</label></div></div><div class="span6"><div class="dataTables_filter" id="sample_1_filter"><label>查询: <input type="text" aria-controls="sample_1" class="m-wrap medium"></label></div></div></div>
								<table class="table table-striped table-bordered table-hover dataTable" id="sample_1" aria-describedby="sample_1_info">

									<thead>

										<tr role="row">
										<th style="width: 24px;" class="sorting_disabled" role="columnheader" rowspan="1" colspan="1" aria-label=""><div class="checker">
										<span><input type="checkbox" class="group-checkable" data-set="#sample_1 .checkboxes"></span></div>
										</th>
										<th class="sorting" role="columnheader" tabindex="0" aria-controls="sample_1" rowspan="1" colspan="1" aria-label="Username: activate to sort column ascending" style="width: 172px;">用户名</th>
										<th class="hidden-480 sorting_disabled" role="columnheader" rowspan="1" colspan="1" aria-label="Email" style="width: 317px;">姓名</th>
										<th class="hidden-480 sorting" role="columnheader" tabindex="0" aria-controls="sample_1" rowspan="1" colspan="1" aria-label="Points: activate to sort column ascending" style="width: 135px;">角色</th>
										<th class="hidden-480 sorting_disabled" role="columnheader" rowspan="1" colspan="1" aria-label="Joined" style="width: 204px;">注册时间</th>
										<th class="sorting_disabled" role="columnheader" rowspan="1" colspan="1" aria-label="" style="width: 181px;">操作</th>
										</tr>

									</thead>

								</table>
								<div class="row-fluid"><div class="span6"><div class="dataTables_info" id="sample_1_info">Showing 1 to 5 of 25 entries</div></div><div class="span6"><div class="dataTables_paginate paging_bootstrap pagination"><ul><li class="prev disabled"><a href="#">← <span class="hidden-480">Prev</span></a></li><li class="active"><a href="#">1</a></li><li><a href="#">2</a></li><li><a href="#">3</a></li><li><a href="#">4</a></li><li><a href="#">5</a></li><li class="next"><a href="#"><span class="hidden-480">Next</span> → </a></li></ul></div></div></div></div>
							
							</div>

						</div>

			</div>
			
			<script src="js/manage/user.js" type="text/javascript"></script>    
</body></html>