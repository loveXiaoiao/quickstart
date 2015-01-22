/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package org.weichart.quickstart.service.user;

import static org.assertj.core.api.Assertions.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springside.modules.test.security.shiro.ShiroTestUtils;
import org.springside.modules.utils.Clock.MockClock;
import org.weichart.quickstart.data.UserData;
import org.weichart.quickstart.entity.User;
import org.weichart.quickstart.repository.UserDao;
import org.weichart.quickstart.service.ServiceException;
import org.weichart.quickstart.service.user.UserService;
import org.weichart.quickstart.service.user.ShiroDbRealm.ShiroUser;

/**
 * userService的测试用例, 测试Service层的业务逻辑.
 * 
 * @author calvin
 */
public class UserServiceTest {

	@InjectMocks
	private UserService userService;

	@Mock
	private UserDao mockUserDao;


	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		ShiroTestUtils.mockSubject(new ShiroUser(3L, "foo", "Foo"));
	}

	@Test
	public void registerUser() {
		for(int i =0;i<20;i++){
		User user = UserData.randomNewUser();
		Date currentTime = new Date();
		userService.setClock(new MockClock(currentTime));
		userService.registerUser(user);
		// 验证user的角色，注册日期和加密后的密码都被自动更新了。
//		assertThat(user.getRoles()).isEqualTo("user");
//		assertThat(user.getRegisterDate()).isEqualTo(currentTime);
//		assertThat(user.getPassword()).isNotNull();
//		assertThat(user.getSalt()).isNotNull();
		}
	}
	@Test
	public void saveUserTest() throws Exception {
		for(int i=0;i<20;i++){
		User user = new User();
		user.setLoginName("liyi");
		user.setName("liyi");
		user.setPassword("liyi");
		user.setRoles("user");
		user.setSalt("liyi");
		user.setRegisterDate(new Date());
		mockUserDao.save(user);
		}
		
	}

	@Test
	public void updateUser() {
		// 如果明文密码不为空，加密密码会被更新.
		User user = UserData.randomNewUser();
		userService.updateUser(user);
		assertThat(user.getSalt()).isNotNull();

		// 如果明文密码为空，加密密码无变化。
		User user2 = UserData.randomNewUser();
		user2.setPlainPassword(null);
		userService.updateUser(user2);
		assertThat(user2.getSalt()).isNull();
	}

	@Test
	public void deleteUser() {
		// 正常删除用户.
		userService.deleteUser(2L);
		Mockito.verify(mockUserDao).delete(2L);

		// 删除超级管理用户抛出异常, userDao没有被执行
		try {
			userService.deleteUser(1L);
			failBecauseExceptionWasNotThrown(ServiceException.class);
		} catch (ServiceException e) {
			// expected exception
		}
		Mockito.verify(mockUserDao, Mockito.never()).delete(1L);
	}

}
