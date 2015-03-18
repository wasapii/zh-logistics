package com.zh.logistics.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.zh.logistics.base.BaseHibernateImpl;
import com.zh.logistics.dao.GoodsDao;
import com.zh.logistics.entity.Goods;
import com.zh.logistics.util.Page;

/**
 * * @author zhanghao 20150203
 * 
 * */
@Repository("goodsDao")
public class GoodsDaoImpl extends BaseHibernateImpl implements GoodsDao {

	private static final Logger logger = Logger.getLogger(GoodsDaoImpl.class);

	@Override
	public Goods save(Goods goods) {
		logger.debug("saving Goods accounts");
		try {
			getSession().save(goods);
			logger.debug("save successful");
			return goods;
		} catch (RuntimeException re) {
			logger.error("save failed", re);
			throw re;
		}
	}

	@Override
	public void delete(int id) {
		logger.debug("deleting Goods instance");
		try {
			String hql = "delete from Goods where id = ?";
			Query query = getSession().createQuery(hql);
			query.setInteger(0, id);
			query.executeUpdate();
			logger.debug("delete successful");
		} catch (RuntimeException re) {
			logger.error("delete failed", re);
			throw re;
		}
	}

	@Override
	public Goods getById(int id) {
		logger.debug("getting Goods with id: " + id);
		try {
			Goods goods = (Goods) getSession().get(Goods.class, id);
			return goods;
		} catch (RuntimeException re) {
			logger.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Goods> query(Goods goods, Page page) {
		try {
			Criteria criteria = getSession().createCriteria(Goods.class);
			if (goods != null && goods.getCategory() != null
					&& !"".equals(goods.getCategory())) {
				criteria.add(Restrictions.eq("category", goods.getCategory()));
			}
			if (goods != null && goods.getGoodsCode() != null
					&& !"".equals(goods.getGoodsCode())) {
				criteria.add(Restrictions.eq("goodsCode", goods.getGoodsCode()));
			}
			if (goods != null && goods.getGoodsName() != null
					&& !"".equals(goods.getGoodsName())) {
				criteria.add(Restrictions.eq("goodsName", goods.getGoodsName()));
			}
			List<Goods> list = criteria.addOrder(Order.desc("id"))
					.setFirstResult(Page.getStartNO(page))
					.setMaxResults(page.getPageSize()).list();
			return list;
		} catch (RuntimeException re) {
			logger.error("get failed", re);
			throw re;
		}

	}

	@Override
	public void update(Goods goods) {
		try {
			getSession().update(goods);
		} catch (RuntimeException re) {
			logger.error("update fail", re);
			throw re;
		}

	}

	@Override
	public int getAllcount(Goods goods) {
		try {
			Criteria criteria = getSession().createCriteria(Goods.class);
			if (goods != null && goods.getCategory() != null
					&& !"".equals(goods.getCategory())) {
				criteria.add(Restrictions.eq("category", goods.getCategory()));
			}
			if (goods != null && goods.getGoodsCode() != null
					&& !"".equals(goods.getGoodsCode())) {
				criteria.add(Restrictions.eq("goodsCode", goods.getGoodsCode()));
			}
			if (goods != null && goods.getGoodsName() != null
					&& !"".equals(goods.getGoodsName())) {
				criteria.add(Restrictions.eq("goodsName", goods.getGoodsName()));
			}
			return criteria.list().size();
		} catch (RuntimeException re) {
			logger.error("get failed", re);
			throw re;
		}
	}

	@Override
	public Goods getByGoodsCode(String goodsCode) {
		try {
			return (Goods) getSession().createCriteria(Goods.class)
					.add(Restrictions.eq("goodsCode", goodsCode))
					.uniqueResult();
		} catch (RuntimeException re) {
			logger.error("get failed", re);
			throw re;
		}
	}

}