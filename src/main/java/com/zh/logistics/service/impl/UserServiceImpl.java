package com.zh.logistics.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zh.logistics.dao.UserDao;
import com.zh.logistics.entity.User;
import com.zh.logistics.service.UserService;
import com.zh.logistics.util.Page;

@Service("userService")
public class UserServiceImpl implements UserService{

	private UserDao userDao;
	
	@Override
	public void test() {
		System.out.println("这是一段spring4测试代码!!!");
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public User save(User user) {
		System.out.println("测试：执行了新增步骤！");
		return userDao.save(user);
		
	}

	@Override
	public void update(User t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> query(User t, Page page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUser(User user) {
		return userDao.getUser(user);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getAllcount(User t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
