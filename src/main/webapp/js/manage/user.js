/**
 * 用户列表
 */
var User = function () {
	var inittable = function(){
		var oTable = $('#usertable').dataTable( {
	        "bServerSide": true,
	        "sAjaxSource": "system/listuser",
	        "bProcessing": false,
	        "bFilter": false,//过滤功能
	        "bSort": false,//排序功能
	        "oLanguage": {
				"sUrl": "js/datatable-cn.txt"
			},
	        "aoColumns": [
	                      	{ "mDataProp": function(lineData){
	                      		var id = lineData.id;
//	                      		return '<div class="checker"> <span><input type="checkbox" class="checkboxes" name="user_check" value="'+id+'" /> </span></div>';
	                      		return '<input type="checkbox" class="group-checkable checkboxes"data-set="#usertable .checkboxes" name="user_check" value="'+id+'" />';
	                      	}},
//							{ "mDataProp": "id" },
							{ "mDataProp": "loginName" },
							{ "mDataProp": "name" },
							{ "mDataProp": "roles" },
							{ "mDataProp": "registerDate" },
							{ "mDataProp": function(lineData){
								var id = lineData.id;
								var del = '<button id="sample_editable_1_new" class="btn red" onclick="del(\''+id+'\')">删除<i class="icon-minus"></i></button>';
								return del;
							} }
	                  ]
		} );
		
		$('#ckcolum input[type="checkbox"]').change(function(){
	        /* Get the DataTables object again - this is not a recreation, just a get of the object */
	        var iCol = parseInt($(this).attr("data-column"));
	        var bVis = oTable.fnSettings().aoColumns[iCol].bVisible;
	        oTable.fnSetColumnVis(iCol, (bVis ? false : true));
	    });
		
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

function addUser(){
	alert("添加用户!");
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