package org.weichart.quickstart.web.business;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
@RequestMapping(value = "/circle")
public class CircleCtrl {
	@Autowired
	private CircleService circleService;
	@Autowired
	private AccountService accountService;
	
	private ResultObject resultObject = new ResultObject(true, "OK!");

	@RequestMapping("listCircle")
	@ResponseBody
	public DataPage<Circle> getPageModel(HttpServletRequest request,Circle entity, Integer iDisplayStart, Integer iDisplayLength) {
		// convertToMap定义于父类，将参数数组中的所有元素加入一个HashMap
		Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");
		// Long userId = getCurrentUserId();
		DataPage<Circle> pages = null;
		try {
			pages = circleService.getPageModel(entity, searchParams, iDisplayStart,iDisplayLength, BaseServlet.sortMsg(request));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pages;
	}

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
	
	@RequestMapping("getEntity")
	@ResponseBody
	public ResultObject getEntity(Circle entity, HttpServletRequest request) {
		try {
			Circle circle = circleService.findById(entity.getId());
			resultObject.setMsg("成功");
			resultObject.setResult(circle);
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
	
	@RequestMapping("updateAttentions")
	@ResponseBody
	public ResultObject updateAttentions(Circle entity, Long[] ids, HttpServletRequest request){
		try{
			List<Account> attentions = accountService.findByids(Arrays.asList(ids));
			entity.setAttentionAccounts(attentions);
			circleService.updateAttentions(entity);
			return resultObject;
		}catch(ServiceException e){
			e.printStackTrace();
			resultObject.setSuccess(false);
			return resultObject;
		}
	}
	
	@RequestMapping("findAllCircle")
	@ResponseBody
	public ResultObject findAll(HttpServletRequest request){
		try{
			List<Circle> circles = circleService.findAllEntity();
			resultObject.setResult(circles);
			return resultObject;
		}catch(ServiceException e){
			e.printStackTrace();
			resultObject.setSuccess(false);
			return resultObject;
		}
	}

}
