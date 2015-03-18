package com.zh.logistics.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.zh.logistics.base.BaseHibernateImpl;
import com.zh.logistics.dao.InventoryDao;
import com.zh.logistics.entity.Inventory;
import com.zh.logistics.util.Page;

@Repository("inventoryDao")
public class InventoryDaoImpl extends BaseHibernateImpl implements InventoryDao {
	
	private static final Logger logger = Logger.getLogger(Inventory.class);

	@Override
	public Inventory save(Inventory inventory) {
		logger.debug("saving Inventory inventory");
		try {
			getSession().save(inventory);
			logger.debug("save successful");
			return inventory;
		} catch (RuntimeException re) {
			logger.error("save failed", re);
			throw re;
		}
	}

	@Override
	public List<Inventory> query(Inventory t, Page page) {
		return null;
	}

	@Override
	public void update(Inventory t) {
		// TODO Auto-generated method stub

	}

	@Override
	public Inventory getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getAllcount(Inventory t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Inventory getByWarehouseCode(String warehouseCode,String goodsCode) {
		return (Inventory) getSession().createCriteria(Inventory.class)
				.add(Restrictions.eq("warehouseCode", warehouseCode))
				.add(Restrictions.eq("goodsCode", goodsCode))
				.uniqueResult();
	}

}
