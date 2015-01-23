package org.weichart.quickstart.web.business;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springside.modules.web.Servlets;
import org.weichart.quickstart.entity.Account;
import org.weichart.quickstart.service.ServiceException;
import org.weichart.quickstart.service.business.AccountService;
import org.weichart.quickstart.util.DataPage;
import org.weichart.quickstart.util.ResultObject;
import org.weichart.quickstart.web.sys.BaseServlet;

/**
 * 
 * @author liyi
 *
 */

@Controller
@RequestMapping(value = "/account")
public class AccountCtrl {
	
	@Autowired
	private AccountService accountService;
	private ResultObject resultObject = new ResultObject(true, "OK!");
	
	
	@RequestMapping("listAccount")
	@ResponseBody
	public DataPage<Account> getPageModel(HttpServletRequest request,Account entity,Integer iDisplayStart,Integer iDisplayLength){
		//convertToMap定义于父类，将参数数组中的所有元素加入一个HashMap 
		Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");
//		Long userId = getCurrentUserId();
		DataPage<Account> pages = null;
		try {
			pages = accountService.getPageModel(entity,searchParams,iDisplayStart,iDisplayLength,BaseServlet.sortMsg(request));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pages;
	}
	
	@RequestMapping("saveAccount")
	@ResponseBody
	public ResultObject saveUser(Account entity, HttpServletRequest request){
		try{
			accountService.addEntity(entity);
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

}
