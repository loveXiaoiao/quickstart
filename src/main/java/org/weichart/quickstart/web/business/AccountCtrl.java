package org.weichart.quickstart.web.business;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springside.modules.web.Servlets;
import org.weichart.quickstart.entity.Account;
import org.weichart.quickstart.entity.Circle;
import org.weichart.quickstart.service.ServiceException;
import org.weichart.quickstart.service.business.AccountService;
import org.weichart.quickstart.service.business.CircleService;
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
	@Autowired
	private CircleService circleService;
	private ResultObject resultObject = new ResultObject(true, "OK!");

	@RequestMapping("listAccount")
	@ResponseBody
	public DataPage<Account> getPageModel(HttpServletRequest request,
			Account entity, Integer iDisplayStart, Integer iDisplayLength) {
		// convertToMap定义于父类，将参数数组中的所有元素加入一个HashMap
		Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");
		// Long userId = getCurrentUserId();
		DataPage<Account> pages = null;
		try {
			pages = accountService
					.getPageModel(entity, searchParams, iDisplayStart,
							iDisplayLength, BaseServlet.sortMsg(request));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pages;
	}

	@RequestMapping("saveAccount")
	@ResponseBody
	public ResultObject saveUser(Account entity, HttpServletRequest request) {
		try {
			accountService.addEntity(entity);
			resultObject.setMsg("保存成功");
			resultObject.setSuccess(true);
			return resultObject;
		} catch (ServiceException e) {
			e.printStackTrace();
			resultObject.setMsg(e.getMessage());
			resultObject.setSuccess(false);
			return resultObject;
		}
	}
	
	@RequestMapping("getEntity")
	@ResponseBody
	public ResultObject getEntity(Account entity, HttpServletRequest request) {
		try {
			Account account = accountService.findById(entity.getId());
			resultObject.setMsg("保存成功");
			resultObject.setResult(account);
			resultObject.setSuccess(true);
			return resultObject;
		} catch (ServiceException e) {
			e.printStackTrace();
			resultObject.setMsg(e.getMessage());
			resultObject.setSuccess(false);
			return resultObject;
		}
	}
	
	

	@RequestMapping("deleteAccount")
	@ResponseBody
	public ResultObject deleteAccount(Account entity, HttpServletRequest request) {
		try {
			accountService.deleteEntity(entity.getId());
			resultObject.setMsg("删除成功");
			resultObject.setSuccess(true);
			return resultObject;
		} catch (ServiceException e) {
			e.printStackTrace();
			resultObject.setMsg("删除失败");
			resultObject.setSuccess(false);
			return resultObject;
		}
	}
	
	@RequestMapping("findAllAccount")
	@ResponseBody
	public ResultObject listAllEntity(HttpServletRequest request){
		Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");
		try {
			List<Account> accounts = accountService.findAll(searchParams);
			resultObject.setResult(accounts);
			resultObject.setSuccess(true);
			return resultObject;
		} catch (ServiceException e) {
			e.printStackTrace();
			resultObject.setSuccess(false);
			return resultObject;
		}
	}
	
	@RequestMapping("getAttentions")
	@ResponseBody
	public ResultObject getCheckAccount(Circle entity, HttpServletRequest request) {
		try {
			Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");
			List<Account> accounts = accountService.findAll(searchParams);
			Circle circle = circleService.findById(entity.getId());
			List<Account> attentionAccounts = circle.getAttentionAccounts();
			for(Account account : accounts){
				account.setFlag("false");
				if(attentionAccounts.contains(account)){
					account.setFlag("true");//如果在粉丝列表中，就把flag设为true
				}
			}
			resultObject.setMsg("成功");
			resultObject.setResult(accounts);
			resultObject.setSuccess(true);
			return resultObject;
		} catch (ServiceException e) {
			e.printStackTrace();
			resultObject.setMsg(e.getMessage());
			resultObject.setSuccess(false);
			return resultObject;
		}
	}
	


}
