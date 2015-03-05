package com.zh.logistics.base;

import java.util.List;

import com.zh.logistics.util.Page;

public interface BaseService<T> {
	
	public T save(T t);
	
	public void update(T t);
	
	public List<T> query(T t, Page page);
	
	public void delete(int id);
	
	public int getAllcount(T t);
	
	public T getById(int id);

}
