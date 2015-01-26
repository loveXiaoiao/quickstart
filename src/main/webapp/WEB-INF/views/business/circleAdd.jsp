<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="modal fade" id="circleAdd" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">新增圈子</h4>
				</div>
				<div class="modal-body" id="modal_content">
				<form action="" id="userForm" class="form-horizontal">
						<div class="control-group">
							<label class="control-label">名称</label>
							<div class="controls">

								<input type="text" id="name" placeholder="名称"
									class="m-wrap medium">
							</div>
						</div>
						
						<div class="control-group">
							<label class="control-label">头像</label>
							<div class="controls">

								<input type="text" id="avatar" placeholder="头像"
									class="m-wrap medium">
							</div>
						</div>

					<div class="control-group">

						<label class="control-label">主题</label>

						<div class="controls">
							<textarea class="medium m-wrap" id="theme" rows="3"></textarea>
						</div>
					</div>
					</form>


</div>
				<div class="modal-footer">
					<button type="button" class="btn green" data-dismiss="modal" id="modal_submit" onclick="add()">保存</button>
					<button type="button" class="btn btn-primary" data-dismiss="modal" id="modal_submit" onclick=";">取消</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
	</div>