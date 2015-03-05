package com.zh.logistics.service;

import java.util.List;

import com.zh.logistics.base.BaseService;
import com.zh.logistics.entity.Category;

/**
 * 类别service
 * @zhanghao
 * 20150205
 * */
public interface CategoryService extends BaseService<Category>{

	public List<Category> query();
	
	public Category findByCode(String categoryCode);
}
