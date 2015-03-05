package com.zh.logistics.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.zh.logistics.base.BaseHibernateImpl;
import com.zh.logistics.dao.WarehouseDao;
import com.zh.logistics.entity.Warehouse;
import com.zh.logistics.util.Page;

@Repository("warehouseDao")
public class WarehouseDaoImpl extends BaseHibernateImpl implements WarehouseDao{
	
	public static Logger logger = Logger.getLogger(WarehouseDaoImpl.class);
	
	@Override
	public Warehouse save(Warehouse warehouse) {
		getSession().save(warehouse);
		return warehouse;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Warehouse> query(Warehouse warehouse, Page page) {
		Criteria criteria = getSession().createCriteria(Warehouse.class);
		if (warehouse != null && warehouse.getWarehouseCode() != null && !"".equals(warehouse.getWarehouseCode())) {
			criteria.add(Restrictions.eq("warehouseCode", warehouse.getWarehouseCode()));
		}
		if (warehouse != null && warehouse.getWarehouseName() != null && !"".equals(warehouse.getWarehouseName())) {
			criteria.add(Restrictions.eq("warehouseName", warehouse.getWarehouseName()));
		}
		return criteria.addOrder(Order.desc("id")).setFirstResult(Page.getStartNO(page)).setMaxResults(page.getPageSize()).list();
	}

	@Override
	public int getAllcount(Warehouse warehouse) {
		Criteria criteria = getSession().createCriteria(Warehouse.class);
		if (warehouse != null && warehouse.getWarehouseCode() != null && !"".equals(warehouse.getWarehouseCode())) {
			criteria.add(Restrictions.eq("warehouseCode", warehouse.getWarehouseCode()));
		}
		if (warehouse != null && warehouse.getWarehouseName() != null && !"".equals(warehouse.getWarehouseName())) {
			criteria.add(Restrictions.eq("warehouseName", warehouse.getWarehouseName()));
		}
		return criteria.list().size();
	}

	@Override
	public void update(Warehouse warehouse) {
		getSession().update(warehouse);
	}

	@Override
	public Warehouse getById(int id) {
		return (Warehouse) getSession().get(Warehouse.class, id);
	}


	@Override
	public void delete(int id) {
		String hql = "delete from Warehouse w where w.id = ?";
		Query query = getSession().createQuery(hql);
		query.setInteger(0, id);
		query.executeUpdate();
	}
}
