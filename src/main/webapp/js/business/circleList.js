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
							{ "mDataProp": "createAccount", "bSortable": false },
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
								var addRole = '<button id="sample_editable_1_new" class="btn green" onclick="del(\''+id+'\')">新增角色</button>';
								
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

function tankun(){
	$("#circleAdd").modal('show');//展示
//	$("#myModal").modal('hid');关闭
}


function add(){
	var params = {}; //获取表单参数
	params["name"] = $('#name').val();
	params["theme"] = $('#theme').val();
	$.ajax({
		  type: "POST",
		  url: "circle/saveCircle",
		  data: params,
		  datatype:"json",
		  success: function(data){
				  $("#modal_content").html(data.msg);
				  $("#modal_submit").attr("onclick","window.location.href='jump/business_circleList'");
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
