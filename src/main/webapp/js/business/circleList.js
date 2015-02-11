/**
 * 帐号列表
 */
var Circle = function () {
	var inittable = function(){
		var oTable = $('#circletable').dataTable( {
	        "bServerSide": true,
	        "sAjaxSource": "circle/listCircle",
	        "bProcessing": true,
	        "bFilter": false,//过滤功能
	        "bSort": true,//排序功能
	        "stateSave": true,
	        "oLanguage": {
				"sUrl": "js/datatable-cn.txt"
			},
			"aaSorting": [[1, 'asc']],//实现默认排序
	        "aoColumns": [
	                      	{ "mDataProp": function(lineData){
	                      		var id = lineData.id;
	                      		return '<input type="checkbox" class="group-checkable checkboxes"data-set="#circletable .checkboxes" name="account_check" value="'+id+'" />';
	                      	}, "bSortable": false},
							{ "mDataProp": "name"},
							{ "mDataProp": function(lineData){
								var createAccount = lineData.createAccount;
								if(createAccount == null){
									return "后台管理员";
								}else {
									return createAccount.accountName;
								}}, "bSortable": false },
							{ "mDataProp": function(lineData){
								var avatar = lineData.avatar;
								if(avatar == null){
									return "--";
								}else {
									return '<img height="25px" width="60px;" src="'+avatar+'" />';
								}}, "bSortable": false },
							{ "mDataProp": "createTime"},
							{ "mDataProp": function(lineData){
								var status = lineData.status;
								if(status == 0){
									return "启用";
								}if(status == 1){
									return "停用";
								}else {
									return "--";
								}
							}, "bSortable": false},
							{ "mDataProp": "theme", "bSortable": false},
							{ "mDataProp": function(lineData){
								var id = lineData.id;
								var del = '<button id="sample_editable_1_new" class="btn red" onclick="del(\''+id+'\')">删除<i class="icon-minus"></i></button>';
								var edit = '<button id="sample_editable_1_new" class="btn blue" onclick="editTK(\''+id+'\')">编辑</button>';
								var editAttention = '<button id="sample_editable_1_new" class="btn green" onclick="editAttentionTK(\''+id+'\')">配置关注</button>';
								return del +edit+editAttention;
							} , "bSortable": false}
	                  ],
	         "fnServerParams": function ( aoData ) { 
	        	  aoData.push( { "name": "search_LIKE_name", "value": $("#search_LIKE_name").val() } );
	        	  } 
		} );
		
		jQuery('#circletable .group-checkable').change(function () {
            var set = jQuery(this).attr("data-set");
            var checked = jQuery(this).is(":checked");
            jQuery(set).each(function () {
                if (checked) {
                    $(this).attr("checked", true);
                } else {
                    $(this).attr("checked", false);
                }
            });
            jQuery.uniform.update(set);
        });
	};
	
    return {
        init: function () {
        	inittable();
        	addAccountOption();
        }
    };

}();

/**
 * 对datatable重新加载
 */
function reloadTable(){
	var table = $('#circletable').DataTable();
	table.ajax.reload();
}

function reset(){
	$("#search_LIKE_name").val('');
	reloadTable();
}

function addTK(){
	$("#circleAddEditModal").modal('show');//展示
	
}
function editAttentionTK(){
	$("#attentionModal").modal('show');
}


function editTK(id){
	$("#id").val(id);
	$("#circleAddEditModal").modal('show');//展示
	var circleId = $.trim($("#id").val());
	//加载资产信息
	if (circleId != "null" && circleId != "" && typeof(circleId)!="undefined") {
		$.ajax({
    		type: "POST",
    		url: "circle/getEntity",
    		data: {'id':circleId},
    		datatype:"json",
    		success: function(data){
    			$('#name').val(data.result.name);
    			$('#avatar').val(data.result.avatar);
    			$('#theme').val(data.result.theme);
    			$('#createAccount').val(data.result.createAccount.id);
    		}
    	});
	}
}


//编辑
function saveCircle(){
	var params = {}; //获取表单参数
	params["id"]= $('#id').val();
	params["createAccount.id"]= $('#createAccount').val();
	params["name"] = $('#name').val();
	params["avatar"] = $('#avatar').val();
	params["theme"] = $('#theme').val();
	$.ajax({
		  type: "POST",
		  url: "circle/saveCircle",
		  data: params,
		  datatype:"json",
		  success: function(data){
			  	  $("#successAlert").html(data.msg);
			  	  $("#myAlertSuccess").show();
				  reloadTable();
				  $("#circleAddForm")[0].reset();
		   }
		});
	
}


function del(id){
	$("#modal_content").html("确定删除吗？删除后将不能恢复！");
	$("#myModal").modal('show');
    $("#modal_submit").click(function(){
    	var params = {}; //获取表单参数
    	params["id"] = id;
    	$.ajax({
    		type: "POST",
    		url: "circle/deleteCircle",
    		data: params,
    		datatype:"json",
    		success: function(data){
    			$("#successAlert").html(data.msg);
    			$("#myAlertSuccess").show();
    			reloadTable();
    		}
    	});
    });
}

function addAccountOption(){
	$.ajax({
		type: "GET",
		url: "account/findAllAccount",
		datatype:"json",
		success: function(data){
			if(data.success){
				for(var i=0;i<data.result.length;i++){
					//给select添加option
					$("#createAccount").append("<option value='"+data.result[i].id+"'>"+data.result[i].accountName+"</option>"); 
				}
			}
		}
	});
}


function editAttentionTK(id){
	if(id != null){
		$('#attentionEditForm-circleId').val(id);
		// 先清空table下的所有节点，根据后台传输的数据动态渲染表格
		$('#attentionEditTable').empty();
		$('#attentionEditTable').append('<tr><th>帐号名称</th><td>是否关注</td></tr>');
		$.ajax({
			url: 'account/getAttentions',
			data: {
				'id': id
			},
			type: 'POST',
			async:false,
			success: function(data){
				var data = data.result;
				if(data != null && data.length > 0){
					for(var i=0;i<data.length;i++){
						var template = '<tr><th>'+data[i].accountName+'</th><td><input name="accountId" value="'+data[i].id+'" type="checkbox" '+(data[i].flag=='true'?'checked':'')+' /></td></tr>';
						$('#attentionEditTable').append(template);
					}
				}
			}
		});
		
		$("#attentionModal").modal('show');
	}
}

function saveAttention(){
		var id = $("#attentionEditForm-circleId").val();
		var ids = "";
		var x=0;
		 $('#attentionEditTable input[name="accountId"]:checked').each(function(){
			 ids += $(this).val() + ","; 
			 x=x+2;
		 });
		 ids = ids.slice(0,x-1);
    	$.ajax({
    		type: "POST",
    		url: "circle/updateAttentions",
    		data:  {
				'ids': ids,
				'id': id
			},
    		datatype:"json",
    		success: function(data){
    			$("#successAlert").html(data.msg);
    			$("#myAlertSuccess").show();
    			reloadTable();
    		}
    	});
}




