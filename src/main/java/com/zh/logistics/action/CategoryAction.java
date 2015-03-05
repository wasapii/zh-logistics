package com.zh.logistics.action;

import java.util.List;

import net.sf.json.JSONArray;
import org.apache.log4j.Logger;

import com.zh.logistics.entity.Category;
import com.zh.logistics.service.CategoryService;
import com.zh.logistics.util.DataFormat;
import com.zh.logistics.util.Page;

/**
 * 商品action
 * 
 * @author zhanghao 20150203
 * 
 * */
public class CategoryAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	private static Logger logger = Logger.getLogger(CategoryAction.class);

	private CategoryService categoryService;
	
	private List<Category> categories;
	
	private Category category;
	
	public String query() {
		try {
			int total = categoryService.getAllcount(category);
			page.setTotal(total);
			page.setTotalPage(Page.caluTotalPage(total, page.getPageSize()));
			categories = categoryService.query(category, page);
			logger.info("查询成功" + categories);
			return "list";
		} catch (RuntimeException e) {
			logger.error("查询失败", e);
			throw e;
		}

	}

	public String queryAll() {
		try {
			category = new Category();
			int total = categoryService.getAllcount(category);
			page = new Page();
			page.setTotal(total);
			page.setLocalPage(1);
			page.setTotalPage(Page.caluTotalPage(total, page.getPageSize()));
			categories = categoryService.query(category, page);
			message = "success";
			logger.info("查询成功" + categories);
			return "list";
		} catch (RuntimeException re) {
			logger.error("查询失败", re);
			throw re;
		}

	}

	public String updateCategory() {
		try {
			categoryService.update(category);
			return queryAll();
		} catch (RuntimeException re) {
			logger.error("更新失败", re);
			throw re;
		}

	}

	public String addCategory() {
		try {
			categoryService.save(category);
			return queryAll();
		} catch (RuntimeException re) {
			logger.error("新增失败", re);
			throw re;
		}
	}

	public String deleteCategory() {
		try {
			logger.info("进入了delete方法，Id:" + id);
			String[] idList = DataFormat.StringFormatArray(id);
			for (String delId : idList) {
				categoryService.delete(Integer.parseInt(delId));
				logger.info("删除结算账户信息成功,删除ID:" + delId);
			}
			return queryAll();
		} catch (RuntimeException re) {
			logger.error("删除失败", re);
			throw re;
		}
	}

	public String toUpdate() {
		try {
			logger.info("获取到的仓库ID信息为：" + category.getId());
			category = categoryService.getById(category.getId());
			logger.info("查询ID为：" + category.getId() + "的仓库信息为：" + category);
			return "update";
		} catch (RuntimeException re) {
			logger.error("查询失败", re);
			throw re;
		}
	}

	public String getCata(){
		categories = categoryService.query();
		JSONArray json = JSONArray.fromObject(categories);
		message = json.toString();
		return SUCCESS;
	}
	
	public Category getCategoryName(String categoryCode){
		return categoryService.findByCode(categoryCode);
	}

	public CategoryService getCategoryService() {
		return categoryService;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
