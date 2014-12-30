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
	<div class="container-fluid">
						<ul class="breadcrumb">
							<li>
								<i class="icon-home"></i>

								<a href="index.html">Home</a> 

								<i class="icon-angle-right"></i>

							</li>
							<li>
								<a href="#">用户管理</a>

								<i class="icon-angle-right"></i>
							</li>

							<li><a href="#">新增用户</a></li>

						</ul>
						
						<div class="portlet box blue tabbable">

							<div class="portlet-title">

								<div class="caption">

									<i class="icon-reorder"></i>

									<span class="hidden-480">General Layouts</span>

								</div>

							</div>

							<div class="portlet-body form">





											<!-- BEGIN FORM-->

											<form action="#" class="form-horizontal">


												<div class="control-group">

													<label class="control-label">Meduam Input</label>

													<div class="controls">

														<input type="text" placeholder="medium" class="m-wrap medium">

														<span class="help-inline">Some hint here</span>

													</div>

												</div>

												<div class="control-group">

													<label class="control-label">Large Input</label>

													<div class="controls">

														<input type="text" placeholder="large" class="m-wrap large">

														<span class="help-inline">Some hint here</span>

													</div>

												</div>

												<div class="control-group">

													<label class="control-label">Small Dropdown</label>

													<div class="controls">

														<select class="small m-wrap" tabindex="1">

															<option value="Category 1">Category 1</option>

															<option value="Category 2">Category 2</option>

															<option value="Category 3">Category 5</option>

															<option value="Category 4">Category 4</option>

														</select>

													</div>

												</div>

												<div class="form-actions">

													<button type="submit" class="btn blue"><i class="icon-ok"></i> Save</button>

													<button type="button" class="btn">Cancel</button>

												</div>

											</form>

											<!-- END FORM-->  
							</div>

						</div>
	</div>
</body>
</html>
