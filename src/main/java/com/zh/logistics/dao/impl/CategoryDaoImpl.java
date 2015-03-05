package com.zh.logistics.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.zh.logistics.base.BaseHibernateImpl;
import com.zh.logistics.dao.CategoryDao;
import com.zh.logistics.entity.Category;
import com.zh.logistics.entity.Company;
import com.zh.logistics.util.Page;

/**
 *  类别
 *  @author zhanghao 20150205
 * 
 * */
@Repository("categoryDao")
public class CategoryDaoImpl extends BaseHibernateImpl implements CategoryDao {

	private static final Logger logger = Logger.getLogger(CategoryDaoImpl.class);

	@Override
	public Category save(Category category) {
		logger.debug("saving Category accounts");
		try {
			getSession().save(category);
			logger.debug("save successful");
			return category;
		} catch (RuntimeException re) {
			logger.error("save failed", re);
			throw re;
		}
	}

	@Override
	public void delete(int id) {
		logger.debug("deleting Category instance");
		try {
			String hql = "delete from Category where id = ?";
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
	public Category getById(int id) {
		logger.debug("getting Category with id: " + id);
		try {
			Category category = (Category) getSession().get(Category.class, id);
			return category;
		} catch (RuntimeException re) {
			logger.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> query() {
		try {
			Criteria criteria = getSession().createCriteria(Category.class);
			List<Category> list = criteria.addOrder(Order.asc("id")).list();
			return list;
		} catch (RuntimeException re) {
			logger.error("get failed", re);
			throw re;
		}

	}

	@Override
	public void update(Category category) {
		try {
			getSession().update(category);
		} catch (RuntimeException re) {
			logger.error("update fail", re);
			throw re;
		}

	}

	@Override
	public int getAllcount(Category category) {
		try {
			Criteria criteria = getSession().createCriteria(Category.class);
			if (category != null && category.getCategoryCode()!= null && !"".equals(category.getCategoryCode())) {
				criteria.add(Restrictions.eq("categoryCode", category.getCategoryCode()));
			}
			if (category != null && category.getCategoryName()!= null && !"".equals(category.getCategoryName())) {
				criteria.add(Restrictions.eq("categoryName", category.getCategoryName()));
			}
			return criteria.list().size();
		} catch (RuntimeException re) {
			logger.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> query(Category category, Page page) {
		try {
			Criteria criteria = getSession().createCriteria(Category.class);
			if (category != null && category.getCategoryCode()!= null && !"".equals(category.getCategoryCode())) {
				criteria.add(Restrictions.eq("categoryCode", category.getCategoryCode()));
			}
			if (category != null && category.getCategoryName()!= null && !"".equals(category.getCategoryName())) {
				criteria.add(Restrictions.eq("categoryName", category.getCategoryName()));
			}
			List<Category> list = criteria.addOrder(Order.desc("id"))
					.setFirstResult(Page.getStartNO(page))
					.setMaxResults(page.getPageSize()).list();
			return list;
		} catch (RuntimeException re) {
			logger.error("get failed", re);
			throw re;
		}
	}

	@Override
	public Category findByCode(String categoryCode) {
		try {
			Criteria criteria = getSession().createCriteria(Category.class);
			criteria.add(Restrictions.eq("categoryCode", categoryCode));
			Category category = (Category)criteria.uniqueResult();
			return category;
		} catch (RuntimeException re) {
			logger.error("get fail", re);
			throw re;
		}
	}

}