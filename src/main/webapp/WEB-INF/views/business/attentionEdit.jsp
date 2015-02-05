<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="modal fade hide" id="attentionModal" tabindex="-1"
	role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel">关注列表</h4>
			</div>
			<div class="modal-body">
				<div id="attentionEdit">
					<form id="attentionEditForm">
						<input id="attentionEditForm-circleId" type="hidden" name="circleId" />
						<div style="overflow-y: auto; height: 210px">
							<table id="attentionEditTable" style="width: 100%;" cellspacing="0">
							</table>
						</div>
					</form>
				</div>

			</div>
			<div class="modal-footer">
				<button type="button" class="btn green" data-dismiss="modal" onclick="saveAttention();">保存</button>
				<button type="button" class="btn btn-primary" data-dismiss="modal" onclick=";">取消</button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
</div>