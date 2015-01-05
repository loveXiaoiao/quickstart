function add(){
	var params = {}; //获取表单参数
	params["loginName"] = $('#loginName').val();
	params["name"] = $('#name').val();
	params["plainPassword"] = $('#plainPassword').val();
	params["roles"] = $('#roles').val();
	$.ajax({
		  type: "POST",
		  url: "system/saveUser",
		  data: params,
		  datatype:"json",
		  success: function(data){
			  if(data.success == true){
				  $("#modal_content").html(data.msg);
				  $("#modal_submit").attr("onclick","window.location.href='jump/manage_userList'");
				  $("#myModal").modal('show');//展示
//				  window.location.href="jump/manage_userList";
			  }else{
				  $("#modal_content").html(data.msg);
				  $("#modal_submit").attr("onclick","window.location.href='jump/manage_userAdd'");
				  $("#myModal").modal('show');//展示
//				  window.location.href="jump/manage_userAdd";
			  }
		   }
		});
}