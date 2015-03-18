package com.zh.logistics.dao;

import com.zh.logistics.base.BaseDao;
import com.zh.logistics.entity.Goods;

public interface GoodsDao extends BaseDao<Goods>{

	public Goods getByGoodsCode(String goodsCode);
}
