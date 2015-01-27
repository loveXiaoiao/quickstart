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
								var addRole = '<button id="sample_editable_1_new" class="btn green" onclick="circleRoleAddTK(\''+id+'\')">新增角色</button>';
								
								return del + addRole;
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
	$("#circleAdd").modal('show');//展示
}
function circleRoleAddTK(id){
	$("#circleId").val(id);
	$("#circleRoleAdd").modal('show');//展示
}


function add(){
	var params = {}; //获取表单参数
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

function addRole(id){
	var params = {}; //获取表单参数
	params["circle_id"] = $('#circleId').val();
	params["avatar"] = $('#roleAvatar').val();
	params["roleName"] = $('#roleName').val();
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

function selectAll(){
	alert("我要选中所有……");
}
