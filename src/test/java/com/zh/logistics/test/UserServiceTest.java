package com.zh.logistics.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zh.logistics.entity.User;
import com.zh.logistics.service.UserService;
import com.zh.logistics.service.WarehouseService;

public class UserServiceTest {

	@Test
	public void testAdd(){
		User user = new User();
		user.setUserName("test");
		user.setPassword("test");
		System.out.println(userService.save(user));
	}
	
	ApplicationContext applicationContext;
	UserService userService;
	
	@Before
	public void loadXml(){
		applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		userService = (UserService) applicationContext.getBean("userService");
	}

	@Test
	public void TestGetUser(){
		User user = new User();
		user.setUserName("test");
		user.setPassword("test");
		System.err.println(userService.getUser(user));
	}
}
