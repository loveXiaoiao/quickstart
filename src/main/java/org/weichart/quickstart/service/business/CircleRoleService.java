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
import org.weichart.quickstart.entity.Account;
import org.weichart.quickstart.entity.Circle;
import org.weichart.quickstart.entity.CircleRole;
import org.weichart.quickstart.repository.AccountDao;
import org.weichart.quickstart.repository.CircleDao;
import org.weichart.quickstart.repository.CircleRoleDao;
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
public class CircleRoleService {
	
	private CircleRoleDao circleRoleDao;
	private CircleDao circleDao;
	private AccountDao accountDao;
	private Clock clock = Clock.DEFAULT;
	@Autowired
	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	@Autowired
	public void setCircleRoleDao(CircleRoleDao circleRoleDao) {
		this.circleRoleDao = circleRoleDao;
	}
	
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
	public DataPage<CircleRole> getPageModel(CircleRole entity, Map<String, Object> searchParams,Integer iDisplayStart,Integer iDisplayLength, Sort sort) throws ServiceException{
		
		DataPage<CircleRole> page = new DataPage<CircleRole>();
		PageRequest pageRequest = new PageRequest(iDisplayStart/iDisplayLength, iDisplayLength, sort);
		Specification<CircleRole> spec = buildSpecification(searchParams);
		long total = circleRoleDao.count(spec);
		Page<CircleRole> rows = circleRoleDao.findAll(spec,pageRequest);
		List<CircleRole> users = rows.getContent();
		page = new DataPage<CircleRole>(total,total, users);
		return page;
	}
	/**
	 * 创建动态查询条件组合.
	 */
	private Specification<CircleRole> buildSpecification(Map<String, Object> searchParams) {
		Map<String, SearchFilter> filters = SearchFilter.parse(searchParams);
//		filters.put("user.id", new SearchFilter("user.id", Operator.EQ, userId));
		Specification<CircleRole> spec = DynamicSpecifications.bySearchFilter(filters.values(), CircleRole.class);
		return spec;
	}
	
	
	public List<CircleRole> getEntityList(Map<String, Object> searchParams){
		List<CircleRole> circles = new ArrayList<CircleRole>();
		Specification<CircleRole> spec = buildSpecification(searchParams);
		circles = circleRoleDao.findAll(spec);
		return circles;
	}
	
	public CircleRole findByRoleName(String roleName) {
		return circleRoleDao.findByRoleName(roleName);
	}
	
	public void saveEntity(CircleRole entity) throws ServiceException{
		Circle circle = circleDao.findOne(entity.getCircle().getId());
		Account account = new Account();
		if(entity.getAccount().getId() != null){
			account = accountDao.findOne(entity.getAccount().getId());
		}
		if(entity.getId() == null){//新增
			if(findByRoleName(entity.getRoleName()) != null){
				throw new ServiceException("该角色已存在!");
			}
			entity.setCircle(circle);
			entity.setAccount(account);
			entity.setStatus(1);//未关联
			entity.setActiveDegree(1);
			entity.setCreateTime(clock.getCurrentDate());
			circleRoleDao.save(entity);
		}else{//修改
			CircleRole circleRole = circleRoleDao.findOne(entity.getId());
			circleRole.setAccount(account);
			circleRole.setAvatar(entity.getAvatar());
			circleRole.setRoleName(entity.getRoleName());
			circleRole.setCircle(circle);
			circleRole.setRemark(entity.getRemark());
			circleRoleDao.save(circleRole);
		}
	}
	
	public void deleteEntity(Long id){
		circleRoleDao.delete(id);
	}
	
	public CircleRole findById(Long id){
		return circleRoleDao.findOne(id);
	}
	
	public List<CircleRole> findAll(Map<String, Object> searchParams){
		Specification<CircleRole> spec = buildSpecification(searchParams);
		return circleRoleDao.findAll(spec);
	}
	
	public void addRelation(CircleRole circleRole, Account account){
		circleRole.setAccount(account);
		circleRoleDao.save(circleRole);
	}
	

	

}
