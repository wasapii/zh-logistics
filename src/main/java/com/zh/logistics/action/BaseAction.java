package com.zh.logistics.action;

import com.opensymphony.xwork2.ActionSupport;
import com.zh.logistics.util.Page;

public class BaseAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
	protected String id;

	protected Page page;

	protected String message;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
