package org.springside.examples.quickstart.web.sys;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springside.modules.web.Servlets;

public class BaseServlet extends Servlets {
	//功能是把request中的值放到map中，在Service中处理，功能和sortMsg类似，已弃用
	public static Map<String,String> getSortMsg(HttpServletRequest request){
		Map<String, String> paramsMap = new HashMap<String, String>();
		Enumeration paramNames = request.getParameterNames();
		while ((paramNames != null) && paramNames.hasMoreElements()) {
			String paramName = (String) paramNames.nextElement();
			paramsMap.put(paramName, request.getParameter(paramName));
		}
		return paramsMap;
	}
	//从request中拿到参数，拼接排序对象
	public static Sort sortMsg(HttpServletRequest request){
		Integer iSortingCols = 0;//排序的列数（一般是1或0）
		Integer iSortCol_0 = 0;//被排序的列的序号
		String sortName = null;//被排序的列的name
		Direction direction = null;
		String sortDir = null;//排序方式 
		Enumeration paramNames = request.getParameterNames();
		while ((paramNames != null) && paramNames.hasMoreElements()) {
			String paramName = (String) paramNames.nextElement();
			if(!"".equals(paramName) && paramName.equals("iSortingCols")){
				iSortingCols = Integer.parseInt(request.getParameter(paramName));
				if(iSortingCols == 0) return null;
				continue;
			}
			if(!"".equals(paramName) && paramName.equals("iSortCol_0")){
				iSortCol_0 = Integer.parseInt(request.getParameter(paramName));
				continue;
			}
			if(!"".equals(paramName) && paramName.startsWith("mDataProp_")){
				Integer sortColNum = Integer.parseInt(paramName.substring("mDataProp_".length()));
				if(sortColNum == iSortCol_0){
					sortName = request.getParameter(paramName);
					continue;
				}
			}
			if(!"".equals(paramName) && paramName.equals("sSortDir_0")){
				sortDir = request.getParameter(paramName);
				if("asc".equals(sortDir)){
					direction = Direction.ASC;
				}
				if("desc".endsWith(sortDir)){
					direction = Direction.DESC;
				}
				continue;
			}
		}
		return new Sort(direction, sortName);
		
	}

}
