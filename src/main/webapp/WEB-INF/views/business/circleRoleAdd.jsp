<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="modal fade" id="circleRoleAdd" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">新增角色</h4>
				</div>
				<div class="modal-body" id="modal_content">
				<form action="" id="userForm" class="form-horizontal">
						<div class="control-group">
							<label class="control-label">角色名</label>
							<div class="controls">

								<input type="text" id="roleName" placeholder="角色名"
									class="m-wrap medium required:true">
							</div>

						</div>

						<div class="control-group">

						<label class="control-label">备注</label>

						<div class="controls">
							<textarea class="medium m-wrap" id="remark" rows="3"></textarea>
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