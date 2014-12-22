/**
 * 用户列表
 */
var Flow = function () {
	var inittable = function(){
		var oTable = $('#flowtable').dataTable( {
	        "bServerSide": true,
	        "sAjaxSource": "api/userTasklist",
	        "bProcessing": false,
	        "bFilter": false,//过滤功能
	        "bSort": false,//排序功能
	        "oLanguage": {
				"sUrl": "js/datatable-cn.txt"
			},
	        "aoColumns": [
							{ "mDataProp": function(lineData){
								var id = lineData.id;
								return '<input type="checkbox" name="user_check" class="checkboxes" value="'+id+'" />';
							}},
	                      	{ "mDataProp": "id"},
							{ "mDataProp": "taskDefinitionKey" },
							{ "mDataProp": "name" },
							{ "mDataProp": "processDefinitionId" },
							{ "mDataProp": "processInstanceId" },
							{ "mDataProp": "priority" },
							{ "mDataProp": "createTime" },
							{ "mDataProp": "dueDate"},
							{ "mDataProp": "description" },
							{ "mDataProp": "assignee" },
							{ "mDataProp": function(lineData){
								var assignee = lineData.assignee;
								var id = lineData.id;
								var clainTask;
								if( assignee != "" && assignee != null){//已签收，待处理
									clainTask = '<button id="sample_editable_1_new" class="btn green" onclick="completeTask(\''+id+'\')">办理<i class="icon-minus"></i></button>';
								}else{
									clainTask = '<button id="sample_editable_1_new" class="btn green" onclick="clainTask(\''+id+'\')">签收<i class="icon-minus"></i></button>';
								}
								return clainTask;
							} }
	                  ]
		} );
		
		$('#ckcolum input[type="checkbox"]').change(function(){
	        /* Get the DataTables object again - this is not a recreation, just a get of the object */
	        var iCol = parseInt($(this).attr("data-column"));
	        var bVis = oTable.fnSettings().aoColumns[iCol].bVisible;
	        oTable.fnSetColumnVis(iCol, (bVis ? false : true));
	    });
	};
	
    return {
        init: function () {
        	inittable();
        }
    };

}();

function clainTask(id){
	$.ajax({
	   type: "POST",
	   url: "api/clainTask?taskId="+id,
	   datatype:"json",
	   success: function(data){
		   alert(data.resultCode + ";" + data.msg);
	   }
	});
}
function completeTask(id){
	$.ajax({
		type: "POST",
		url: "api/completeTask?taskId="+id,
		datatype:"json",
		success: function(data){
			alert(data.resultCode + ";" + data.msg);
		}
	});
}