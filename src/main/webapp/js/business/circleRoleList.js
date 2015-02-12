/**
 * 帐号列表
 */
var CircleRole = function () {
	var inittable = function(){
		var oTable = $('#circleRoletable').dataTable( {
	        "bServerSide": true,
	        "sAjaxSource": "circleRole/listCircleRole",
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
//	                      		return '<div class="checker"> <span><input type="checkbox" class="checkboxes" name="user_check" value="'+id+'" /> </span></div>';
	                      		return '<input type="checkbox" class="group-checkable checkboxes"data-set="#circleRoletable .checkboxes" value="'+id+'" />';
	                      	}, "bSortable": false},
							{ "mDataProp": "roleName" },
							{ "mDataProp": "circle.name" },
							{ "mDataProp": function(lineData){
								var avatar = lineData.avatar;
								if(avatar == null){
									return "--";
								}else {
									return '<img height="25px" width="60px;" src="'+avatar+'" />';
								}}, "bSortable": false },
							{ "mDataProp": "createTime" },
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
							{ "mDataProp": "remark" , "bSortable": false},
							{ "mDataProp": function(lineData){
								var account = lineData.account;
								if(account == null){
									return "未关联";
								}else {
									return account.accountName;
								}
							} },
							{ "mDataProp": function(lineData){
								var id = lineData.id;
								var del = '<button id="sample_editable_1_new" class="btn red" onclick="del(\''+id+'\')">删除<i class="icon-minus"></i></button>';
								var edit = '<button id="sample_editable_1_new" class="btn blue" onclick="editTK(\''+id+'\')">编辑</button>';
								return del +edit;
							} , "bSortable": false}
	                  ],
	         "fnServerParams": function ( aoData ) { 
	        	  aoData.push( { "name": "search_LIKE_roleName", "value": $("#search_LIKE_roleName").val() } );
	        	  } 
		} );
		
		jQuery('#circleRoletable .group-checkable').change(function () {
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
        	addCircleOption();
        	addAccountOption();
        }
    };

}();

/**
 * 对datatable重新加载
 */
function reloadTable(){
	var table = $('#circleRoletable').DataTable();
	table.ajax.reload();
}

function reset(){
	$("#search_LIKE_roleName").val('');
	reloadTable();
}

function addCircleOption(){
	$.ajax({
		type: "GET",
		url: "circle/findAllCircle",
		datatype:"json",
		success: function(data){
			if(data.success){
				for(var i=0;i<data.result.length;i++){
					//给select添加option
					$("#belongCircle").append("<option value='"+data.result[i].id+"'>"+data.result[i].name+"</option>"); 
				}
			}
		}
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
					$("#bindingAccount").append("<option value='"+data.result[i].id+"'>"+data.result[i].accountName+"</option>"); 
				}
			}
		}
	});
}

function addTK(){
	$("#circleRoleAddEditModal").modal('show');//展示
}


function editTK(id){
	$("#id").val(id);
	$("#circleRoleAddEditModal").modal('show');//展示
	var circleRoleId = $.trim($("#id").val());
	//加载资产信息
	if (circleRoleId != "null" && circleRoleId != "" && typeof(circleRoleId)!="undefined") {
		$.ajax({
    		type: "POST",
    		url: "circleRole/getEntity",
    		data: {'id':circleRoleId},
    		datatype:"json",
    		success: function(data){
    			$('#roleName').val(data.result.roleName);
    			$('#avatar').val(data.result.avatar);
    			$('#remark').val(data.result.remark);
    			$('#belongCircle').val(data.result.circle.id);//所在圈子
    			$('#bindingAccount').val(data.result.account.id);//使用人
    		}
    	});
	}
}
//编辑
function saveCircleRole(){
	var params = {}; //获取表单参数
	params["id"]= $('#id').val();
	params["roleName"] = $('#roleName').val();
	params["avatar"] = $('#avatar').val();
	params["circle.id"] = $('#belongCircle').val();
	params["account.id"] = $('#bindingAccount').val();
	params["remark"] = $('#remark').val();
	$.ajax({
		  type: "POST",
		  url: "circleRole/saveCircleRole",
		  data: params,
		  datatype:"json",
		  success: function(data){
			  	  $("#successAlert").html(data.msg);
			  	  $("#myAlertSuccess").show();
				  reloadTable();
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
		  url: "circleRole/deleteCircleRole",
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
