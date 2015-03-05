package com.zh.logistics.dao;

import java.util.List;

import com.zh.logistics.base.BaseDao;
import com.zh.logistics.entity.Category;

public interface CategoryDao extends BaseDao<Category>{

	public List<Category> query();

	public Category findByCode(String categoryCode);
}
