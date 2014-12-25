ar User = function () {
	var inittable = function(){
		var oTable = $('#usertable').dataTable( {
	        "bServerSide": true,
	        "sAjaxSource": "listuser",
	        "bProcessing": false,
	        //simple_numbers  full_numbers
	        //"sPaginationType": "two_button",
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
							{ "mDataProp": "id" },
							{ "mDataProp": "userCode" },
							{ "mDataProp": "userPass" },
							{ "mDataProp": "userName" },
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
	};
	
    return {
        init: function () {
        	inittable();
        }
    };

}();