package com.zh.logistics.dao;

import com.zh.logistics.base.BaseDao;
import com.zh.logistics.entity.Inventory;

/**
 * 库存信息
 * */
public interface InventoryDao extends BaseDao<Inventory>{
	
	public Inventory getByWarehouseCode(String warehouseCode,String goodsCode);

}
