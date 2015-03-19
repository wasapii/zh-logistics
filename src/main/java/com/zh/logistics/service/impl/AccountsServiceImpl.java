package com.zh.logistics.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zh.logistics.dao.AccountsDao;
import com.zh.logistics.entity.Accounts;
import com.zh.logistics.service.AccountsService;
import com.zh.logistics.util.Page;

@Service("accountsService")
public class AccountsServiceImpl implements AccountsService{

	private AccountsDao accountsDao;
	
	@Override
	public Accounts save(Accounts t) {
		return accountsDao.save(t);
	}

	@Override
	public List<Accounts> query(Accounts t, Page page) {
		return accountsDao.query(t, page);
	}

	@Override
	public void update(Accounts t) {
		accountsDao.update(t);
	}

	@Override
	public Accounts getById(int id) {
		return accountsDao.getById(id);
	}

	@Override
	public void delete(int id) {
		accountsDao.delete(id);
	}

	@Override
	public int getAllcount(Accounts accounts) {
		return accountsDao.getAllcount(accounts);
	}
	
	public AccountsDao getAccountsDao() {
		return accountsDao;
	}

	public void setAccountsDao(AccountsDao accountsDao) {
		this.accountsDao = accountsDao;
	}

	@Override
	public List<String> getAccountCode(String str) {
		return accountsDao.getAccountCode(str);
	}
}
