package org.springside.examples.quickstart.web.sys;

import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springside.examples.quickstart.service.account.AccountService;
import org.springside.examples.quickstart.service.account.ShiroDbRealm.ShiroUser;
import org.springside.modules.web.Servlets;

import com.google.common.collect.Maps;

@Controller
@RequestMapping(value = "/system")
public class System {
	private static final String DEFAULT_PAGE_SIZE = "3";
	private static Map<String, String> sortTypes = Maps.newLinkedHashMap();
	@Autowired
	private AccountService accountService;
	
	
	@RequestMapping(value = "success")
	public String success(){
		return "manage/system";
	}
	
//	@RequestMapping("/listuser")
//	@ResponseBody
//	public DataPage<User> getPageModel(HttpServletRequest request,User entity,Integer iDisplayStart,Integer iDisplayLength ){
//		DataPage<User> pages = null;
//		try {
//			pages = userService.getPageModel(entity,PageUtil.get(iDisplayStart, iDisplayLength));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return pages;
//	}
	
	/**
	 * 取出Shiro中的当前用户Id.
	 */
	private Long getCurrentUserId() {
		ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
		return user.id;
	}

}
