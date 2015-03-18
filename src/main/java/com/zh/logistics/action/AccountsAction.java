package com.zh.logistics.action;

import java.util.List;

import org.apache.log4j.Logger;

import com.zh.logistics.entity.Accounts;
import com.zh.logistics.service.AccountsService;
import com.zh.logistics.util.FormatDateUtil;
import com.zh.logistics.util.Page;

/**
 * 结算账户action
 * 
 * @author zhanghao 20150203
 * 
 * */
public class AccountsAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	private static Logger logger = Logger.getLogger(AccountsAction.class);

	private AccountsService accountsService;

	private Accounts accounts;

	private List<Accounts> accountsList;

	public String query() {
		try {
			int total = accountsService.getAllcount(accounts);
			page.setTotal(total);
			page.setTotalPage(Page.caluTotalPage(total, page.getPageSize()));
			accountsList = accountsService.query(accounts, page);
			message = "success";
			logger.info("查询成功" + accountsList);
			return "list";
		} catch (RuntimeException e) {
			logger.error("查询失败", e);
			throw e;
		}

	}

	public String queryAll() {
		try {
			accounts = new Accounts();
			int total = accountsService.getAllcount(accounts);
			page = new Page();
			page.setTotal(total);
			page.setLocalPage(1);
			page.setTotalPage(Page.caluTotalPage(total, page.getPageSize()));
			accountsList = accountsService.query(accounts, page);
			message = "success";
			logger.info("查询成功" + accountsList);
			return "list";
		} catch (RuntimeException re) {
			logger.error("查询失败", re);
			throw re;
		}

	}

	public String updateAccounts() {
		try {
			accountsService.update(accounts);
			return queryAll();
		} catch (RuntimeException re) {
			logger.error("更新失败", re);
			throw re;
		}

	}

	public String addAccounts() {
		try {
			accountsService.save(accounts);
			return queryAll();
		} catch (RuntimeException re) {
			logger.error("新增失败", re);
			throw re;
		}
	}

	public String deleteAccounts() {
		try {
			logger.info("进入了delete方法，Id:" + id);
			String[] idList = FormatDateUtil.StringFormatArray(id);
			for (String delId : idList) {
				accountsService.delete(Integer.parseInt(delId));
				logger.info("删除结算账户信息成功,删除ID:" + delId);
			}
			return queryAll();
		} catch (RuntimeException re) {
			logger.error("删除失败", re);
			throw re;
		}
	}

	public String toUpdate() {
		try {
			logger.info("获取到的仓库ID信息为：" + accounts.getId());
			accounts = accountsService.getById(accounts.getId());
			logger.info("查询ID为：" + accounts.getId() + "的仓库信息为：" + accounts);
			return "update";
		} catch (RuntimeException re) {
			logger.error("查询失败", re);
			throw re;
		}
	}

	public AccountsService getAccountsService() {
		return accountsService;
	}

	public void setAccountsService(AccountsService accountsService) {
		this.accountsService = accountsService;
	}

	public Accounts getAccounts() {
		return accounts;
	}

	public void setAccounts(Accounts accounts) {
		this.accounts = accounts;
	}


	public List<Accounts> getAccountsList() {
		return accountsList;
	}

	public void setAccountsList(List<Accounts> accountsList) {
		this.accountsList = accountsList;
	}
}
