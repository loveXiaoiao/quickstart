package org.weichart.quickstart.web.api;

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
@RequestMapping(value = "/api")
public class AccountApi {

	@Autowired
	private AccountService accountService;
	private ResultObject resultObject = new ResultObject(true, "OK!");


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
	/**
	 * 
	 * @param entity
	 * @param request
	 * accountName
	 * password
	 * @return
	 */
	@RequestMapping("verifyAccount")
	@ResponseBody
	public ResultObject verifyAccount(Account entity, HttpServletRequest request) {
		try {
			Account account = accountService.findByAccountNameAndPassword(entity.getAccountName(), entity.getPassword());
			if(account == null){
				resultObject.setMsg("用户名或密码错误");
				resultObject.setSuccess(false);
				return resultObject;
			}
			resultObject.setMsg("登录成功");
			resultObject.setResult(account);
			resultObject.setSuccess(true);
			return resultObject;
		} catch (ServiceException e) {
			e.printStackTrace();
			resultObject.setMsg("登录失败");
			resultObject.setSuccess(false);
			return resultObject;
		}
	}

}
