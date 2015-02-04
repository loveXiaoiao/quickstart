package org.weichart.quickstart.web.business;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springside.modules.web.Servlets;
import org.weichart.quickstart.entity.Account;
import org.weichart.quickstart.entity.Circle;
import org.weichart.quickstart.entity.CircleRole;
import org.weichart.quickstart.entity.Topic;
import org.weichart.quickstart.service.ServiceException;
import org.weichart.quickstart.service.business.AccountService;
import org.weichart.quickstart.service.business.CircleRoleService;
import org.weichart.quickstart.service.business.CircleService;
import org.weichart.quickstart.service.business.TopicService;
import org.weichart.quickstart.util.DataPage;
import org.weichart.quickstart.util.ResultObject;
import org.weichart.quickstart.web.sys.BaseServlet;

/**
 * 
 * @author liyi
 *
 */

@Controller
@RequestMapping(value = "/topic")
public class TopicCtrl {
	
	@Autowired
	private TopicService topicService;
	
	@Autowired
	private CircleRoleService circleRoleService;
	
	@Autowired
	private CircleService circleService;
	
	@Autowired
	private AccountService accountService;
	
	private ResultObject resultObject = new ResultObject(true, "OK!");

	@RequestMapping("listTopic")
	@ResponseBody
	public DataPage<Topic> getPageModel(HttpServletRequest request,Topic entity, Integer iDisplayStart, Integer iDisplayLength) {
		// convertToMap定义于父类，将参数数组中的所有元素加入一个HashMap
		Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");
		// Long userId = getCurrentUserId();
		DataPage<Topic> pages = null;
		try {
			pages = topicService.getPageModel(entity, searchParams, iDisplayStart,iDisplayLength, BaseServlet.sortMsg(request));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pages;
	}
	/**
	 * 
	 * @param entity
	 * circleRole.id
	 * @param request
	 * @return
	 */

	@RequestMapping("saveTopic")
	@ResponseBody
	public ResultObject saveTopic(Topic entity, HttpServletRequest request) {
		try {
				topicService.saveEntity(entity);
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
	public ResultObject getEntity(Topic entity, HttpServletRequest request) {
		try {
			Topic topic = topicService.findById(entity.getId());
			resultObject.setMsg("成功");
			resultObject.setResult(topic);
			resultObject.setSuccess(true);
			return resultObject;
		} catch (ServiceException e) {
			e.printStackTrace();
			resultObject.setMsg(e.getMessage());
			resultObject.setSuccess(false);
			return resultObject;
		}
	}

	@RequestMapping("deleteTopic")
	@ResponseBody
	public ResultObject deleteTopic(Topic entity, HttpServletRequest request) {
		try {
			topicService.deleteEntity(entity.getId());
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

}
