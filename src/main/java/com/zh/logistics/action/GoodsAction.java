package com.zh.logistics.action;

import java.util.List;

import net.sf.json.JSONArray;
import org.apache.log4j.Logger;

import com.zh.logistics.entity.Category;
import com.zh.logistics.entity.Goods;
import com.zh.logistics.service.CategoryService;
import com.zh.logistics.service.GoodsService;
import com.zh.logistics.util.DataFormat;
import com.zh.logistics.util.Page;

/**
 * 商品action
 * 
 * @author zhanghao 20150203
 * 
 * */
public class GoodsAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	private static Logger logger = Logger.getLogger(GoodsAction.class);

	private GoodsService goodsService;

	private Goods goods;

	private List<Goods> goodsList;

	private CategoryService categoryService;
	
	private List<Category> categories;
	
	public String query() {
		try {
			int total = goodsService.getAllcount(goods);
			page.setTotal(total);
			page.setTotalPage(Page.caluTotalPage(total, page.getPageSize()));
			goodsList = goodsService.query(goods, page);
			logger.info("查询成功" + goodsList);
			return "list";
		} catch (RuntimeException e) {
			logger.error("查询失败", e);
			throw e;
		}

	}

	public String queryAll() {
		try {
			goods = new Goods();
			int total = goodsService.getAllcount(goods);
			page = new Page();
			page.setTotal(total);
			page.setLocalPage(1);
			page.setTotalPage(Page.caluTotalPage(total, page.getPageSize()));
			goodsList = goodsService.query(goods, page);
			message = "success";
			logger.info("查询成功" + goodsList);
			return "list";
		} catch (RuntimeException re) {
			logger.error("查询失败", re);
			throw re;
		}

	}

	public String updateGoods() {
		try {
			Category category = this.getCategoryName(goods.getCategory());
			goods.setCategoryName(category.getCategoryName());
			goodsService.update(goods);
			return queryAll();
		} catch (RuntimeException re) {
			logger.error("更新失败", re);
			throw re;
		}

	}

	public String addGoods() {
		try {
			Category category = this.getCategoryName(goods.getCategory());
			goods.setCategoryName(category.getCategoryName());
			goodsService.save(goods);
			return queryAll();
		} catch (RuntimeException re) {
			logger.error("新增失败", re);
			throw re;
		}
	}

	public String deleteGoods() {
		try {
			logger.info("进入了delete方法，Id:" + id);
			String[] idList = DataFormat.StringFormatArray(id);
			for (String delId : idList) {
				goodsService.delete(Integer.parseInt(delId));
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
			logger.info("获取到的仓库ID信息为：" + goods.getId());
			goods = goodsService.getById(goods.getId());
			logger.info("查询ID为：" + goods.getId() + "的仓库信息为：" + goods);
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
	
	public GoodsService getGoodsService() {
		return goodsService;
	}

	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public List<Goods> getGoodsList() {
		return goodsList;
	}

	public void setGoodsList(List<Goods> goodsList) {
		this.goodsList = goodsList;
	}

	public void setMessage(String message) {
		this.message = message;
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
}
