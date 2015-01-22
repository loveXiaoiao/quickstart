package org.weichart.quickstart.service.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.weichart.quickstart.repository.CircleRoleDao;

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
	
	
	@Autowired
	public void setCircleRoleDao(CircleRoleDao circleRoleDao) {
		this.circleRoleDao = circleRoleDao;
	}
	
	

}
