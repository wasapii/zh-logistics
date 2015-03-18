package com.zh.logistics.service;

import com.zh.logistics.base.BaseService;
import com.zh.logistics.entity.Invoice;

/**
 * 进货单service
 * @zhanghao
 * 20150209
 * */
public interface AsnService extends BaseService<Invoice>{
	public String getMax();
}
