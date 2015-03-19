package com.zh.logistics.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.zh.logistics.base.BaseHibernateImpl;
import com.zh.logistics.dao.AccountsDao;
import com.zh.logistics.entity.Accounts;
import com.zh.logistics.util.Page;

@Repository("accountsDao")
public class AccountsDaoImpl extends BaseHibernateImpl implements AccountsDao {

	private static final Logger logger = Logger
			.getLogger(AccountsDaoImpl.class);

	@Override
	public Accounts save(Accounts accounts) {
		logger.debug("saving Accounts accounts");
		try {
			getSession().save(accounts);
			logger.debug("save successful");
			return accounts;
		} catch (RuntimeException re) {
			logger.error("save failed", re);
			throw re;
		}
	}

	@Override
	public void delete(int id) {
		logger.debug("deleting Accounts instance");
		try {
			String hql = "delete from Accounts where id = ?";
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
	public Accounts getById(int id) {
		logger.debug("getting accounts with id: " + id);
		try {
			Accounts accounts = (Accounts) getSession().get(Accounts.class, id);
			return accounts;
		} catch (RuntimeException re) {
			logger.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Accounts> query(Accounts accounts, Page page) {
		try {
			Criteria criteria = getSession().createCriteria(Accounts.class);
			if (accounts != null && accounts.getAccountsCode() != null && !"".equals(accounts.getAccountsCode())) {
				criteria.add(Restrictions.eq("accountsCode", accounts.getAccountsCode()));
			}
			if (accounts != null && accounts.getAccountsName() != null && !"".equals(accounts.getAccountsName())) {
				criteria.add(Restrictions.eq("accountsName", accounts.getAccountsName()));
			}
			List<Accounts> list = criteria.addOrder(Order.desc("id"))
					.setFirstResult(Page.getStartNO(page))
					.setMaxResults(page.getPageSize()).list();
			return list;
		} catch (RuntimeException re) {
			logger.error("get failed", re);
			throw re;
		}

	}

	@Override
	public void update(Accounts accounts) {
		try {
			getSession().update(accounts);
		} catch (RuntimeException re) {
			logger.error("update fail" , re);
			throw re;
		}

	}

	@Override
	public int getAllcount(Accounts accounts) {
		try {
			Criteria criteria = getSession().createCriteria(Accounts.class);
			if (accounts != null && accounts.getAccountsCode() != null && !"".equals(accounts.getAccountsCode())) {
				criteria.add(Restrictions.eq("accountsCode", accounts.getAccountsCode()));
			}
			if (accounts != null && accounts.getAccountsName() != null && !"".equals(accounts.getAccountsName())) {
				criteria.add(Restrictions.eq("accountsName", accounts.getAccountsName()));
			}
			return criteria.list().size();
		} catch (RuntimeException re) {
			logger.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getAccountCode(String str) {
		String hql = "select accountsCode from Accounts where accountsCode like ?";
		Query query = getSession().createQuery(hql);
		query.setString(0, str + "%");
		return query.list();
	}

}