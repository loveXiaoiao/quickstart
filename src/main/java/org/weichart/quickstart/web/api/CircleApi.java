package org.weichart.quickstart.web.api;

import java.util.ArrayList;
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
import org.weichart.quickstart.util.ResultObject;

/**
 * 
 * @author liyi
 * 
 */

@Controller
@RequestMapping(value = "/api")
public class CircleApi {
	@Autowired
	private CircleService circleService;
	@Autowired
	private AccountService accountService;

	private ResultObject resultObject = new ResultObject(true, "OK!");


	@RequestMapping("saveCircle")
	@ResponseBody
	public ResultObject saveCircle(Circle entity, HttpServletRequest request) {
		try {
			circleService.saveEntity(entity);
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
	
	@RequestMapping("deleteCircle")
	@ResponseBody
	public ResultObject deleteCircle(Circle entity, HttpServletRequest request) {
		try {
			circleService.deleteEntity(entity.getId());
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
	
	@RequestMapping("listCircle")
	@ResponseBody
	public ResultObject listApi(HttpServletRequest request) {
		Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");
		try {
			List<Circle> circles = new ArrayList<Circle>();
			circles = circleService.getEntityList(searchParams);
			resultObject.setResult(circles);
			resultObject.setMsg("success");
			resultObject.setSuccess(true);
			return resultObject;
		} catch (ServiceException e) {
			e.printStackTrace();
			resultObject.setMsg(e.getMessage());
			resultObject.setSuccess(false);
			return resultObject;
		}
	}
	
	/**
	 * 
	 * @param request
	 * circleId
	 * accountId
	 * @return
	 */
	@RequestMapping("attentionCircle")
	@ResponseBody
	public ResultObject attentionCircle(HttpServletRequest request) {
		try {
			Long circleId = Long.parseLong(request.getParameter("circleId"));
			Long accountId = Long.parseLong(request.getParameter("accountId"));
			Circle circle = circleService.findById(circleId);
			Account account = accountService.findById(accountId);
			if(circle != null && account != null){
				circleService.attentionCircle(account, circle);
				resultObject.setMsg("success");
				resultObject.setSuccess(true);
				return resultObject;
			}
			resultObject.setMsg("false");
			resultObject.setSuccess(false);
			return resultObject;
		} catch (ServiceException e) {
			e.printStackTrace();
			resultObject.setMsg(e.getMessage());
			resultObject.setSuccess(false);
			return resultObject;
		}
	}
	
	/**
	 * 
	 * @param request
	 * circleId
	 * accountId
	 * @return
	 */
	@RequestMapping("removeAttentionCircle")
	@ResponseBody
	public ResultObject removeAttentionCircle(HttpServletRequest request) {
		try {
			Long circleId = Long.parseLong(request.getParameter("circleId"));
			Long accountId = Long.parseLong(request.getParameter("accountId"));
			Circle circle = circleService.findById(circleId);
			Account account = accountService.findById(accountId);
			if(circle != null && account != null){
				circleService.removeAttentionCircle(account, circle);
				resultObject.setMsg("success");
				resultObject.setSuccess(true);
				return resultObject;
			}
			resultObject.setMsg("false");
			resultObject.setSuccess(false);
			return resultObject;
		} catch (ServiceException e) {
			e.printStackTrace();
			resultObject.setMsg(e.getMessage());
			resultObject.setSuccess(false);
			return resultObject;
		}
	}
	

}
