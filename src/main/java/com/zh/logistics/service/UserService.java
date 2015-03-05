package com.zh.logistics.service;

import com.zh.logistics.base.BaseService;
import com.zh.logistics.entity.User;

public interface UserService extends BaseService<User>{

	public void test();
	
	public User getUser(User user);
}
