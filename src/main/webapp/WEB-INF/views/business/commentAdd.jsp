<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="modal fade hide" id="commentAddEditModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">评论</h4>
				</div>
				<div class="modal-body">
				<form action=""  class="form-horizontal">
						<div class="control-group">
							<label class="control-label">内容</label>
							<div class="controls">

								<input type="text" id="content" name="content" placeholder="内容"
									class="m-wrap medium required:true">
							</div>

						</div>
						<div class="control-group">
							<label class="control-label">图片</label>
							<div class="controls">
								<input type="text" id="images"  name="images" placeholder="内容"
									class="m-wrap medium required:true">
							</div>

						</div>

					<input type="hidden" id="topicId" name="topicId" class="m-wrap medium required:true" >
					<input type="hidden" id="parentCommentId" name="parentCommentId" class="m-wrap medium required:true" >

					</form>

				</div>
				<div class="modal-footer">
					<button type="button" class="btn green" data-dismiss="modal" id="commentAdd">保存</button>
					<button type="button" class="btn btn-primary" data-dismiss="modal" onclick=";">取消</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
	</div>