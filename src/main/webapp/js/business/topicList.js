/**
 * 帐号列表
 */
var Topic = function () {
	var inittable = function(){
		var oTable = $('#topictable').dataTable( {
	        "bServerSide": true,
	        "sAjaxSource": "topic/listTopic",
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
							{ "mDataProp": "content"},
							{ "mDataProp": function(lineData){
								var images = lineData.images;
								if(images == null){
									return "--";
								}else {
									return '<img height="25px" width="60px;" src="'+images+'" />';
								}}, "bSortable": false },
							{ "mDataProp": "createTime"},
							{ "mDataProp": function(lineData){
								var account = lineData.account;
									if(account != null){
										return account.accountName;
									}else{
										return "--";
									}
								}, "bSortable": false },
							{ "mDataProp": function(lineData){
								var circle = lineData.circle;
								return circle.name;}, "bSortable": false},
							{ "mDataProp": function(lineData){
								var circleRole = lineData.circleRole;
								return circleRole.roleName;}, "bSortable": false},
							{ "mDataProp": function(lineData){
								var id = lineData.id;
								var del = '<button id="sample_editable_1_new" class="btn red" onclick="del(\''+id+'\')">删除<i class="icon-minus"></i></button>';
								var edit = '<button id="sample_editable_1_new" class="btn blue" onclick="editTK(\''+id+'\')">编辑</button>';
								return del +edit;
							} , "bSortable": false}
	                  ],
	         "fnServerParams": function ( aoData ) { 
	        	  aoData.push( { "name": "search_LIKE_content", "value": $("#search_LIKE_content").val() } );
	        	  } 
		} );
		
		jQuery('#topictable .group-checkable').change(function () {
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
	var table = $('#topictable').DataTable();
	table.ajax.reload();
}

function reset(){
	$("#search_LIKE_content").val('');
	reloadTable();
}


function editTK(id){
	$("#id").val(id);
	$("#topicAddEditModal").modal('show');//展示
	var circleId = $.trim($("#id").val());
	//加载资产信息
	if (circleId != "null" && circleId != "" && typeof(circleId)!="undefined") {
		$.ajax({
    		type: "POST",
    		url: "topic/getEntity",
    		data: {'id':circleId},
    		datatype:"json",
    		success: function(data){
    			$('#content').val(data.result.content);
    			$('#images').val(data.result.images);
    		}
    	});
	}
}
/**
 * 未用
 */
function saveTopic(){
	var params = {}; //获取表单参数
	params["id"]= $('#id').val();
	params["content"] = $('#content').val();
	params["images"] = $('#images').val();
	$.ajax({
		  type: "POST",
		  url: "topic/saveTopic",
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
    		url: "topic/deleteTopic",
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


