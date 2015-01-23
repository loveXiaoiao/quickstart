package org.weichart.quickstart.web.business;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springside.modules.web.Servlets;
import org.weichart.quickstart.entity.CircleRole;
import org.weichart.quickstart.service.ServiceException;
import org.weichart.quickstart.service.business.CircleRoleService;
import org.weichart.quickstart.util.DataPage;
import org.weichart.quickstart.util.ResultObject;
import org.weichart.quickstart.web.sys.BaseServlet;

/**
 * 
 * @author liyi
 *
 */

@Controller
@RequestMapping(value = "/circleRole")
public class CircleRoleCtrl {
	@Autowired
	private CircleRoleService circleRoleService;
private ResultObject resultObject = new ResultObject(true, "OK!");
	
	
	@RequestMapping("listCircleRole")
	@ResponseBody
	public DataPage<CircleRole> getPageModel(HttpServletRequest request,CircleRole entity,Integer iDisplayStart,Integer iDisplayLength){
		//convertToMap定义于父类，将参数数组中的所有元素加入一个HashMap 
		Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");
//		Long userId = getCurrentUserId();
		DataPage<CircleRole> pages = null;
		try {
			pages = circleRoleService.getPageModel(entity,searchParams,iDisplayStart,iDisplayLength,BaseServlet.sortMsg(request));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pages;
	}
	
	@RequestMapping("saveCircleRole")
	@ResponseBody
	public ResultObject saveUser(CircleRole entity, HttpServletRequest request){
		try{
			circleRoleService.addEntity(entity);
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