package com.zh.logistics.dao.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.zh.logistics.base.BaseHibernateImpl;
import com.zh.logistics.dao.UserDao;
import com.zh.logistics.entity.User;
import com.zh.logistics.util.Page;

@Repository("userDao")
public class UserDaoImpl extends BaseHibernateImpl implements UserDao {

	@Override
	public User save(User user) {
		getSession().save(user);
		return user;
				
	}

	@Override
	public List<User> query(User user, Page page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUser(User user) {
		return (User)getSession().createCriteria(User.class).
				add(Restrictions.eq("userName", user.getUserName())).
				add(Restrictions.eq("password", user.getPassword()))
				.uniqueResult();
	}

	@Override
	public User getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(User t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getAllcount(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

}
