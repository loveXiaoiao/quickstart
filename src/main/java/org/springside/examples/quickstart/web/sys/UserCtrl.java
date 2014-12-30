package org.springside.examples.quickstart.web.sys;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springside.examples.quickstart.entity.User;
import org.springside.examples.quickstart.service.account.AccountService;
import org.springside.examples.quickstart.service.account.ShiroDbRealm.ShiroUser;
import org.springside.examples.quickstart.util.DataPage;
import org.springside.modules.web.Servlets;

import com.google.common.collect.Maps;

@Controller
@RequestMapping(value = "/system")
public class UserCtrl {
	@Autowired
	private AccountService accountService;
	
	
	@RequestMapping(value = "success")
	public String success(){
		return "manage/userList";
	}
	
	@RequestMapping(value = "saveUser")
	public String saveUser(){
		return "manage/userList";
	}
	
	@RequestMapping("listuser")
	@ResponseBody
	public DataPage<User> getPageModel(HttpServletRequest request,User entity,Integer iDisplayStart,Integer iDisplayLength, String sortType){
		Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");
//		Long userId = getCurrentUserId();
		DataPage<User> pages = null;
		try {
			pages = accountService.getPageModel(entity,searchParams,iDisplayStart,iDisplayLength,sortType);
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
