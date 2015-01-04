function add(){
	var params = {}; //获取表单参数
	params["loginName"] = $('#loginName').val();
	$('#loginName').validate();
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
				  alert(data.msg);
			  }else{
				  alert(data.msg);
			  }
			  window.location.href="jump/manage_userList";
		   }
		});
}