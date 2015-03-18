package com.zh.logistics.dao;


import com.zh.logistics.base.BaseDao;
import com.zh.logistics.entity.Warehouse;

public interface WarehouseDao extends BaseDao<Warehouse>{
	
	public Warehouse getByWarehouseCode(String warehouseCode);
	
	public String getNameByWarehouseCode(String warehouseCode);
}
