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
import org.weichart.quickstart.entity.Comment;
import org.weichart.quickstart.entity.Topic;
import org.weichart.quickstart.service.ServiceException;
import org.weichart.quickstart.service.business.AccountService;
import org.weichart.quickstart.service.business.CircleRoleService;
import org.weichart.quickstart.service.business.CircleService;
import org.weichart.quickstart.service.business.CommentService;
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
@RequestMapping(value = "/comment")
public class CommentCtrl {
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private TopicService topicService;
	
	@Autowired
	private CircleRoleService circleRoleService;
	
	@Autowired
	private CircleService circleService;
	
	@Autowired
	private AccountService accountService;
	
	private ResultObject resultObject = new ResultObject(true, "OK!");

	@RequestMapping("listComment")
	@ResponseBody
	public DataPage<Comment> getPageModel(HttpServletRequest request,Comment entity, Integer iDisplayStart, Integer iDisplayLength) {
		// convertToMap定义于父类，将参数数组中的所有元素加入一个HashMap
		Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");
		// Long userId = getCurrentUserId();
		DataPage<Comment> pages = null;
		try {
			pages = commentService.getPageModel(entity, searchParams, iDisplayStart,iDisplayLength, BaseServlet.sortMsg(request));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pages;
	}

	@RequestMapping("saveComment")
	@ResponseBody
	public ResultObject saveComment(Comment entity, HttpServletRequest request) {
		try {
			Topic topic = topicService.findById(entity.getTopic().getId());
			if(topic != null){
				Circle circle = topic.getCircle();
				CircleRole circleRole = topic.getCircleRole();
				Account account = topic.getAccount();
			}
			commentService.saveEntity(entity);
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
	public ResultObject getEntity(Comment entity, HttpServletRequest request) {
		try {
			Comment comment = commentService.findById(entity.getId());
			resultObject.setMsg("成功");
			resultObject.setResult(comment);
			resultObject.setSuccess(true);
			return resultObject;
		} catch (ServiceException e) {
			e.printStackTrace();
			resultObject.setMsg(e.getMessage());
			resultObject.setSuccess(false);
			return resultObject;
		}
	}

	@RequestMapping("deleteComment")
	@ResponseBody
	public ResultObject deleteComment(Comment entity, HttpServletRequest request) {
		try {
			commentService.deleteEntity(entity.getId());
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
