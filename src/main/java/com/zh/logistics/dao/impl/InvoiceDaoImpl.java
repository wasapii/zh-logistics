package com.zh.logistics.dao.impl;

import java.text.ParseException;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.zh.logistics.base.BaseHibernateImpl;
import com.zh.logistics.dao.InvoiceDao;
import com.zh.logistics.entity.Invoice;
import com.zh.logistics.util.FormatDateUtil;
import com.zh.logistics.util.Page;

/**
 * * @author zhanghao 20150209
 * 
 * */
@Repository("invoiceDao")
public class InvoiceDaoImpl extends BaseHibernateImpl implements InvoiceDao {

	private static final Logger logger = Logger.getLogger(InvoiceDaoImpl.class);

	@Override
	public Invoice save(Invoice invoice) {
		logger.debug("saving Invoice accounts");
		try {
			getSession().save(invoice);
			logger.debug("save successful");
			return invoice;
		} catch (RuntimeException re) {
			logger.error("save failed", re);
			throw re;
		}
	}

	@Override
	public void delete(int id) {
		logger.debug("deleting Invoice instance");
		try {
			String hql = "delete from Invoice where id = ?";
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
	public Invoice getById(int id) {
		logger.debug("getting Invoice with id: " + id);
		try {
			Invoice invoice = (Invoice) getSession().get(Invoice.class, id);
			return invoice;
		} catch (RuntimeException re) {
			logger.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Invoice> query(Invoice invoice, Page page) {
		try {
			Criteria criteria = getSession().createCriteria(Invoice.class);
			if (invoice != null && invoice.getStartDate() != null
					&& !"".equals(invoice.getStartDate())
					&& invoice.getEndDate() != null
					&& !"".equals(invoice.getEndDate())) {
				try {
					criteria.add(Restrictions.between("invoiceDate", FormatDateUtil
							.formatStringToDate(invoice.getStartDate()),
							FormatDateUtil.formatStringToDate(invoice.getEndDate())));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			if (invoice != null && invoice.getInvoiceNum() != null
					&& !"".equals(invoice.getInvoiceNum())) {
				criteria.add(Restrictions.eq("invoiceNum",
						invoice.getInvoiceNum()));
			}
			if (invoice != null && invoice.getCompany() != null
					&& !"".equals(invoice.getCompany())) {
				criteria.add(Restrictions.eq("company", invoice.getCompany()));
			}
			criteria.add(Restrictions.eq("invoiceType",
					invoice.getInvoiceType()));
			List<Invoice> list = criteria.addOrder(Order.desc("id"))
					.setFirstResult(Page.getStartNO(page))
					.setMaxResults(page.getPageSize()).list();
			return list;
		} catch (RuntimeException re) {
			logger.error("get failed", re);
			throw re;
		}

	}

	@Override
	public void update(Invoice invoice) {
		try {
			getSession().update(invoice);
		} catch (RuntimeException re) {
			logger.error("update fail", re);
			throw re;
		}

	}

	@Override
	public int getAllcount(Invoice invoice) {
		try {
			Criteria criteria = getSession().createCriteria(Invoice.class);
			if (invoice != null && invoice.getStartDate() != null
					&& !"".equals(invoice.getStartDate())
					&& invoice.getEndDate() != null
					&& !"".equals(invoice.getEndDate())) {
				try {
					criteria.add(Restrictions.between("invoiceDate", FormatDateUtil
							.formatStringToDate(invoice.getStartDate()),
							FormatDateUtil.formatStringToDate(invoice.getEndDate())));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			if (invoice != null && invoice.getInvoiceNum() != null
					&& !"".equals(invoice.getInvoiceNum())) {
				criteria.add(Restrictions.eq("invoiceNum",
						invoice.getInvoiceNum()));
			}
			if (invoice != null && invoice.getCompany() != null
					&& !"".equals(invoice.getCompany())) {
				criteria.add(Restrictions.eq("company", invoice.getCompany()));
			}
			criteria.add(Restrictions.eq("invoiceType",
					invoice.getInvoiceType()));
			return criteria.list().size();
		} catch (RuntimeException re) {
			logger.error("get failed", re);
			throw re;
		}
	}

	@Override
	public String getMaxInvoiceNum() {
		try {
			String hql = "select max(invoiceNum) from Invoice where invoiceNum like 'ASN%'";
			Query query = getSession().createQuery(hql);
			logger.debug("delete successful");
			return (String) query.uniqueResult();
		} catch (RuntimeException re) {
			logger.error("update fail", re);
			throw re;
		}
	}

}