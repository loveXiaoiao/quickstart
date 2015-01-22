/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package org.weichart.quickstart.service.user;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springside.modules.persistence.DynamicSpecifications;
import org.springside.modules.persistence.SearchFilter;
import org.springside.modules.security.utils.Digests;
import org.springside.modules.utils.Clock;
import org.springside.modules.utils.Encodes;
import org.weichart.quickstart.entity.User;
import org.weichart.quickstart.repository.UserDao;
import org.weichart.quickstart.service.ServiceException;
import org.weichart.quickstart.service.user.ShiroDbRealm.ShiroUser;
import org.weichart.quickstart.util.DataPage;

/**
 * 用户管理类.
 * 
 * @author calvin
 */
// Spring Service Bean的标识.
@Component
@Transactional
public class UserService {

	public static final String HASH_ALGORITHM = "SHA-1";
	public static final int HASH_INTERATIONS = 1024;
	private static final int SALT_SIZE = 8;

	private static Logger logger = LoggerFactory.getLogger(UserService.class);

	private UserDao userDao;
	private Clock clock = Clock.DEFAULT;
	
	

	public List<User> getAllUser() {
		return (List<User>) userDao.findAll();
	}
	
	/**
	 * getPageModel:分页查询.
	 *
	 * @param entity 实体
	 * @return 分页查询结果
	 * @since JDK 1.6
	 */
	public DataPage<User> getPageModel(User entity, Map<String, Object> searchParams,Integer iDisplayStart,Integer iDisplayLength, Sort sort) throws ServiceException{
		
		DataPage<User> page = new DataPage<User>();
		PageRequest pageRequest = new PageRequest(iDisplayStart/iDisplayLength, iDisplayLength, sort);
		Specification<User> spec = buildSpecification(searchParams);
		long total = userDao.count(spec);
		Page<User> rows = userDao.findAll(spec,pageRequest);
		List<User> users = rows.getContent();
		page = new DataPage<User>(total,total, users);
		return page;
	}
	/**
	 * 创建动态查询条件组合.
	 */
	private Specification<User> buildSpecification(Map<String, Object> searchParams) {
		Map<String, SearchFilter> filters = SearchFilter.parse(searchParams);
//		filters.put("user.id", new SearchFilter("user.id", Operator.EQ, userId));
		Specification<User> spec = DynamicSpecifications.bySearchFilter(filters.values(), User.class);
		return spec;
	}
	//此方法已弃用，用来生成排序对象
	private Sort buildSort(Map<String, String> paramsMap){
		Integer iSortingCols = 0;
		Integer iSortCol_0 = 0;
		String sortName = null;
		Direction direction = null;
		String sortDir = null;
		for(String paramName : paramsMap.keySet()){
			if(!"".equals(paramName) && paramName.equals("iSortingCols")){
				iSortingCols = Integer.parseInt(paramsMap.get(paramName));
				if(iSortingCols == 0) return null;
				continue;
			}
			if(!"".equals(paramName) && paramName.equals("iSortCol_0")){
				iSortCol_0 = Integer.parseInt(paramsMap.get(paramName));
				continue;
			}
			if(!"".equals(paramName) && paramName.startsWith("mDataProp_")){
				Integer sortColNum = Integer.parseInt(paramName.substring("mDataProp_".length()));
				if(sortColNum == iSortCol_0){
					sortName = paramsMap.get(paramName);
					continue;
				}
			}
			if(!"".equals(paramName) && paramName.equals("sSortDir_0")){
				sortDir = paramsMap.get(paramName);
				if("asc".equals(sortDir)){
					direction = Direction.ASC;
				}
				if("desc".endsWith(sortDir)){
					direction = Direction.DESC;
				}
				continue;
			}
		}
		return new Sort(direction,sortName);
	}

	public User getUser(Long id) {
		return userDao.findOne(id);
	}

	public User findUserByLoginName(String loginName) {
		return userDao.findByLoginName(loginName);
	}

	public void registerUser(User user) throws ServiceException{
		if(findUserByLoginName(user.getLoginName()) != null){
			throw new ServiceException("用户名已存在!");
		}
		entryptPassword(user);
		user.setRoles("user");
		user.setRegisterDate(clock.getCurrentDate());
		userDao.save(user);
	}

	public void updateUser(User user) {
		if (StringUtils.isNotBlank(user.getPlainPassword())) {
			entryptPassword(user);
		}
		userDao.save(user);
	}

	public void deleteUser(Long id) {
		if (isSupervisor(id)) {
			logger.warn("操作员{}尝试删除超级管理员用户", getCurrentUserName());
			throw new ServiceException("不能删除超级管理员用户");
		}
		userDao.delete(id);

	}

	/**
	 * 判断是否超级管理员.
	 */
	private boolean isSupervisor(Long id) {
		return id == 1;
	}

	/**
	 * 取出Shiro中的当前用户LoginName.
	 */
	private String getCurrentUserName() {
		ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
		return user.loginName;
	}

	/**
	 * 设定安全的密码，生成随机的salt并经过1024次 sha-1 hash
	 */
	private void entryptPassword(User user) {
		byte[] salt = Digests.generateSalt(SALT_SIZE);
		user.setSalt(Encodes.encodeHex(salt));

		byte[] hashPassword = Digests.sha1(user.getPlainPassword().getBytes(), salt, HASH_INTERATIONS);
		user.setPassword(Encodes.encodeHex(hashPassword));
	}

	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}


	public void setClock(Clock clock) {
		this.clock = clock;
	}
}
