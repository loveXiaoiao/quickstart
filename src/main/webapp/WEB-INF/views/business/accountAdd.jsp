<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="modal fade hide" id="accountAdd" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">新增账户</h4>
				</div>
				<div class="modal-body">
				<form action="" id="userForm" class="form-horizontal">
						<div class="control-group">
							<label class="control-label">帐号</label>
							<div class="controls">

								<input type="text" id="accountName" placeholder="微信号"
									class="m-wrap medium required:true">
							</div>

						</div>

						<div class="control-group">

							<label class="control-label">昵称</label>

							<div class="controls">
								<input type="text" id="nickName" placeholder="昵称"
									class="m-wrap medium required">
							</div>

						</div>
						<div class="control-group">

							<label class="control-label">密码</label>

							<div class="controls">
								<input type="password" id="password" placeholder="密码"
									class="m-wrap medium required">
							</div>

						</div>
						<div class="control-group">

							<label class="control-label">头像</label>

							<div class="controls">
								<input type="text" id="avatar" placeholder="头像"
									class="m-wrap medium required">
							</div>

						</div>

						<div class="control-group">

							<label class="control-label">性别</label>

							<div class="controls">

								<select class="small m-wrap" id="gender">

									<option value="0">男</option>

									<option value="1">女</option>

								</select>

							</div>

						</div>

						<div class="control-group">

							<label class="control-label">地区</label>

							<div class="controls">
								<input type="text" id="area" placeholder="地区"
									class="m-wrap medium required">
							</div>

						</div>

						<div class="control-group">

							<label class="control-label">个性签名</label>

							<div class="controls">
								<input type="text" id="personSignature" placeholder="个性签名"
									class="m-wrap medium required">
							</div>

						</div>

					</form>


</div>
				<div class="modal-footer">
					<button type="button" class="btn green" data-dismiss="modal" onclick="add()">保存</button>
					<button type="button" class="btn btn-primary" data-dismiss="modal" onclick=";">取消</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
	</div>