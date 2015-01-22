package org.weichart.quickstart.web.sys;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springside.modules.web.Servlets;
import org.weichart.quickstart.entity.User;
import org.weichart.quickstart.service.ServiceException;
import org.weichart.quickstart.service.user.UserService;
import org.weichart.quickstart.service.user.ShiroDbRealm.ShiroUser;
import org.weichart.quickstart.util.DataPage;
import org.weichart.quickstart.util.ResultObject;
/**
 * 
 * @author liyi
 *
 */

@Controller
@RequestMapping(value = "/system")
public class UserCtrl {
	@Autowired
	private UserService userService;
	
	private ResultObject resultObject = new ResultObject(true, "OK!");
	
	
	@RequestMapping(value = "success")
	public String success(){
		return "manage/userList";
	}
	
	@RequestMapping("saveUser")
	@ResponseBody
	public ResultObject saveUser(User entity, HttpServletRequest request){
		try{
			userService.registerUser(entity);
			resultObject.setMsg("保存成功");
			resultObject.setSuccess(true);
			return resultObject;
		}catch(ServiceException e){
			e.printStackTrace();
			resultObject.setMsg(e.getMessage());
			resultObject.setSuccess(false);
			return resultObject;
		}
	}
	
	@RequestMapping("listuser")
	@ResponseBody
	public DataPage<User> getPageModel(HttpServletRequest request,User entity,Integer iDisplayStart,Integer iDisplayLength){
		//convertToMap定义于父类，将参数数组中的所有元素加入一个HashMap 
		Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");
//		Long userId = getCurrentUserId();
		DataPage<User> pages = null;
		try {
			pages = userService.getPageModel(entity,searchParams,iDisplayStart,iDisplayLength,BaseServlet.sortMsg(request));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pages;
	}
	
	
	
	/**
	 * 取出Shiro中的当前用户Id.
	 */
	private Long getCurrentUserId() {
		ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
		return user.id;
	}
	
	

}
