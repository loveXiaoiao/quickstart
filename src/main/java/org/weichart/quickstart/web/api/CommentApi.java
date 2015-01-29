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
import org.weichart.quickstart.entity.Comment;
import org.weichart.quickstart.service.ServiceException;
import org.weichart.quickstart.service.business.AccountService;
import org.weichart.quickstart.service.business.CommentService;
import org.weichart.quickstart.util.ResultObject;

/**
 * 
 * @author liyi
 * 
 */

@Controller
@RequestMapping(value = "/api")
public class CommentApi {
	@Autowired
	private CommentService commentService;
	@Autowired
	private AccountService accountService;

	private ResultObject resultObject = new ResultObject(true, "OK!");


	@RequestMapping("saveComment")
	@ResponseBody
	public ResultObject saveComment(Comment entity, HttpServletRequest request) {
		try {
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
	
	@RequestMapping("listComment")
	@ResponseBody
	public ResultObject listApi(HttpServletRequest request) {
		Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");
		try {
			List<Comment> comments = new ArrayList<Comment>();
//			comments = commentService.getEntityList(searchParams);
			resultObject.setResult(comments);
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
	
	

}
