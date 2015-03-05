package com.zh.logistics.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zh.logistics.dao.WarehouseDao;
import com.zh.logistics.entity.Warehouse;
import com.zh.logistics.service.WarehouseService;
import com.zh.logistics.util.Page;

@Service("warehouseService")
public class WarehouseServiceImpl implements WarehouseService{

	private WarehouseDao warehouseDao;
	
	public WarehouseDao getWarehouseDao() {
		return warehouseDao;
	}

	public void setWarehouseDao(WarehouseDao warehouseDao) {
		this.warehouseDao = warehouseDao;
	}

	@Override
	public Warehouse save(Warehouse warehouse) {
		return warehouseDao.save(warehouse);
	}

	@Override
	public List<Warehouse> query(Warehouse warehouse, Page page) {
		return warehouseDao.query(warehouse, page);
	}

	@Override
	public int getAllcount(Warehouse warehouse) {
		return warehouseDao.getAllcount(warehouse);
	}

	@Override
	public void update(Warehouse warehouse) {
		warehouseDao.update(warehouse);
	}

	@Override
	public void delete(int id) {
		warehouseDao.delete(id);
	}

	@Override
	public Warehouse getById(int id) {
		return warehouseDao.getById(id);
	}

}
