package com.zh.logistics.base;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class BaseHibernateImpl {
	
	private SessionFactory sessionFactory;
	
	protected Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
}
