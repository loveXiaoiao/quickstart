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
import org.weichart.quickstart.entity.CircleRole;
import org.weichart.quickstart.service.ServiceException;
import org.weichart.quickstart.service.business.AccountService;
import org.weichart.quickstart.service.business.CircleRoleService;
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
@RequestMapping(value = "/api")
public class CircleRoleApi {
	@Autowired
	private CircleRoleService circleRoleService;
	
	@Autowired
	private AccountService accountService;

	@Autowired
	private CircleService circleService;
	private ResultObject resultObject = new ResultObject(true, "OK!");


	@RequestMapping("saveCircleRole")
	@ResponseBody
	public ResultObject saveUser(CircleRole entity, HttpServletRequest request) {
		Long circleId = Long.parseLong(request.getParameter("circle_id"));
		Circle circle = circleService.findById(circleId);
		if (circle == null) {
			resultObject.setMsg("保存失败");
			resultObject.setSuccess(false);
			return resultObject;
		}
		try {
			entity.setCircle(circle);
			entity.setStatus(1);
			circleRoleService.addEntity(entity);
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

	@RequestMapping("deleteCircleRole")
	@ResponseBody
	public ResultObject deleteCircleRole(CircleRole entity,
			HttpServletRequest request) {
		try {
			circleRoleService.deleteEntity(entity.getId());
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
	 * 获取圈子角色列表
	 * @param request
	 * @return
	 */
	@RequestMapping("listCircleRole")
	@ResponseBody
	public ResultObject listApi(HttpServletRequest request) {
		Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");
		try {
			List<CircleRole> circleRoles = new ArrayList<CircleRole>();
			circleRoles = circleRoleService.getEntityList(searchParams);
			resultObject.setResult(circleRoles);
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
	 * 添加修改角色账户关联
	 * @param request
	 * circleRoleId
	 * accountId
	 * @return
	 */
	@RequestMapping("addRoleRelationAccount")
	@ResponseBody
	public ResultObject addRelation(HttpServletRequest request) {
		try {
			Long circleRoleId = Long.parseLong(request.getParameter("circleRoleId"));
			Long accountId = Long.parseLong(request.getParameter("accountId"));
			CircleRole circleRole = circleRoleService.findById(circleRoleId);
			Account account = accountService.findById(accountId);
			if(circleRole!=null && account != null){
				circleRoleService.addRelation(circleRole, account);
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
