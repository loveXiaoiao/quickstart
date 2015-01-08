/**
 * 用户列表
 */
var User = function () {
	var inittable = function(){
		var oTable = $('#usertable').dataTable( {
	        "bServerSide": true,
	        "sAjaxSource": "system/listuser",
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
	                      		return '<input type="checkbox" class="group-checkable checkboxes"data-set="#usertable .checkboxes" name="user_check" value="'+id+'" />';
	                      	}, "bSortable": false},
							{ "mDataProp": "loginName" },
							{ "mDataProp": "name" },
							{ "mDataProp": "roles" , "bSortable": false},//屏蔽此列排序功能
							{ "mDataProp": "registerDate" },
							{ "mDataProp": function(lineData){
								var id = lineData.id;
								var del = '<button id="sample_editable_1_new" class="btn red" onclick="del(\''+id+'\')">删除<i class="icon-minus"></i></button>';
								return del;
							} , "bSortable": false}
	                  ],
	         "fnServerParams": function ( aoData ) { 
	        	  aoData.push( { "name": "search_LIKE_loginName", "value": $("#search_LIKE_loginName").val() } );
	        	  aoData.push( { "name": "search_LIKE_name", "value": $("#search_LIKE_name").val() } ); 
	        	  } 
		} );
		
		jQuery('#usertable .group-checkable').change(function () {
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
	var table = $('#usertable').DataTable();
	table.ajax.reload();
}

function reset(){
	$("#search_LIKE_loginName").val('');
	$("#search_LIKE_name").val('');
	reloadTable();
}

function tankun(){
	$("#modal_content").html("请选择内容！");
	$("#myModal").modal('show');//展示
//	$("#myModal").modal('hid');关闭
}

function deleteUsers(){
	alert("删除选中用户!");
}

function del(id){
	alert(id);
}

function selectAll(){
	alert("我要选中所有……");
}
