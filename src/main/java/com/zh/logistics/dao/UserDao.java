package com.zh.logistics.dao;

import com.zh.logistics.base.BaseDao;
import com.zh.logistics.entity.User;

public interface UserDao extends BaseDao<User>{
	
	public User getUser(User user);

}
