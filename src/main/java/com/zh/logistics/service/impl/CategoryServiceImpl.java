package com.zh.logistics.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zh.logistics.dao.CategoryDao;
import com.zh.logistics.entity.Category;
import com.zh.logistics.service.CategoryService;
import com.zh.logistics.util.Page;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService{

	private CategoryDao categoryDao;

	@Override
	public Category save(Category t) {
		return categoryDao.save(t);
	}

	@Override
	public void update(Category t) {
		categoryDao.update(t);		
	}

	@Override
	public List<Category> query() {
		return categoryDao.query();
	}

	@Override
	public void delete(int id) {
		categoryDao.delete(id);
	}

	@Override
	public int getAllcount(Category t) {
		return categoryDao.getAllcount(t);
	}

	@Override
	public Category getById(int id) {
		return categoryDao.getById(id);
	}

	public CategoryDao getCategoryDao() {
		return categoryDao;
	}

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	@Override
	public List<Category> query(Category t, Page page) {
		return categoryDao.query();
	}

	@Override
	public Category findByCode(String categoryCode) {
		return categoryDao.findByCode(categoryCode);
	}

}
