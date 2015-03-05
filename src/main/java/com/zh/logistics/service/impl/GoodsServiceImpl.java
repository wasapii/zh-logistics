package com.zh.logistics.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zh.logistics.dao.GoodsDao;
import com.zh.logistics.entity.Goods;
import com.zh.logistics.service.GoodsService;
import com.zh.logistics.util.Page;

@Service("goodsService")
public class GoodsServiceImpl implements GoodsService{

	private GoodsDao goodsDao;

	@Override
	public Goods save(Goods t) {
		return goodsDao.save(t);
	}

	@Override
	public void update(Goods t) {
		goodsDao.update(t);		
	}

	@Override
	public List<Goods> query(Goods t, Page page) {
		return goodsDao.query(t, page);
	}

	@Override
	public void delete(int id) {
		goodsDao.delete(id);
	}

	@Override
	public int getAllcount(Goods t) {
		return goodsDao.getAllcount(t);
	}

	@Override
	public Goods getById(int id) {
		return goodsDao.getById(id);
	}

	public GoodsDao getGoodsDao() {
		return goodsDao;
	}

	public void setGoodsDao(GoodsDao goodsDao) {
		this.goodsDao = goodsDao;
	}

}
