package org.weichart.quickstart.web.business;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springside.modules.web.Servlets;
import org.weichart.quickstart.entity.Circle;
import org.weichart.quickstart.service.ServiceException;
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
	
	private ResultObject resultObject = new ResultObject(true, "OK!");
	
	@RequestMapping("listCircle")
	@ResponseBody
	public DataPage<Circle> getPageModel(HttpServletRequest request,Circle entity,Integer iDisplayStart,Integer iDisplayLength){
		//convertToMap定义于父类，将参数数组中的所有元素加入一个HashMap 
		Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");
//		Long userId = getCurrentUserId();
		DataPage<Circle> pages = null;
		try {
			pages = circleService.getPageModel(entity,searchParams,iDisplayStart,iDisplayLength,BaseServlet.sortMsg(request));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pages;
	}
	
	@RequestMapping("saveCircle")
	@ResponseBody
	public ResultObject saveUser(Circle entity, HttpServletRequest request){
		try{
			circleService.addEntity(entity);
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
		
		@RequestMapping("deleteCircle")
		@ResponseBody
		public ResultObject deleteCircle(Circle entity, HttpServletRequest request){
			try{
				circleService.deleteEntity(entity.getId());
				resultObject.setMsg("删除成功");
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
