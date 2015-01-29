/**
 * 帐号列表
 */
var Account = function () {
	var inittable = function(){
		var oTable = $('#accounttable').dataTable( {
	        "bServerSide": true,
	        "sAjaxSource": "account/listAccount",
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
	                      		return '<input type="checkbox" class="group-checkable checkboxes"data-set="#accounttable .checkboxes" name="account_check" value="'+id+'" />';
	                      	}, "bSortable": false},
							{ "mDataProp": "accountName" },
							{ "mDataProp": "nickName" },
							{ "mDataProp": "password" , "bSortable": false},
							{ "mDataProp": function(lineData){
								var avatar = lineData.avatar;
								if(avatar == null){
									return "--";
								}else {
									return '<img height="25px" width="60px;" src="'+avatar+'" />';
								}} , "bSortable": false},
							{ "mDataProp": "createTime" },
							{ "mDataProp": function(lineData){
								var gender = lineData.gender;
								if(gender == 0){
									return "男";
								}if(gender == 1){
									return "女";
								}else {
									return "--";
								}
							}, "bSortable": false},
							{ "mDataProp": "area" },
							{ "mDataProp": "personSignature" , "bSortable": false},
							{ "mDataProp": function(lineData){
								var id = lineData.id;
								var del = '<button id="sample_editable_1_new" class="btn red" onclick="del(\''+id+'\')">删除<i class="icon-minus"></i></button>';
								var addCircle = '<button id="sample_editable_1_new" class="btn green" onclick="circleAddTK(\''+id+'\')">新增圈子</button>';
								return del+addCircle;
							} , "bSortable": false}
	                  ],
	         "fnServerParams": function ( aoData ) { 
	        	  aoData.push( { "name": "search_LIKE_accountName", "value": $("#search_LIKE_accountName").val() } );
	        	  } 
		} );
		
		jQuery('#accounttable .group-checkable').change(function () {
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
	var table = $('#accounttable').DataTable();
	table.ajax.reload();
}

function reset(){
	$("#search_LIKE_accountName").val('');
	reloadTable();
}

function tankun(){
	$("#accountAdd").modal('show');//展示
}

function circleAddTK(id){
	$("#accountId").val(id);
	$("#circleAddEditModal").modal('show');//展示
}


function addCircle(){
	var params = {}; //获取表单参数
	params["createAccount.id"]= $('#accountId').val();
	params["name"] = $('#name').val();
	params["avatar"] = $('#circleAvatar').val();
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


function add(){
	var params = {}; //获取表单参数
	params["accountName"] = $('#accountName').val();
	params["nickName"] = $('#nickName').val();
	params["password"] = $('#password').val();
	params["gender"] = $('#gender').val();
	params["avatar"] = $('#avatar').val();
	params["area"] = $('#area').val();
	params["personSignature"] = $('#personSignature').val();
	$.ajax({
		  type: "POST",
		  url: "account/saveAccount",
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
    		url: "account/deleteAccount",
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

function selectAll(){
	alert("我要选中所有……");
}
