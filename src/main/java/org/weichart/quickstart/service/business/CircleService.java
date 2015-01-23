package org.weichart.quickstart.service.business;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springside.modules.persistence.DynamicSpecifications;
import org.springside.modules.persistence.SearchFilter;
import org.springside.modules.utils.Clock;
import org.weichart.quickstart.entity.Circle;
import org.weichart.quickstart.repository.CircleDao;
import org.weichart.quickstart.service.ServiceException;
import org.weichart.quickstart.util.DataPage;

/**
 * 
 * @author liyi
 *
 */
//Spring Bean的标识.
@Component
//类中所有public函数都纳入事务管理的标识.
@Transactional
public class CircleService {
	
	private CircleDao circleDao;
	private Clock clock = Clock.DEFAULT;

	
	@Autowired
	public void setCircleDao(CircleDao circleDao) {
		this.circleDao = circleDao;
	}
	/**
	 * getPageModel:分页查询.
	 *
	 * @param entity 实体
	 * @return 分页查询结果
	 * @since JDK 1.6
	 */
	public DataPage<Circle> getPageModel(Circle entity, Map<String, Object> searchParams,Integer iDisplayStart,Integer iDisplayLength, Sort sort) throws ServiceException{
		
		DataPage<Circle> page = new DataPage<Circle>();
		PageRequest pageRequest = new PageRequest(iDisplayStart/iDisplayLength, iDisplayLength, sort);
		Specification<Circle> spec = buildSpecification(searchParams);
		long total = circleDao.count(spec);
		Page<Circle> rows = circleDao.findAll(spec,pageRequest);
		List<Circle> users = rows.getContent();
		page = new DataPage<Circle>(total,total, users);
		return page;
	}
	/**
	 * 创建动态查询条件组合.
	 */
	private Specification<Circle> buildSpecification(Map<String, Object> searchParams) {
		Map<String, SearchFilter> filters = SearchFilter.parse(searchParams);
//		filters.put("user.id", new SearchFilter("user.id", Operator.EQ, userId));
		Specification<Circle> spec = DynamicSpecifications.bySearchFilter(filters.values(), Circle.class);
		return spec;
	}
	
	public Circle findCircleByName(String name) {
		return circleDao.findByname(name);
	}
	
	public void addEntity(Circle entity) throws ServiceException{
		if(findCircleByName(entity.getName()) != null){
			throw new ServiceException("该圈子已存在!");
		}
		entity.setCreateTime(clock.getCurrentDate());
		entity.setStatus(0);
		circleDao.save(entity);
	}

	
	
	
	

}
