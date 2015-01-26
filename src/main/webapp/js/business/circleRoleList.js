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
							{ "mDataProp": "account" },
							{ "mDataProp": function(lineData){
								var id = lineData.id;
								var del = '<button id="sample_editable_1_new" class="btn red" onclick="del(\''+id+'\')">删除<i class="icon-minus"></i></button>';
								var addAccount = '<button id="sample_editable_1_new" class="btn green" onclick="del(\''+id+'\')">添加账户</button>';
								return del + addAccount;
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

function tankun(){
	$("#circleRoleAdd").modal('show');//展示
//	$("#myModal").modal('hid');关闭
}


function add(){
	var params = {}; //获取表单参数
	params["roleName"] = $('#roleName').val();
	params["remark"] = $('#remark').val();
	$.ajax({
		  type: "POST",
		  url: "circleRole/saveCircleRole",
		  data: params,
		  datatype:"json",
		  success: function(data){
				  $("#modal_content").html(data.msg);
				  $("#modal_submit").attr("onclick","window.location.href='jump/business_circleRoleList'");
				  $("#myModal").modal('show');//展示
		   }
		});
}

function del(id){
	alert(id);
}

function selectAll(){
	alert("我要选中所有……");
}
