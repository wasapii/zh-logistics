package com.zh.logistics.action;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;

import com.zh.logistics.entity.User;
import com.zh.logistics.service.UserService;

public class UserAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	private static Logger logger = Logger.getLogger(UserAction.class);

	private User user;

	private UserService userService;

	private List<User> list;


	/**
	 * 登录
	 * 
	 * @return
	 * @throws IOException
	 */
	public String login() {
		logger.info("进入login...");
		if ("zh".equals(user.getUserName())
				&& "aaa123".equals(user.getPassword())) {
			user.setId(123);
			message = "success";
		} else {
			message = "用户名密码错误";
		}
		return "success";
	}

	public String loginUp() {
		System.out.println("22222222221");
		return "success";
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getList() {
		return list;
	}

	public void setList(List<User> list) {
		this.list = list;
	}

}
