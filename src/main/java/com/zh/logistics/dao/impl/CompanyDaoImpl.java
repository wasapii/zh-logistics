package com.zh.logistics.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.zh.logistics.base.BaseHibernateImpl;
import com.zh.logistics.dao.CompanyDao;
import com.zh.logistics.entity.Company;
import com.zh.logistics.util.Page;

/**
 * * @author zhanghao 20150203
 * 
 * */
@Repository("companyDao")
public class CompanyDaoImpl extends BaseHibernateImpl implements CompanyDao {

	private static final Logger logger = Logger.getLogger(CompanyDaoImpl.class);

	@Override
	public Company save(Company company) {
		logger.debug("saving Company company");
		try {
			getSession().save(company);
			logger.debug("save successful");
			return company;
		} catch (RuntimeException re) {
			logger.error("save failed", re);
			throw re;
		}
	}

	@Override
	public void delete(int id) {
		logger.debug("deleting Company instance");
		try {
			String hql = "delete from Company where id = ?";
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
	public Company getById(int id) {
		logger.debug("getting Company with id: " + id);
		try {
			Company company = (Company) getSession().get(Company.class, id);
			return company;
		} catch (RuntimeException re) {
			logger.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Company> query(Company company, Page page) {
		try {
			Criteria criteria = getSession().createCriteria(Company.class);
			if (company != null && company.getCompanyCode() != null && !"".equals(company.getCompanyCode())) {
				criteria.add(Restrictions.eq("companyCode", company.getCompanyCode()));
			}
			if (company != null && company.getCompanyName() != null && !"".equals(company.getCompanyName())) {
				criteria.add(Restrictions.eq("companyName", company.getCompanyName()));
			}
			if (company != null && company.getCompanyCategory() != null && !"".equals(company.getCompanyCategory())) {
				criteria.add(Restrictions.eq("companyCategory", company.getCompanyCategory()));
			}
			List<Company> list = criteria.addOrder(Order.desc("id"))
					.setFirstResult(Page.getStartNO(page))
					.setMaxResults(page.getPageSize()).list();
			return list;
		} catch (RuntimeException re) {
			logger.error("get failed", re);
			throw re;
		}
	}

	@Override
	public void update(Company company) {
		try {
			getSession().update(company);
		} catch (RuntimeException re) {
			logger.error("update fail", re);
			throw re;
		}

	}

	@Override
	public int getAllcount(Company company) {
		try {
			Criteria criteria = getSession().createCriteria(Company.class);
			if (company != null && company.getCompanyCode() != null && !"".equals(company.getCompanyCode())) {
				criteria.add(Restrictions.eq("companyCode", company.getCompanyCode()));
			}
			if (company != null && company.getCompanyName() != null && !"".equals(company.getCompanyName())) {
				criteria.add(Restrictions.eq("companyName", company.getCompanyName()));
			}
			if (company != null && company.getCompanyCategory() != null && !"".equals(company.getCompanyCategory())) {
				criteria.add(Restrictions.eq("companyCategory", company.getCompanyCategory()));
			}
			return criteria.list().size();
		} catch (RuntimeException re) {
			logger.error("get failed", re);
			throw re;
		}
	}

	@Override
	public Company getByCompanyCode(String companyCode) {
		return (Company) getSession().createCriteria(Company.class)
				.add(Restrictions.eq("companyCode", companyCode))
				.uniqueResult();
	}

	@Override
	public String getNameByCompanyCode(String companyCode) {
		String hql = "select companyName from Company where companyCode = ?";
		Query query = getSession().createQuery(hql);
		query.setString(0, companyCode);
		return (String)query.uniqueResult();
	}
}