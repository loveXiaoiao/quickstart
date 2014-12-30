/**
 * 用户列表
 */
var Flow = function () {
	var inittable = function(){
		var oTable = $('#flowtable').dataTable( {
	        "bServerSide": true,
	        "sAjaxSource": "api/processList",
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
							{ "mDataProp": "processDefinitionId" },
							{ "mDataProp": "deploymentId" },
							{ "mDataProp": "name" },
							{ "mDataProp": "key" },
							{ "mDataProp": "version" },
							{ "mDataProp": "resourceName" },
							{ "mDataProp": function(lineData){
								var id = lineData.deploymentId;
								var diagramResourceName = lineData.diagramResourceName;
								return "<a target=\"_blank\" href='api/resource/read/"+id+"/xml'>"+diagramResourceName +"</a>";
							}},
							{ "mDataProp": "deploymentTime" },
							{ "mDataProp": "suspended" },
							{ "mDataProp": function(lineData){
								var id = lineData.deploymentId;
								var key = lineData.key;
								var processDefinitionId = lineData.processDefinitionId;
								var del = '<button id="sample_editable_1_new" class="btn red" onclick="del(\''+id+'\')">删除<i class="icon-minus"></i></button>';
								var opt = "";
								var start = "";
								if( lineData.suspended == "false" ){
									opt = '<button id="sample_editable_1_new" class="btn red" onclick="suspend(\''+processDefinitionId+'\')">挂起<i class="icon-minus"></i></button>';
									start = '<button id="sample_editable_1_new" class="btn green" onclick="start(\''+key+'\')">启动<i class="icon-minus"></i></button>';
								}else{
									opt = '<button id="sample_editable_1_new" class="btn green" onclick="active(\''+processDefinitionId+'\')">激活<i class="icon-minus"></i></button>';
								}
								return del + opt + start;
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

function del(id){
	$.ajax({
	   type: "POST",
	   url: "api/delProcess/"+id,
	   datatype:"json",
	   success: function(data){
		   alert(data.resultCode + ";" + data.msg);
	   }
	});
}

function start(key){
	$.ajax({
		type: "POST",
		url: "api/startprocessbykey/"+key,
		datatype:"json",
		success: function(data){
			alert(data.resultCode + ";" + data.msg);
		}
	});
}

function deploy(){
	window.location.href="page/deploy";
}

function selectAll(){
	alert("我要选中所有……");
}

function active(processDefinitionId){
	$.ajax({
	   type: "POST",
	   url: "api/activeProcessByKey/"+processDefinitionId,
	   datatype:"json",
	   success: function(data){
		   alert(data.resultCode + ";" + data.msg);
	   }
	});
}
function suspend(processDefinitionId){
	$.ajax({
	   type: "POST",
	   url: "api/suspendProcessByKey/"+processDefinitionId,
	   datatype:"json",
	   success: function(data){
		   alert(data.resultCode + ";" + data.msg);
	   }
	});
}