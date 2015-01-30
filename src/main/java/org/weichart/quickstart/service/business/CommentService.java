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
import org.weichart.quickstart.entity.Comment;
import org.weichart.quickstart.entity.Topic;
import org.weichart.quickstart.repository.CircleRoleDao;
import org.weichart.quickstart.repository.CommentDao;
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
public class CommentService {
	
	private CommentDao commentDao;
	private Clock clock = Clock.DEFAULT;
	private TopicDao topicDao;
	private CircleRoleDao circleRoleDao;
	@Autowired
	public void setCommentDao(CommentDao commentDao) {
		this.commentDao = commentDao;
	}
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
	public DataPage<Comment> getPageModel(Comment entity, Map<String, Object> searchParams,Integer iDisplayStart,Integer iDisplayLength, Sort sort) throws ServiceException{
		
		DataPage<Comment> page = new DataPage<Comment>();
		PageRequest pageRequest = new PageRequest(iDisplayStart/iDisplayLength, iDisplayLength, sort);
		Specification<Comment> spec = buildSpecification(searchParams);
		long total = commentDao.count(spec);
		Page<Comment> rows = commentDao.findAll(spec,pageRequest);
		List<Comment> users = rows.getContent();
		page = new DataPage<Comment>(total,total, users);
		return page;
	}
	/**
	 * 创建动态查询条件组合.
	 */
	private Specification<Comment> buildSpecification(Map<String, Object> searchParams) {
		Map<String, SearchFilter> filters = SearchFilter.parse(searchParams);
//		filters.put("user.id", new SearchFilter("user.id", Operator.EQ, userId));
		Specification<Comment> spec = DynamicSpecifications.bySearchFilter(filters.values(), Comment.class);
		return spec;
	}
	
	public List<Comment> getEntityList(Map<String, Object> searchParams){
		List<Comment> comments = new ArrayList<Comment>();
		Specification<Comment> spec = buildSpecification(searchParams);
		comments = commentDao.findAll(spec);
		return comments;
	}
	
	public void saveEntity(Comment entity) throws ServiceException{
		if(entity.getId() == null){//新增
			entity.setCreateTime(clock.getCurrentDate());
			if(entity.getTopic() != null){
				Topic topic = topicDao.findOne(entity.getTopic().getId());
				entity.setTopic(topic);
			}
			if(entity.getCircleRole() != null){
				CircleRole circleRole = circleRoleDao.findOne(entity.getCircleRole().getId());
				entity.setCircleRole(circleRole);
				entity.setAccount(circleRole.getAccount());
			}
			if(entity.getParentComment() != null){
				entity.setParentComment(commentDao.findOne(entity.getParentComment().getId()));
			}
			commentDao.save(entity);
		}else{//修改
			Comment comment = commentDao.findOne(entity.getId());
			comment.setContent(entity.getContent());
			comment.setImages(entity.getImages());
			commentDao.save(comment);
		}
	}
	
	public void deleteEntity(Long id) throws ServiceException{
		commentDao.delete(id);
	}
	
	public Comment findById(Long id){
		return commentDao.findOne(id);
	}
	
	
	
	

}
