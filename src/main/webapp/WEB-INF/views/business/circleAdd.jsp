<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="modal fade hide" id="circleAddEditModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">新增圈子</h4>
				</div>
				<div class="modal-body">
				<form action=""  class="form-horizontal">
						<div class="control-group">
							<label class="control-label">名称</label>
							<div class="controls">

								<input type="text" id="name" name="name" placeholder="角色名"
									class="m-wrap medium required:true">
							</div>

						</div>
						<div class="control-group">
							<label class="control-label">头像</label>
							<div class="controls">

								<input type="text" id="avatar"  name="avatar" placeholder="头像"
									class="m-wrap medium required:true">
							</div>

						</div>

						<div class="control-group">

						<label class="control-label">主题</label>

						<div class="controls">
							<textarea class="medium m-wrap" id="theme" name="theme" rows="3"></textarea>
						</div>
					</div>
					<input type="hidden" id="id" name="id" class="m-wrap medium required:true" >

					</form>

				</div>
				<div class="modal-footer">
					<button type="button" class="btn green" data-dismiss="modal" onclick="save();">保存</button>
					<button type="button" class="btn btn-primary" data-dismiss="modal" onclick=";">取消</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
	</div>