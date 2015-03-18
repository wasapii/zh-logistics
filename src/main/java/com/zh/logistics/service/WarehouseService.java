package com.zh.logistics.service;

import com.zh.logistics.base.BaseService;
import com.zh.logistics.entity.Warehouse;

public interface WarehouseService extends BaseService<Warehouse>{
	
	
	public Warehouse getByWarehouseCode(String warehouseCode);
	
	public String getNameByWarehouseCode(String warehouseCode);
}
