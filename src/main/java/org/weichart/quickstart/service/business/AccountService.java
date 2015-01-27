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
import org.weichart.quickstart.entity.Account;
import org.weichart.quickstart.repository.AccountDao;
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
public class AccountService {
	
	private AccountDao accountDao;
	private Clock clock = Clock.DEFAULT;
	
	
	@Autowired
	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}


	/**
	 * getPageModel:分页查询.
	 *
	 * @param entity 实体
	 * @return 分页查询结果
	 * @since JDK 1.6
	 */
	public DataPage<Account> getPageModel(Account entity, Map<String, Object> searchParams,Integer iDisplayStart,Integer iDisplayLength, Sort sort) throws ServiceException{
		
		DataPage<Account> page = new DataPage<Account>();
		PageRequest pageRequest = new PageRequest(iDisplayStart/iDisplayLength, iDisplayLength, sort);
		Specification<Account> spec = buildSpecification(searchParams);
		long total = accountDao.count(spec);
		Page<Account> rows = accountDao.findAll(spec,pageRequest);
		List<Account> users = rows.getContent();
		page = new DataPage<Account>(total,total, users);
		return page;
	}
	/**
	 * 创建动态查询条件组合.
	 */
	private Specification<Account> buildSpecification(Map<String, Object> searchParams) {
		Map<String, SearchFilter> filters = SearchFilter.parse(searchParams);
//		filters.put("user.id", new SearchFilter("user.id", Operator.EQ, userId));
		Specification<Account> spec = DynamicSpecifications.bySearchFilter(filters.values(), Account.class);
		return spec;
	}
	
	public Account findAccountByName(String accountName) {
		return accountDao.findByAccountName(accountName);
	}
	
	public void addEntity(Account entity) throws ServiceException{
		if(findAccountByName(entity.getAccountName()) != null){
			throw new ServiceException("微信号已存在!");
		}
		entity.setCreateTime(clock.getCurrentDate());
		accountDao.save(entity);
	}
	
	public void deleteEntity(Long id){
		accountDao.delete(id);
	}
	

}
