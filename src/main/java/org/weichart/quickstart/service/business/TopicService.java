package org.weichart.quickstart.service.business;

import java.util.ArrayList;
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
import org.weichart.quickstart.entity.CircleRole;
import org.weichart.quickstart.entity.Topic;
import org.weichart.quickstart.repository.CircleRoleDao;
import org.weichart.quickstart.repository.TopicDao;
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
public class TopicService {
	
	private TopicDao topicDao;
	private Clock clock = Clock.DEFAULT;
	private CircleRoleDao circleRoleDao;

	@Autowired
	public void setTopicDao(TopicDao topicDao) {
		this.topicDao = topicDao;
	}
	@Autowired
	public void setCircleRoleDao(CircleRoleDao circleRoleDao) {
		this.circleRoleDao = circleRoleDao;
	}

	/**
	 * getPageModel:分页查询.
	 *
	 * @param entity 实体
	 * @return 分页查询结果
	 * @since JDK 1.6
	 */
	public DataPage<Topic> getPageModel(Topic entity, Map<String, Object> searchParams,Integer iDisplayStart,Integer iDisplayLength, Sort sort) throws ServiceException{
		
		DataPage<Topic> page = new DataPage<Topic>();
		PageRequest pageRequest = new PageRequest(iDisplayStart/iDisplayLength, iDisplayLength, sort);
		Specification<Topic> spec = buildSpecification(searchParams);
		long total = topicDao.count(spec);
		Page<Topic> rows = topicDao.findAll(spec,pageRequest);
		List<Topic> users = rows.getContent();
		page = new DataPage<Topic>(total,total, users);
		return page;
	}
	/**
	 * 创建动态查询条件组合.
	 */
	private Specification<Topic> buildSpecification(Map<String, Object> searchParams) {
		Map<String, SearchFilter> filters = SearchFilter.parse(searchParams);
//		filters.put("user.id", new SearchFilter("user.id", Operator.EQ, userId));
		Specification<Topic> spec = DynamicSpecifications.bySearchFilter(filters.values(), Topic.class);
		return spec;
	}
	
	public List<Topic> getEntityList(Map<String, Object> searchParams){
		List<Topic> topics = new ArrayList<Topic>();
		Specification<Topic> spec = buildSpecification(searchParams);
		topics = topicDao.findAll(spec);
		return topics;
	}
	
	public void saveEntity(Topic entity) throws ServiceException{
		if(entity.getId() == null){//新增
			entity.setCreateTime(clock.getCurrentDate());
			CircleRole circleRole = circleRoleDao.findOne(entity.getCircleRole().getId());
			entity.setCircleRole(circleRole);
			entity.setAccount(circleRole.getAccount());
			entity.setCircle(circleRole.getCircle());
			topicDao.save(entity);
		}else{//修改
			//TODO
			Topic topic = topicDao.findOne(entity.getId());
			CircleRole circleRole = circleRoleDao.findOne(entity.getCircleRole().getId());
			entity.setCircleRole(circleRole);
			entity.setAccount(circleRole.getAccount());
			entity.setCircle(circleRole.getCircle());
			topic.setContent(entity.getContent());
			topic.setImages(entity.getImages());
			topicDao.save(topic);
		}
	}
	
	public void deleteEntity(Long id) throws ServiceException{
		topicDao.delete(id);
	}
	
	public Topic findById(Long id){
		return topicDao.findOne(id);
	}
	
	
	
	
	

}
